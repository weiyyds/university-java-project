<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/9/29
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>前台页面</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<style>
   *{
       padding: 0;
       margin: 0;
   }
    #login_background{
        width: 100%;
        height: 100%;
        background-image: url("./img/4.jpg");
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }
   #login_form{
       width: 700px;
       margin: -392px auto;
       padding-bottom: 5px;
   }
   #login_form>table{
       margin-left: 180px;
   }
   #login_form>table>tr:nth-child(1){}
   .search_tel:hover{
       color: blue;
       cursor: pointer;
   }

   #login_form>table>tr:nth-child(2){
   }
   .search_password:hover{
       color: blue;
       cursor: pointer;
   }

   #login_form>table>tr:nth-child(3){}
   #captcha{
       line-height: 20px;
   }


   #login_form>p{
       margin-left: 150px;
   }
   #login_form>p>span:hover{
       color: mediumorchid;
       cursor: pointer;
   }
   #login_form>button:nth-child(3){
       background-color: green;
       margin-left: 150px;
       font-size: 18px;
   }
   #login_form>button:nth-child(3):hover{
       cursor: pointer;
   }
   #login_form>button:nth-child(4){
       background-color: pink;
       margin-left: 30px;
       font-size: 18px;
   }
   #login_form>button:nth-child(4):hover{
       cursor: pointer;
   }
    .login_reset{
        width: 300px;
        height: 100px;
        text-align: center;
        margin-left: 144px;
        margin-top: 10px;
    }
   .login_reset>span:hover{
       color: blue;
       cursor: pointer;
   }
</style>
<body>
<div class="content">

    <div id="login_background">
        <h2 style="text-align: center;padding-top: 180px;color: white">宿舍管理系统</h2>
    </div>
    <form id="login_form" action="">
        <table cellpadding="2" cellspacing="6">
            <tr>
                <td style="font-size: 18px">账号：</td>
                <td><input
                           name="sno" id="sno"  style="border-radius: 8px;width: 200px"
                           class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入学号'">&nbsp;&nbsp;&nbsp;</td>
                <td><span class="search_tel" onclick="find_account()">找回账号</span><br></td>
            </tr>
            <tr>
                <td style="font-size: 18px">密码:</td>
                <td><input
                           name="password" id="pwd" style="border-radius: 8px;width: 200px"
                           class="easyui-passwordbox" prompt="请输入密码">&nbsp;&nbsp;&nbsp;</td>
                <td><span class="search_password" onclick="findpwd()">找回密码</span><br></td>
            </tr>
            <tr>
                <td style="font-size: 18px">验证码:</td>
                <td><input
                           name="input_code" id="input_code" style="border-radius: 8px;width: 200px"
                           class="easyui-textbox"></td>
                <td> <img alt="" id="captcha" src='<%=request.getContextPath()%>/123'/>
                    <a href="javascript:void(0);" onclick="flush_()" style="color: pink">看不清楚</a>
                </td>
            </tr>

        </table>
        <div class="login_reset">
              <span onclick="go_register()" style="margin-right: 50px">点击注册</span>
        <%--        <button type="button" onclick="success_login()">登录</button>--%>
                <a id="btn" href="#" class="easyui-linkbutton" onclick="login()">登录</a>
                <a id="btn" href="#" class="easyui-linkbutton" style="margin-left: 50px" onclick="reset()">重置</a>
        </div>
    </form>
</div>
</body>
<script>
    function findpwd() {
    location.href="${pageContext.request.contextPath}/findpwd.jsp"
    }
    function login() {
        $("#login_form").form('submit',{
            url:'${pageContext.request.contextPath}/login2',
            onSubmit: function(){
                var sno=$("#sno").val();
                var pwd=$("#pwd").val();
                var input_code=$("#input_code").val();
                if(sno==""||sno==null){
                    alert("账号不能为空");
                    return false;
                } if(pwd==""||sno==pwd){
                    alert("密码不能为空");
                    return false;
                } if(input_code==""||input_code==null){
                    alert("验证码不能为空");
                    return false;
                }

            },
            success:function (data) {
                var json=JSON.parse(data);
                console.log(json);
                if(json.msg=="登录成功"){
                    location.href='${pageContext.request.contextPath}/homepage.jsp';
                }else if(json.msg=="验证码输入错误"){
                    alert("验证码输入错误");
                    location.href='${pageContext.request.contextPath}/login.jsp';

                }else{
                    alert("该用户还未注册，请先注册后再登录");
                    location.href='${pageContext.request.contextPath}/login.jsp';
                }


            }
        })
    }
    function flush_() {
        document.getElementById("captcha").src = "<%=request.getContextPath()%>/123?d="+new Date();
        // alert("88");
        window.location.reload();
    }
//    清除表单数据==重置
    function reset(){
        $("#login_form").form('clear');
    }
//点击找回账号的回调函数
    function find_account() {
        location.href="/find_account.jsp"
        // location.href="/test.html"
    }
//点击注册的回调函数
    function go_register() {
        location.href="/register.jsp"
    }

</script>
</html>
