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
                loginId : 'nghialun',
                token : '123123123'
            }


            var requestObject = {'product': product, 'userInfo': self.userInfo };
            console.log("request data: ", requestObject)
            return $http.post(mgmt_product + 'item/', requestObject).then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    return $q.reject(errResponse);
                }
            )
        }, //   close create product
        updateProduct: function (product, id) {
            return $http.put(mgmt_product + 'item/'+ id, product)
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