(function () {
    var app = angular.module('userControllerModule', ['userServiceModule']);

    app.controller('UserController', ['UserService', '$rootScope', '$scope', '$location', function (UserService, $rootScope, $scope, $location) {
        console.log("In user Controller");


        var self = this;
        self.user = {};
        self.errorMessage = "";


        UserService.clearCredentials();

        this.addUser = function () {
            self.user.role = "user";
            console.log(self.user);

            UserService.createUser(self.user, function (response) {

                if (response.success) {
                    $location.path('/');
                } else {
                    self.errorMessage = response.message;
                    $scope.error = response.message;

                }
            });


        };

        this.validateUser = function () {
            UserService.checkUser($scope.userName, $scope.password, function (response) {
                if (response.success) {
                    $location.path('/');
                } else {
                    self.errorMessage = response.message;
                    $scope.error = response.message;

                }
            });
        }


        this.validateAdmin = function () {
            UserService.checkAdmin($scope.userName, $scope.password, function (response) {
                if (response.success) {
                    $location.path('/');
                } else {
                    self.errorMessage = response.message;
                    $scope.error = response.message;

                }
            });

        }

    }]);

})();