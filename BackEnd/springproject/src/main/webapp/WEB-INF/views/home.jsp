<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<body>
<h1> Welcome practicing of Spring mvc static resource </h1>
<img src="<c:url value="/myResource/P1234.png"/>"
alt="image" style ="width:100px; height: 100px" />
<img src="<c:url value="/myResource/P1235.png"/>"
alt="image" style ="width:100px; height: 100px" />
<p>next</p>
<img src="<c:url value="/myResource/P1236.png"/>"
alt="image" style ="width:100px; height: 100px" />
<h1> Learn Ur contextPath: ${pageContext.request.contextPath} </h1>
<img src="<c:url value="/myResource/P1237.png"/>"
alt="image" style ="width:100px; height: 100px" />
</body>
</html>