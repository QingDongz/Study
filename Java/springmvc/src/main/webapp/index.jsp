<%--
  Created by IntelliJ IDEA.
  User: 木子君
  Date: 2018/1/1
  Time: 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生列表</title>

    <%-- web路径：
    不以 / 开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以 / 开始的相对路径，找资源，以服务器的路径(http://localhost:3306)为标准
    比如当前项目叫springmvc，那么项目路径就是：
            http://localhost:3306/springmvc
    这样写又太麻烦，所以，用java语句获取        --%>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <%-- 引入jauery --%>
    <script type="text/javascript" src="${APP_PATH}/statics/js/jquery-2.1.4.min.js"></script>
    <%-- 引入BootStrap --%>
    <link href="${APP_PATH }/statics/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<%-- 搭建显示页面--%>
<div class="container" >
    <%-- 标题行 --%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM CRUD</h1>
        </div>
    </div>

    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-9">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <%-- 表格数据 --%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="students_table">
                <%-- <thead> 标签 标识为 HTML 表格的表头 --%>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>qq</th>
                        <th>入学时间</th>
                        <th>学校</th>
                        <th>誓言</th>
                        <th>从何处了解</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <%-- <tbody> 定义一段表格主体, 可将表格中的一行或几行合成一组 --%>
                <tbody>
                    <%-- 通过js解析获得数据，填充到这里 --%>
                </tbody>
            </table>
        </div>
    </div>

    <%-- 底部分页信息 --%>
    <div class="row">
        <div class="row-md-6" id="page_info_area">
        </div>
        <div class="row-md-6 col-md-offset-4" id="page_nav_area">
        </div>

    </div>
</div>

<script type="text/javascript">
    <%-- 页面完成后，发送ajax请求，要到分业数据--%>
    $(function () {
        //
        toPageNum(1);
    });

    // 解析学生数据的函数
    function build_student_table(result) {
        $("#students_table tbody").empty();
        var students = result.backValue.pageInfo.list;
        // 用alert试验是否成功，成功的话，会在页面提示。
        // alert(item.name)

        $.each(students,function (index, item) {
            var stdID = $("<td></td>").append(item.id);
            var stdName = $("<td></td>").append(item.name);
            var stdQQ = $("<td></td>").append(item.qq);
            var stdType = $("<td></td>").append(item.type);
            var stdEntryTime = $("<td></td>").append(item.entryTime);
            var stdSchool = $("<td></td>").append(item.school);
            var stdOath = $("<td></td>").append(item.oath);
            var stdknowfrom = $("<td></td>").append(item.knowfrom);
            // 编辑和删除按钮
            var editBtn=$("<button></button>")
                .addClass("btn btn-primary btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                .append("编辑");
            var delBtn=$("<button></button>")
                .addClass("btn btn-danger btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
                .append("删除");
            // 两个按钮放到表格的一个格子中，中间放一个空格
            var btnTn = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            // 连续append，因为append执行完还是 <tr>
            $("<tr></tr>").append(stdID)
                .append(stdName)
                .append(stdQQ)
                .append(stdEntryTime)
                .append(stdSchool)
                .append(stdOath)
                .append(stdknowfrom)
                .append(btnTn)
                .appendTo("#students_table tbody");
            // 构建完 <tr> 用 appendTo，完成后调试
        })
    }


    // 解析显示分页信息
    function bulid_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area")
            .append($("<h4></h4>")
                .append("当前为第"+result.backValue.pageInfo.pageNum+"页," +
                    "共"+result.backValue.pageInfo.total+"条记录," +
                    "分为 "+result.backValue.pageInfo.pages+"页"));
    }


    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));


        // 如果不是第一页，添加首页、前一页
        if (!result.backValue.pageInfo.isFirstPage) {
            firstPageLi.click(function () {
                toPageNum(1);
            });
            prePageLi.click(function () {
                toPageNum(result.backValue.pageInfo.prePage)
            });
            ul.append(firstPageLi).append(prePageLi);
        }

        // navigatepageNums 的值是 [1,2,3...]
        $.each(result.backValue.pageInfo.navigatepageNums,function(index,item){
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            // 判断当前页码，如果是当前页，高亮显示
            if(result.backValue.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                toPageNum(item);
            });
            ul.append(numLi);
        });

        // 如果不是最后一页，就添加下一页和最后一页
        if (!result.backValue.pageInfo.isLastPage) {
            lastPageLi.click(function () {
                toPageNum(result.backValue.pageInfo.pages);
            });
            nextPageLi.click(function () {
                toPageNum(result.backValue.pageInfo.nextPage)
            });
            ul.append(nextPageLi).append(lastPageLi);
        }

        // 把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    function toPageNum(pn) {
        $.ajax({
            url:"${APP_PATH}/students",
            data:"pn="+pn,
            type:"get",
            success:function (result) {
                // 显示到 控制台，就是F12，network栏显示
                // console.log(result)
                // 1、解析显示学生数据
                build_student_table(result);
                // 2、解析显示分页信息
                bulid_page_info(result);
                // 3、解析显示分页页码数据，也就是导航条
                build_page_nav(result);
            }
        });

    }

</script>

</body>
</html>
