<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous">
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
      display: flex;
      flex-direction: column;
    }

    #add_btn {
        text-decoration: none;
        background-color: blue;
        color: white;
        font-size: 24px;
        padding: 5px 10px;
    }
    #add_btn:hover {
        border-radius: 5rem;
    }
    #div-right {
       float: right;
    }
    #divLinks {
        align-self: center;
        margin: 2rem 1rem;
        Padding: 0 1rem;
        font-size: 1.5rem;
    }
    #divLinks {
      display: inline-block;
    }

    #divLinks a {
      color: black;
      float: left;
      padding: 8px 16px;
      text-decoration: none;
    }
    #divLinks a:hover {
      background-color: #4CAF50;
      color: white;
    }



</style>
</head>
<body>
<h1 class="h1-sp">  STUDENT MANAGEMENT SYSTEM </h1>
<hr />
<div class="div1">
    <div>
        <a  id ="add_btn" href="/addPage"> ADD </a>
        <div id="div-right">
            <form action="/filter" method="post">
                <input type="text" name="search" placeholder="search"/>
                <input type="submit" class="btn btn-primary btn-sm" value="Search"/>
            </form>
        </div>
    </div>
    <table>
        <tr>
            <th> ID </th>
            <th> Name </th>
            <th> Gender </th>
            <th> Phone </th>
            <th> Address </th>
            <th> DATE </th>
            <th colSpan=2> Action </th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
               <td> ${student.student_id} </td>
               <td>${student.student_name}</td>
               <td> ${student.student_gender}</td>
                <td>${student.student_phone} </td>
               <td> ${student.student_address}</td>
               <td> ${student.date_entry} </td>
               <td> <a href="update/${student.student_id}">Update </a> </td>
               <td> <a href="delete?id=${student.student_id}"> Delete </a> </td>
            </tr>
        </c:forEach>
    </table>
    <div id="divLinks">
           <a href="viewStudent?id=1">1</a>
           <a href="viewStudent?id=2">2</a>
           <a href="viewStudent?id=3">3</a>
           <di>
                <a href="/welcome" class="btn btn-small ms-3 btn-primary">Back</a>
           </div>
    </div>
</div>
</body>
</html>