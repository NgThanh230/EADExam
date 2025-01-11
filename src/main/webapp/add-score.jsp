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
<h2>Thêm Điểm Sinh Viên</h2>

<form action="addScore" method="post">
    <!-- Chọn sinh viên -->
    <label for="studentId">Chọn Sinh Viên:</label>
    <select id="studentId" name="studentId">
        <c:forEach var="student" items="${students}">
            <option value="${student.studentId}">${student.fullName}</option>
        </c:forEach>
    </select><br><br>

    <!-- Chọn môn học -->
    <label for="subjectId">Chọn Môn Học:</label>
    <select id="subjectId" name="subjectId">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject.subjectId}">${subject.subjectName}</option>
        </c:forEach>
    </select><br><br>

    <!-- Nhập điểm -->
    <label for="score1">Điểm 1:</label>
    <input type="number" id="score1" name="score1" min="0" max="10" required /><br><br>

    <label for="score2">Điểm 2:</label>
    <input type="number" id="score2" name="score2" min="0" max="10" required /><br><br>

    <input type="submit" value="Thêm Điểm" />
</form>

<!-- Hiển thị thông báo -->
<p>${message}</p>

<p><a href="students.jsp">Trở Lại Trang Chính</a></p>
</body>
</html>
