<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div style="text-align: center">
    <h1 style="margin-top: 1rem;"> User Registration </h1>

    <form action="save" method="POST">
        <p>
            <label>UserName</label>
            <input type="text" name="userName"/>
        </p>
        <p>
            <label>Password</label>
            <input type="password"  name="pass"/>
        </p>
        <input type="submit">
    <form>
</div>
</body>
</html>