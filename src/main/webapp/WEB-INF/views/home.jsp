<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Simba-Led home page</title>
    <meta content="" name="author"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="<c:url value = '/static/css/app.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css/angular_error_style.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css/header.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css/menu-top.css'/>" rel="stylesheet"/>

    <link href="<c:url value = '/static/css/product-list.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css/main-page.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css/footer.css'/>" rel="stylesheet"/>
</head>
<body ng-app="myApp">
<div class = "container">
    <!--TOP FIXED MENU  -->
    <div class="my-container">
        <c:import url="menu-top-fix.jsp"></c:import>
    </div>

    <!--MAIN PAGE CONTAINER-->
    <div class="row">
        <c:import url="main-page-product-items.jsp"></c:import>
    </div>
    <div class = "row">


    </div>
    <!--FOOTER-->
    <c:import url="footer.jsp"></c:import>

</div>

<script src="<c:url value = '/static/js/angular-1.4.6.js'/>"></script>
<script src="<c:url value = '/static/js/app.js'/>"></script>
</body>
</html>