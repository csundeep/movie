(function () {
    var app = angular.module('movieflix', ['ngRoute', 'userControllerModule', 'homeControllerModule',
        'addMovieControllerModule', 'editMovieControllerModule', 'movieDetailControllerModule', 'validationApp']);

    app.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'templates/home.html',
                controller: 'HomeController',
                controllerAs: 'homeCtrl',
                resolve: {
                    init: function () {
                    }
                }
            })
            .when('/login', {
                templateUrl: 'templates/login.html',
                controller: 'UserController',
                controllerAs: 'userCtrl'
            })

            .when('/loginAdmin', {
                templateUrl: 'templates/loginAdmin.html',
                controller: 'UserController',
                controllerAs: 'userCtrl'
            })

            .when('/addMovie', {
                templateUrl: 'templates/addMovie.html',
                controller: 'AddMovieController',
                controllerAs: 'AddMovieCtrl',
                resolve: {
                    init: function () {
                    }
                }
            })
            .when('/cardDetail/:id', {
                templateUrl: 'templates/cardDetail.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailCtrl',
                resolve: {
                    init: function () {
                    }
                }
            })

            .when('/editMovie/:id', {
                templateUrl: 'templates/editMovie.html',
                controller: 'EditMovieController',
                controllerAs: 'editMovieCtrl',
                resolve: {
                    init: function () {
                    }
                }
            })

            .otherwise({redirectTo: '/login'});
    });


    app.run(function ($rootScope, $cookieStore) {
        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            console.log(next.templateUrl);
            if (next) {

                if (next.templateUrl === "templates/loginAdmin.html" || next.templateUrl === "templates/login.html") {
                    $rootScope.loginPage = true;
                }
                if (next.templateUrl === "templates/home.html") {
                    $rootScope.loginPage = false;
                    if ($cookieStore.get('globals')) {
                        $rootScope.uName = $cookieStore.get('globals').currentUser.user_name;
                        $rootScope.role = $cookieStore.get('globals').currentUser.role;
                        $rootScope.user_id = $cookieStore.get('globals').currentUser.user_id;
                    }
                }

                if (next.templateUrl === "templates/addMovie.html") {
                    $rootScope.loginPage = false;
                    if ($cookieStore.get('globals')) {
                        $rootScope.uName = $cookieStore.get('globals').currentUser.user_name;
                        $rootScope.role = $cookieStore.get('globals').currentUser.role;
                        $rootScope.user_id = $cookieStore.get('globals').currentUser.user_id;
                    }
                }

                if (next.templateUrl === "templates/cardDetail.html") {
                    $rootScope.loginPage = false;
                    if ($cookieStore.get('globals')) {
                        $rootScope.uName = $cookieStore.get('globals').currentUser.user_name;
                        $rootScope.role = $cookieStore.get('globals').currentUser.role;
                        $rootScope.user_id = $cookieStore.get('globals').currentUser.user_id;
                    }
                }
                if (next.templateUrl === "templates/editMovie.html") {
                    $rootScope.loginPage = false;
                    if ($cookieStore.get('globals')) {
                        $rootScope.uName = $cookieStore.get('globals').currentUser.user_name;
                        $rootScope.role = $cookieStore.get('globals').currentUser.role;
                        $rootScope.user_id = $cookieStore.get('globals').currentUser.user_id;
                    }
                }
            }


        });
    });

})();
