<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>12</h1>
<json:array>
    <c:forEach items="${requestScope.allFruits}" var="f" varStatus="vs">
        <json:object>
            <json:property name="id" value="${f.id}"/>
            <json:property name="name" value="${f.fruitName}"/>
            <json:property name="price" value="${f.fruitPrice}"/>
        </json:object>
    </c:forEach>
</json:array>
</body>
</html>
