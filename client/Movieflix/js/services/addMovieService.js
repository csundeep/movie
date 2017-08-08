(function () {
    var app = angular.module('addMovieServiceModule', []);


    app.factory('AddMovieFactory', ['$http', '$timeout', function ($http, $timeout) {
        var factory = {};

        factory.listGenres = function (callback) {
            $timeout(function () {
                $http.get('http://localhost:8080/movieflix/api/movies/genres').then(function (success) {
                    this.genres = success.data;
                    callback(this.genres);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);
        }

        factory.addMovie = function (movie, callback) {

            $timeout(function () {
                $http.post('http://localhost:8080/movieflix/api/movies', movie).then(function (success) {
                    this.response = {};
                    this.movie = success.data;
                    console.log(this.movie);
                    this.response.success = true;
                    callback(response);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);

        };


        return factory;
    }]);

    app.service('AddMovieService', function (AddMovieFactory) {
        this.createNewMovie = function (movie, callback) {
            return AddMovieFactory.addMovie(movie, callback);
        };
        this.getGenres = function (callback) {
            return AddMovieFactory.listGenres(callback);
        };

    });

})();
