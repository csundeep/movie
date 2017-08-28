(function () {
    var app = angular.module('homeServiceModule', []);


    app.factory('HomeFactory', ['$http', '$timeout', function ($http, $timeout) {
        var factory = {};

        factory.listMovies = function (url, callback) {
            $timeout(function () {
                $http.get(url).then(function (success) {
                    this.genres = success.data;
                    callback(this.genres);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);
        }


        return factory;
    }]);

    app.service('HomeService', function (HomeFactory) {
        this.getMovies = function (url, callback) {
            return HomeFactory.listMovies(url, callback);
        };

    });

})();
