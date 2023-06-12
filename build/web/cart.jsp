<%-- 
    Document   : cart
    Created on : 20 May, 2023, 8:45:04 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Cart</title>

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
            .continue-btn{
                cursor: pointer;
                border-radius: 30px;
                background-color: #f28123;
                color: white;
                border:none;
            }

            .continue-btn:hover{
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
                                <h1>Cart</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

            <!-- cart -->
            <div class="cart-section mt-150 mb-150">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-12">
                            <div class="cart-table-wrap">
                                <table class="cart-table">
                                    <thead class="cart-table-head">
                                        <tr class="table-head-row">
                                            <th class="product-remove"></th>
                                            <th class="product-image">Product Image</th>
                                            <th class="product-name">Name</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-total">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${items}" var="c">
                                        <tr class="table-body-row">
                                            <td class="product-remove"><a href="remove-from-cart?id=${c.product.productID}"><i class="far fa-window-close"></i></a></td>
                                            <td class="product-image"><img src="${c.product.image}" alt="" style="height: 50px; width: 50px;"></td>
                                            <td class="product-name">${c.product.name}</td>
                                            <td class="product-price">${c.product.price}$</td>
                                            <td class="product-quantity"><input type="number" readonly placeholder="${c.quantity}"></td>
                                            <td class="product-total">${c.quantity * c.product.price}$</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>


                            </table>

                        </div>
                        <div class="mt-5"><a href="shopping" class="px-5 py-3 mt-5 continue-btn">Continue shopping</a></div>

                    </div>

                    <div class="col-lg-4">
                        <c:if test="${ok == null}">
                            <div class="total-section">
                                <table class="total-table">
                                    <thead class="total-table-head">
                                        <tr class="table-total-row">
                                            <th>Name</th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${items}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.product.name}</strong></td>
                                                <td>${c.product.price * c.quantity}$</td>
                                            </tr>
                                        </c:forEach>

                                        <!--                                        <tr class="total-data">
                                                                                    <td><strong>Shipping: </strong></td>
                                                                                    <td>$50</td>
                                                                                </tr>-->
                                        <tr class="total-data">
                                            <td><strong>Total: </strong></td>
                                            <td>${subtotal}$</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="cart-buttons">
                                    <a href="checkout" class="boxed-btn black">Check Out</a>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${ok != null}">
                            <div class="total-section">
                                <table class="total-table">
                                    <thead class="total-table-head">
                                        <tr class="table-total-row">
                                            <th>Name</th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${items}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.product.name}</strong></td>
                                                <c:forEach items="${saleList}" var="e">
                                                    <c:if test="${e.productID == c.product.productID}">
                                                        <td><del class="text-danger">${c.product.price * c.quantity}$</del> &nbsp; ${c.product.price * c.quantity * (1 - saleValue)}$</td>
                                                        <c:set var="k" value="1"></c:set>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${k != 1}">
                                                    <td>${c.product.price * c.quantity}$</td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>

                                        <!--                                        <tr class="total-data">
                                                                                    <td><strong>Shipping: </strong></td>
                                                                                    <td>$50</td>
                                                                                </tr>-->
                                        <tr class="total-data">
                                            <td><strong>Total: </strong></td>
                                            <td>${subtotal}$</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="cart-buttons">
                                    <a href="checkout" class="boxed-btn black">Check Out</a>
                                </div>
                            </div>
                        </c:if>


                        <div class="coupon-section">
                            <h3>Apply Coupon</h3>
                            <div class="coupon-form-wrap">
                                <form action="add-to-cart" method="post">
                                    <input type="hidden" name="productID" value="${productID}">
                                    <p><input type="text" name="code" placeholder="Coupon"></p>
                                    <p><input type="submit" value="Apply"></p>
                                </form>
                                <p class="text-danger">${ms != null ? ms : ""}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end cart -->



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
