<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/14
  Time: 21:52
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
    <script type="text/javascript">
        $(function () {
            $('#main_tree').tree({
                url:'${pageContext.request.contextPath}/showMenu',
                onClick:function (node) {
                    if ($("#main_tabs").tabs('getTab',node.text)==null){
                        //alert(node.text);
                        $('#main_tabs').tabs('add',{
                            title: node.text,
                            selected: true,
                            //content:'<b>这里加内容</b>'
                          /*  href:'${pageContext.request.contextPath}/system/role.jsp'*/
                            href:node.attributes.fileName,
                            closable:true,


                        });
                    }else {
                        $("#main_tabs").tabs('select',node.text);
                    }


                }
            });
        });
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'至尊管理系统'" style="height:100px;">
    <div style="width: 400px;height: 66px;float: left;font-size: 20px;font-weight: bold;line-height: 66px;padding-left: 20px;">
        至尊管理系统
    </div>
    <div style="width: 200px;height: 66px;float: right;line-height: 66px;">
        你好，${user.name},欢迎登陆！
    </div>
</div>
<div data-options="region:'south',title:'底部声明'" style="height:100px;">
    <div style="height: 66px;line-height: 66px;text-align: center;color: gray;">
        Copyright &copy; 2021 黄少伟 408
    </div>
</div>
<div data-options="region:'west',title:'菜单'" style="width:200px;">
    <ul id="main_tree"></ul>
</div>
<div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
    <div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
        <div title="首页" style="padding:20px;">
            tab1 ad
        </div>

    </div>
</div>
</body>
</html>
