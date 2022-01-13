<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/9/30
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>

</head>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
<body>
<style>
    .form_width{
        width: 100px;

    }
    #container{
        width: 100%;
        padding-left: 50px
    }
    .margin-top{
        margin-top: 10px;
    }
    #form_button{
        top: 300px ! important;
        width: 167px ! important;
        background: white;
        position: absolute;
        right: 20px;
        margin-top: 10px;
    }
    #container2{
        width: 100%;
        padding-left: 50px
    }
    #form_button2{
        top: 300px ! important;
        width: 167px ! important;
        background: white;
        position: absolute;
        right: 20px;
        margin-top: 10px;
    }
</style>

<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addStudent()">添加</a>
<a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="export_message()">导出</a>
<input id="search_value" name="Sname" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:150px">
<a id="search" href="#" class="easyui-linkbutton" onclick="searchByName()">搜索</a>

<table id="dg"></table>
<div id="container" style="display: none">
    <form id="student_form">
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>学号:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="easyui-textbox" name="sno" id="sno" value="" style="width: 200px;">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>姓名:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="easyui-textbox" name="sname" id="sname" value="" style="width: 200px;">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="男" id="man"  name="sex"/>男
            <input type="radio" value="女" id="woman" name="sex"/>女
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>年龄:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" type="text" class="easyui-numberbox" data-options="min:18,max:30" name="age" id="age" value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>电话:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox"  name="sphone" id="sphone" value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>班级:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox"  name="course" id="course" value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>宿舍编号:</label>
            <input style="width: 200px;" class="easyui-textbox"  name="dormitoryid" id="dormitoryid" value=""/>
        </div>
        <div id="form_button">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="submitMessage()">Ok</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">Cancel</a>
        </div>
    </form>

</div>


<div id="container2" style="display: none">
    <form id="student_form2">
        <div class="margin-top">
            <input type="hidden" name="id" value="">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>学号:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox" name="sno" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>姓名:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox" name="sname" value="">
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="男"  name="sex"/>男
            <input type="radio" value="女" name="sex"/>女
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>年龄:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" type="text" class="easyui-numberbox" data-options="min:18,max:30" name="age" value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>电话:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox"  name="sphone"  value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>班级:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width: 200px;" class="easyui-textbox"  name="course"  value=""/>
        </div>
        <div class="margin-top">
            <i style="color: red">*</i>&nbsp;&nbsp;<label>宿舍编号:</label>
            <input style="width: 200px;" class="easyui-textbox"  name="dormitoryid" value=""/>
        </div>
        <div id="form_button2">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="edit()">确认</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">取消</a>
        </div>
    </form>

</div>
<script>
<%--    模糊查询学生信息--%>
//    通过名字搜索信息
function searchByName() {
    //发请求
    $.ajax({
        url:"${pageContext.request.contextPath}/searchByName?Sname="+$("#search_value").val(),
        type:"get",
        success:function (data) {
            //重新加载本地数据
            $('#dg').datagrid('loadData',data);
            //清空输入框数据
            $("#search_value").textbox("setValue","");
        }
    })
}

<%--    修改页面学生信息--%>
        function edit() {
            //获取表单信息
            //通过form表单的submit方法提交给后台
            $("#student_form2").form('submit',{
                url:'${pageContext.request.contextPath}/edit',
                success:function(data){
                    var json=JSON.parse(data);
                    //关闭对话框
                    $("#container2").dialog('close');
                    //弹出信息提示
                    $.messager.show({
                        title:'系统提示',
                        msg:json.msg,
                        timeout:3000,
                        showType:'slide'
                    });
                    //修改成功,刷新datagrid
                    $('#dg').datagrid('reload');
                }
            })

        }
    function submitMessage() {
                $.ajax({
                    url:"${pageContext.request.contextPath}/add",
                    type:"post",
                    data:$("#student_form").serialize(),
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
                            $("#container").dialog('close');
                            //刷新
                            $('#dg').datagrid('reload');
                        }
                    }
                })


    }



    $('#dg').datagrid({
        url:'${pageContext.request.contextPath}/select',
        // url:'data.json',
        fitColumns:true,
        columns:[[
            {field:'id',title:'ID',width:100,},
            {field:'sex',title:'性别',width:100},
            {field:'age',title:'年龄',width:100},
            {field:'course',title:'班级',width:100},
            {field:'dormitoryid',title:'宿舍编号',width:100},
            {field:'sno',title:'学号',width:100},
            {field:'sname',title:'姓名',width:100},
            {field:'sphone',title:'手机号',width:100},
            {field:'operate',title:'操作',width:150,
                formatter:function (value,row,index) {
                    return "<a href='#' class='delete' onclick='delete_student()'>删除</a>&nbsp;&nbsp;"+
                        "<a href='#' class='edit' onclick='stu()'>修改</a>"
                }},
         ]],
        onLoadSuccess:function(data){
                $(".delete").linkbutton({ text:'删除', plain:true, iconCls:'icon-remove' });
                $(".edit").linkbutton({ text:'修改', plain:true, iconCls:'icon-edit' });

        },
        pagination:true,
        pageSize:8,
        pageList:[8,16,32]
    });
    function stu() {
        $("#container2").dialog({
            title: '学生基本信息修改',
            width: 400,
            height: 400,
            iconCls:'icon-save',
            modal: true,
            closed: false,
            toolbar:'#form_button2',
        });
        $("#dg").datagrid('options').onClickRow=function (index,row) {
            $("#student_form2").form("load",row);

        }


    }


    //添加学生信息
    function addStudent() {
        $('#container').dialog({
            title: '学生基本信息',
            width: 450,
            height: 400,
            iconCls:'icon-save',
            <%--href: '${pageContext.request.contextPath}/studentMessage.jsp',--%>
            modal: true,
            toolbar:'#form_button2'
        });

    }


//导出学生表信息
    function export_message() {
        var url = '${pageContext.request.contextPath}/export_message';
        $('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
    }
//删除一条学生信息
    function delete_student() {
       $("#dg").datagrid('options').onClickRow=function (index,row) {
           //是否确认删除
           $.messager.confirm('系统确认', '您想要删除该数据吗？', function(r){
               if (r){
                   //发送请求
                   $.ajax({
                       url:"${pageContext.request.contextPath}/delete_student?id="+row.id,
                       type:"get",
                       success:function (data) {
                           $('#dg').datagrid('reload');
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
