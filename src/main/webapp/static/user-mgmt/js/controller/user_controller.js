'use strict';

mgmt.controller('UserController', ['$scope', 'UserService', function ($scope, userService) {
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
            console.log('data return when get all data:' + d);
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
        console.log('name: '+name +'    addr: '+addr);
        userService.findByNameAndAddr(name,addr).then(function (data) {
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
    self.filter = function (filter1, filter2) {
        // console.log('filter1: '+filter1 +'    filter2: '+filter2);
        userService.getFilterOptions().then(function (dataResponse) {
            $scope.filterOptions = dataResponse;
            console.log('filterOptions', $scope.filterOptions);
        }, function (errResponse) {
            console.error('An error occured when fet filterOptions. Controller: getFilteroptions()');
        });

        $scope.nameOptions = [];

        angular.forEach($scope.filterOptions, function (key, value) {
            var test = {uid :'', value:''};
            test.uid=1;
            test.value = value.userName;
            $scope.nameOptions.push(test);
        });
        console.log('name options:',$scope.nameOptions);
    };

    $scope.addrOptions = [
        {
            "id": "HaiHa",
            "label": "HaiHa"
        }, {
            "id": "xxx",
            "label": "xxxxx2"
        }, {
            "id": "aaa",
            "label": "aaaa3"
        }
    ]
}]);
