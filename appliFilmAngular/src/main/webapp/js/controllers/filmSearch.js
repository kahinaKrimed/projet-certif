//(function(){
//	var film=angular.module("film");
//	film.controller("filmSearch", filmSearch);
//	function filmSearch($scope, $http){
//		
//		$scope.filmSearch=function(){
//			
//			var API_KEY="?api_key=f9dbb51c988c033af6bfcabbc3a01152";
//			var SEARCH="search/collection";
//			var URL="http://api.themoviedb.org/3/";
//			var QUERY="&query="
//			
//			$scope.getFilms= function(){
//				$http.get(URL+SEARCH+API_KEY+QUERY+"will");
//			}
//		}
//	}
//	
//	
//})();

(function() {
	var app = angular.module("film");
	
	app.controller('filmSearch', function($http, $scope) {
		var self = this;
		
		self.films = [];
		
		self.film = null;
		
		
		$scope.list = function() {
			$scope.query="";
			$http({
				method : 'GET',
				//url:'https://api.themoviedb.org/3/movie/popular?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=fr-FR&page=1'
				url:'services/films-now-playing/'
				//url :'https://api.themoviedb.org/3/movie/now_playing?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=en-US&page=1'
				//url : 'https://api.themoviedb.org/3/movie/now_playing?api_key=f9dbb51c988c033af6bfcabbc3a01152&query="sun"'
			}).then(function successCallback(response) {
			
				console.log("successCallback",response.data);
				$scope.films=response.data;
			}, function errorCallback(response) {

			});
		};
		

	});
})();