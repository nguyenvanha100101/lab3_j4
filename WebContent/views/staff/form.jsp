<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/pk02085_lab3_j4/staff" method="post"  enctype="multipart/form-data">
		Họ và tên: <input name="fullname"><br>
		Image: <input name="photo" type="file">
		<br> Ngày sinh: <input
			name="birthday"><br> Quốc tịch: <select name="country">
			<option value="VN">Việt Nam</option>
			<option value="US">United States</option>
		</select><br> Giới tính: <input name="gender" type="radio" value="true">Nam
		<input name="gender" type="radio" value="false">Nữ<br> TT
		hôn nhân: <input name="married" type="checkbox">Đã có gia
		đình?<br> Sở thích: <input name="hobbies" type="checkbox"
			value="R">Đọc sách <input name="hobbies" type="checkbox"
			value="T">Du lịch <input name="hobbies" type="checkbox"
			value="M">Âm nhạc <input name="hobbies" type="checkbox"
			value="O">Khác<br> Ghi chú:
		<textarea name="notes" rows="3" cols="30"></textarea>
		<hr>
		<button>Thêm mới</button>
	</form>
</body>
</html>