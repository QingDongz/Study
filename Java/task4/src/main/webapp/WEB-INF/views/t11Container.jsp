<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="time" uri="/timeTag" %>

    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <div class="container">

        <div class="nav-title">首页&gt;职业</div>
        <div class="nav-bar">
            <span class="">方向：</span>
            <a class="nav-bar-a a-selected" href="">全部</a>
            <a class="nav-bar-a" href="">前端开发</a>
            <a class="nav-bar-a" href="">后端开发</a>
            <a class="nav-bar-a" href="">移动开发</a>
            <a class="nav-bar-a" href="">整站开发</a>
            <a class="nav-bar-a" href="">运营维护</a>
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
                                <p class="text-present"><time:time value="${job.createAt }" /></p>
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
