<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row top-menu-wrapper">
    <div class="header-image">

    </div>
    <nav class="menu-fixed-top container-fluid">
        <div class = "col-md-12">
            <div class="row">
                <div class="col-md-2">
                    <div class="row logo top-menu-column">
                        <a href="#"> Website name!!!</a>
                    </div>

                </div>
                <%--close logo--%>
                <div class="col-md-2">
                    <div class="row top-menu-item">
                        <a href="#">Mạch điều khiển LED</a>
                    </div>
                    <div class="row  top-menu-item">
                        <a href="#">Menu 1</a>
                    </div>

                </div>
                <%--close column 1--%>
                <div class="col-md-2">
                    <div class="row top-menu-item">
                        <a href="#">Mạch điều khiển LED</a>
                    </div>
                    <div class="row top-menu-item">
                        <a href="#">Menu 2</a>
                    </div>
                </div>
                <%--close column 2--%>
                <div class="col-md-2">
                    <div class="row top-menu-item">
                        <a href="#">Mạch điều khiển LED</a>
                    </div>
                    <div class="row top-menu-item">
                        <a href="#">Menu 3</a>
                    </div>
                </div>
                <%--close column 3--%>
                <div class="col-md-2">
                    <div class="row top-menu-item">
                        <a href="#">Mạch điều khiển LED</a>
                    </div>
                    <div class="row top-menu-item">
                        <a href="#">Menu 4</a>
                    </div>
                </div>
                <%--close column 4--%>
                <div class="col-md-2">
                    <div class="row top-menu-item">
                        <a href="#">Đăng nhập</a>
                    </div>
                    <div class="row top-menu-item">
                        <a href="#">Tìm kiếm</a>
                    </div>

                </div>
                <%--close login, search--%>
            </div>
        </div>
    </nav>
    <nav clas = "menu-fixed-top-2"></nav>
</div>
<script>
    var mn = $('.menu-fixed-top');
    console.log(mn);
    mns = 'menu-fixed-top-scrolled';
    hdr = $('header-image').height();
    console.log(hdr);
    $(window).scroll(function () {
        if ($(this).scrollTop() > hdr) {
            mn.addClass(mns);
        } else {
            mn.removeClass(mns);
        }
    });
</script>