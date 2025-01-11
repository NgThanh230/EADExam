<%@ page import="com.example.eadexam.Entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.eadexam.Entity.StudentScore" %><%--
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
<table>
    <thead>
    <tr>
        <th>Student Code</th>
        <th>Full Name</th>
        <th>Address</th>
        <th>Subject</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
    <h2>Danh sách sinh viên</h2>
    <p><a href="add-student.jsp">Thêm Sinh Viên</a></p>
    <p><a href="add-score.jsp">Thêm Điểm Sinh Viên</a></p>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student : students) {
    %>
    <h3><%= student.getFullName() %> - <%= student.getAddress() %></h3>
    <ul>
        <%
            for (StudentScore score : student.getScores()) {
        %>
        <li>Môn: <%= score.getSubject() %> - Điểm: <%= score.getGrade() %></li>
        <%
            }
        %>
    </ul>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
