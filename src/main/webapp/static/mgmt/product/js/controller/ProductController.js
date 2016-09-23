'use strict'
prdManagement.controller('UserController', ['$scope', 'UserService', '$rootScope', function ($scope, userService, $rootScope) {
    var self = this;
    self.SubType = {
        led: 'LED', matrix: 'MATRIX', board: 'BOARD', power: 'POWER'
        //  list all sub type of led, power, maxtric, board, ...
    }

    self.LEDType = {
        LED_5050: 'LED_5050', LED_5730: 'LED_5730'
    }

    self.ColorTemp = {
        T_3000K: 'T_3000K', T_4500K: 'T_4500K', T_5000K: 'T_5000K', T_6000K: 'T_6000K'
    }

    self.PowerSource = {
        AC: 'AC', DC: 'DC'
    }
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
        subType: SubType,
        productDescriptions: '',
        colors: [],
        ledType: LEDType,
        colorTemp: ColorTemp,
        occasion: '',
        powerGeneration: '',
        ledsPerMeter: '',
        averageLife: 0,
        waterProff: false,
        voltage: 0,
        colorTemperature: '',
        powerSource: PowerSource,
        modelNumber: ''
    }
    self.products = [];


}]);