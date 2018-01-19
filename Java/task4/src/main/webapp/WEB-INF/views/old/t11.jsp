<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <link href="${APP_PATH}/statics/t11.css" rel="stylesheet" type="text/css">
    <link href="${APP_PATH}/statics/base.css" rel="stylesheet" type="text/css">
    <link href="${APP_PATH}/statics/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${APP_PATH}/statics/Untitled-1base.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="${APP_PATH}/statics/t10images/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="${APP_PATH}/statics/t10images/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="${APP_PATH}/statics/t10images/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${APP_PATH}/statics/t10images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="${APP_PATH}/old10">首页</a></li>
                <li><a href="${APP_PATH}/old11">职业</a></li>
                <li><a href="${APP_PATH}/">登录或注册</a></li>
                <li><a href="">注销</a></li>
            </ul>
        </div>

    </div>
</nav>

    <div class="container">

        <div class="nav-title">首页&gt;职业</div>
        <div class="nav-bar">
            <span class="">方向：</span>
            <a class="nav-bar-a a-selected" href="">全部</a>
            <a class="nav-bar-a" style="color: black" href="">前端开发</a>
            <a class="nav-bar-a" style="color: black" href="">后端开发</a>
            <a class="nav-bar-a" style="color: black" href="">移动开发</a>
            <a class="nav-bar-a" style="color: black" href="">整站开发</a>
            <a class="nav-bar-a" style="color: black" href="">运营维护</a>
        </div>

        <div class="caption">
            <h4>前端开发方向</h4>
        </div>

        <div class="row padding-bottom">

            <c:forEach items="${requestScope.jobs}" var="job" varStatus="status">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src="${APP_PATH}/statics/t11images/687.png"></div>
                            <div class="text">
                                <h4 class="">${job.jobName}</h4>
                                <p class="text-present">${job.introduce}</p>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛
                                    <c:forEach var ="i" begin="1" end= "${job.entryBarrier}">
                                        <%-- entryBarrier字段为int，值为几，就添加几个星星 --%>
                                        <img src="${APP_PATH}/statics/t11images/xx.png">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度
                                    <c:forEach var ="i" begin="1" end= "${job.difficultLevel}">
                                        <img src="${APP_PATH}/statics/t11images/xx.png">
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期
                                    <span class="iconfont-color">${job.growTime}</span>年
                                </div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${job.firmRequiredNum}</span>家公司需要</div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${job.salary1}K/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${job.salary2}K/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${job.salary3}K/月</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <c:forEach items="${requestScope.numbers}" var="numbers" varStatus="numstatus">
                                <c:if test="${status.index == numstatus.index}">
                                    <b class="text-b">有${numbers}人正在学</b>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:${job.tips}</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">${job.jobName}</p>
                            <p class="flip-text">${job.introduce}</p>
                        </div>
                    </div>

                </div>
            </c:forEach>

        </div>

    </div>

    <!--footer-->
<footer class="footer">
    <div class="container height">
        <div class="row">
            <div class="text-left col-sm-4">
                <span>技能树 &mdash; 改变你我</span>
                <p class="bottom">关于我们 | 联系我们 | 合作企业</p>
            </div>
            <div class="text-center col-sm-4">
                <p>旗下网站</p>
                <span>草船云孵化器     最强IT特训营</span>
                <span>葡萄藤轻游戏     桌游精灵</span>
            </div>
            <div class="text-right col-sm-4">
                <p>微信公众号</p>
                <img src="${APP_PATH}/statics/t11images/2524.jpg">
            </div>
        </div>

    </div>

    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com  All Rights Reserved | 京ICP
    </div>
</footer>

<%-- 生成职业信息的脚本 --%>
<script type="text/javascript">
    $(function () {

    })

</script>
</body>
</html>