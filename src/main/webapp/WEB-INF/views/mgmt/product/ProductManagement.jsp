<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Product management page</title>

    <!--      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
    <link href="<c:url value='/static/assert/css/bootstrap.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/user-mgmt/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/user-mgmt/css/angular_error_style.css' />" rel="stylesheet"/>
    <!--      <link href="../static/css/bootstrap.min.css />" rel="stylesheet" type="text/css" /> -->
    <!--      <link href="../static/css/app.css />" rel="stylesheet" type="text/css" /> -->
</head>
<body>
<div class="container">
    <div class="row formcontainer" ng-controller="ProductManagement as prdMgmt" name="prd-form">
        <form class="form-horizontal">
            <input type="hidden" ng-model="prdMgmt.product.id">
            <div class="row">
                <label class="col-md-2 control-label">name</label>
                <div class="col-md-7">
                    <input type="text" ng-model="prdMgmt.product.name" name="fName" class="form-control input-sm" placeholder="enter name value"
                           required ng-maxlength="100">
                    <div class="has-error" ng-show="prd-form.$dirty">
                        <span ng-show="prd-form.fName.$error.required">This is required field.</span>
                        <span ng-show="prd-form.fName.$error.maxlength">Maximum length required is 100.</span>
                        <span ng-show="prd-form.fName.$invalid">This field is invalid.</span>
                    </div>
                </div>
            </div>
            <!--close name field-->
            <div class="row">
                <div class="floatRight">
                    <input type="submit" value="{{!prdMgmt.product.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm"
                           ng-disabled="prd-form.$invalid">
                    <button type="button" ng-click="prdMgmt.reset()" class="btn btn-warning btn-sm" ng-disabled="prd-form.$pristine"> Reset form
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
                        <th width = "20%"></th>
                    </tr>
                </thread>
                <tbody>
                    <tr ng-repeat="productItem in prdMgmt.products">
                        <td><span ng-bind="productItem.id"></span></td>
                        <td><span ng-bind="productItem.name"></span></td>
                        <td><span ng-bind="productItem.name"></span></td>
                        <td><span ng-bind="productItem.name"></span></td>
                        <td>
                            <button type = "button" ng-click = "prdMgmt.edit(productItem.id)" class="btn btn-success custom-width"> Edit</button>
                            <button type = "button" ng-click = "prdMgmt.remove(productItem.id)" class="btn btn-danger custom-width"> Remove</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="<c:url value='/static/assert/js/angular-1.4.6.js' />"></script>
<script src="<c:url value='/static/user-mgmt/js/app.js' />"></script>
</body>
</html>
