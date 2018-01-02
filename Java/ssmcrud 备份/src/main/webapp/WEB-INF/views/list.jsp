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
    <table align="center" border="1" cellpadding="5" cellspacing="0">
        <tr>
            <td>id</td>
            <td>姓    名</td>
            <td>qq</td>
            <td>入学时间</td>
            <td>学校</td>
            <td>学号</td>
            <td>日报连接</td>
            <td>誓言</td>
            <td>指导师兄</td>
            <td>从何处了解</td>
        </tr>
        <c:forEach items="${requestScope.allStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.entryTime}</td>
                <td>${student.school}</td>
                <td>${student.studentId}</td>
                <td>${student.link}</td>
                <td>${student.oath}</td>
                <td>${student.brother}</td>
                <td>${student.knowFrom}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
<h3><a href="/student">添加学生</a> </h3>
</body>
</html>
