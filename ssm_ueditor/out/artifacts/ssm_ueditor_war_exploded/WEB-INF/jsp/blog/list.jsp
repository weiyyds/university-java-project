<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>博客内容列表 </title>
<meta name="robots" content="noindex, nofollow">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/Styles/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${pageContext.request.contextPath}/blog/input">新增博客</a></span>
    <span class="action-span1"><a href="__GROUP__">博客 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 博客信息列表 </span>
    <div style="clear:both"></div>
</h1>
<!--  搜索框:开始 -->
<div class="form-div">
    <form action="${pageContext.request.contextPath}/customer_list" name="searchForm" method="post">
      标题：<input type="text" name="title"/>
        <!-- 关键字 -->
        <input type="submit" value=" 搜索 " class="button" />
    </form>
</div>
<!--  搜索框 :结束-->

<form method="post" action="" name="listForm">
    <div class="list-div" id="listDiv">
        <table width="100%" cellspacing="1" cellpadding="2" id="list-table">
            <tr>
                <th>序号</th>
                <th>标题</th>
                <th>添加时间</th>
                <th>作者</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="blog">
            <tr align="center" class="0">
            	<td align="left" class="first-cell" >
            		${blog.id}
                </td>
                <td align="left" class="first-cell" >
                        ${blog.title}
                </td>
                 <td align="left" class="first-cell" >
                     <fmt:formatDate value="${blog.addtime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                </td>
                   <td align="left" class="first-cell" >
                           ${blog.author}
                </td>
                <td width="30%" align="center">
                <a href="${pageContext.request.contextPath}/blog/findById?id=${blog.id}">编辑</a> |
                <a href="javascript:void()" title="移除" onclick="del('${blog.id}')">移除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        
        <!-- 分页开始 -->
	        <table id="page-table" cellspacing="0">
	            <tr>
	                <td width="80%">&nbsp;</td>
	                <td align="center" nowrap="true">
	                    <s:a value="/customer_list?query.curPage=%{#pb.firstPage}">首页</s:a>&nbsp;
	                    <s:a value="/customer_list?query.curPage=%{#pb.prePage}">上一页</s:a>&nbsp;
	                    <s:a value="/customer_list?query.curPage=%{#pb.nextPage}"> 下一页</s:a>&nbsp;
	                    <s:a value="/customer_list?query.curPage=%{#pb.totalPage}">末页</s:a>&nbsp;
	                    当前第<s:property value="#pb.curPage"/>页/共<s:property value="#pb.totalPage"/>页,
	                    共<s:property value="#pb.totalCount"/>条数据，每页显示<s:property value="#pb.pageSize"/>条
	                </td>
	            </tr>
	        </table>
	    <!-- 分页结束 -->
    </div>
</form>
<div id="footer">
共执行 1 个查询，用时 0.055904 秒，Gzip 已禁用，内存占用 2.202 MB<br />
版权所有 &copy; 2005-2012 xxxxx科技有限公司，并保留所有权利。</div>

<script type="text/javascript">
	function del(id){
		if(window.confirm("确认删除此记录吗?一但删除不能恢复了")){
			window.location.href="${pageContext.request.contextPath}/blog/delete?id="+id;
		}
	}
</script>

</body>
</html>
