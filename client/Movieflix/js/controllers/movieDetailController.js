(function () {
    var app = angular.module('movieDetailControllerModule', []);

    app.controller('MovieDetailController', ['$http', '$rootScope', '$routeParams', function ($http, $rootScope, $routeParams) {
        var self = this;
        self.movie = {};
        self.comments = {};

        $http.get('http://localhost:8080/movieflix/api/movies/' + $routeParams.id).then(function (success) {
            self.movie = success.data;
        }, function (error) {
            console.error(error)
        });

        $http.get('http://localhost:8080/movieflix/api/comments?movie_id=' + $routeParams.id).then(function (success) {
            self.comments = success.data;
        }, function (error) {
            console.error(error)
        });

        $http.get('http://localhost:8080/movieflix/api/ratings/' + $routeParams.id + "/" + $rootScope.user_id).then(function (success) {
            self.rating = success.data;
        }, function (error) {
            console.error(error)
        });

        this.postComment = function () {

            this.comment = {};
            this.comment.userComment = self.newComment;

            $http.post('http://localhost:8080/movieflix/api/comments?movie_id=' + $routeParams.id + "&user_id=" + $rootScope.user_id, this.comment).then(function (success) {
                var newComment = success.data;
                self.comments.push(newComment);
            }, function (error) {
                console.error(error)
            });
            self.newComment = "";

        }
        this.giveRating = function () {
            if (self.rating.movie)
                delete self.rating.movie;
            if (self.rating.user)
                delete self.rating.user;
            console.log(self.rating);
            $http.post('http://localhost:8080/movieflix/api/ratings?movie_id=' + $routeParams.id + "&user_id=" + $rootScope.user_id, this.rating).then(function (success) {
                self.rating = success.data;
                console.log(self.rating);
            }, function (error) {
                console.error(error)
            });
            console.log(self.rating);
        }

    }]);

})();