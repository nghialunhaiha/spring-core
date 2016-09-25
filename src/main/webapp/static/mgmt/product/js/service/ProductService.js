/**
 * Created by Nghia on 26-09-2016.
 */
'use strict'
var mgmt_product = '';
prdManagement.factory('ProductService', ['$http', '$q', function ($http, $q) {
    return {
        createProduct: function (product) {
            console.log('create product: ', product);
            /*return $http.post(mgmt_product + '/nghiadaica', product).then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    return $q.reject(errResponse);
                }
            )*/
        }, //   close create product
        updateProduct: function (product, id) {
            return $http.put(mgmt_product + '/nghiadaica'+ id, product)
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