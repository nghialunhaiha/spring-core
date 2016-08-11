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
</head>
<body>
<c:import url="menu.jsp"></c:import>
<div class="container">
    <%--header--%>
    <div class="row">

        <%--close header--%>
    </div>
    <div class="row">
        <c:import url="main-page.jsp"></c:import>
    </div>
    <%--close main-page--%>

    <div class="row">
        <%--footer--%>
        <c:import url="footer.jsp"></c:import>
        <%--close footer--%>
    </div>
</div>
<%--close container--%>
<script src="<c:url value = '/static/js/angular-1.4.6.js'/>"></script>
<script src="<c:url value = '/static/js/app.js'/>"></script>
</body>
<%--main-page--%>
</html>
