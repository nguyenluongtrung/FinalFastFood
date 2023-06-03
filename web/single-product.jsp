<%-- 
    Document   : single-product
    Created on : 20 May, 2023, 8:43:24 AM
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
        <title>Single Product</title>

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
            .rating{
    width: 400px;
    background: white;
    padding 20px 30px;
    border: 1px solid #444;
    border-radius: 5px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.rating .star input{
    display: none;
}

.star label{
    font-size: 40px;
    color: #444;
    padding: 10px;
    float:right;
    transition: all 0.2s ease;
}

input:not(:checked) ~ label:hover,
input:not(:checked) ~ label:hover ~ label{
    color: #fd4;
}

input:checked ~ label{
    color: #fd4;
}
.rating{

    padding: 20px 30px;
    border-radius: 5px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    border:0;
}

.rating .star input{
    display: none;
}

.star label{
    font-size: 20px;
    color: #444;
    padding: 10px;
    float:right;
    transition: all 0.2s ease;
}

input:not(:checked) ~ label:hover,
input:not(:checked) ~ label:hover ~ label{
    color: #fd4;
}

input:checked ~ label{
    color: #fd4;
}

.feedback{
    background-color: #f5f5f5;
    border-radius: 5px;
    padding: 20px;
}

.feedback-content{

    margin-top: 20px;
}

.feedback-content .date{
    float: right;
    margin-right: 30px;
    margin-top: 5px;
}

.date p{
    color: #2F4F4F;
}

.feedback-content img{
    margin-bottom: 30px;
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
                                <p>See more Details</p>
                                <h1>Single Product</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

            <!-- single product -->
            <div class="single-product mt-150 mb-150">
                <div class="container">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="single-product-img">
                                <img src="${product.image}" alt="">
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="single-product-content">
                            <h3>${product.name}</h3>
                            <p class="single-product-pricing">${product.price}$</p>
                            <div class="single-product-form">
                                <p>Calories: ${product.calories}</p>
                                <p>Categories: ${category.categoryName}</p>
                                <p><strong>Rating: ${product.rating}/5.0</strong></p>
                                <form action="add-to-cart">
                                    <input type="number" placeholder="0" name="quantity" min="1"><br>
                                    <input type="hidden" name="productID" value="${product.productID}">
                                    <button class="btn btn-success px-5 py-3" type="submit"><i class="fas fa-shopping-cart"></i> Add to Cart</button>
                                </form><br>
                                <c:if test="${sessionScope.acc.role != null}">
                                    <a href="add-to-wishlist?productID=${product.productID}"><button class="btn btn-danger px-5 py-3"><i class="fas fa-heart"></i></button></a>
                                        </c:if>
                            </div>
                            <h4>Share:</h4>
                            <ul class="product-share">
                                <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href=""><i class="fab fa-twitter"></i></a></li>
                                <li><a href=""><i class="fab fa-google-plus-g"></i></a></li>
                                <li><a href=""><i class="fab fa-linkedin"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row row-content">
                <div class="col-12">
                    <h3 class="text-black mt-5 text-center">Your Feedback</h3>
                </div>
                <div class="col-9 offset-2">
                    <form action="feedback" method="post">
                        <input name="pid" value="${product.productID}" style="display:none;">
                        <input name="orate" value="${product.rating}" style="display:none;">

                        <div class="rating">
                            <div class="star">
                                <input type="radio" name="rate" id="rate-1" value="5">
                                <label for="rate-1"  class="fas fa-star"></label>
                                <input type="radio" name="rate" id="rate-2" value="4">
                                <label for="rate-2"  class="fas fa-star"></label>
                                <input type="radio" name="rate" id="rate-3" value="3">
                                <label for="rate-3"  class="fas fa-star"></label>
                                <input type="radio" name="rate" id="rate-4" value="2">
                                <label for="rate-4"  class="fas fa-star"></label>
                                <input type="radio" name="rate" id="rate-5" value="1">
                                <label for="rate-5"  class="fas fa-star"></label>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <textarea class="form-control" name="feedback" placeholder="Please write your feedback" rows="4"></textarea>
                            </div>
                        </div>
                        <div class="form-group row offset-10">
                            <div class="col-12">
                                <button type="submit"  class="btn btn-warning">Send Feedback</button>
                            </div>
                        </div>

                    </form>
                    <div class="feedback">
                        <form>
                            <c:forEach items="${feed}" var="c">
                                <div class="feedback-content">
                                    <div class="date"><p>${c.date}</p></div>
                                    <div class="row">
                                        <div >
                                            <img src="image/avata.png" alt="avatar" class="ml-3" style="width: 35px; height: 35px;"/>  
                                        </div>
                                        <div class="ml-3"><h4>${c.name}</h4></div>
                                    </div>
                                    <div class="ml-5"><p style="font-size: 16px">${c.msg}</p></div>                         

                                </div><hr>
                            </c:forEach>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- end single product -->

        <!-- more products -->
        <div class="more-products mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2 text-center">
                        <div class="section-title">	
                            <h3><span class="orange-text">Related</span> Products</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, fuga quas itaque eveniet beatae optio.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${relatedProducts}" var="c">
                        <div class="col-lg-4 col-md-6 text-center">
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
            </div>
        </div>
        <!-- end more products -->

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
