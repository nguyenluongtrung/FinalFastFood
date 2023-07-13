<%-- 
    Document   : header
    Created on : 20 May, 2023, 8:29:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- header -->
<div class="top-header-area" id="sticker">
    <div class="container-fluid"  style="background-color: rgba(0,0,0,0.5); padding: 0 100px; margin-top: -25px;" class="justify-content-center align-items-center">
        <div class="row">
            <div class="col-lg-12 col-sm-12 text-center"">
                <div class="main-menu-wrap">
                    <!-- logo -->
                    <div class="site-logo">
                        <a href="index.jsp">
                            <img src="image/abc.png" style="padding: 0; transform: scale(0.9); margin-top: -20px; margin-left: -80px; padding-top: 30px">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu" style="padding-top: 30px;">
                        <ul>
                            <li class="current-list-item"><a href="home-control">Home</a>
                            </li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="shopping">Menu</a></li>
                                <c:if test="${sessionScope.acc.role == 'AD'}">
                                <li><a class="" href="admin-page">Admin Page</a></li>
                                </c:if>
                                <c:if test="${sessionScope.acc.role == 'ST'}">
                                <li><a class="" href="staff-page">Staff Page</a></li>
                                </c:if>

                            <li>

                                <div class="header-icons">
                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                    <c:if test="${sessionScope.count != null && sessionScope.count != 0}">
                                        <a class="shopping-cart" href="add-to-cart"><i class="fas fa-shopping-cart"></i>
                                            <span class='badge badge-warning rounded-circle' id='lblCartCount'> ${sessionScope.count} </span>
                                        </a>
                                    </c:if>
                                    <c:if test="${sessionScope.count == null || sessionScope.count == 0}">
                                        <a class="shopping-cart" href="add-to-cart"><i class="fas fa-shopping-cart"></i></a>
                                    </c:if>

                                    <c:if test="${sessionScope.acc.role == null}">
                                        <a class="" href="LoginServlet">Login</a>
                                        <a class="" href="signup">Sign up</a>
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
