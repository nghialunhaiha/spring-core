/**
 * Created by Nghia on 26-09-2016.
 */
'use strict'
var mgmt_product = 'http://localhost:8080/mgmt/prd/';
prdManagement.factory('ProductService', ['$http', '$q', function ($http, $q) {
    return {
        createProduct: function (product) {
            console.log('service call create product: ', product);
            var self = this;
            self.userInfo = {
                loginId: 'nghialun',
                token: '123123123'
            }
            var req = {
                'product': product, 'userInfo': self.userInfo
            }
            console.log("request info: ", req);
            return $http.post('http://localhost:8080/mgmt/prd/item/', req).then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    return $q.reject(errResponse);
                }
            )
        }, //   close create product
        updateProduct: function (product, id) {
            return $http.put(mgmt_product + 'item/' + id, product)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        return $q.reject(errResponse);
                    }
                );
        } //    close update product
    };
}]);