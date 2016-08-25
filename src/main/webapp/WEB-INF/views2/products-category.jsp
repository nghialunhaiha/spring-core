<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <title>list san pham theo inner menu</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="<c:url value = '/static/css2/menu.css'/>" rel="stylesheet"/>
    <link href="<c:url value = '/static/css2/prd-categories.css'/>" rel="stylesheet"/>
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
<div class="container prd-categories">
    <%--cach ra 1 doan cho nay gioi thieu menu linh tinh cac kieu--%>
    <div class="row prd-categories-intro">
        <div class="col-md-2 col-xs-2 col-sm-2 left-intro">

        </div>
        <div class="col-md-10 col-xs-10 col-sm-10 main-intro">

        </div>
    </div>
    <%--list san pham o day--%>
    <div class="row col-main">
        <div class="col-md-2 col-xs-2 col-sm-2 left-filter-bar">

        </div>
        <div class="col-md-10 col-xs-10 col-sm-10 prd-categories-list"><%--khung to list tat ca cac item ra tren nay--%>
            <ul class = "main-list-items">
                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>
                            <a href="#">
                                <img src="<c:url value = '/static/imgs/220x220.jpg'/>">
                             <%--<script src="<c:url value = '/static/js/app.js'/>"></script>--%>
                            </a>
                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <%------------------------------------------------%>
                <%------------------------------------------------%>
                <%--MOI THE LI SE DC THAY THE BANG THE NG-REPEAT--%>
                <%------------------------------------------------%>
                <%------------------------------------------------%>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

                <li class="list-item list-item-first"><%--wrapper bao quanh ben ngoai cua moi item--%>
                    <div class="item"><%--moi item se dc design o day--%>
                        <div class="img img-border"><%--anh se hien thi o day 220x220--%>

                        </div>
                        <div class="info"><%--mo ta cho san pham--%>
                            <div class="hotproduct-info"><%--mo ta cho hot product: san pham moi nhat nam 2016, danh cho toa nha cao cap ^^--%>

                            </div>
                            <div class="price"><%--price--%>

                            </div>
                            <div class="shipping-info"><%--shipping info--%>

                            </div>
                            <div class="rate-history"><%--rate history--%>

                            </div>
                            <%----%>
                        </div>
                        <%--close item info--%>

                        <div class="info-more"><%--mo ta cho san pham ma nhieu thong tin hon--%>
                            <%--thong tin them phai hien thi o day--%>
                        </div>
                        <%--close item info--%>
                    </div>
                </li>

            </ul>
        </div>
    </div>

</div>

<%--<c:import url="footer.jsp"></c:import>--%>
<%--FOOTER--%>

<script src="<c:url value = '/static/js/angular-1.4.6.js'/>"></script>
<script src="<c:url value = '/static/js/app.js'/>"></script>

</body>
<%--main-page--%>
</html>
