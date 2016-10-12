/**
 * Created by Nghia on 26-09-2016.
 */
'use strict'
var mgmt_product = '/mgmgt/prd/';
prdManagement.factory('ProductService', ['$http', '$q', function ($http, $q) {
    return {
        createProduct: function (product) {
            console.log('service call create product: ', product);
            var self = this;
            self.userInfo = {
                loginId : 'nghialun',
                token : '123123123'
            }
            return $http.post(mgmt_product + 'item/', product, userInfo).then(
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