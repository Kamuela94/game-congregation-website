var myHeader = angular.module('header', ["ngCookies"]);


myHeader.controller('headerCtrl', function ($scope, $http) {
    $scope.includeNavBar = "partials/navbar.html";
    $scope.user = {};
    $scope.user.username = null;
    $scope.user.password = null;
    $scope.user.message = null;

    $scope.checkedLogin = function() {
        $http.get(URI + "/login").then(
            function(response){
                //code to dependency inject the new modal
                
            }, function(response){
                //code send message to user stating that their
                //login was unsuccesful
            }
        )

    };


});