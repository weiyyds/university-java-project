<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" href="static/css/login.css">
    <link rel="stylesheet" href="static/css/easyui.css">
    <link rel="stylesheet" href="static/css/icon.css">
    <script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>
</head>
<body>
    <div class="content">
    <div id="login_background">

    </div>
    <form id="login_form">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>账号：</td>
                <td><input type="text" name="telNumber" id="tel" placeholder="请输入手机号" style="border-radius: 8px">&nbsp;&nbsp;&nbsp;</td>
                <td><span class="search_tel">找回账号</span><br></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" id="pwd" placeholder="请输入密码" style="border-radius: 8px">&nbsp;&nbsp;&nbsp;</td>
                <td><span class="search_password">找回密码</span><br></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input type="text" name="input_code" id="" style="border-radius: 8px"></td>
                <td> <img alt="" id="captcha" src='<%=request.getContextPath()%>/123'/>
                    <a href="javascript:void(0);" onclick="flush_()">看不清楚</a>
                </td>
            </tr>

        </table>
        <p>没有通行证?<span onclick="go_register()">点击注册</span></p>
        <button type="button" onclick="success_login()">登录</button>
        <button type="reset">重置</button>
    </form>
    </div>
</body>
<script type="text/javascript">
<%--    点击注册按钮--%>
function go_register() {
    window.location="${pageContext.request.contextPath}/register.jsp"
}
    function success_login() {
        $.ajax({
            url:"${pageContext.request.contextPath}/login",
            type:"post",
            data:$("#login_form").serialize(),
            success:function (data) {
                console.log(data);
                if (data>0){
                    window.location="${pageContext.request.contextPath}/success_login.jsp"
                }else if(data==-1){
                    //alert("该用户没有注册,请先注册后再登录！！")
                    alert("账号 || 密码不能为空！！");
                }else if (data==-2){
                    alert("验证码输入错误！！");
                }else if (data==0){
                    alert("该用户没有注册,请先注册后再登录！！");
                }

            }
        });
    }
    function flush_() {
         document.getElementById("captcha").src = "<%=request.getContextPath()%>/123?d="+new Date();
        // alert("88");
        window.location.reload();
    }

</script>
</html>
