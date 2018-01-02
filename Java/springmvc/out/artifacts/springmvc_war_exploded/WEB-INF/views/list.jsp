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
                <table class="table table-hover" >
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
                    <c:forEach items="${requestScope.pageInfo.list}" var="std">
                    <tr>
                        <th>${std.id}</th>
                        <th>${std.name}</th>
                        <th>${std.qq}</th>
                        <th>${std.entryTime}</th>
                        <th>${std.school}</th>
                        <th>${std.oath}</th>
                        <th>${std.knowfrom}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </th>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <%-- 底部分页信息 --%>
        <div class="row">
            <div class="row-md-6">
                <h4>当前为第${requestScope.pageInfo.pageNum}页，
                    共${requestScope.pageInfo.total}条记录，
                    共${requestScope.pageInfo.pages}页
                </h4>
            </div>
            <div class="row-md-6 col-md-offset-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">

                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li><a href="${APP_PATH}/students">首页</a></li>
                            <li>
                                <a href="${APP_PATH}/students?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${page_Num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <c:if test="${page_Num != pageInfo.pageNum}">
                                <li class=><a href="${APP_PATH}/students?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/students?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            <li><a href="${APP_PATH}/students?pn=${pageInfo.pages}">末页</a></li>
                        </c:if>

                    </ul>
                </nav>
            </div>

        </div>
    </div>
    <table align="center" border="1" cellpadding="5" cellspacing="0">
                <c:forEach items="${requestScope.allstds}" var="std">
            <tr>
                
            </tr>
        </c:forEach>
    </table>

</body>
</html>