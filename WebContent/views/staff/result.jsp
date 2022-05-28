<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>Họ và tên: <b>${bean.fullname}</b></li>
		<li>Hình ảnh: <img src="${bean.photo}"></li>
		<li>Ngày sinh: <b>${bean.birthday}</b></li>
		<li>Giới tính: <b>${bean.gender}</b></li>
		<li>Quốc tịch: <b>${bean.country}</b></li>
		<li>TT hôn nhân: <b>${bean.married}</b></li>
		<li>Sở thích: <b>${bean.hobbies}</b></li>
		<li>Ghi chú: <b>${bean.notes}</b></li>
	</ul>
</body>
</html>