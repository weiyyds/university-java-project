<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String sessionID=session.getId();
	String name=(String)session.getAttribute("name");
	long time=session.getCreationTime();
	Date date=new Date(time);
%>
</body>
<center>
	<p>3.jsp</p>
	<%=name %>,您的sessionId为:<br/>
	<%=sessionID %>
	session对象创建的时间<%=date %><br/>
		<a href="2.jsp">欢迎到2.jsp页面</a>
		<a href="4.jsp">欢迎到4.jsp页面</a>
</center>
</body>
</html>