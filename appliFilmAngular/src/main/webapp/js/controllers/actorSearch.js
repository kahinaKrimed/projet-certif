(function() {
	var app = angular.module("film");
	
	app.controller('actorSearch', function($http, $scope) {
		var self = this;
		
		self.films = [];
		
		self.film = null;
		
		
		$scope.getActor = function() {
					
			$scope.query="";

			$http({
				method : 'GET',
				url : 'services/acteurs-populaires/'
			}).then(function successCallback(result) {
			
				console.log("successCallback",result.data.results);
				$scope.actors=result.data.results;
			}, function errorCallback(result) {

			});
		};
		

	});
})()

//var API_KEY="?api_key=f9dbb51c988c033af6bfcabbc3a01152";
//			var SEARCH="search/person";
//			var URL ="https://api.themoviedb.org/3/";
//			var QUERY= "&query=";
//			$scope.actorKey="tom";