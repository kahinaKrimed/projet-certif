(function() {
	var app = angular.module("film");
	
	app.controller('actorSearch', function($http, $scope) {
		//var self = this;
		
		$scope.acteurs = [];
		
		$scope.acteur = null;
		
		
		$scope.listActeurs = function() {
					console.log("getActor");
			//$scope.query="";

			$http({
				method : 'GET',
				url : 'services/acteurs-populaires/'
			}).then(function successCallback(response) {
			
				console.log("successCallback",response.data);
				$scope.acteurs=response.data;
			}, function errorCallback(response) {

			});
		};
		

	});
})()

//var API_KEY="?api_key=f9dbb51c988c033af6bfcabbc3a01152";
//			var SEARCH="search/person";
//			var URL ="https://api.themoviedb.org/3/";
//			var QUERY= "&query=";
//			$scope.actorKey="tom";