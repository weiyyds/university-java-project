<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>神码学堂博客后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="Text/Javascript" language="JavaScript">

if (window.top != window) {
    window.top.location.href = document.location.href;
}
</script>

<frameset rows="76,*" framespacing="0" border="0">
    <frame src="${pageContext.request.contextPath}/top.action" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
    <frameset cols="200,*" framespacing="0" border="0" id="frame-body">
        <frame src="${pageContext.request.contextPath}/menu.action" id="menu-frame" name="menu-frame" frameborder="no" scrolling="no">
        <frame src="${pageContext.request.contextPath}/index.action" id="main-frame" name="main-frame" frameborder="no">
    </frameset>
</frameset>
</head>
<body>
</body>
</html>
