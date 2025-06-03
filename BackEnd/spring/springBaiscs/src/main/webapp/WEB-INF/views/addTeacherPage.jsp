<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style  type="text/css">
    form {
        padding: 10px 0 ;
    }
</style>
</head>
<body>
<h1 align="center"> Add teacher Page </h1>
<div align="center">
<form:form action="/saveTeacher" method="POST" modelAttribute="teacher" >
    <form:hidden path="teacher_id" />
    <br/>
    FirstName<form:input path="teacher_name" style="margin: 10px 0;"/>
    </br>
    Gender: Male <form:radiobutton path="teacher_gender" value="male"/>
    Female <form:radiobutton path="teacher_gender" value="female" />
    <br/>
    phone <form:input path="teacher_phone" style="margin-top: 10px;"/>
     <br/>
    Address <form:input path="teacher_address" style="margin-top: 10px;"/>
    <br/>
    <input type="submit" value="submit" style="margin-top: 10px;"/>
</form:form>
<div>
</body>
</html>