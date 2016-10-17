'use strict'
var NON_SELECT_DROPDOWN = 'Please Choose...';
prdManagement.controller('ProductController', ['$scope', '$rootScope', 'ProductService', function ($scope, $rootScope, productService) {
    var self = this;
    
    self.SubTypes = [
        {
            key: 'none',
            value: NON_SELECT_DROPDOWN
        },{
            key: 'LED',
            value: 'Led dây'
        }, {
            key: 'MATRIX',
            value: 'Led ma trận'
        }, {
            key: 'BOARD',
            value: 'Led bảng mạch'
        }, {
            key: 'POWER',
            value: 'Nguồn'
        },

    ];

    self.LEDTypes = [{
        key: 'none',
        value: NON_SELECT_DROPDOWN
    },
        {
            key: 'LED_5050',
            value: 'LED_5050'
        }, {
            key: 'LED_5730',
            value: 'LED_5730'
        }

    ];

    self.ColorTemps =[{
        key: 'none',
        value: NON_SELECT_DROPDOWN
    },
        {
            key: 'T_3000K',
            value: 'T_3000K'
        },{
            key: 'T_4500K',
            value: 'T_4500K'
        },{
            key: 'T_5000K',
            value: 'T_5000K'
        },{
            key: 'T_6000K',
            value: 'T_6000K'
        }
    ];

    self.PowerSources = [{
        key: 'none',
        value: NON_SELECT_DROPDOWN
    },
        {
            key: 'AC',
            value: 'AC'
        },{
            key: 'DC',
            value: 'DC'
        }
    ];
    self.product = {
        id: null,
        title: '',
        rate: '',
        feedBack: '',
        order: '',
        shipmentInfo: '',
        price: '',
        discountPrice: '',
        deliveryTime: '',
        deliveryNote: '',
        availableStatus: '',
        subType: 'none',
        productDescriptions: '',
        colors: [],
        ledType: 'none',
        colorTemp: 'none',
        occasion: '',
        powerGeneration: '',
        ledsPerMeter: '',
        averageLife: 0,
        waterProff: '',
        voltage: 0,
        colorTemperature: '',
        powerSource: 'none',
        modelNumber: ''
    };
    self.products = [];

    self.reset = function () {
        self.product = {
            id: null,
            title: '',
            rate: '',
            feedBack: '',
            order: '',
            shipmentInfo: '',
            price: '',
            discountPrice: '',
            deliveryTime: '',
            deliveryNote: '',
            availableStatus: '',
            subType: self.SubType,
            productDescriptions: '',
            colors: [],
            ledType: self.LEDType,
            colorTemp: self.ColorTemp,
            occasion: '',
            powerGeneration: '',
            ledsPerMeter: '',
            averageLife: 0,
            waterProff: false,
            voltage: 0,
            colorTemperature: '',
            powerSource: self.PowerSource,
            modelNumber: ''
        }
        $scope.prdForm.$setPristine(); // reset Form
    };
    //  close reset form.

    //  submit form.
    self.submitProductSetting = function () {
        if (self.product.id == null) {

            var reqProduct = {
                title: 'Led chiếu sáng 5050 ',
                rate: 'chưa có thông tin đánh giá',
                feedBack: 'Chưa có phản hồi',
                order: '10000000',
                shipmentInfo: 'Giao hàng trong ng',
                price: '123132',
                discountPrice: '12311',
                deliveryTime: '111111',
                deliveryNote: 'GIao hàng trong giờ hành chính.',
                availableStatus: 'còn hàng',
                subType: 'LED_STRIP',
                productDescriptions: '',
                colors: 'RED',
                ledType: 'none',
                colorTemp: 'none',
                occasion: '',
                powerGeneration: '',
                ledsPerMeter: '',
                averageLife: 0,
                waterProff: '',
                voltage: 0,
                colorTemperature: '',
                powerSource: 'none',
                modelNumber: ''
            }
            self.product = reqProduct;
            console.log('[controller]: create product', self.product);


            productService.createProduct(self.product);
        } else {
            console.log('[controller]: udpate product', self.product);
            console.log('update product', self.product);
            productService.updateProduct(self.product, self.product.id);
        }
    }
}]);