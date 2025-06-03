<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">


<link rel="stylesheet" href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="/webstore/res/controller.js"></script>
</head>
<body ng-app="cartApp" >

<div cssClass="Container" >
    <div class="row">
        <div class="col-sm-6 col-md-4" style="padding-bottom: 15px">
            <div class="card m-3 p-3 bg-primary rounded"  >
                <div class="card-body p-1" >
                    <img src="/webstore/res/${product.productId}.png" alt="image" width="100%"/>
                    <h1 class"t-center">${product.name}</h1>
                    <p>${product.description}</p>
                    <p><strong>ItemCode: </strong>
                    <span class="bg-warning"> ${product.productId}</span></p>
                    <p>Available ${product.unitsInStock} units in stock</p>
                    <p>${product.unitPrice} USD</p>
                    <p ng-controller="cartCtrl">
                        <a href="#" class="btn btn-warning btn-large"
                        ng-click="addToCart('${product.productId}')" >
                            <spn><i class="bi bi-cart"></i><span>
                            ORDER NOW
                        </a>
                        <a href="<spring:url value="/products" />"
                        class="btn btn-warning btn-large">
                        <span><i class="bi bi-arrow-left-square-fill"></i></span> Back </a>
                    </p>
                    <a href="<spring:url value="/cart" />" class="btn btn-primary">
                        <span><i class="bi bi-arrow-right-square-fill"> </i></span> View Cart
                    </a>

                </div>
            </div>
        </div>
     </div>
</div>

</body>
</html>