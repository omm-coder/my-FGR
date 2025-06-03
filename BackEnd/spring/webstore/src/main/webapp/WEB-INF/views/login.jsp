<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div style="text-align: center">
    <h1 style="margin-top: 1rem;"> User Login </h1>

    <div>
        <c:if test="${param.error != null }" >
            <p style="color:red">Invalid username and password.</p>
        </c:if>
    </di>
    <form action="login" method="POST">
        <c:if test="${param.logout != null}">
            <div style="color:green">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <c:if test="${param.accessDenied != null}">
             <div style="color:red">
                 <p> ACCESS DENIED : YOU ARE NOT AUTHORIZED.</p>
             </div>
        </c:if>
        <p>
            <label>UserName</label>
            <input type="text" name="userName"/>
        </p>
         <p>
             <label>password</label>
             <input type="password" name="pass"/>
         </p>
         <input type="submit">
    <form>
</div>
</body>
</html>