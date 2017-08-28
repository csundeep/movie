(function () {
    var app = angular.module('editMovieControllerModule', ['editMovieServiceModule']);


    app.controller('EditMovieController', ['EditMovieService', '$location', '$http', '$routeParams', function (EditMovieService, $location, $http, $routeParams) {
        var self = this;
        self.movie = {};
        self.genres = {};
        self.selectedGenres = [];
        self.casts = [];
        self.id = $routeParams.id;
        self.i = 1;
        self.movieType = false;


        EditMovieService.getMovieById(self.id, function (response) {
            if (response) {
                self.movie = response;
                // console.log(self.movie);
                movie.genre.forEach(function (genre) {
                    self.selectedGenres.push(genre);
                });
                if (movie.movieType === 'Movie')
                    self.movieType = true;

                movie.casts.forEach(function (cast) {
                    cast.castId = self.i;
                    self.casts.push(cast);
                    self.i++;
                });

            } else {
            }
        });


        EditMovieService.getGenres(function (response) {
            if (response) {
                self.genres = response;
            } else {
            }
        });

        this.addCast = function () {
            self.casts.push({
                castId: self.i,
                name: "",
                role: ""
            });
            self.i++;
        }


        this.updateMovie = function () {
            self.movie.genre = self.selectedGenres;
            self.movie.casts = self.casts;
            self.movie.year = new Date(self.movie.releaseDate).getFullYear();

            EditMovieService.updateMovie(self.movie, self.id, function (response) {
                if (response.success) {
                    $location.path("/");

                } else {
                }
            });

        };

        this.toggleSelection = function toggleSelection(genre) {
            var idx = self.selectedGenres.indexOf(genre);

            if (idx > -1) {
                self.selectedGenres.splice(idx, 1);
            }

            else {
                self.selectedGenres.push(genre);
            }

        };

    }]);

})();
