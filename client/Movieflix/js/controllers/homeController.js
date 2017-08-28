(function () {
    var app = angular.module('homeControllerModule', ['homeServiceModule']);

    app.controller('HomeController', ['$http', function ($http) {

        var self = this;
        self.movies = {}
        self.search = {};
        self.url = 'http://localhost:8080/movieflix/api/movies?searchCatogoryType=ALL&searchCatogoryValue=ALL&sortType=ALL';


        $http.get(self.url).then(function (success) {
            self.movies = success.data;
            console.log(self.movies);
        }, function (error) {
            console.error(error)
        });

        this.search = function () {
            self.url = 'http://localhost:8080/movieflix/api/movies?searchCatogoryType=' + self.search.type + '&searchCatogoryValue=' + self.search.value + '&sortType=' + self.search.sort;
            console.log(self.url);
            $http.get(self.url).then(function (success) {
                self.movies = success.data;
                console.log(success.data);
            }, function (error) {
                console.error(error)
            });
        }

    }]);

})();
