(function () {
    var app = angular.module('addMovieControllerModule', ['addMovieServiceModule']);


    app.controller('AddMovieController', ['AddMovieService', function (AddMovieService) {
        var self = this;
        self.movie = {};
        self.genres = {};
        self.selectedGenres = [];
        self.casts = [];


        self.casts.push({
            castId: 1,
            name: "",
            role: ""
        });


        AddMovieService.getGenres(function (response) {
            if (response) {
                self.genres = response;
            } else {
            }
        });

        this.addCast = function () {
            var i = 2;
            self.casts.push({
                castId: i,
                name: "",
                role: ""
            });
            i++;
        }


        this.addMovie = function () {
            self.movie.genre = self.selectedGenres;
            self.movie.casts = self.casts;
            self.movie.year = new Date(self.movie.releaseDate).getFullYear();

            console.log(self.movie);


            AddMovieService.createNewMovie(self.movie, function (response) {
                if (response.success) {
                } else {
                }
            });

            self.casts = [];
            self.selectedGenres = [];
            self.movie = {};
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
