(function () {
    var app = angular.module('editMovieServiceModule', []);


    app.factory('EditMovieFactory', ['$http', '$timeout', function ($http, $timeout) {
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

        factory.getMovieById = function (id, callback) {
            $timeout(function () {
                $http.get('http://localhost:8080/movieflix/api/movies/' + id).then(function (success) {
                    this.movie = success.data;
                    callback(this.movie);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);
        }

        factory.editMovie = function (movie, id, callback) {

            $timeout(function () {
                $http.put('http://localhost:8080/movieflix/api/movies/' + id, movie).then(function (success) {
                    this.response = {};
                    this.movie = success.data;
                    this.response.success = true;
                    callback(response);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);

        };


        return factory;
    }]);

    app.service('EditMovieService', function (EditMovieFactory) {
        this.updateMovie = function (movie, id, callback) {
            return EditMovieFactory.editMovie(movie, id, callback);
        };
        this.getGenres = function (callback) {
            return EditMovieFactory.listGenres(callback);
        };

        this.getMovieById = function (id, callback) {
            return EditMovieFactory.getMovieById(id, callback);
        };

    });


})();
