<%--
    本文件是布局文件，说明网页长什么样，相当于html的骨架结构
    具体内容怎么填充在 布局定义xml文件 中
--%>
<%-- pageEncoding="utf-8" --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- tiles --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<html>
<head>
    <tiles:insertAttribute name="headCommon" ignore="true" />
    <title>实验</title>
</head>
<body>
    <div>
        <tiles:insertAttribute name="foot" ignore="true" />
    </div>
</body>
</html>