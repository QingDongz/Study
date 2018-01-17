<%--
    本文件是布局文件，相当于一个模板，相当于html的骨架结构
    具体内容怎么填充在 布局定义xml文件 中
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- tiles --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<html>
<head>
    <tiles:insertAttribute name="headCommon" />
    <title>实验</title>
</head>
<body>
    <div>
        <tiles:insertAttribute name="foot" />
    </div>
</body>
</html>