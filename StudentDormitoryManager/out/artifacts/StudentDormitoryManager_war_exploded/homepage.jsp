<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/9/30
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
    }
    body{
        width: 100%;
        height: 100%;
    }
    /*多行文本溢出*/
    .ellipsis{
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }
    #message{

    }
    #message>p:nth-child(1){
    }
    #message>p:nth-child(2){
        margin-top: 10px;
    }
</style>
<body>
<div id="homeContainer" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north',split:true" style="height:7%;background: #DFEDFF;padding-top: 10px">
        <span style="padding-left:10px; font-size: 16px;">学生宿舍管理系统</span>
        <div style="float: right;padding-right: 10px">
        <span>${sessionScope.sname}</span>您好，欢迎使用&nbsp;&nbsp;&nbsp;
        <a href="/exit" >安全退出</a>
        </div>
    </div>
    <div data-options="region:'south',title:'',split:true" style="height:100px;">
        <span style="width:300px;height:100px;margin-left: 500px">Copyright &nbsp; &copy;【CV团伙】</span>
    </div>
    <div id="message" data-options="region:'east',iconCls:'icon-reload',title:'消息',split:true" style="width:200px;">
        <p class="ellipsis">宿舍门装饰宿舍门是被外界所直观感知的最前沿,宿舍文化的体现窗口,参照中国矿大矿院宿舍,北区个别宿舍,有以下建议:</p>
        <p class="ellipsis">宿舍内装饰(自愿)宿舍文化装饰指各宿舍确定自己宿舍的风格，如文雅、温馨、活泼等。发挥宿舍成员充分的想象力，可通过装饰墙壁（禁止涂鸦，张贴低俗海报）、天花板，张贴宿舍铭或悬挂健康向上的书画作品或摆放富有特色的饰物或利用照片、彩带、气球等装饰，严禁破坏移动宿舍原有物品！</p>
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:150px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true,selected:-1" style="width:150px;animate:true">
            <div title="学生管理" data-options="iconCls:'icon-man'" style="padding:10px;">
                <a id="btn" href="#" onclick="createStudentTab()">学生信息</a>
            </div>
            <div title="维修登记" data-options="iconCls:'icon-add'" style="padding:10px;">
                <a id="repaired_btn" href="#" onclick="createRepairedTab()">维修登记</a>
            </div>

        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:white;">
        <div class="easyui-tabs" id="tabs" data-options="fit:true">
            <jsp:include page="welcome.jsp"></jsp:include>
        </div>


    </div>
</div>
</body>
<script>

    function createStudentTab() {
        //关闭欢迎界面
        $("#tabs").tabs('close','欢迎使用');
        if (!$("#tabs").tabs('exists','学生信息')){
            $("#tabs").tabs('add',{
                title:'学生信息',
                closable:true,
                href:'${pageContext.request.contextPath}/studentMessage.jsp'
            });
        }
        if ($("#tabs").tabs('select','学生信息')){
            $('#dg').datagrid('reload');    // 重新载入当前页面数据
        }

    }
        function createRepairedTab() {
            //关闭欢迎界面
            $("#tabs").tabs('close','欢迎使用');
            if (!$("#tabs").tabs('exists','维修登记')){
                $("#tabs").tabs('add',{
                    title:'维修登记',
                    closable:true,
                    href:'${pageContext.request.contextPath}/repaired.jsp'
                });
            }
            if ($("#tabs").tabs('select','维修登记')){
                $('#dg').datagrid('reload');    // 重新载入当前页面数据
            }
        }

</script>
</html>
