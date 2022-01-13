<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/13
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>维修登记</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
</head>

<body>
<style>
    #rep_container{
        width: 100%;
        padding-left: 50px
    }
    .margin-top{
        margin-top: 10px;
    }
    #rep_form_button{
        top: 150px ! important;
        width: 167px ! important;
        background: white;
        position: absolute;
        right: 20px;
        margin-top: 10px;
    }
    #rep_container2{
        width: 100%;
        padding-left: 50px
    }
    #rep_form_button2{
        top: 150px ! important;
        width: 167px ! important;
        background: white;
        position: absolute;
        right: 20px;
        margin-top: 10px;
    }
</style>
<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addRepairedMessage()">添加</a>
<table id="repaired_dg"></table>
<div id="rep_container" style="display: none">
    <form id="repaired_form">
        <div class="margin-top">
            <input type="hidden" value="">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>宿舍楼:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox" name="dormitoryid" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>报修事由:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox" name="reason" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>提交时间:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" id="time" type="text" class="easyui-datebox" name="submit_time">
        </div>
        <div id="rep_form_button">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="submitMessage()">Ok</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">Cancel</a>
        </div>
    </form>
</div>

<div id="rep_container2" style="display: none">
    <form id="repaired_form2">
        <div class="margin-top">
            <input type="hidden" name="id" value="">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>宿舍楼:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="easyui-textbox" name="dormitoryid" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>报修事由:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="easyui-textbox" name="reason" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>提交时间:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="time2" type="text" class="easyui-datebox" name="submit_time">
        </div>
        <div id="rep_form_button2">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="edit_repairedMessage2()">确认</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">取消</a>
        </div>
    </form>
</div>
<script>
    function edit_repairedMessage2() {
        $("#repaired_form2").form('submit',{
            url:'${pageContext.request.contextPath}/edit_repairedMessage2',
            success:function(data){
                var json=JSON.parse(data);
                //关闭对话框
                $("#rep_container2").dialog('close');
                //弹出信息提示
                $.messager.show({
                    title:'系统提示',
                    msg:json.msg,
                    timeout:3000,
                    showType:'slide'
                });
                //修改成功,刷新datagrid
                $('#repaired_dg').datagrid('reload');
            }
        })
    }
<%--    修改维修信息--%>
    function edit_repairedMessage() {
        $("#rep_container2").dialog({
            title: '维修基本信息修改',
            width: 400,
            height: 250,
            iconCls:'icon-save',
            modal: true,
            closed: false,
            toolbar:'#rep_form_button2',
        });
        $("#repaired_dg").datagrid('options').onClickRow=function (index,row) {
            $("#repaired_form2").form("load",row);

        }

    }
    function submitMessage() {
        $.ajax({
            url:"${pageContext.request.contextPath}/add_repaired",
            type:"post",
            data:$("#repaired_form").serialize(),
            success:function (flag) {
                if(flag==true){
                    //提示添加成功
                    $.messager.show({
                        title:'我的消息',
                        msg:'添加成功',
                        timeout:3000,
                        showType:'slide'
                    });
                    //关闭对话框
                    $('#rep_container').dialog('close');
                    //刷新
                    $('#repaired_dg').datagrid('reload');
                }
            }
        })


    }

    //添加维修信息
    function addRepairedMessage() {
        $('#rep_container').dialog({
            title: '维修登记',
            width: 450,
            height: 250,
            iconCls:'icon-save',
            modal: true,
            toolbar:'#rep_form_button'
        });
    $("#repaired_form").form('reset');

    }
    $('#repaired_dg').datagrid({
        url:'${pageContext.request.contextPath}/select_repaired_page',
        // url:'data.json',
        fitColumns:true,
        columns:[[
            {field:'id',title:'ID',width:100,},
            {field:'dormitoryid',title:'宿舍楼',width:100},
            {field:'reason',title:'报修事由',width:100},
            {field:'submit_time',title:'提交时间',width:100},
            {field:'operate',title:'操作',width:150,
                formatter:function (value,row,index) {
                    return "<a href='#' class='delete' onclick='delete_repaired()'>删除</a>&nbsp;&nbsp;"+
                        "<a href='#' class='edit' onclick='edit_repairedMessage()'>修改</a>"
                }},
        ]],
        onLoadSuccess:function(data){
            $(".delete").linkbutton({ text:'删除', plain:true, iconCls:'icon-remove' });
            $(".edit").linkbutton({ text:'修改', plain:true, iconCls:'icon-edit' });

        },
        pagination:true,
        pageSize:4,
        pageList:[4,16,32]
    });
    function delete_repaired() {
        //删除一条维修信息
            $("#repaired_dg").datagrid('options').onClickRow=function (index,row) {
                //是否确认删除
                $.messager.confirm('系统确认', '您想要删除该数据吗？', function(r){
                    if (r){
                        //发送请求
                        $.ajax({
                            url:"${pageContext.request.contextPath}/delete_repaired?id="+row.id,
                            type:"get",
                            success:function (data) {
                                $('#repaired_dg').datagrid('reload');
                                //提示信息
                                $.messager.show({
                                    title:'系统提示',
                                    msg:data.msg
                                })
                            }
                        })
                    }
                });


            }


    }
</script>
</body>

</html>
