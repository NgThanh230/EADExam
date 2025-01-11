<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/11/2025
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm Sinh Viên</h2>
<form action="addStudent" method="post">
    <label for="studentCode">Mã Sinh Viên:</label>
    <input type="text" id="studentCode" name="studentCode" required /><br><br>

    <label for="fullName">Tên Sinh Viên:</label>
    <input type="text" id="fullName" name="fullName" required /><br><br>

    <label for="address">Địa Chỉ:</label>
    <input type="text" id="address" name="address" required /><br><br>

    <input type="submit" value="Thêm Sinh Viên" />
</form>

<!-- Hiển thị thông báo -->
<p>${message}</p>
<p><a href="students.jsp">Trở Lại Trang Chính</a></p>
</body>
</html>
