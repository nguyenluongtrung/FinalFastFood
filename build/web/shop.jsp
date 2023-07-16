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

            .price-ul{
                list-style: none;
                padding-left: 5px;
            }

            .price-ul li a{
                color: grey;
                font-size: 100%;
            }

            .price-ul li a:hover{
                border-bottom: #f28123 3px solid;
                display:block;
                transition: 0.3s ease-in-out;
            }

            .overlay {
                position: absolute; 
                left: 15px;
                top: 0;
            }

            .overlay p{
                background-color: orange;
                font-weight: bold;
                font-size: 95%;
                padding: 13;
                color: white;
            }

            .bg-yellow {
                background-color: pink;
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
                        <div class="shop__sidebar__search w-100">
                            <form action="search-name" method="get" >
                                <input style="width: 86%;" class="rounded p-2 border-1" oninput="searchByName(this)" type="text" placeholder="Search..." name="name">
                                <button style="width: 12%" class="p-2 rounded border-1" type="submit"><span class="fas fa-search" style="font-size: 120%;"></span></button>
                            </form>
                        </div>
                        <hr>
                        <div class="search-by-price ">
                            <p class="bg-orange p-3 text-white font-weight-bold">The amount of price you want:</p>

                            <ul class="price-ul">
                                <li class='mb-2'><a href="search-price?from=${1}&to=${10}">1 - 10$</a></li>
                            <li class='mb-2'><a href="search-price?from=${11}&to=${20}">11 - 20$</a></li>
                            <li class='mb-2'><a href="search-price?from=${21}&to=${30}">21 - 30$</a></li>
                            <li class='mb-2'><a href="search-price?from=${31}&to=${40}">31 - 40$</a></li>
                            <li class='mb-2'><a href="search-price?from=${41}&to=${-1}">41+$</a></li>
                        </ul>

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
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'" class="border-0 bg-orange"><a class="text-white" href="search-category?id=${-1}">All</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${1}">Chicken</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${2}">Sandwich</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${3}">Burger</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${4}">Beverage</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${5}">Spaghetti</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${6}">Salad</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${7}">Taco</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${8}">Fresh Fries</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${9}">Dessert</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="search-category?id=${10}">Slide Dish</a></li>
                                            <li onMouseOver="this.style.backgroundColor = '#000'" onMouseOut="this.style.backgroundColor = '#f28123'"  class="border-0 bg-orange"><a class="text-white" href="view-all-combo">Combo</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="row product-lists">
                                <c:if test="${ms != null}">
                                    <p class="w-100 text-center text-secondary">${ms}</p>
                                </c:if>
                                <c:if test="${ms == null}">
                                    <c:if test="${isCombo == null}">
                                        <c:forEach items="${list}" var="c">
                                            <c:if test="${(c.isSurprise == true && c.status == true) || (c.isSurprise == false)}">
                                                <div class="col-lg-4 col-md-6 text-center strawberry">
                                                    <div class="single-product-item ${c.isSurprise ? "bg-yellow" : ''}" >
                                                        <div class="product-image">
                                                            <a href="single-product?id=${c.productID}"><img src="${c.image}" style='width:100%;height:250px'></a>
                                                        </div>
                                                        <h3 style="${c.isSurprise ? "color: grey" : ''}">${c.name}</h3>
                                                        <p style="${c.isSurprise ? "color: grey" : ''}" class="product-price"> ${c.price}$ </p>
                                                        <p class="${c.isSurprise ? "text-white" : 'text-secondary'}">${c.calories} Calories</p>
                                                        <c:if test="${c.status == false}">
                                                            <a href="sorry.jsp" class="btn btn-danger px-5 py-3">Sold out</a>
                                                        </c:if>
                                                        <c:if test="${c.status == true}">
                                                            <a href="add-to-cart?productID=${c.productID}" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
                                                        </c:if>

                                                        <c:if test="${sessionScope.acc.role != null}">
                                                            <c:if test="${c.isSurprise == false}">
                                                                <a href="add-to-wishlist?productID=${c.productID}"><button class="btn btn-danger px-5 py-3"><i class="fas fa-heart" onclick="changeColor(this)"></i></button></a>
                                                                    </c:if>
                                                                </c:if>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${isCombo != null}">
                                        <c:forEach items="${listCombo}" var="c">
                                            <div class="col-lg-4 col-md-6 text-center strawberry border-danger">
                                                <div class="single-product-item">
                                                    <div class="product-image">
                                                        <a href="combo-detail?id=${c.comboID}"><img src="${c.image}" style='width:100%;height:250px'></a>
                                                    </div>
                                                    <h3>${c.comboName}</h3>
                                                    <p class="product-price"> ${c.totalPrice}$ </p>
                                                    <p class="text-secondary">${c.totalCalories} Calories</p>
                                                    <a href="add-to-cart?comboID=${c.comboID}" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
                                                    <c:if test="${sessionScope.acc.role != null}">
                                                        <a href="add-to-wishlist?comboID=${c.comboID}"><button class="btn btn-danger px-5 py-3"><i class="fas fa-heart" onclick="changeColor(this)"></i></button></a>
                                                            </c:if>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                </c:if>

                            </div>

                            <c:if test="${price == null && s_name == null && calo == null && category == null}">
                                <div class="row">
                                    <div class="col-lg-12 text-center">
                                        <div class="pagination-wrap">
                                            <ul>
                                                <c:forEach begin="1" end="${pageNumber}" var="i">
                                                    <li><a href="shopping?index=${i}">${i}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${price != null && s_name == null && calo == null && category == null}">
                                <div class="row">
                                    <div class="col-lg-12 text-center">
                                        <div class="pagination-wrap">
                                            <ul>
                                                <c:forEach begin="1" end="${pageNumber}" var="i">
                                                    <li><a href="search-price?from=${from}&to=${to}&index=${i}">${i}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${price == null && s_name != null && calo == null && category == null}">
                                <div class="row">
                                    <div class="col-lg-12 text-center">
                                        <div class="pagination-wrap">
                                            <ul>
                                                <c:forEach begin="1" end="${pageNumber}" var="i">
                                                    <li><a href="search-name?name=${name}&index=${i}">${i}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${price == null && s_name == null && calo != null && category == null}">
                                <div class="row">
                                    <div class="col-lg-12 text-center">
                                        <div class="pagination-wrap">
                                            <ul>
                                                <c:forEach begin="1" end="${pageNumber}" var="i">
                                                    <li><a href="search-by-calories?from=${from}&to=${to}&index=${i}">${i}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${price == null && s_name == null && calo == null && category != null}">
                                <div class="row">
                                    <div class="col-lg-12 text-center">
                                        <div class="pagination-wrap">
                                            <ul>
                                                <c:forEach begin="1" end="${pageNumber}" var="i">
                                                    <li><a href="search-category?id=${id}&index=${i}">${i}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

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
