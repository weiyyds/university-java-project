<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="role_table"></table>
<div id="role_dialog"></div>
<script type="text/javascript">
    function abc(obj){

        $('#role_dialog').dialog({
            title: '分配权限',
            width: 400,
            height: 220,
            closed: false,
            cache: false,
            href: '${pageContext.request.contextPath}/system/privilege.jsp',
            modal: true,
            //在弹出窗口时加载数据
            onLoad:function () {

                $("#privilege_form :hidden:eq(0)").val($(obj).parent().parent().siblings("[field='id']").children().eq(0).html());
                $("#privilege_tree").tree({
                url:"${pageContext.request.contextPath}/showPrivilege?id="+$(obj).parent().parent().siblings("[field='id']").children().eq(0).html(),
                     checkbox:true
                });
            }

        });
    }


    $(function () {
        //表格的
        $('#role_table').datagrid({
            url:'${pageContext.request.contextPath}/showRole',
            columns:[[
                {field:'id',title:'编号',width:100,hidden:true},
                {field:'name',title:'角色名称',width:100},
                {field:'sort',title:'排序id',width:100,align:'right'},
                {field:'remark',title:'备注',width:100,align:'right'},
                {
                    field: 'abc', title: '操作', width: 100, align: 'right', formatter: function (value, row, index) {
                    return "<a id='role_privilege_a' href='javascript:void(0)' onclick='abc(this)'>分配权限</a> &nbsp;&nbsp;<a href=''>查看</a>";
                    }
                }
            ]],
            pagination:true,
            pageSize:2,//当前页面的总条数大小
            pageList:[2,4,6],//在设置分页属性的时候初始化页面大小选择列表。
            fitColumns:true,
            striped:true,
            //singleSelect:true,
            rownumbers:true,
            toolbar: [{
                iconCls: 'icon-add',
                text:'增加',
                handler: function(){alert('正在建设中')}
            },'-',{
                iconCls: 'icon-remove',
                text:'删除',
                handler: function(){alert('正在建设中')}
            },'-',{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    //alert($("#role_table").datagrid("getSelections").length)
                 if ($("#role_table").datagrid("getSelections").length==1){
                     //弹出窗口的
                     $('#role_dialog').dialog({
                         title: '修改角色',
                         width: 400,
                         height: 220,
                         closed: false,
                         cache: false,
                         href: '${pageContext.request.contextPath}/system/role_edit.jsp',
                         modal: true,
                         //在弹出窗口时加载数据
                         onLoad:function () {
                            $("#role_edit_form :text:eq(0)").val($("#role_table").datagrid("getSelected").name);
                            $("#role_edit_form :text:eq(1)").val($("#role_table").datagrid("getSelected").sort);
                            $("#role_edit_form :text:eq(2)").val($("#role_table").datagrid("getSelected").remark);
                            $("#role_edit_form :hidden:eq(0)").val($("#role_table").datagrid("getSelected").id);
                         }
                     });
                    }else{
                     $.messager.alert('系统信息','请选择<b style="color: red;">一行</b>数据修改');
                 }


                }
            }]
        });

    })
</script>
</body>
</html>
