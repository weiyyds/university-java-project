<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>录入博客内容</title>
<meta name="robots" content="noindex, nofollow"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/Styles/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/Styles/main.css" rel="stylesheet" type="text/css" />

<%--    引入ueditor资源文件--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/Js/ueditor/ueditor.all.js"></script>
<%--导入datapicker--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/My97DatePicker/WdatePicker.js"></script>



</head>
<body>
<h1>
    <span class="action-span"><a href="${pageContext.request.contextPath}/blog/list">博客内容列表</a></span>
    <span class="action-span1"><a href="__GROUP__">博客管理中心</a></span>
    <span id="search_id" class="action-span1"> - 录入博客内容 </span>
    <div style="clear:both"></div>
</h1>
<div class="main-div">
    <form action="${pageContext.request.contextPath}/blog/save" method="post">
    	<input type="hidden" name="id" value="${blog.id}"/>
        <table width="100%" id="general-table">
            <tr>
                <td class="label">标题:</td>
                <td>
                   <input type="text" name="title" value="${blog.title}" size="60" />  <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td class="label">作者:</td>
                <td>
                   <input type="text" name="author"  value="${blog.author}"  />  <font color="red">*</font>
                </td>
            </tr>
            <tr>

                <td class="label">录入时间:</td>
                <td>
                   <input type="text" name="addtime" readonly="readonly" onclick="WdatePicker()"  value=" <fmt:formatDate value='${blog.addtime}' pattern='yyyy-MM-dd hh:mm:ss'/>"/>  <font color="red">*</font>
                </td>
            </tr>
             <tr>
                <td class="label">内容详情:</td>
                <td>
                  <script id="container" name="content" type="text/plain"> ${blog.content}</script>
                </td>
            </tr>
        </table>
        <div class="button-div">
            <input type="submit" value=" 确定 " />
            <input type="reset" value=" 重置 " />
        </div>
    </form>
</div>

<div id="footer">
共执行 3 个查询，用时 0.162348 秒，Gzip 已禁用，内存占用 2.266 MB<br />
版权所有 &copy; 2005-2012 xxxxx科技有限公司，并保留所有权利。</div>

<script type="text/javascript">
   var ue = UE.getEditor('container',{
       //设置UEditor的参数
       //宽度
       initialFrameWidth:800,
       initialFrameHeight:400
   });
</script>

</body>
</html>
