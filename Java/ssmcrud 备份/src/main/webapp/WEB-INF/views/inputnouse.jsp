<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--
        使用springmvc from标签 ，快速开发
    --%>
    <form:form action="student" method="POST" modelAttribute="student">
        Name:<form:input path="name"/><br>
        QQ:<form:input path="qq"/><br>
        <%
            Map<Integer,String> types = new HashMap<>();
            types.put(1, "java");
            types.put(2, "css");
            types.put(3, "pm");
            request.setAttribute("types",types);
        %>
        StudyTypes:<form:select
            path="studytypes"
            items="${types}" itemValue="${types.values()}"/>
        EntryTime:<form:input path="entrytime"/><br>
        School:<form:input path="school"/><br>
        StudentId:<form:input path="studentid"/><br>
        Link:<form:input path="link"/><br>
        Oath:<form:input path="oath"/><br>
        Brother:<form:input path="brother"/><br>
        KnowFrom:<form:input path="knowfrom"/><br>
        <input type="新建学生" value="Submit">
    </form:form>
</body>
</html>
