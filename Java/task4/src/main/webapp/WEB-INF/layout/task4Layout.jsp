<%--
    本文件是布局文件，相当于一个模板，相当于html的骨架结构
    具体内容怎么填充在 布局定义xml文件 中 pageEncoding="utf-8"
--%>
<%@ page  pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- tiles --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<html>
<head>
    <%-- t10和t11公共的部分 --%>
    <tiles:insertAttribute name="headCommon" ignore="true" />

    <%-- t10和t11不同的部分 --%>
    <tiles:insertAttribute name="headDifferent" ignore="true" />

    <title>task4</title>
</head>
<body>
    <%-- header是一样的 --%>
    <tiles:insertAttribute name="header" ignore="true" />

    <%-- container 是不同的 --%>
    <tiles:insertAttribute name="container" ignore="true" />

    <%-- footer 也是一样的--%>
    <tiles:insertAttribute name="footer" ignore="true" />

</body>
</html>
