<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/2
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回账号</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
    }


    body {
        height: 100vh;
        width: 100%;
        overflow: hidden;
        background-image: linear-gradient(125deg, #F44336, #E91E63, #9C27B0, #3F51B5, #2196F3);
        background-size: 400%;
        font-family: "montserrat";
        animation: bganimation 15s infinite;
    }

    @keyframes bganimation {
        0% {
            background-position: 0% 50%;
        }

        50% {
            background-position: 100% 50%;
        }

        100% {
            background-position: 0% 50%;
        }
    }


    .form {
        width: 85%;
        max-width: 600px;
        /* max-height: 700px; */
        background-color: rgba(255, 255, 255, .05);
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 0 5px #000;
        text-align: center;
        font-family: "微软雅黑";
        color: #fff;
    }


    .form h1 {
        margin-top: 0;
        font-weight: 200;
    }

    .form .txtb {
        border: 1px solid #aaa;
        margin: 8px 0;
        padding: 12px 18px;
        border-radius: 10px;
    }

    .txtb label {
        display: block;
        text-align: left;
        color: #fff;
        font-size: 14px;
    }


    .txtb input,
    .txtb textarea {
        width: 100%;
        background: none;
        border: none;
        outline: none;
        margin-top: 6px;
        font-size: 18px;
        color: #fff;
    }



    .btn {
        display: block;
        /* background-color: rgba(156, 39, 176, .5); */
        padding: 14px 0;
        color: #fff;
        cursor: pointer;
        margin-top: 8px;
        width: 100%;
        border: 1px solid #aaa;
        border-radius: 10px;
    }
    .captcha_position{
        margin-top: -30px;
        position: absolute;
        left: 175px;
    }
</style>
<div class="form">
    <form action="">
        <h1>找回账号</h1>
        <div class="txtb">
            <label for="">手机号:</label>
            <input type="text" placeholder="请输入手机号"></div>
        <div class="txtb">
            <label for="">验证码:</label>
            <input type="text" placeholder="请输入验证码">
           <div class="captcha_position">
               <img alt="" id="captcha" src='<%=request.getContextPath()%>/123'/>
               <a href="javascript:void(0);" onclick="flush_()" style="color: pink">看不清楚</a>
           </div>
        </div>
        <div class="txtb">
            <label for="">新账号:</label>
            <input type="text" placeholder="请设置新账号"></div>
        <div class="txtb">
            <label for="">确认新账号:</label>
            <input type="text" placeholder="请重新输入新账号"></div>
        <a href="login.jsp"><span class="btn">提交</span></a>
    </form>
</div>
<script>
    function flush_() {
        document.getElementById("captcha").src = "<%=request.getContextPath()%>/123?d="+new Date();
        window.location.reload();
    }
</script>
</body>
</html>
