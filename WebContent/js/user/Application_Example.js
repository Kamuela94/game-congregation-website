//-----------------------REGISTERING THE APPLICATION AND DEPENDENCIES-----------------------

var application = angular.module("Application", [ "ngRoute" ]);

//----------------------CONFIGURING THE APPLICATION------------------------

application.config([ '$routeProvider', function(routeProvider) {
	routeProvider.when('/book', {
		templateUrl : 'partials/booking.html',
		controller : 'BookingController'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

//-------------------------------------------------------------

application.filter('CountFilter', function() {

	return function(numericValue) {
		var listOfNumberAsString = ["One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve"];
		return listOfNumberAsString[numericValue - 1];
	};

});

//---------------------------------------------------------------------

var URI = getURI();

//------------------------------------------------------