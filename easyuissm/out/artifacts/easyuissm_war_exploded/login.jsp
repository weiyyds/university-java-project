<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/14
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 引入css代码--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css"/>
    <%--   引入js代码 --%>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
    .icon-login{
        background:url('img/login.png') no-repeat center center;
    }
</style>
    <script type="text/javascript">
        $(function () {
        $("#login_submit").click(function () {
            $('#login_form').form('submit', {
                url:'${pageContext.request.contextPath}/main/login',
                onSubmit: function(){
                   //非空验证规则
                    if ($(":text:eq(0)").val()==""){
                        $.messager.alert('系统信息','用户名不能为空！');
                        return false;
                    }
                    else if($(":password:eq(0)").val()==""){
                        $.messager.alert('系统信息','密码不能为空！');
                        return false;
                    }
                },
                success:function(data){
                    if (data=='1'){
                        location.href="${pageContext.request.contextPath}/main.jsp";
                    }else{
                        $.messager.alert('系统提示','登录失败');
                    }
                }
            });
        })
        })
    </script>
</head>
<body style="background-color: #E9F1FF">
<div style="margin: 150px auto;width: 420px">
    <div id="p" class="easyui-panel" title="登录"
         style="width:420px;height:220px;padding:10px;background:#fafafa;"
         data-options="iconCls:'icon-login',closable:true,
                collapsible:true,minimizable:true,maximizable:true">
        <form action="login" method="post" id="login_form">
            <table width="240" align="center">
                <tr>
                    <td colspan="2" style="text-align: center;font-size: 20px;font-weight: bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至尊管理系统</td>
                </tr>
                <tr style="height: 40px;">
                    <td >登录名</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr style="height: 40px;">
                    <td>密码</td>
                    <td><input type="password" name="pwd" id="pwd"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <a id="login_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</div>

</body>
</html>
