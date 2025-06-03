var cartApp = angular.module('cartApp', [])
cartApp.controller('cartCtrl', function($scope,$http) {
    $scope.refreshCart = function(cartId) {

        $http.get('/webstore/rest/cart/' + $scope.cartId)
        .success(function(data) {
            $scope.cart = data;
            let myList = data
//            alert("inside refresh cart and the cart object has "+ data.length+ " cart items" )
         });
    }

    $scope.clearCart = function() {
        $http.delete('/webstore/rest/cart/' + $scope.cartId)
        .success(function(data) {
            $scope.refreshCart($scope.cartId);
        });
    }

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;

        $scope.refreshCart($scope.cartId);
        console.log("getting cart id: "+ $scope.cartId)
    };

    $scope.addToCart = function(productId) {
        $http.put('/webstore/rest/cart/add/' + productId)
        .success(function(data) {
            alert("Product Successfully added to the Cart!");
        })
    }

    $scope.removeFromCart = function(productId) {
        $http.put('/webstore/rest/cart/remove/' + productId)
        .success(function(data) {
            $scope.refreshCart($scope.cartId);
        });
    }

})

cartApp.controller("sampleController", function($scope, $http) {

    $scope.message = "Using angular and ajax";
    $scope.add = function(name) {
        $http.put('/webstore/rest/cart/add/' +name)
        console.log(name + ": You Clicked button and I from angular CTRL ")
        console.log("we got this url :"+ '/webstore/rest/cart/add/' +name)

    }

})