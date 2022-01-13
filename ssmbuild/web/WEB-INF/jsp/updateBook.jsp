<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>--%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<html>
<head>
    <title>修改书籍</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 colum">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <%--            出现的问题：我们提交了修改的sql请求，但是修改失败，因为bookid为0，修改失败--%>
            <%--            前端传递隐藏域--%>
            <input type="hidden" name="bookID" value="${QBbooks.bookID}">
            <div class="form-group">
                <label >书籍名称</label>
                <input type="text" name="bookName" class="form-control" value="${QBbooks.bookName}" required>
            </div>
            <div class="form-group">
                <label >书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" value="${QBbooks.bookCounts}" required>
            </div>
            <div class="form-group">
                <label >书籍描述</label>
                <input id="scr" type="text" name="detail" class="form-control" value="${QBbooks.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control"  value="修改" >
            </div>
        </form>
</div>
</body>
</html>

