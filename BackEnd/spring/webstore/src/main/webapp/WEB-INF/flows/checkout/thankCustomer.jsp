<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset="utf-8">
 <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 <title>Invalid cart </title>
 </head>
 <body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger"> Thank you</h1>
                <p>Thanks for the order. your order will be delivered to you on
                    <fmt:formatDate type="date" value="${order.shippingDetail.shippingDate}" />!
                </p>
                <p>Your Order Number is ${order.orderId}</p>
            </div>
         </div>
    </section>
    <section>
        <div class="container">
            <p>
                <a href="<spring:url value="/products" />" class="btn btn-primary">
                    <span class="glyphicon-hand-left glyphicon">
                    </span> products
                </a>
            </p>
        </div>
     </section>
 </body>
</html>