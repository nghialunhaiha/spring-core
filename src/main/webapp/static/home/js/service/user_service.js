'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllUsers: function() {
					return $http.get('http://localhost:8080/management/user/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},

		    createUser: function(user){
					return $http.post('http://localhost:8080/management/user/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },

		    updateUser: function(user, id){
					return $http.put('http://localhost:8080/management/user/'+id, user)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},

			deleteUser: function(id){
					return $http.delete('http://localhost:8080/management/user/'+id)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting user');
										return $q.reject(errResponse);
									}
							);
			},

			findWithKey: function(searchText) {
//			    var data = {
//			            searchText:searchText
//			           };

//			    var config = {
//			            params: data,
//			            headers : {'Accept' : 'application/json'}
//			           };
			    return $http.get('http://localhost:8080/management/search/'+ searchText).then(
			            function(response) {
			                return response.data;
			            }, function(errResponse) {
//			                console.error(errResponse);
//			                console.error('Error while searching user');
                            return $q.reject(errResponse);
			            }
			    );
			}
		
	};

}]);
