<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生基本信息</title>
<script src="./jquery.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student" method="post">
		姓名<input type="text" name="username"><br>
		年龄<input type="text" name="age"><br>
		手机号<input type="telephone" name="telephone"><br>
		地址<select name="address">
				<option value="广东省">
					广东省
				</option>
				<option value="广东省">
					广西省
				</option>
		</select>
		<input type="submit" value="提交">
	</form>
</body>
</html>