application.controller("BookingController",
		function($scope, $http) {
			$scope.bookingForm = {};
			$scope.boatingMap = null;
			$scope.bookingForm.location = null;
			$scope.bookingForm.boatingType = null;
			$scope.bookingForm.dateOfRide = null;
			$scope.bookingForm.noOfPeople = null;
			$scope.bookingForm.contactNo = null;
			$scope.bookingForm.message = null;
			
			$scope.generateList = function() {
				$scope.bookingForm.message = null;
				$http.get(URI + "Boat/fetchboatingtypes").then(
						function(response) {						
							$scope.boatingMap = response.data;
							$scope.bookingForm.message = null;
						}, function(response) {
							$scope.bookingForm.message = response.data.message;
							$scope.boatingMap = null;
						});
			};

			$scope.bookingForm.submitTheForm = function() {
				$scope.bookingForm.message = null;
				$scope.bookingForm.dateOfRide = $scope.bookingForm.dateOfRide.toLocaleString();
				var data = JSON.stringify($scope.bookingForm);
				$http.post(URI + "Boat/book", data).then(function(response) {
					$scope.bookingForm.message = response.data.message;
				}, function(response) {
					$scope.bookingForm.message = response.data.message;
				});
			};
		});