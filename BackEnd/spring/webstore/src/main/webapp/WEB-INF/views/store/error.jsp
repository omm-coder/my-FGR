<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html;
 charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
 crossorigin="anonymous">

 <link rel="stylesheet" href=
 "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
 <title>Error Page </title>

 </head>
 <body>
 <section>
    <div class="container card mt-5">
        <div class="card-body">
            <h1 class="card-title text-danger">
            There is no product found with the Product id
            <span class="bg-warning"> ${invalidProductId} </span> </h1>
        </div>
        <div class="card-text">
             <p>${url}</p>
             <p>${exception}</p>
        </div>
        <div class="card-link mb-3">
            <a href="<spring:url value="/products" />"
             class="btn btn-warning btn-large">
             <span><i class="bi bi-arrow-left-square-fill"></i></span> Back </a>
        </div>
    </div>
 </section>
 </body>
 </html>