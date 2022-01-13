<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>--%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<html>
<head>
    <title>Title</title>
    <script src="jquery-3.5.1.min.js"></script>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 colum">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label >书籍名称</label>
                <input type="text" name="bookName" class="form-control" >
            </div>
            <div class="form-group">
                <label >书籍数量</label>
                <input type="text" name="bookCounts" class="form-control">
            </div>
            <div class="form-group">
                <label >书籍描述</label>
                <input type="text" name="detail" class="form-control">
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="添加">
            </div>
        </form>



</div>
</body>
</html>
