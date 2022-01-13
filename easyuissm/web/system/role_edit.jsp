<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    $(function () {
        $("#role_edit_submit").click(function () {
            $('#role_edit_form').form('submit', {
                url:'${pageContext.request.contextPath}/update',
                onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){
                    if (data==1){
                        $.messager.show({
                            title:'系统消息',
                            msg:'修改成功！！',
                            timeout:3000,
                            showType:'slide'
                        });
                        //关闭dialog
                        $("#role_dialog").dialog("close");
                        //重新刷新页面内容
                        $('#role_table').datagrid('reload');
                    }else{
                        $.messager.alert("系统信息","修改失败，请重新修改！！");
                    }
                }
            });
        })

    })
</script>
<div style="padding: 10px;">
系统设置>>角色管理
<hr/>
<form action="" method="post" id="role_edit_form">
    <input type="hidden" name="id">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>角色排序</td>
            <td><input type="text" name="sort" id="sort"></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input type="text" name="remark" id="remark"></td>
        </tr>
        <tr>
            <td colspan="2">
                <a id="role_edit_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
