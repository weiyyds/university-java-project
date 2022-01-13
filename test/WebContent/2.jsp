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
	session.setAttribute("name", "john");
	String author=(String)session.getAttribute("author");
	long time=session.getCreationTime();
	Date date=new Date(time);
%>
</body>
<center>
	<p>2.jsp</p>
	<%=author %>,您的sessionId为:<br/>
	<%=sessionID %>
	session对象创建的时间<%=date %><br/>
		<form action="3.jsp" method="post">
			<input type="submit" value="转向3.jsp">
		</form>
		<a href="4.jsp">欢迎到4.jsp页面</a>
</center>

</html>