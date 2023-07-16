<%-- 
    Document   : index
    Created on : 20 May, 2023, 8:40:50 AM
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
        <title>Fruitkha - Slider Version</title>

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
            .single-testimonial-slider1{
                color: white;
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
            <!-- end search area -->

            <!-- home page slider -->
            <div class="homepage-slider">
                <!-- single home slider -->
                <div class="single-homepage-slider homepage-bg-1">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-lg-7 offset-lg-1 offset-xl-0">
                                <div class="hero-text">
                                    <div class="hero-text-tablecell">
                                        <p class="subtitle">Fresh & Organic</p>
                                        <h1>Delicious Seasonal Fruits</h1>
                                        <div class="hero-btns">
                                            <a href="shop.html" class="boxed-btn">Fruit Collection</a>
                                            <a href="contact.html" class="bordered-btn">Contact Us</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- single home slider -->
                <div class="single-homepage-slider homepage-bg-2">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 offset-lg-1 text-center">
                                <div class="hero-text">
                                    <div class="hero-text-tablecell">
                                        <p class="subtitle">Fresh Everyday</p>
                                        <h1>100% Organic Collection</h1>
                                        <div class="hero-btns">
                                            <a href="shop.html" class="boxed-btn">Visit Shop</a>
                                            <a href="contact.html" class="bordered-btn">Contact Us</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- single home slider -->
                <div class="single-homepage-slider homepage-bg-3">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 offset-lg-1 text-right">
                                <div class="hero-text">
                                    <div class="hero-text-tablecell">
                                        <p class="subtitle">Mega Sale Going On!</p>
                                        <h1>Get December Discount</h1>
                                        <div class="hero-btns">
                                            <a href="shop.html" class="boxed-btn">Visit Shop</a>
                                            <a href="contact.html" class="bordered-btn">Contact Us</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end home page slider -->

            <!-- features list section -->
            <div class="list-section pt-80 pb-80">
                <div class="container">

                    <div class="row">
                        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                            <div class="list-box d-flex align-items-center">
                                <div class="list-icon">
                                    <i class="fas fa-shipping-fast"></i>
                                </div>
                                <div class="content">
                                    <h3>Free Shipping</h3>
                                    <p>When order over $75</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                            <div class="list-box d-flex align-items-center">
                                <div class="list-icon">
                                    <i class="fas fa-phone-volume"></i>
                                </div>
                                <div class="content">
                                    <h3>24/7 Support</h3>
                                    <p>Get support all day</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="list-box d-flex justify-content-start align-items-center">
                                <div class="list-icon">
                                    <i class="fas fa-sync"></i>
                                </div>
                                <div class="content">
                                    <h3>Refund</h3>
                                    <p>Get refund within 3 days!</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- end features list section -->
            <!-- shop banner -->
        <c:if test="${ok != null}">
            <section class="shop-banner">
                <div class="container">
                    <h3><span class="text-warning">${sale.saleName}</span> sale is on! <br> with big <span class="orange-text">Discount...</span></h3>
                    <div class="sale-percent"><span>Sale! <br> Upto</span>${saleValue}%<span>off</span></div>
                    <div class="mb-3"><span>Sale code: <span class="text-danger font-weight-bold">${sale.saleCode}</span></span></div>
                    <div class="mb-3"><p class="text-secondary" style="font-style: italic; font-size: 80%">(*) This sale event only applies for: ${wItems}</p></div>
                    <!--Countdown Timer-->
                    <div class="time-counter"><div class="time-countdown clearfix" data-countdown="${sale.endDate}"><div class="counter-column"><div class="inner"><span class="count">00</span>Days</div></div> <div class="counter-column"><div class="inner"><span class="count">00</span>Hours</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Mins</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Secs</div></div></div></div>

                    <a href="shopping" class="cart-btn btn-lg">Shop Now</a>
                </div>
            </section>
        </c:if>

        <c:if test="${okelala != null}">
            <div class="testimonail-section mt-150">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12 p-0">
                            <div class="testimonial-sliders">
                                <div class="single-testimonial-slider">
                                    <section class="shop-banner">
                                        <div class="container">
                                            <h3><span class="text-warning">${sale.saleName}</span> sale is on! <br> with big <span class="orange-text">Discount...</span></h3>
                                            <div class="sale-percent"><span>Sale! <br> Upto</span>${saleValue}%<span>off</span></div>
                                            <div class="mb-3"><span>Sale code: <span class="text-danger font-weight-bold">${sale.saleCode}</span></span></div>
                                            <div class="mb-3"><p class="text-secondary" style="font-style: italic; font-size: 80%">(*) This sale event only applies for: ${wItems}</p></div>
                                            <!--Countdown Timer-->
                                            <div class="time-counter"><div class="time-countdown clearfix" data-countdown="${sale.endDate}"><div class="counter-column"><div class="inner"><span class="count">00</span>Days</div></div> <div class="counter-column"><div class="inner"><span class="count">00</span>Hours</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Mins</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Secs</div></div></div></div>
                                            <a href="shopping" class="cart-btn btn-lg">Shop Now</a>
                                        </div>
                                    </section>
                                </div>
                                <div class="single-testimonial-slider1">
                                    <section class="w-100" style="background-image: url('https://pbsapos.com.au/wp-content/uploads/2019/12/fastfood.jpg'); 
                                             position: relative;
                                             background-color: #f5f5f5;
                                             background-size: cover;
                                             padding: 110px 0px 115px;
                                             height: 95vh">
                                        <div class="container-fluid ml-5 pl-5">
                                            <h1 class="text-white" style="font-size: 320%; margin-bottom: 30px">Surprise meal is on!</h1>
                                            <div class="mb-5"><span class="text-white">To satisfy your taste buds and cravings for the homely cooked food, prepared by the <br>women expert in their own areas, by offering an opportunity to the household women in Bangalore & Aligarh.
                                                </span></div><br>
                                            <!--Countdown Timer-->
                                            <div class="time-counter mb-5"><div class="time-countdown clearfix" data-countdown="${surpriseProduct.p_endDate}"><div class="counter-column"><div class="inner"><span class="count">00</span><p style="color: white">Days</p></div></div> <div class="counter-column"><div class="inner"><span class="count">00</span>Hours</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Mins</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Secs</div></div></div></div>

                                            <a href="single-product?id=${surpriseProduct.productID}" class="cart-btn btn-lg">Shop Now</a>
                                        </div>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${okela != null}">
            <section class="surprise-banner" style="background-image: url('https://pbsapos.com.au/wp-content/uploads/2019/12/fastfood.jpg'); 
                     position: relative;
                     background-color: #f5f5f5;
                     background-size: cover;
                     padding: 110px 0px 115px;
                     height: 95vh">
                <div class="container-fluid ml-5 pl-5">
                    <h1 class="text-white" style="font-size: 320%; margin-bottom: 30px">Surprise meal is on!</h1>
                    <div class="mb-5"><span class="text-white">To satisfy your taste buds and cravings for the homely cooked food, prepared by the <br>women expert in their own areas, by offering an opportunity to the household women in Bangalore & Aligarh.
                        </span></div><br>
                    <!--Countdown Timer-->
                    <div class="time-counter mb-5"><div class="time-countdown clearfix" data-countdown="${surpriseProduct.p_endDate}"><div class="counter-column"><div class="inner"><span class="count">00</span><p>Days</p></div></div> <div class="counter-column"><div class="inner"><span class="count">00</span>Hours</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Mins</div></div>  <div class="counter-column"><div class="inner"><span class="count">00</span>Secs</div></div></div></div>

                    <a href="single-product?id=${surpriseProduct.productID}" class="cart-btn btn-lg">Shop Now</a>
                </div>
            </section>
        </c:if>




        <br>

        <!-- end shop banner -->

        <!-- product section -->
        <div class="product-section mt-150 mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2 text-center">
                        <div class="section-title">	
                            <h3><span class="orange-text">Our</span> Products</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, fuga quas itaque eveniet beatae optio.</p>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <c:forEach items="${someProducts}" var="c">
                        <div class="col-lg-4 col-md-6 text-center">
                            <div class="single-product-item">
                                <div class="product-image">
                                    <a href="single-product?id=${c.productID}"><img src="${c.image}" style='width:100%;height:250px' alt=""></a>
                                </div>
                                <h3>${c.name}</h3>
                                <p class="product-price"> ${c.price}$ </p>
                                <c:if test="${c.status == false}">
                                    <a href="sorry.jsp" class="btn btn-danger px-5 py-3">Sold out</a>
                                </c:if>
                                <c:if test="${c.status == true}">
                                    <a href="add-to-cart?productID=${c.productID}" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
                                </c:if>
                                <c:if test="${sessionScope.acc.role != null}">
                                    <a href="add-to-wishlist?productID=${c.productID}"><button class="btn btn-danger px-5 py-3"><i class="fas fa-heart"></i></button></a>
                                        </c:if>                       
                            </div>
                        </div>
                    </c:forEach> 

                </div>
            </div>
        </div>
        <!-- end product section -->

        <!-- testimonail-section -->
        <div class="testimonail-section mt-150 mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1 text-center">
                        <div class="testimonial-sliders">
                            <div class="single-testimonial-slider">
                                <div class="client-avater">
                                    <img src="assets/img/avaters/avatar1.png" alt="">
                                </div>
                                <div class="client-meta">
                                    <h3>Saira Hakim <span>Local shop owner</span></h3>
                                    <p class="testimonial-body">
                                        " Sed ut perspiciatis unde omnis iste natus error veritatis et  quasi architecto beatae vitae dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
                                    </p>
                                    <div class="last-icon">
                                        <i class="fas fa-quote-right"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="single-testimonial-slider">
                                <div class="client-avater">
                                    <img src="assets/img/avaters/avatar2.png" alt="">
                                </div>
                                <div class="client-meta">
                                    <h3>David Niph <span>Local shop owner</span></h3>
                                    <p class="testimonial-body">
                                        " Sed ut perspiciatis unde omnis iste natus error veritatis et  quasi architecto beatae vitae dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
                                    </p>
                                    <div class="last-icon">
                                        <i class="fas fa-quote-right"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="single-testimonial-slider">
                                <div class="client-avater">
                                    <img src="assets/img/avaters/avatar3.png" alt="">
                                </div>
                                <div class="client-meta">
                                    <h3>Jacob Sikim <span>Local shop owner</span></h3>
                                    <p class="testimonial-body">
                                        " Sed ut perspiciatis unde omnis iste natus error veritatis et  quasi architecto beatae vitae dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
                                    </p>
                                    <div class="last-icon">
                                        <i class="fas fa-quote-right"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end testimonail-section -->

        <!-- advertisement section -->
        <div class="abt-section mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="abt-bg">
                            <a href="https://www.youtube.com/watch?v=dA0VGEbbw4g" class="video-play-btn popup-youtube"><i class="fas fa-play"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12">
                        <div class="abt-text">
                            <p class="top-sub">Since Year 1999</p>
                            <h2>We are <span class="orange-text">Fruitkha</span></h2>
                            <p>Etiam vulputate ut augue vel sodales. In sollicitudin neque et massa porttitor vestibulum ac vel nisi. Vestibulum placerat eget dolor sit amet posuere. In ut dolor aliquet, aliquet sapien sed, interdum velit. Nam eu molestie lorem.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente facilis illo repellat veritatis minus, et labore minima mollitia qui ducimus.</p>
                            <a href="about.html" class="boxed-btn mt-4">know more</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end advertisement section -->



        <jsp:include page="footer.jsp"></jsp:include>
        <style>

        </style>






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
