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
<!-- 添加学生 模态框 -->
<div class="modal fade" id="addStudentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加学生</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="add_student_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <%-- input标签 name和domain bean 属性一致，方便对象转化 --%>
                            <input type="text" name="name" class="form-control" id="stdName_add_input" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-10">
                            <input type="text" name="qq" class="form-control" id="stdQQ_add_input" placeholder="QQ">
                            <span class="help-block"></span>
                        </div>
                    </div>
                 <%--   <div class="form-group">
                        <label class="col-sm-2 control-label">修真类型</label>
                        <div class="col-sm-10">
                            <input type="password" name="type" class="form-control" id="stdType_add_input" placeholder="Type">
                        </div>
                    </div>--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">修真类型</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="type" id="type_add_select">
                                <%-- value是提交的值，文本是下拉选择显示的内容--%>
                                <option value="1">java</option>
                                <option value="2">前端</option>
                                <option value="3">pm</option>
                                <option value="4">运营</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="add_modal_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改学生 弹出的模态框 -->
<div class="modal fade" id="updateStudentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改学生</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update_student_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <%-- input标签 name和domain bean 属性一致，方便对象转化 --%>
                            <input type="text" name="name" class="form-control" id="stdName_update_input" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-10">
                            <input type="text" name="qq" class="form-control" id="stdQQ_update_input" placeholder="QQ">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--   <div class="form-group">
                           <label class="col-sm-2 control-label">修真类型</label>
                           <div class="col-sm-10">
                               <input type="password" name="type" class="form-control" id="stdType_add_input" placeholder="Type">
                           </div>
                       </div>--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">修真类型</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="type" id="type_update_select">
                                <%-- value是提交的值，文本是下拉选择显示的内容--%>
                                <option value="1">java</option>
                                <option value="2">前端</option>
                                <option value="3">pm</option>
                                <option value="4">运营</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="update_modal_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>

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
            <button class="btn btn-primary" id="add_student_btn">新增</button>
            <button class="btn btn-danger" id="delete_checked">删除选中</button>
        </div>
    </div>
    <%-- 表格数据 --%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="students_table">
                <%-- <thead> 标签 标识为 HTML 表格的表头 --%>
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="check_all"/>
                        </th>
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
    // 全局页码数
    var totalPages,currentPage;
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
            var checkBocId = $("<td><input type='checkbox' class='check_item'/></td>")
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
                .addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                .append("编辑");
            // 为编辑按钮添加一个id属性，方便ajax 查询当前id的学生信息
            editBtn.attr("edit-id",item.id);
            var delBtn=$("<button></button>")
                .addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
                .append("删除");
            // 为编辑按钮添加一个id属性，方便ajax 删除当前id的学生信息
            delBtn.attr("del-id",item.id);
            // 两个按钮放到表格的一个格子中，中间放一个空格
            var btnTn = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            // 连续append，因为append执行完还是 <tr>
            $("<tr></tr>").append(checkBocId)
                .append(stdID)
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
        totalPages = result.backValue.pageInfo.pages + 1;
        currentPage = result.backValue.pageInfo.pageNum;
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
            // result 就是 controller 函数返回的对象，处理为json字符串返回
            success:function (result) {
                // 显示到 控制台，就是F12，network栏显示
                // console.log(result)
                // 1、解析显示学生数据
                build_student_table(result);
                // 2、解析显示分页信息
                bulid_page_info(result);
                // 3、解析显示分页页码数据，也就是导航条
                build_page_nav(result);
                // check_all 的属性设为false
                $("#check_all").prop("checked",false);
            }
        });
    }

    // 增加 按钮，弹出对话框
    $("#add_student_btn").click(function () {
        // 先清空原来的样式和提示文本，可以抽取出一个函数
        $("#add_student_form")[0].reset();
        //表单下所有元素 removeClass
        $("#add_student_form").find("*").removeClass("has-success has-error");
        // 表单下的文本清楚
        $("#add_student_form").find(".help-block").text("");

        $("#addStudentModal").modal({
            backdrop:"static"
        });
    });

    // 新增学生，保存按钮 事件，提交数据保存，先校验是否符合格式
    // 再判断数据库中的重复性，如果要保证某个字段唯一，就要检验
    $("#add_modal_save_btn").click(function () {

        // 提交数据先进行前端校验
        if(!form_validate_name("#stdName_add_input")) {
            return false;
        }
        if(!form_validate_qq("#stdQQ_add_input")) {
            return false;
        }

        // 模态框中的数据提交到服务器进行保存
        // 序列化表格数据为字符串，先用alert测试下
        // alert($("#add_student_form").serialize());

        // 学习ajax 发送请求，success 对象
        $.ajax({
            url:"${APP_PATH}/student",
            type:"POST",
            data:$("#add_student_form").serialize(),
            // result 是controller函数返回对象（序列化后的json字符）
            success:function (result) {
                // alert(result.msg);
                // 添加成功后，关闭模态框
                $("#addStudentModal").modal("hide");
                // 跳转到最后一页
                //
                toPageNum(totalPages);
            }
        });
    });

    // 校验数据
    function form_validate_name(element) {
        // 拿到form数据
        var stdName = $(element).val();
        var regName = /(^[a-zA-Z_-]{4,10}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
        // alert(regName.test(stdName));
        if (regName.test(stdName)) {
            show_validate_msg(element, "success", "");
        } else {
            show_validate_msg(element, "error", "用户名：2-5汉字或4-10字母");
            return false;
        }
        return true;
    }

    function form_validate_qq(element) {
        var stdQQ= $(element).val();
        var regQQ=/(^[0-9]{5,11}$)/;
        // alert(regQQ.test(stdQQ));
        if (regQQ.test(stdQQ)){
            show_validate_msg(element,"success","");
        } else{
            show_validate_msg(element,"error","QQ号：5-11数字");
            return false;
        }
        return true;
    }

    // 抽取校验的方法
    function show_validate_msg(element, status, msg) {
        // 清楚元素以前的状态
        $(element).parent().removeClass("has-success has-error");
        $(element).next("span").text("");
        if(status=="success"){
            $(element).parent().addClass("has-success");
            $(element).next("span").text(msg);
        }else if(status=="error"){
            $(element).parent().addClass("has-error");
            $(element).next("span").text(msg);
        }

    }

    // 绑定  编辑按钮  事件，更新数据
    // 不能使用click方法，因为编辑按钮是 ajax查询出数据后，创建的
    // click就是在 创建按钮外频前绑定，创建之前，没有按钮，没法绑定
    // 可以用 live方法。新版jquery去除了live, 用on 方法
    $(document).on("click", ".edit_btn", function () {
        // alert("edit");
        // 先弹出模态框
        $("#updateStudentModal").modal({
            backdrop:"static"
        });
        // 查出学生信息，放到模态框中
        // $(this).attr("edit-id") 取出上面添加的 一列学生的id
        getStudent($(this).attr("edit-id"));

        // 把id传给 更新按钮
        $("#update_modal_update_btn").attr("edit-id",$(this).attr("edit-id"))

    });

    function getStudent(id) {
        $.ajax({
            url:"${APP_PATH}/students/"+id,
            type:"GET",
            success:function (result) {
                // console.log(result);
                var stdData=result.backValue.student;
                $("#stdName_update_input").val(stdData.name);
                $("#stdQQ_update_input").val(stdData.qq);
                $("#type_update_select").val(stdData.type);
            }
        });
    }

    // 更新按钮事件
    $("#update_modal_update_btn").click(function () {

        // 提交数据先进行前端校验
        if(!form_validate_name("#stdName_update_input")) {
            return false;
        }
        if(!form_validate_qq("#stdQQ_update_input")) {
            return false;
        }

        /* ajax=PUT 请求的问题
        * 封装数据的问题，请求体中有数据，但是Student对象封装不上
        * 原因：tomcat的问题：
        *       1、tomcat会把请求体中 json 字符，封装为一个map
        *       2、request.getParameter("name) 就会从这个map中取值
        *       3、SpringMVC 封装domain层 的Bean(POJO) 时，会对每个字段调用
        *       request.getParameter方法来获取数据。
        * 但是，AJAX 发送PUT 请求时，
        *       Tomcat 一看是请求是 PUT，就不会封装请求体中的数据
        *       Tomcat 只封装Post请求的数据
        *       请看源码：
        *   org.apache.catalina.connector.Request.java
        *   protected void parseParameters() 方法：
        *   下边有个判断
        *   if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }

        * 有一个请求方法的集合，默认是 POST，
        * 我们可以使用 springmvc 的过滤器来拦截所有请求并处理
        * 在web.xml 配置 HttpPutFormContentFilter
        *  requset被重新包装，getParameter() 被重写
        * */

        $.ajax({
            url:"${APP_PATH}/students/"+$(this).attr("edit-id"),

/*          用手动加参数的方法，改成PUT方法也可以
            type:"POST",
            data:$("#update_student_form").serialize()+"&_method=PUT",
*/
            type:"PUT",
            data:$("#update_student_form").serialize(),

            // result 是controller函数返回对象（序列化后的json字符）
            success:function (result) {
                // alert(result.msg);
                // 添加成功后，关闭模态框
                $("#updateStudentModal").modal("hide");
                // 跳转到最后一页
                //
                toPageNum(currentPage);
            }
        });
    });

    // 单个删除
    $(document).on("click", ".delete_btn", function () {
        // 弹出确认对话框
        var stdName = $(this).parents("tr").find("td:eq(2)").text()
        // alert($(this).parents("tr").find("td:eq(1)").text());

        if(confirm("确认删除 "+stdName+"吗？")) {
            $.ajax({
                url:"${APP_PATH}/students/"+$(this).attr("del-id"),
                type:"DELETE",
                success:function (result) {
                    // console.log(result);
                    alert(result.msg);
                    toPageNum(currentPage);
                }
            })
        }
    });

    // 全选
    $("#check_all").click(function () {
        // 原生的 checkbox dom属性用 prop获取
        // attr 用来绑定、读取 自定义的值
        // $(".check_item")  表示所有的 check_item 元素
        // 把当前选择框的 checked 属性 赋值给 所有的 check_item，它们也就都选中
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    // 单个选择按钮的单击事件
    $(document).on("click", ".check_item", function () {
        // 首先改变上面全选按钮的状态，用一个flag判断下面的框是否全部选中
        // .check_item:checked 用了jquery 的checked 函数，表示选中的个数
        // 全选中，flag = true
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked",flag);
    });

    $("#delete_checked").click(function () {
        // $(".check_item:checked") 表示被选中的
        // 注意 是 parents 不是 parten
        var stdNames = "";
        var del_ids_str = "";

        $.each($(".check_item:checked"),function () {
            stdNames += $(this).parents("tr").find("td:eq(2)").text()+",";
            del_ids_str += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        // jquery 的substring 截取字符串，去除多余的 ,
        stdNames = stdNames.substring(0,stdNames.length-1);
        del_ids_str = del_ids_str.substring(0,del_ids_str.length-1);
        if(confirm("确认删除 "+stdNames+" 吗？")){
            $.ajax({
                url:"${APP_PATH}/students/"+ del_ids_str,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    toPageNum(currentPage);
                }
            })
        }
    });

</script>

</body>
</html>
