<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="<c:url value = '/static/css2/menu.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css2/main-page.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css2/footer.css'/>" rel="stylesheet"/>
</head>
<body style="background-color: #eee;">

<c:import url="menu.jsp"></c:import>
<div class="container">
    <div class="row">
        <ul class="a" style="list-style-type: none">
            <li><a href="http://tobiasahlin.com/blog/how-to-animate-box-shadow/">link box shadow css, effect with
                css3</a></li>
            <li><a href="http://jsfiddle.net/tetgG/">too easy box shadow</a></li>
            <li><a href="http://zurb.com/library"> libraries</a></li>
            <li><a href="http://zurb.com/building-blocks/image-hover-effects"> hover image effect</a></li>

        </ul>


    </div>
</div>
<div class="container main-page">
    <div class="row prd-item-wrapper">
        <div class="col-md-12 col-xs-12 col-sm-12">
            <c:import url="main-page.jsp"></c:import>
            <c:import url="main-page.jsp"></c:import>
            <c:import url="main-page.jsp"></c:import>
            <c:import url="main-page.jsp"></c:import>
        </div>
    </div>

</div>

<c:import url="footer.jsp"></c:import>
<%--FOOTER--%>

<script src="<c:url value = '/static/js/angular-1.4.6.js'/>"></script>
<script src="<c:url value = '/static/js/app.js'/>"></script>

</body>
<%--main-page--%>
</html>
