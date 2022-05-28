<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<mark>${message}</mark>
	<form action="/pk02085_lab3_j4/login" method="post">
		Username: <input name="username" value="${username}"><br>
		Password: <input name="password" type="password" value="${password}"><br>
		<br> <input name="remember" type="checkbox">Remember me?
		<hr>
		<button>Login</button>
	</form>


</body>
</html>