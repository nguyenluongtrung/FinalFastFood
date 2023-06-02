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
                            <li class="current-list-item"><a href="home-control">Home</a>
                            </li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="shopping">Menu</a></li>
                                <c:if test="${sessionScope.acc.role == 'AD'}">
                                <li><a class="" href="admin-page">Admin Page</a></li>
                                </c:if>

                            <li>

                                <div class="header-icons">
                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                    <a class="shopping-cart" href="add-to-cart"><i class="fas fa-shopping-cart"></i></a>
                                        <c:if test="${sessionScope.acc.role == null}">
                                        <a class="" href="login.jsp">Login</a>
                                        <a class="" href="signup.jsp">Sign up</a>
                                    </c:if>

                                    <c:if test="${sessionScope.acc.role != null}">

                                        <a class="wishlist" href="get-list-wishlist"><i class="fas fa-heart"></i></a>
                                        <a href="UpdateAccountServlet">My Account</a>
                                        <a href="logout">Log out</a>
                                    </c:if>

                                </div>
                            </li>


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
