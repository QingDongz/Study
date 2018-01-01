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
</head>
<body>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>qq</td>
            <td>日报连接</td>
            <td>誓言</td>
        </tr>
        <c:forEach items="${requestScope.allStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.link}</td>
                <td>${student.oath}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
