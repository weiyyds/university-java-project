<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/14
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <link rel="stylesheet" href="static/css/index.css">
  <body>
<%--首页--%>
  <div id="top">
    <span>全国大学英语四六级考试</span>
    <span>010-62987880</span>
  </div>
  <div id="nav">
    <ul>
      <li><a href="">首页</a></li>
      <li><a href="">考试简介</a></li>
      <li><a href="">考生须知</a></li>
      <li><a href="">考试时间</a></li>
      <li><a href="">报名流程</a></li>
      <li><a href="">常见问题</a></li>
      <li><a href="">成绩报告单</a></li>
    </ul>
  </div>
  <div id="img">
<%--图片--%>
  </div>
  <div class="content">
    <div id="content-left">
      <div>
        <img src="static/img/people.png" alt="">
        <span onclick="return_login()">进入报名</span>
      </div>
      <div>
        <img src="static/img/icon1.png" alt="">
        <span onclick="return_register()">注册用户</span>
      </div>
      <div>
        <img src="static/img/watch.png" alt="">
        <span>找回已报名的账号</span>
      </div>
      <div>
        <img src="static/img/bookicon.png" alt="">
        <span>补办成绩证明</span>
      </div>
      <div>
        <img src="static/img/icon2.png" alt="">
        <span>查询准考证</span>
      </div>
    </div>
    <div id="content-center">

    </div>
    <div id="content-right">
      <p>CET考试最新动态</p>
      <div>
        <span>2021年上半年考试时间</span>
        <span>笔试：6-12</span>
        <span>上午：英语、日语、德语、俄语、法语四级</span>
        <span>下午：英语、日语、德语、俄语六级</span>
        <span>口语：</span>
        <span>5-22：英语四级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5-23：英语六级</span>
      </div>
    </div>
  </div>
  </body>
<script>
<%--  跳转到登录界面--%>
  function return_login(){
    window.location="${pageContext.request.contextPath}/login.jsp"
  }
//  跳转到注册界面
function return_register(){
  window.location="register.jsp"
}

</script>
</html>
