<%-- 
    Document   : shop
    Created on : 20 May, 2023, 8:42:33 AM
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
        <title>Shop</title>

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
            .bg-orange{
                background-color: #f28123;
            }
            
            
            .calories-ul{
                list-style: none;
                padding-left: 5px;
            }
            
            .calories-ul li a{
                color: grey;
                font-size: 100%;
            }
            
            .calories-ul li a:hover{
                border-bottom: #f28123 3px solid;
                display:block;
                transition: 0.3s ease-in-out;
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
                                <h1>Shop</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3 mt-150 mb-150">
                        <div class="search-by-name bg-success " style="height:50px;width:100%">

                        </div>
                        <hr>
                        <div class="search-by-price bg-danger my-5" style="height: 300px; width: 100%;">

                        </div>
                        <hr>
                        <div class="search-by-categories ">
                            <p class="bg-orange p-3 text-white font-weight-bold">The amount of calories you want to take in</p>

                                <ul class="calories-ul">
                                    <li class='mb-2'><a href="search-by-calories?from=${0}&to=${100}">0 - 100 (calories)</a></li>
                                <li class='mb-2'><a href="search-by-calories?from=${100}&to=${200}">100 - 200 (calories)</a></li>
                                <li class='mb-2'><a href="search-by-calories?from=${200}&to=${300}">200 - 300 (calories)</a></li>
                                <li class='mb-2'><a href="search-by-calories?from=${300}&to=${400}">300 - 400 (calories)</a></li>
                                <li class='mb-2'><a href="search-by-calories?from=${400}&to=${-1}">400+ (calories)</a></li>
                            </ul>
                    </div>
                </div>

                <div class="col-sm-9">
                    <!-- products -->
                    <div class="product-section mt-150 mb-150">
                        <div class="container">

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="product-filters">
                                        <ul>
                                            <li class="active" data-filter="*">All</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="row product-lists">
                                <c:forEach items="${list}" var="c">
                                    <div class="col-lg-4 col-md-6 text-center strawberry">
                                        <div class="single-product-item">
                                            <div class="product-image">
                                                <a href="single-product?id=${c.productID}"><img src="${c.image}" style='width:100%;height:250px'></a>
                                            </div>
                                            <h3>${c.name}</h3>
                                            <p class="product-price"> ${c.price}$ </p>
                                            <a href="add-to-cart?productID=${c.productID}" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
                                            <c:if test="${sessionScope.acc.role != null}">
                                                <a href="add-to-wishlist?productID=${c.productID}"><button class="btn btn-danger px-5 py-3"><i class="fas fa-heart"></i></button></a>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <div class="row">
                                <div class="col-lg-12 text-center">
                                    <div class="pagination-wrap">
                                        <ul>
                                            <li><a href="#">Prev</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a class="active" href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">Next</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end products -->
                </div>   
            </div>
        </div>
    </div>

</div>
</div>


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
