<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>4.jsp</title>
</head>
<body>
<%
	String sessionID=session.getId();
	String name=(String)session.getAttribute("name");
	session.setAttribute("author", "Smith");
	long time=session.getCreationTime();
	Date date=new Date(time);
%>
<center>
	<p>4.jsp</p>
	<%=name %>,您的sessionId为:<br/>
	<%=sessionID %>
	session对象创建的时间<%=date %><br/>
		<form action="2.jsp" method="post">
			<input type="submit" value="转向2.jsp">
		</form>
</center>
</body>
</html>