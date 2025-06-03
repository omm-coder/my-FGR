<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">

<link rel="stylesheet" href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<body>
 <section>
            <div class="jumbotron">
               <div class="container">
                  <h1>Products</h1>
                  <a href="addProduct">Add Product </a> |
                  <a href="logout">logout</a>
               </div>
            </div>
 </section>
<div cssClass="Container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-4" style="padding-bottom: 15px">
                <div class="card m-3 p-3 bg-primary rounded">
                   <div class="card-body p-1">
                        <img src="/webstore/res/${product.productId}.png" alt="image" width="100%"/>
                        <h1 class"t-center">${product.name} </h1>
                        <p>${product.description}</p>
                        <p>${product.unitPrice} USD</p>
                        <p>Available ${product.unitsInStock} units in stock</p>
                        <p>${product.productId}</p>
                        <a class="btn btn-warning btn-sm" href="/webstore/product?id=${product.productId}">
                        <span><i class="bi bi-info-circle-fill"></i></span> DetailsPage </a>
                   </div>
               </div>
            </div>
        </c:forEach >
    </div>
</div>

</body>
</html>