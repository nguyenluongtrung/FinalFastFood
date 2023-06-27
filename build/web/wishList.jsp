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
        <title>Wish List</title>

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
                                <h1>Wish List</h1>
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
                        <div class="col-md-12">
                            <div class="cart-table-wrap">
                                <table class="cart-table">
                                    <thead class="cart-table-head">
                                        <tr class="table-head-row">
                                            <!--<th class="product-remove"></th>-->
                                            <th class="product-image">Product Image</th>
                                            <th class="product-name">Name</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-detail">Detail</th>
                                            <th class="product-delete">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${products}" var="c">
                                        <tr class="table-body-row">
                                            <!--<td class="product-remove"><a href="remove-from-cart?id=${c.productID}"><i class="far fa-window-close"></i></a></td>-->
                                            <td class="product-image"><img src="${c.image}" alt="" style="height: 50px; width: 50px;"></td>
                                            <td class="product-name">${c.name}</td>
                                            <td class="product-price">${c.price}$</td>
                                            <td class="product-detail"><a href="single-product?id=${c.productID}">See Detail</a></td>
                                            <!--<td class="product-delete"><a>Thêm Button Delete</a></td>-->
                                            <td class="product-delete">
                                                <a href="remove-wishlist?productID=${c.productID}">
                                                    <button class="btn btn-danger px-5 py-3">
                                                        <i class="fas fa-trash"></i>
                                                    </button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>     
                                    <c:forEach items="${combos}" var="c">
                                        <tr class="table-body-row">
                                            <!--<td class="product-remove"><a href="remove-from-cart?id=${c.comboID}"><i class="far fa-window-close"></i></a></td>-->
                                            <td class="product-image"><img src="${c.image}" alt="" style="height: 50px; width: 50px;"></td>
                                            <td class="product-name">${c.comboName}</td>
                                            <td class="product-price">${c.totalPrice}$</td>
                                            <td class="product-detail"><a href="combo-detail?id=${c.comboID}">See Detail</a></td>
                                            <!--<td class="product-delete"><a>Thêm Button Delete</a></td>-->
                                            <td class="product-delete">
                                                <a href="remove-wishlist?comboID=${c.comboID}">
                                                    <button class="btn btn-danger px-5 py-3">
                                                        <i class="fas fa-trash"></i>
                                                    </button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>     
                                </tbody> 
                            </table>
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
