<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/5
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div>
    <p class="begin">欢迎您注册宿舍管理系统，若已有账户，请点击&nbsp;<a href="login.jsp" class="easyui-linkbutton" class="login">登录</a></p><!-- 开头标题，a跳转登录页面 -->
<form action="" id="reg_form">
    <table>
        <tr>
            <td class="td">
                <span class="span">姓名：</span>
                <input type="text" placeholder="请输入名称" class="easyui-validatebox" name="sname"><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">用户名：</span>
                <input name="sno" type="text" placeholder="请输入学号11位数" class="easyui-validatebox" id="sid"><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">设置密码：</span>
                <input name="password" type="password" placeholder="请输入不少于6位密码" class="easyui-validatebox" data-options="validType:'minLength[6]'" id="password""><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">确认密码：</span>
                <input type="password" placeholder="请再次输入密码" id="checkpassword""><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">联系方式：</span>
                <input name="sphone"  type="text" placeholder="请输入11位手机号码" id="telNumber"><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">邮箱地址：</span>
                <input name="email" type="text" placeholder="请输入邮箱地址" class="easyui-validatebox" data-options="required:true,validType:'email'"><br>
            </td>
        </tr>
        <tr>
            <td class="td">
                <span class="span">验证码：</span>
                <input type="text" id="reg_input_code" name="reg_input_code">

            </td>
            <td>
                <div class="look">
                    <img alt="" id="captcha" src='<%=request.getContextPath()%>/123'/>
                </div>

            </td>
            <td>
                <a href="javascript:void(0);" onclick="flush_()" style="color: pink">看不清楚</a>
            </td>
        </tr>
    </table>
    <a id="register" href="#" class="easyui-linkbutton" onclick="myfunction()">注册</a>
</form>
</div>
</body>
<script>
    <%--function go_login() {--%>
    <%--    location.href="${pageContext.request.contextPath}/login.jsp";--%>
    <%--}--%>
    function flush_() {
        document.getElementById("captcha").src = "<%=request.getContextPath()%>/123?d="+new Date();
        window.location.reload();
    }
    $('#sid').validatebox({
        required: true,
        validType: 'length[11,11]',
        missingMessage:'用户名不能为空！',
        invalidMessage:'用户名请输入11位！'
    });
    $('#telNumber').validatebox({
        required: true,
        validType: 'length[11,11]',
        missingMessage:'手机号码不能为空！',
        invalidMessage:'手机号码数字请输入11位！'
    });
    function myfunction(){

    //提交表单注册
        $('#reg_form').form('submit',{
            url:"${pageContext.request.contextPath}/register",
            onSubmit: function(){
                var password=$("#password").val();
                var password2=$("#checkpassword").val();
                console.log(password,password2);
                var sid=$('#sid').val();
                var len=$('#telNumber').val();
                var telNumber=len.length;
                console.log(telNumber);
                console.log(sid);
                var reg_input_code=$("#reg_input_code").val();

                if (sid==="") {
                    alert('用户名为空');
                    return false;
                }else{
                    if(password===""){
                        alert("密码不能为空");
                        return false;
                    }else{
                        if(telNumber===11){
                           if(reg_input_code===""){
                               alert("请输入验证码");
                               return false;
                           }else{
                               if (password===password2){
                                   console.log("注册成功");
                               }else{
                                   alert("密码不一致，请重新输入");
                                   return false;
                               }
                           }
                        }
                        else{
                            alert("请输入正确手机格式");
                            return false;
                        }
                    }
                }
            },
            success:function(data){
                console.log(data);
                var json=JSON.parse(data);
                if(json.msg=="注册成功"){
                    alert("注册成功");
                    //清除表单内容
                    $("#reg_form").form('clear');
                    location.href="${pageContext.request.contextPath}/login.jsp";
                }else{
                    alert("注册失败,验证码输入错误");
                }

            }
        });
    }

</script>
</html>
