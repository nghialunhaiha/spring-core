<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Product management page</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value='/static/user-mgmt/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/user-mgmt/css/angular_error_style.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/mgmt/product/css/product-management-page.css' />" rel="stylesheet"/>
</head>
<body ng-app="ProductManagement">
<div class="container">
    <div class="row formcontainer prdForm" ng-controller="ProductController as productController">
        <form class="form-horizontal" name="prdForm" ng-submit="productController.submitProductSetting()">
            <div class="row">
                <div class="col-md-6">
                    <!--id-->
                    <input type="hidden" ng-model="productController.product.id">
                    <!--name field-->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Title</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.title" name="fTitle" class="form-control input-sm"
                                   placeholder="enter name value"
                                   required ng-maxlength="100">
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.fTitle.$error.required">This is  field.</span>
                                <span ng-show="prdForm.fTitle.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.fTitle.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close name field-->
                    <!--shipment info field-->
                    <div class="row  prd-field">
                        <label class="col-md-4 control-label">Shipment info</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.shipmentInfo" name="fShipmentInfo"
                                   class="form-control input-sm" placeholder="enter shipment info"
                                   required ng-maxlength="100">
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.fShipmentInfo.$error.required">This is  field.</span>
                                <span ng-show="prdForm.fShipmentInfo.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.fShipmentInfo.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close shipment info-->
                    <!--price -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Price</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.price" name="fPrice" class="form-control input-sm"
                                   placeholder="enter price info"
                                   required ng-maxlength="100">
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.fPrice.$error.required">This is  field.</span>
                                <span ng-show="prdForm.fPrice.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.fPrice.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close price -->
                    <!--discountPrice -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Discount price</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.discountPrice" name="fDiscountPrice"
                                   class="form-control input-sm" placeholder="enter discount price info"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close discountPrice-->
                    <!--delivery time -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Delivery time</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.deliveryTime" name="fDeliveryTime"
                                   class="form-control input-sm" placeholder="enter delivery time info"
                                   required ng-maxlength="100">
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.fDeliveryTime.$error.required">This is  field.</span>
                                <span ng-show="prdForm.fDeliveryTime.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.fDeliveryTime.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close delivery time-->
                    <!--delivery note -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Delivery note</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.deliveryNote" name="fDeliveryNote"
                                   class="form-control input-sm" placeholder="enter delivery note info"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close delivery note-->

                    <!--colors -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">colors</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.colors" name="fColors" class="form-control input-sm"
                                   placeholder="select from colors of leds"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close colors-->

                    <!--occasion -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">occasion</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.occasion" name="fOccasion"
                                   class="form-control input-sm"
                                   placeholder="occasion là sử dụng cho trường hợp nào, chỗ nào dùng thì phù hợp"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close occasion-->
                    <!--powerGeneration -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">powerGeneration</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.powerGeneration" name="fPowerGeneration"
                                   class="form-control input-sm" placeholder="powerGeneration chả biết là cái mẹ gì, setting sau"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close powerGeneration-->
                    <!--ledsPerMeter -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">ledsPerMeter</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.ledsPerMeter" name="fLedsPerMeter"
                                   class="form-control input-sm" placeholder="Số mắt LED/m setting vd: 50/m"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close ledsPerMeter-->
                    <!--averageLife -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">averageLife</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.averageLife" name="fAverageLife"
                                   class="form-control input-sm" placeholder="Tuổi thọ của led."
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close averageLife-->
                    <!--waterProff -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">waterProff</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.waterProff" name="fWaterProff"
                                   class="form-control input-sm"
                                   placeholder="loại bọc nước, có bọc nước hay không, bọc theo thể loại nào. vd: có bọc siliicon - Không bọc."
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close waterProff-->
                    <!--voltage -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">voltage</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.voltage" name="fVoltage" class="form-control input-sm"
                                   placeholder="Điện áp sử dụng."
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close voltage-->
                    <!--colorTemperature -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">colorTemperature</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.colorTemperature" name="fColorTemperature"
                                   class="form-control input-sm" placeholder="Nhiệt độ tỏa của bóng."
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close colorTemperature-->

                    <!--modelNumber -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">modelNumber</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.modelNumber" name="fmodelNumber"
                                   class="form-control input-sm" placeholder="model Number 5050/xxxx"
                                   ng-maxlength="100">
                        </div>
                    </div>
                    <!--close modelNumber-->
                </div>
                <!--close left column setting-->
                <div class="col-md-6">
                    <!--Sub-type -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Type, Sub-type</label>
                        <div class="col-md-8">
                            <select class="form-control" ng-model="productController.product.subType"
                                    ng-options="type.key as type.value for type in productController.SubTypes">
                            </select>
                        </div>
                    </div>
                    <!--close Sub-type-->
                    <!--ledType -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">ledType</label>
                        <div class="col-md-8">
                            <select class="form-control" ng-model="productController.product.ledType" required
                                    ng-options="type.key as type.value for type in productController.LEDTypes">
                            </select>
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.ledType.$error.required">This is required field.</span>
                                <span ng-show="prdForm.ledType.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.ledType.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close ledType-->
                    <!--colorTemp -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">colorTemp</label>
                        <div class="col-md-8">
                            <select class="form-control" ng-model="productController.product.colorTemp"
                                    ng-options="type.key as type.value for type in productController.ColorTemps">
                            </select>
                        </div >
                    </div>
                    <!--close colorTemp-->
                    <!--powerSource -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">powerSource</label>
                        <div class="col-md-8">
                            <select class="form-control" ng-model="productController.product.powerSource"
                                    ng-options="type.key as type.value for type in productController.PowerSources">
                            </select>
                        </div>
                    </div>
                    <!--close powerSource-->

                    <!--productDescriptions -->
                    <div class="row prd-field">
                        <label class="col-md-4 control-label">Product Descriptions</label>
                        <div class="col-md-8">
                            <input type="text" ng-model="productController.product.productDescriptions" name="fProductDescriptions"
                                   class="form-control input-sm" placeholder="cái này cho vào multitex"
                                   required ng-maxlength="100">
                            <div class="has-error" ng-show="prdForm.$dirty">
                                <span ng-show="prdForm.fProductDescriptions.$error.required">This is  field.</span>
                                <span ng-show="prdForm.fProductDescriptions.$error.maxlength">Maximum length  is 100.</span>
                                <span ng-show="prdForm.fProductDescriptions.$invalid">This field is invalid.</span>
                            </div>
                        </div>
                    </div>
                    <!--close productDescriptions-->
                </div>
                <!--close right column setting-->
            </div>

            <div class="row">
                <div class="floatRight">
                    <input type="submit" value="{{!productController.product.id ? 'Add' : 'Update'}}"
                           class="btn btn-primary btn-sm"
                           ng-disabled="prdForm.$invalid">
                    <button type="button" ng-click="productController.reset()" class="btn btn-warning btn-sm"
                            ng-disabled="prdForm.$pristine"> Reset form
                    </button>
                </div>
            </div>
            <!--close buttons-->
        </form>
        <!--close form-->
    </div>
    <!--close form style-->
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">List values</span>
        </div>
        <div class="tablecontainer">
            <table class="table table-responsive">
                <thread>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th width="20%"></th>
                    </tr>
                </thread>
                <tbody>
                <tr ng-repeat="productItem in productController.products">
                    <td><span ng-bind="productItem.id"></span></td>
                    <td><span ng-bind="productItem.name"></span></td>
                    <td><span ng-bind="productItem.name"></span></td>
                    <td><span ng-bind="productItem.name"></span></td>
                    <td>
                        <button type="button" ng-click="productController.edit(productItem.id)"
                                class="btn btn-success custom-width"> Edit
                        </button>
                        <button type="button" ng-click="productController.remove(productItem.id)"
                                class="btn btn-danger custom-width"> Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value='/static/assert/js/angular-1.4.6.js' />"></script>
<script src="<c:url value='/static/user-mgmt/js/app.js' />"></script>
<script src="<c:url value='/static/mgmt/product/js/ProductManagement.js' />"></script>
<script src="<c:url value='/static/mgmt/product/js/controller/ProductController.js' />"></script>
<script src="<c:url value='/static/mgmt/product/js/service/ProductService.js' />"></script>
</body>
</html>
