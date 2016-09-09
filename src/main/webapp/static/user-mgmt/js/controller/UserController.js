'use strict';
mgmt.controller('UserController', ['$scope','UserService', function ($scope, UserService) {
    var self = this;
    self.user = {
        id: null,
        userName : '',
        address : '',
        email : ''
    };
    self.users = [];

}]);