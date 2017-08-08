(function () {
    var app = angular.module('userServiceModule', ['ngCookies']);


    app.factory('UserFactory', ['$http', '$cookieStore', '$timeout', '$rootScope', function ($http, $cookieStore, $timeout, $rootScope) {
        var factory = {};

        factory.addUser = function (user, callback) {
            delete user.confirmPassword;

            $timeout(function () {
                $http.post('http://localhost:8080/movieflix/api/users', user).then(function (success) {
                    this.response = {};
                    this.user = success.data;
                    this.response.success = true;
                    $rootScope.globals = {
                        currentUser: {
                            user_name: this.user.lastName + " " + this.user.firstName,
                            user_id: this.user.id
                        }
                    };

                    $cookieStore.put('globals', $rootScope.globals);
                    callback(response);
                }, function (error) {
                    console.error(error)
                });

            }, 1000);

        };


        factory.validateUser = function (username, password, callback) {
            $timeout(function () {
                $http.get('http://localhost:8080/movieflix/api/users').then(function (success) {
                    this.users = success.data;
                    var response = false;
                    self.users.forEach(function (user) {
                        response = {success: (username === user.userName || username === user.email) && password === user.password && user.role === 'user'};
                        if (response.success) {
                            $rootScope.globals = {
                                currentUser: {
                                    user_name: user.lastName + " " + user.firstName,
                                    user_id: user.id,
                                    role: 'user'
                                }
                            };

                            $cookieStore.put('globals', $rootScope.globals);
                            callback(response);
                        }
                    });

                    if (!response.success) {
                        response.message = 'Username or password is incorrect';
                    }
                    callback(response);
                }, function (error) {
                    // console.error(error);
                });

            }, 1000);

        };


        factory.validateAdmin = function (username, password, callback) {
            $timeout(function () {
                $http.get('http://localhost:8080/movieflix/api/users').then(function (success) {
                    this.users = success.data;
                    var response = false;
                    self.users.forEach(function (user) {
                        response = {success: (username === user.userName || username === user.email) && password === user.password && user.role === 'admin'};
                        if (response.success) {
                            $rootScope.globals = {
                                currentUser: {
                                    user_name: user.lastName + " " + user.firstName,
                                    user_id: user.id,
                                    role: user.role
                                }
                            };

                            $cookieStore.put('globals', $rootScope.globals);
                            callback(response);
                        }
                    });
                    console.log("Admin");
                    if (!response.success) {
                        response.message = 'Username or password is incorrect';
                    }
                    callback(response);
                }, function (error) {
                    // console.error(error);
                });

            }, 1000);

        };

        factory.logoutUser = function () {
            $rootScope.globals = {};
            $cookieStore.remove('globals');
        };


        return factory;
    }]);

    app.service('UserService', function (UserFactory) {
        this.createUser = function (user, callback) {
            return UserFactory.addUser(user, callback);
        };
        this.checkUser = function (username, password, callback) {
            return UserFactory.validateUser(username, password, callback);
        };

        this.checkAdmin = function (username, password, callback) {
            return UserFactory.validateAdmin(username, password, callback);
        };

        this.clearCredentials = function () {
            return UserFactory.logoutUser();
        };

    });

})();