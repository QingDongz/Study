<%--
  Created by IntelliJ IDEA.
  User: 木子君
  Date: 2018/1/2
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> </h1>
    <form action="/student" method="post">
        <table align="center" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td>学生姓名</td>
                <td>QQ号</td>
                <td>入学时间</td>
                <td>学校</td>
                <td>日报连接</td>
                <td>誓言</td>
                <td>指导师兄</td>
                <td>从何处了解</td>
            </tr>
            <tr>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="qq"></td>
                <td><input type="text" name="entryTime"></td>
                <td><input type="text" name="school"></td>
                <td><input type="text" name="link"></td>
                <td><input type="text" name="oath"></td>
                <td><input type="text" name="brother"></td>
                <td><input type="text" name="knowFrom"></td>
            </tr>
            <tr><td colspan="8" align="center"><input type="submit" value="添加学生"></td></tr>
        </table>
    </form>
</body>
</html>
