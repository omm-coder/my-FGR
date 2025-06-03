<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    table {
      margin-top: 10px;
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
      height: 80px;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
    .h1-sp {
        text-align: center;
        color: green;
    }
    .div1 {
      margin: 4% 100px;

    }
    #add_btn {
        text-decoration: none;
        background-color: blue;
        color: white;
        font-size: 24px;
        padding: 5px 10px;
    }
    #add_btn:hover {
        border-radius: 50px;
    }
</style>
</head>
<body>
<h1 class="h1-sp">  SCHOOL MANAGEMENT SYSTEM </h1>
<hr />
<div class="div1">
    <a  id ="add_btn" href="/addTeacherPage"> ADD </a>
    <table>
        <tr>
            <th> ID </th>
            <th> Name </th>
            <th> Gender </th>
            <th> Phone </th>
            <th> Address </th>
            <th colSpan=2> Action </th>
        </tr>
        <c:forEach items="${teachers}" var="teacher">
            <tr>
               <td> ${teacher.teacher_id} </td>
               <td>${teacher.teacher_name}</td>
               <td> ${teacher.teacher_gender}</td>
                <td>${teacher.teacher_phone} </td>
               <td> ${teacher.teacher_address}</td>
               <td> <a href="updateTeacher?id=${teacher.teacher_id}">Update </a> </td>
               <td> <a href="deleteTeacher?id=${teacher.teacher_id}"> Delete </a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>