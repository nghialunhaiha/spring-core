mgmt.controller('UserController', ['$scope', 'UserService', '$rootScope', function ($scope, userService, $rootScope) {
    var self = this;
    self.user = {
        id: null,
        username: '',
        address: '',
        email: ''
    };
    self.users = [];
    self.searchText = '';

    self.fetchAllUsers = function () {
        userService.fetchAllUsers().then(function (d) {
            self.users = d;
            console.log('data return when get all data:', d);
        }, function (errResponse) {
            console.error('Error while fetching Currencies');
        });
    };

    self.createUser = function (user) {
        userService.createUser(user).then(self.fetchAllUsers,
            function (errResponse) {
                console.error('Error while creating User.');
            });
    };

    self.updateUser = function (user, id) {
        userService.updateUser(user, id).then(self.fetchAllUsers,
            function (errResponse) {
                console.error('Error while updating User.');
            });
    };

    self.deleteUser = function (id) {
        userService.deleteUser(id).then(self.fetchAllUsers,
            function (errResponse) {
                console.error('Error while deleting User.');
            });
    };

    self.fetchAllUsers();

    self.findByNameAndAddr = function (name, addr) {
        console.log('name: ' + name + '    addr: ' + addr);
        userService.findByNameAndAddr(name, addr).then(function (data) {
            self.users = data;
        }, function (errResponse) {
            console.error('Error when search with key input.')
        });
    };
    // in User Registration Form
    /*
     * HANDLE submit, action in form.
     */
    self.search = function () {
        if (self.searchText == null || self.searchText == '') {
            console.error('Search text input is empty.')
        } else
            userService.findWithKey(self.searchText).then(function (data) {
                // self.fetchAllUsers,
                self.users = data;
                console.log('data return when using search :' + data);
            }, function (errResponse) {
                console.error('Error when search with key input.')
            });
    };

    self.submit = function () {
        if (self.user.id == null) {
            console.log('Saving New User', self.user);
            self.createUser(self.user);
        } else {
            self.updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        self.reset();
    };

    self.edit = function (id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.users.length; i++) {
            if (self.users[i].id == id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    };

    self.remove = function (id) {
        console.log('id to be deleted', id);
        if (self.user.id === id) {// clean form if the user to be
            // deleted is shown there.
            self.reset();
        }
        self.deleteUser(id);
    };

    self.reset = function () {
        self.user = {
            id: null,
            username: '',
            address: '',
            email: ''
        };
        $scope.myForm.$setPristine(); // reset Form
    };

// ======================================================
    //$scope.filterOptions = [];

    self.filterOptions = [];
    userService.getFilterOptions().then(function (dataResponse) {
        self.filterOptions = dataResponse;
        $rootScope.$broadcast('gotData', self.filterOptions); // promise that: filterOptions got data.
    }, function (errResponse) {
        console.error('An error occurred when fet filterOptions. Controller: getFilteroptions()');
    });

    self.nameOptions = [];
    self.addrOptions = [];
    $scope.$on('gotData', function (event, data) {

        console.log('event service', event);
        console.log('data service', data);

        angular.forEach(data, function (object, key) {
            self.nameOptions.push(self.getNameOption(key, object.userName));
            self.addrOptions.push(self.getAddrOption(key, object.village));
        });

        console.log('name options: ', self.nameOptions);
        console.log('addr options: ', self.addrOptions);
    });

    // process filter option
    self.filter = function (filter1, filter2) {

        console.log('name options: ', filter1);
        console.log('addr options: ', filter2);
    };

    //  ex: getName option for filter options
    self.getNameOption = function(id, value) {
        var nameOption = {uid: '', value: ''};
        nameOption.uid = value;
        nameOption.value = value;
        return nameOption;
    }

    //  ex: getAddr option for filter options
    self.getAddrOption = function(id, value) {
        var addrOption = {aid: '', value: ''};
        addrOption.aid = value;
        addrOption.value = value;
        return addrOption;
    }

}]);

'use strict';
