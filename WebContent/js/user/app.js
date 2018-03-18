var myApp = angular.module('app', [ "ngRoute", "ngCookies"]);



myApp.controller('mainCtrl', function($scope){
    $scope.melee = "partials/melee.html";
});



var URI = getURI();



