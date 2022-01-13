<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/11
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../css/findpwd.css" />
</head>
<body>
<form action="" class="login">
    <p class="fpwd">找回密码</p>
    <input type="text" placeholder="请输入注册的 手机号" id="phone">
    <input type="text" placeholder="请输入注册的 邮箱" id="email"/>
    <input type="submit" class="btn" value="立即验证" onclick="findpwd()" />
</form>
<script>
    function findpwd(){
        var phone=$("#phone").val();
        var email=$("#email").val();
        $('.login').form({
            onSubmit: function(){
                if (phone==""){
                    alert("请输入手机号，不能为空");
                    return false;
                }
                if (email==""){
                    alert("请输入邮箱,不能为空");
                    return false;
                }
                alert('验证成功 , 请重新登录');
                location.href='${pageContext.request.contextPath}/login.jsp';
            },


        });

    }
</script>
</body>

</html>
