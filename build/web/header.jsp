<%-- 
    Document   : header
    Created on : 20 May, 2023, 8:29:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- header -->
<div class="top-header-area" id="sticker">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 text-center">
                <div class="main-menu-wrap">
                    <!-- logo -->
                    <div class="site-logo">
                        <a href="index.html">
                            <img src="assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>
                            <li class="current-list-item"><a href="index.jsp">Home</a>
                            </li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="shopping">Shop</a>
                                <ul class="sub-menu">
                                    <li><a href="shopping">Shop</a></li>
                                    <li><a href="checkout.jsp">Check Out</a></li>
                                    <li><a href="single-product.jsp">Single Product</a></li>
                                    <li><a href="cart.jsp">Cart</a></li>
                                </ul>
                            </li>
                            <li>
                                <!--									<div class="header-icons">
                                                                                                                <a class="shopping-cart" href="cart.html"><i class="fas fa-shopping-cart"></i></a>
                                                                                                                <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                                                                                        </div>-->
                                <div class="header-icons">
                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                        <c:if test="${sessionScope.acc ==null}">
                                        <!--                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>-->
                                        <a class="" href="login.jsp">Login</a>
                                    </c:if>
                                </div>

                            </li>
                            <c:if test="${sessionScope.acc != null}"> 
                                <li><a href="#">${sessionScope.acc.name}  <i class="fas fa-user"></i></a>

                                    <ul class="sub-menu">
                                        <c:if test="${sessionScope.acc.role == 'AD'}">
                                            <li><a href="#">Feature 1</a></li>
                                            <li><a href="#">Feature 2</a></li>
                                            <li><a href="#">Feature 3</a></li>
                                            </c:if>
                                            <c:if test="${sessionScope.acc.role == 'US'}">
                                            <li><a href="#">Feature 1</a></li>
                                            <li><a href="#">Feature 2</a></li>
                                            <li><a href="#">Feature 3</a></li>
                                            </c:if>
                                            <c:if test="${sessionScope.acc.role == 'ST'}">
                                            <li><a href="#">Feature 1</a></li>
                                            <li><a href="#">Feature 2</a></li>
                                            <li><a href="#">Feature 3</a></li>
                                            </c:if>
                                    </ul> 




                                <li><a href="./logout">Logout</a></li>
                                </c:if>


                        </ul>
                    </nav>
                    <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                    <div class="mobile-menu"></div>
                    <!-- menu end -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end header -->
