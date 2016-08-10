<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #################################### -->
<!--TOP Fixed menu-->
<!-- #################################### -->
 
        <nav class="navbar navbar-inverse navbar-fixed-top top-nav">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">WebSiteName</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Page 1-1</a></li>
                            <li><a href="#">Page 1-2</a></li>
                            <li><a href="#">Page 1-3</a></li>
                        </ul></li>
                    <li><a href="#">Page 2</a></li>
                    <li><a href="#">Page 3</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </div>
        </nav>
        <!--CLOSE TOP FIXED MENU-->
        <!-- MENU DANH MUC SAN PHAM -->
        <div class=" product-list">
            <div class=" prt-list-menu">
                <div class="col-md-4 ">
                    <a href="#" class=" prt-list-menu-text"> Option 1 </a> <a href="#" class="row prt-list-menu-text"> Option 2</a> <a href="#"
                        class="row prt-list-menu-text"> Option 3</a>
                </div>
                <div class="col-md-4 ">
                    <a href="#" class="row prt-list-menu-text"> Option 1 </a> <a href="#" class="row prt-list-menu-text"> Option 2</a> <a href="#"
                        class="row prt-list-menu-text"> Option 3</a>
                </div>
                <div class="col-md-4 ">
                    <a href="#" class="row prt-list-menu-text"> Option 1 </a> <a href="#" class="row prt-list-menu-text"> Option 2</a> <a href="#"
                        class="row prt-list-menu-text"> Option 3</a>
                </div>
            </div>

        </div>
        <!-- CLOSE MENU DANH MUC SAN PHAM -->