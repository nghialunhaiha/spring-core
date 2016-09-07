var prdApp = angular.module('prdApp', []);
prdApp.controller('prdItems', function ($scope) {

    var images = ["https://farm9.staticflickr.com/8549/29285734261_9f69d53185_m_d.jpg","https://farm9.staticflickr.com/8498/29364701065_23208a43ec_m_d.jpg",
    "https://farm9.staticflickr.com/8208/29364700855_91bc3de76f_m_d.jpg", "https://farm9.staticflickr.com/8314/29364699215_d48137af26_m_d.jpg"];
    // for (var i = 0; i < 100; i++) {
    //     records.push(i);
    // }
    $scope.images = images;
});