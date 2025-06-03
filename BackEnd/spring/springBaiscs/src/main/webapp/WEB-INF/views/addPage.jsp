<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style  type="text/css">
    form {
        padding: 10px 0 ;
    }
    .error{color:red}
</style>
</head>
<body>
<h1 align="center"> Add Student Page </h1>
<div align="center">
<form:form action="/save" method="POST" modelAttribute="student" >
    <form:hidden path="student_id" />
    <br/>
    FirstName<form:input path="student_name" style="margin: 10px 0;"/>
    <form:errors path="student_name" cssClass="error"/>
    </br>
    Gender: </br>
     <form:errors path="student_gender" cssClass="error"/>
    Male <form:radiobutton path="student_gender" value="male"/>
    Female <form:radiobutton path="student_gender" value="female" />
    <form:errors path="student_gender" cssClass="error" element="h2"/>
    <br/>
    phone <form:input path="student_phone" style="margin-top: 10px;"/>
    <form:errors path="student_phone" cssClass="error"/>
     <br/>
    Address <form:input path="student_address" style="margin-top: 10px;"/>
    <form:errors path="student_address" cssClass="error"/>
    <br/>
    Date Entry
    <form:input path="date_entry" style="margin-top: 10px;"/>
    <form:errors path="date_entry" cssClass="error"/>
    <br/>
    <input type="submit" value="submit" style="margin-top: 10px;"/>
</form:form>
<p cssClass"error">${error}</p>
<div>
</body>
</html>