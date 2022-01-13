<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
    <title>优就业-线医疗管理系统</title>
	<meta charset="UTF-8">
	<link rel="icon" href="Images/logo_favicon.ico" type="image/x-icon" />
   <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="Js/jquery.validate.js"></script>
    <script type="text/javascript" src="Js/messages_zh.js"></script>
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background-color: buttonhighlight;
        }

        .form-signin {
            max-width: 600px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            background: rgba(255,255,255,0.5);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            font-size: 24px;
            margin-left: 90px;
        }
        
        .form-signin .form-signin-heading{
        	margin-bottom: 10px;
            font-size: 24px;
            margin-left: 200px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
		
		
		#message{
			font-size: 14px;
			color:red;
			margin-left: 40px;
		}
		
		.input-block-level{
			width: 300px;
			margin-left: 40px;
		}
		.input-medium{
			margin-left: 40px;
		}
		.code_images{
			width: 115px;
			height: 35px;
			margin-top: -15px;
			margin-left: 10px;
		}
		.error{
			color: red;
			font-size: 14px;
		}
		
    </style>  
</head>
<body>
<div class="container">	
    <form class="form-signin" method="post" action="user">
    	<input type="hidden" name="method" value="regist">
        <h2 class="form-signin-heading" >管理员注册</h2>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
		<input type="text" name="name" class="input-block-level" placeholder="账号">
		<br/>
                        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
        <input id="password" type="password" name="password" class="input-block-level" placeholder="密码">
        <br/>
                       确认密码：<input type="password" name="password2" class="input-block-level" placeholder="确认密码">
        <br/>
                        用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" id="username" name="username" class="input-block-level" placeholder="用户名">
        <span id="username_msg"></span><br/>
                        邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" id="email" name="email" class="input-block-level" placeholder="邮箱">
        <span id="email_msg"></span><br/>               
        <p style="text-align: center;">
        <input id="login" type="button" value="注册" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input id="reset" type="reset" value="清空" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        </p>
    </form>
</div>

<script type="text/javascript">
//单击注册按钮表单提交
$("#login").click(function(){
	$("form").submit();
})
//表单验证：姓名\密码\确认
$("form").validate({
	rules:{
		"name":{
			"required":true
		},
		"password":{
			"required":true,
			"rangelength":[3,10]
		},
		"password2":{
			"required":true,
			"rangelength":[3,10],
			"equalTo":"#password"
			
		}
	},
	messages:{
		"name":{
			"required":"用户名不能为空！"
		},
		"password":{
			"required":"密码不能为空！",
			"rangelenth":"密码长度必须在3到10位之间！"
		},
		"password2":{
			"required":"确认密码不能为空！",
			"rangelenth":"密码长度必须在3到10位之间！",
			"equalTo":"两次密码不一致！"
			
		}
	},
	errorElement:"error"
})
	//验证用户名的非空、是否存在
	$("#username").blur(function(){
		//获取用户名
		var username=$("#username").val();
		if(username==null||username==""){
			$("#username_msg").text("用户名不能为空！").css("color","red");
		}else{
			//向后台发送请求
			$.ajax({
				url:"user",
				type:"post",
				data:{
					"username":username,
					"method":"checkUserName"
				},
				dataType:"json",
				success:function(obj){
					if(obj){
						$("#username_msg").text("用户名已存在，不能注册！").css("color","red");
					}else{
						$("#username_msg").text("用户验证通过！").css("color","green");
					}
				}
			})
		}
	}) 
	//验证邮箱的非空、格式、是否存在的验证
	$("#email").blur(function(){
		//获取用户名
		var email=$("#email").val();
		//正则表达式（邮箱）
		var reg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
		if(email==null||email==""){
			$("#email_msg").text("邮箱不能为空！").css("color","red");
		}else if(!reg.test(email)){
			$("#email_msg").text("邮箱格式不正确！").css("color","red");
		}
		else{
			//向后台发送请求
			$.ajax({
				url:"user",
				type:"post",
				data:{
					"email":email,
					"method":"checkEmail"
				},
				dataType:"json",
				success:function(obj){
					if(obj){
						$("#email_msg").text("该邮箱已被注册！").css("color","red");
					}else{
						$("#email_msg").text("邮箱验证通过！").css("color","green");
					}
				}
			})
		}
	}) 
</script>
</body>
</html>