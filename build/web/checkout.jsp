<%-- 
    Document   : checkout
    Created on : 20 May, 2023, 8:44:35 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Check Out</title>

        <!-- favicon -->
        <link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
        <!-- google font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
        <!-- fontawesome -->
        <link rel="stylesheet" href="assets/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <!-- owl carousel -->
        <link rel="stylesheet" href="assets/css/owl.carousel.css">
        <!-- magnific popup -->
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <!-- animate css -->
        <link rel="stylesheet" href="assets/css/animate.css">
        <!-- mean menu css -->
        <link rel="stylesheet" href="assets/css/meanmenu.min.css">
        <!-- main style -->
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- responsive -->
        <link rel="stylesheet" href="assets/css/responsive.css">

        <style>
            .place-btn{
                cursor: pointer;
                border-radius: 30px;
                background-color: #f28123;
                color: white;
                border:none;
            }

            .place-btn:hover{
                background-color: black;
                color: #f28123;
                border: none;
            }
        </style>

    </head>
    <body>

        <!--PreLoader-->
        <div class="loader">
            <div class="loader-inner">
                <div class="circle"></div>
            </div>
        </div>
        <!--PreLoader Ends-->

        <jsp:include page="header.jsp"></jsp:include>

            <!-- search area -->
            <div class="search-area">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <span class="close-btn"><i class="fas fa-window-close"></i></span>
                            <div class="search-bar">
                                <div class="search-bar-tablecell">
                                    <h3>Search For:</h3>
                                    <form action="search-name" method="get">
                                        <input type="text" placeholder="Search by name..." name="name">
                                        <button type="submit">Search <i class="fas fa-search"></i></button>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- end search arewa -->

            <!-- breadcrumb-section -->
            <div class="breadcrumb-section breadcrumb-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2 text-center">
                            <div class="breadcrumb-text">
                                <p>Fresh and Organic</p>
                                <h1>Check Out Product</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

            <!-- check out section -->

            <div class="checkout-section mt-150 mb-150">
                <div class="container">

                    <div class="row">

                        <div class="col-lg-8">
                            <div class="checkout-accordion-wrap">
                                <div class="accordion" id="accordionExample">
                                    <div class="card single-accordion">
                                        <div class="card-header" id="headingOne">
                                            <h5 class="mb-0">
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                    Billing Address
                                                </button>
                                            </h5>
                                        </div>

                                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="billing-address-form">
                                                    <form action="checkout" method="post">
                                                        <p><input type="text" placeholder="Name" value="${sessionScope.acc.name}" name="name"></p>
                                                    <p><input type="email" placeholder="Email"value="${sessionScope.acc.email}" name="email"></p>
                                                    <p><input type="text" placeholder="Address" value="${sessionScope.acc.address}" name="address"></p>
                                                    <p><input type="text" placeholder="Phone" value="${sessionScope.acc.phone}" name="phone"></p>
                                                    <p><input type="hidden" value="${code}" name="code"></p>
                                                    <p><input type="hidden" value="${my_point}" name="my_point"></p>
                                                    <p><textarea name="note" id="bill" cols="30" rows="10" placeholder="Say Something"></textarea></p>
                                                    <button type="submit" class="boxed-btn place-btn px-4 py-2">Place Order</button>
                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="order-details-wrap">
                            <table class="order-details">
                                <thead>
                                    <tr>
                                        <th>Your order Details</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody class="order-details-body">
                                    <tr>
                                        <td>Product</td>
                                        <td>Total</td>
                                    </tr>
                                    <c:if test="${ok != null}">
                                        <c:forEach items="${items}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.product.name}</strong></td>
                                                <c:forEach items="${saleList}" var="e">
                                                    <c:if test="${(e.productID == c.product.productID) && (e.saleQuantity > 0)}">
                                                        <c:if test="${c.quantity > e.saleQuantity}">
                                                            <td><del class="text-danger">${c.product.price * c.quantity}$</del> &nbsp; <fmt:formatNumber value="${c.product.price * e.saleQuantity * (1 - saleValue) + c.product.price * (c.quantity - e.saleQuantity)}" pattern="#.##" />$</td>
                                                        </c:if>
                                                        <c:if test="${c.quantity <= e.saleQuantity}">
                                                            <td><del class="text-danger">${c.product.price * c.quantity}$</del> &nbsp; <fmt:formatNumber value="${c.product.price * c.quantity * (1 - saleValue)}" pattern="#.##" />$</td>
                                                        </c:if>
                                                        <c:set var="k" value="1"></c:set>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${k != 1}">
                                                    <td>${c.product.price * c.quantity}$</td>
                                                </c:if>
                                                <c:set var="k" value="0"></c:set>
                                                </tr>
                                        </c:forEach>
                                        <c:forEach items="${comboItems}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.combo.comboName}</strong></td>
                                                <td>
                                                <fmt:formatNumber value="${c.combo.totalPrice * c.quantity}" pattern="#.##" />$
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${ok == null}">
                                        <c:forEach items="${items}" var="c">                             
                                            <tr>
                                                <td>${c.product.name}</td>
                                                <td>${c.product.price * c.quantity}$</td>
                                            </tr>
                                        </c:forEach>
                                        <c:forEach items="${comboItems}" var="c">
                                            <tr class="total-data">
                                                <td>${c.combo.comboName}</td>
                                                <td>
                                                <fmt:formatNumber value="${c.combo.totalPrice * c.quantity}" pattern="#.##" />$
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>



                                </tbody>
                                <tbody class="checkout-details">
                                    <tr>
                                        <td>Subtotal</td>
                                        <td>${subtotal}$</td>
                                    </tr>
                                    <!--                                    <tr>
                                                                            <td>Shipping</td>
                                                                            <td>$50</td>
                                                                        </tr>-->
                                    <tr>
                                        <td><strong>TOTAL</strong></td>
                                        <td>${subtotal}$</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- end check out section -->



        <jsp:include page="footer.jsp"></jsp:include>


        <!-- jquery -->
        <script src="assets/js/jquery-1.11.3.min.js"></script>
        <!-- bootstrap -->
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <!-- count down -->
        <script src="assets/js/jquery.countdown.js"></script>
        <!-- isotope -->
        <script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
        <!-- waypoints -->
        <script src="assets/js/waypoints.js"></script>
        <!-- owl carousel -->
        <script src="assets/js/owl.carousel.min.js"></script>
        <!-- magnific popup -->
        <script src="assets/js/jquery.magnific-popup.min.js"></script>
        <!-- mean menu -->
        <script src="assets/js/jquery.meanmenu.min.js"></script>
        <!-- sticker js -->
        <script src="assets/js/sticker.js"></script>
        <!-- main js -->
        <script src="assets/js/main.js"></script>

    </body>
</html>
