<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html;
 charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
 crossorigin="anonymous">

 <link rel="stylesheet" href=
 "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>


 <script src="/webstore/res/controller.js"></script>

 <title>Cart</title>
 </head>
 <body>

    <section class="container" ng-app="cartApp">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger float-start" ng-click="clearCart()">
                    <span class="bi bi-trash"></span> Clear Cart
                </a>
                <a href="<spring:url value="/checkout?cartId=${cartId}" />" class="btn btn-success float-end">
                    <span class="bi bi-cart"></span> Check out
                </a>
                <P> cartID: ${cartId}</p>
            </div>
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat="item in cart.cartItems">
                    <td>{{item.product.productId}}-{{item.product.name}}</td>
                    <td>{{item.product.unitPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger"
                    ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove" /></span> Remove
                    </a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>{{cart.grandTotal}}</th>
                    <th></th>
                </tr>
            </table>
            <a href="<spring:url value="/products" />" class="btn btn-default">
                <span class="glyphicon-hand-left glyphicon"></span> Continue shopping
            </a>
        </di>
    </section>
</body>
</html>
