<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"  isELIgnored= "false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
crossorigin="anonymous"></script>

<link rel="stylesheet" href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<body>
<section>
   <div class="jumbotron">
      <div class="container">
          <h1>Products</h1>
          <p>Add products</p>
      </div>
      <div style="float:right">
        <a href="products" class="btn btn-small btn-primary"> Back </a>
      </div>
   </div>
</section>
<div class="container card bg-primary text-white p-3 ">
<form:form action="/webstore/saveProduct" method="POST" modelAttribute="product"
    class="row ps-5 pe-3" enctype="multipart/form-data">

        <div class="form-group col-sm-5">
            <label for="prod_id"> ProductID </label>
            <form:input path="productId" class="form-control" />
            <form:errors path="productId" class="mb-2 mt-1  bg-warning text-danger" />
        </div>
        <div class="form-group col-sm-5">
            <label for="prod_name">Name</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" class="mb-2 mt-1  bg-warning p-1 text-danger" />
        </div>
        <div class="form-group col-sm-5">
            <label for="unit_price">UnitPrice</label>
            <form:input path="unitPrice" class="form-control" />
            <form:errors path="unitPrice" class="mb-2 mt-1 bg-warning text-danger" />
        </div>
        <div class="form-group col-sm-5">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="manufacturer" class="form-control" />
            <form:errors path="manufacturer" class="mb-2 mt-1  bg-warning text-danger" />
        </div>
        <div class="form-group col-sm-5">
            <label for="category">Category</label>
            <form:input path="category" class="form-control" />
            <form:errors path="category" class="mb-2 mt-1  bg-warning text-danger" />
        </div>
        <div class="form-group col-sm-5">
              <label for="unitsInStock">UnitsInStock</label>
              <form:input path="unitsInStock" class="form-control" />
              <form:errors path="unitsInStock" class="mb-2 mt-1  bg-warning text-danger" />
        </div>
        <div class="form-group col-sm-5">
             <label for="unitsInOrder">UnitsInOrder</label>
             <form:input path="unitsInOrder" class="form-control" />
        </div>
        <div class="form-group col-sm-5">
             <label for="description">Description</label>
             <form:textarea rows="1" path="description" class="form-control" />
        </div>
        <div class="form-group col-sm-5 pt-2">
             <label for="condition">Condition</label>
             <form:radiobutton path="condition" value="New"/>New
             <form:radiobutton path="condition" value="Old"/>Old
             <form:radiobutton path="condition" value=">Refurbished"/>Refurbished
        </div>
        <div class="form-group col-sm-5 pt-2">
            <label for="discontinued">DisContinued</label>
            <form:checkbox  path="discontinued"/>
        </div>
        <div class="form-group col-sm-5 pt-2">
             <label for="productImage"> Product Image</label>
             <form:input  path="productImage" type="file"/>
        </div>

        <div class="pt-4">
           <input type="submit" value="ADD" class="btn btn-large btn-success"/>
        </div>
</form:form>
</div>
</body>
</html>