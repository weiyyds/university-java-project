<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/17
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="static/css/register.css">
    <link rel="stylesheet" href="static/css/easyui.css">
    <link rel="stylesheet" href="static/css/icon.css">
    <script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>

</head>
<body>
    <div id="top">
        <div>
            <span onclick="login()">首页</span>
            <span>|</span>
            <span onclick="login()">退出</span>
        </div>
    </div>
    <div id="register_title">
        <h3>用户注册</h3>
    </div>
<%--    --%>
    <form id="form_register">
        <div>
            <table>
                <tr>
                    <td>电子邮箱：</td>
                    <td><input type="text" name="email" id="email"></td>
                </tr>
                <tr>
                    <td>手机号：</td>
                    <td><input type="text" name="telNumber" id="telNumber"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" id="password"></td>
                </tr>
                <tr>
                    <td>密码确认：</td>
                    <td><input type="password" name="password2" id="password2"></td>
                </tr>
            </table>
        </div>
        <div>
            <span>提示：</span><span>1.邮箱和手机号均可作为您的登录账号，并用于重置密码使用，请务必仔细核对正确填写</span>
            <br><span>2.密码长度为8-18位字符，且必须同时包含：字母、数字和特殊字符!@#$%^&*_-</span>
        </div>
        <div>
            <h4>个人资料（可选填）</h4>
            <span>证件类型：</span>
            <select id="card">
                <option value="">中华人民共和国居民身份证</option>
                <option value="">台湾居民往来大陆通行证</option>
                <option value="">港澳居民往来内地通行证</option>
                <option value="">军人证件</option>
                <option value="">护照</option>
                <option value="">香港身份证</option>
                <option value="">澳门身份证</option>
            </select><br>
            证件号：<input type="text" name="ID_number" id="" style="margin-left: 20px"><br>
            姓名：<input type="text" name="name" id="" style="margin-left: 35px"><br>
            <span style="color: red">提示：个人资料非报考信息，考生报名时需要采集或关联个人基本信息</span><br>
            验证码：<input type="text" name="" id="" style="width: 100px">
            <img id="captcha" src="${pageContext.request.contextPath}/123" alt="">
            <a href="javascript:void(0);" onclick="flush_()">看不清楚</a><br>

        </div>
        <button type="button" onclick="register()" class="resigin_button" >注册</button>
    </form>

</body>
<script type="text/javascript">
<%--添加格式验证信息--%>
    $('#email').validatebox({
        required: true,
        validType: 'email',
        missingMessage:'邮箱不能为空！'
    });
    $('#telNumber').validatebox({
        required: true,
        validType: 'length[11,11]',
        missingMessage:'手机号码不能为空！',
        invalidMessage:'手机号码数字请输入11位！'
    });
function register() {
    var password=$("#password").val();
    var password2=$("#password2").val();
    if (password==password2){
        $.ajax({
            url:"${pageContext.request.contextPath}/adduser",
            type:"post",
            // data:JSON.stringify($("#form_register").serialize()),
            data:$("#form_register").serialize(),
            // contentType: "application/json; charset=utf-8",
            // dataType:"json",
            success:function (data) {
                if (data.toString()==="1"){
                    alert("注册成功");
                    window.location="${pageContext.request.contextPath}/login.jsp"
                }else{
                    alert("注册失败")
                }
            }
        });
    }else {
        alert("两次的密码输入不一致！！请您重新输入")
    }

}


    function flush_() {
        document.getElementById("captcha").src = "<%=request.getContextPath()%>/123?d="+new Date();
        window.location.reload();
    }
    //返回首页index.jsp
    function login() {
        window.location="index.jsp"
    }
</script>
</html>
