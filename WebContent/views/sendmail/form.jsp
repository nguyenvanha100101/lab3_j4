<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="send" method="post" enctype="multipart/form-data">
		<input type="text" name="from" placeholder="Người gửi"	value="vanha100101@gmail.com"> <br>
		<input type="text" name="to"	placeholder="Người nhận"> <br>
		<input type="text" name="subject"	placeholder="Tiêu đề"> <br>
		<textarea name="body" rows="10" cols="50"></textarea> <br>
		<input type="file" name="attach"> <br>
		<input type="submit" value="send" name="btnSend">
	</form>
	<h5>${message }</h5>
</body>
</html>