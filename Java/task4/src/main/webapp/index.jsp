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
    <title>task5</title>

    <%-- web路径：
    不以 / 开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以 / 开始的相对路径，找资源，以服务器的路径(http://localhost:3306)为标准
    比如当前项目叫springmvc，那么项目路径就是：
            http://localhost:3306/springmvc
    这样写又太麻烦，所以，用java语句获取        --%>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <%--引入jauery、引入 BootStrap--%>
    <%--
    <script type="text/javascript" src="${APP_PATH}/statics/js/jquery-2.1.4.min.js"></script>
    <link href="${APP_PATH }/statics/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    --%>
    <%-- 使用cdn加速 --%>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 注册 模态框 -->
                    <%--$$$$$$$$$$$$$$$--%>
<div class="modal fade" id="signUpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">注册</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="sign_up_from">  <%--$$$$$$$$$$$$$$$--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <%-- input标签 name和domain bean 属性一致，方便对象转化 --%>
                            <input type="text" name="userName" class="form-control" id="sign_name_input" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control" id="sign_password_input" placeholder="Password">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="sign_up_modal_sign_btn">注册</button>
            </div>
        </div>
    </div>
</div>

<!-- 登录 弹出的模态框 -->
                        <%--$$$$$$$$$$--%>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="login_form"> <%--$$$$$$$$$$--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <%-- input标签 name和domain bean 属性一致，方便对象转化 --%>
                            <input type="text" name="userName" class="form-control" id="login_modal_name_input" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control" id="login_modal_password_input" placeholder="Password">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="login_modal_login_btn">登录</button>
            </div>
        </div>
    </div>
</div>

<%-- 搭建显示页面--%>
<div class="container" >
    <%-- 标题行 --%>
    <div class="row">
        <div class="col-md-12 text-center">
            <h1>task5</h1>
        </div>
    </div>

    <%--按钮--%>
    <div class="row">
        <%-- col-md-offset-4 偏移4个位置--%>
        <div class="col-md-12 text-center ">
            <button type="button" class="btn btn-primary btn-lg" id="sign_up_btn">注册</button>
            <a> </a>
            <button type="button" class="btn btn-default btn-lg" id="login_btn">登录</button>
        </div>
    </div>

</div>

<script type="text/javascript">
    // 全局页码数
    var totalPages,currentPage;

    // 注册 按钮，弹出对话框
    $("#sign_up_btn").click(function () {

        // 先清空原来的样式和提示文本，可以抽取出一个函数
        $("#sign_up_from")[0].reset();
        // 表单下所有元素 的状态，removeClass
        $("#sign_up_from").find("*").removeClass("has-success has-error");
        // 清除 表单下的 原来的 文本
        $("#sign_up_from").find(".help-block").text("");

        $("#signUpModal").modal({
            backdrop:"static"
        });
    });

    // 登录 按钮，弹出对话框
    $("#login_btn").click(function () {

        // 先清空原来的样式和提示文本，可以抽取出一个函数
        $("#login_form")[0].reset();
        // 表单下所有元素 的状态，removeClass
        $("#login_form").find("*").removeClass("has-success has-error");
        // 清除 表单下的 原来的 文本
        $("#login_form").find(".help-block").text("");

        $("#loginModal").modal({
            backdrop:"static"
        });
    });

    // 注册时，文本内容改变的话，开始校验用户名
    $("#sign_name_input").change(function () {
        // 提交数据先进行前端校验
        if(!form_validate_name("#sign_name_input")) {
            return false;
        }
        // 需要校验的 用户名，就是输入框的value值
        var userName = this.value;
        $.ajax({
            url:"${APP_PATH}/checkName",
            type:"POST",
            data:"userName="+userName,
            // result 是controller函数返回对象（序列化后的json字符）
            success:function (result) {
                if(result.code==200){
                    // 使用抽取的函数 显示提示信息
                    show_validate_msg("#sign_name_input","error","用户名已存在");
                    // 点击注册按钮，没有效果，添加一个自定义属性
                    $("#sign_up_modal_sign_btn").attr("ajax-value","error");
                }else{
                    show_validate_msg("#sign_name_input","success","用户名可用");
                    $("#sign_up_modal_sign_btn").attr("ajax-value","success");
                }
            }
        });
    })

    // 注册 模态框 ，点击 注册按钮 的事件，先校验是否符合格式
    // 再判断数据库中的重复性，如果要保证某个字段唯一，就要检验
    $("#sign_up_modal_sign_btn").click(function () {

        // 提交数据先进行前端校验
        if(!form_validate_name("#sign_name_input")) {
            return false;
        }

        // 如果上边 用户名检验失败，直接返回false
        if($(this).attr("ajax-value")=="error") {
            // 使用抽取的函数 显示提示信息
            show_validate_msg("#sign_name_input","error","用户名已存在");
            return false;
        }

        // 学习ajax 发送请求，success 对象
        $.ajax({
            url:"${APP_PATH}/signup",
            type:"POST",
            data:$("#sign_up_from").serialize(),
            // result 是controller函数返回对象（序列化后的json字符）
            success:function (result) {
                if(result.code==100){
                    // 使用抽取的函数 显示提示信息
                    $("#signUpModal").modal("hide");
                    // 跳出登录页面
                    $("#loginModal").modal({
                        backdrop:"static"
                    });
                }else{
                    return false;
                }

            }
        });
    });

    // 登录按钮 模态框 ，点击 登录按钮 的事件，先校验是否符合格式
    // 再判断数据库中的重复性，如果要保证某个字段唯一，就要检验
    $("#login_modal_login_btn").click(function () {

        // 学习ajax 发送请求，success 对象
        $.ajax({
            url:"${APP_PATH}/login",
            type:"POST",
            data:$("#login_form").serialize(),
            // result 是controller函数返回对象（序列化后的json字符）
            success:function (result) {
                if(result.code==100){
                    // 使用抽取的函数 显示提示信息
                    $("#loginModal").modal("hide");
                    // 跳转
                    $(location).attr('href', "${APP_PATH}/old10");
                }else{
                    show_validate_msg("#login_modal_name_input","error","用户名或密码错误");
                    return false;
                }

            }
        });
    });

    // 校验数据
    function form_validate_name(element) {
        // 拿到form数据
        var stdName = $(element).val();
        var regName = /(^[a-zA-Z_-]{4,10}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
        // alert(regName.test(stdName));
        if (regName.test(stdName)) {
            show_validate_msg(element, "success", "");
        } else {
            show_validate_msg(element, "error", "用户名：2-5汉字或4-10字母");
            return false;
        }
        return true;
    }

    function form_validate_qq(element) {
        var stdQQ= $(element).val();
        var regQQ=/(^[0-9]{5,11}$)/;
        // alert(regQQ.test(stdQQ));
        if (regQQ.test(stdQQ)){
            show_validate_msg(element,"success","");
        } else{
            show_validate_msg(element,"error","QQ号：5-11数字");
            return false;
        }
        return true;
    }

    // 抽取校验的方法
    function show_validate_msg(element, status, msg) {
        // 清楚元素以前的状态
        $(element).parent().removeClass("has-success has-error");
        $(element).next("span").text("");
        if(status=="success"){
            $(element).parent().addClass("has-success");
            $(element).next("span").text(msg);
        }else if(status=="error"){
            $(element).parent().addClass("has-error");
            $(element).next("span").text(msg);
        }

    }


</script>

</body>
</html>
