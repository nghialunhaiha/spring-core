'use strict';
var mgmt_user = 'http://localhost:8080/mgmt';
mgmt.factory('UserService', ['$http', '$q', function ($http, $q) {

    return {

        fetchAllUsers: function () {
            return $http.get(mgmt_user + '/user/')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },

        createUser: function (user) {
            return $http.post(mgmt_user + '/user/', user)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateUser: function (user, id) {
            return $http.put(mgmt_user + '/user/' + id, user)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while updating user');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteUser: function (id) {
            return $http.delete(mgmt_user + '/user/' + id)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        },

        findWithKey: function (searchText) {
//			    var data = {
//			            searchText:searchText
//			           };

//			    var config = {
//			            params: data,
//			            headers : {'Accept' : 'application/json'}
//			           };
            return $http.get(mgmt_user + '/search/' + searchText).then(
                function (response) {
                    return response.data;
                }, function (errResponse) {
//			                console.error(errResponse);
//			                console.error('Error while searching user');
                    return $q.reject(errResponse);
                }
            );
        }

    };

}]);
