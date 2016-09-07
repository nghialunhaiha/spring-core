<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>

<head>
    <meta name="viewport" content="width=1260">
    <title>List product items</title>
    <meta name="keywords" content="Shop aun projector online, Buy aun projector">
    <meta name="description"
          content="Shop the online stores on AliExpress.com to find reliable aun projector for unbeatable, cheap prices">
    <meta name="google-translate-customization" content="8daa66079a8aa29e-f219f934a1051f5a-ge19f8e1eaa3bf94b-e">
    <meta name="robots" content="follow,noindex">

    <script src="<c:url value = '/static/assert/js/jquery-2.2.4.js'/>"></script>
    <script src="<c:url value = '/static/assert/js/3.3.7_bootstrap.min.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/static/assert/css/bootstrap.min.css'/> ">
    <link href="<c:url value='/static/prd-list-page/css/me-footer.css'/> " rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/prd-list-page/css/ae-header.css'/> " rel="stylesheet" type="text/css">
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>--%>

    <meta name="data-spm" content="2114">
    <link rel="dns-prefetch" href="http://g02.a.alicdn.com/">
    <link rel="dns-prefetch" href="http://g04.a.alicdn.com/">
    <link rel="dns-prefetch" href="http://dmtracking2.alibaba.com/">
    <link rel="dns-prefetch" href="http://g03.a.alicdn.com/">
    <link rel="dns-prefetch" href="http://i.alicdn.com/">
    <link rel="dns-prefetch" href="http://ae01.alicdn.com/">
    <link rel="dns-prefetch" href="http://g01.a.alicdn.com/">
    <link rel="dns-prefetch" href="http://us.ynuf.alipay.com/">
    <link rel="shortcut icon" type="image/x-icon"
          href="http://i00.i.aliimg.com/images/eng/wholesale/icon/aliexpress.ico">
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/static/prd-list-page/css/saved_resource.css'/> ">

</head>

<body id="we-wholesale-search-list" data-spm="01010208" class="lang_en_US">

<input type="hidden" id="isSeller" value="false">

<!--ams-cdp-resource-start 60-->

<!--ams-cdp-resource-end 60-->

<!--ams-region-start 580-->
<c:import url="prd-list-header.jsp"/>

<c:import url="prd-list-breadcrumb.jsp"/>
<div id="page" class="categories-collapse autosize_wrap en-us">
    <div class="grid-c2-s5 util-clearfix">

        <c:import url="prd-list-col-main.jsp"></c:import>
        <c:import url="prd-list-col-sub.jsp"></c:import>

    </div>
</div>

<script src="<c:url value = '/static/assert/js/angular.js'></c:url>"></script>
<c:import url="prd-list-footer.jsp"/>
<!--<script src="/static/js/controller/products-category.js"></script>-->
</body>

</html>