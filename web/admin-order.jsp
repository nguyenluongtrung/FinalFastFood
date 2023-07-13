<%-- 
    Document   : dashboard-admin
    Created on : 6 Mar, 2023, 9:36:54 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <style>
            :root {
                --main-bg-color: #009d63;
                --main-text-color: #009d63;
                --second-text-color: #bbbec5;
                --second-bg-color: #c1efde;
            }

            .primary-text {
                color: var(--main-text-color);
            }

            .second-text {
                color: var(--second-text-color);
            }

            .primary-bg {
                background-color: var(--main-bg-color);
            }

            .secondary-bg {
                background-color : var(--second-bg-color);
            }

            .rounded-full {
                border-radius: 100%;
            }

            #wrapper {
                overflow-x: hidden;
                background-image: linear-gradient(
                    to right,
                    #baf3d7,
                    #c2f5de,
                    #cbf7e4,
                    #d4f8ea,
                    #ddfaef
                    );
            }

            #sidebar-wrapper {
                min-height: 100vh;
                margin-left: -15rem;
                -webkit-transition: margin 0.25s ease-out;
                -moz-transition: margin 0.25s ease-out;
                -o-transition: margin 0.25s ease-out;
                transition: margin 0.25s ease-out;
            }

            #sidebar-wrapper .sidebar-heading {
                padding: 0.875rem 1.25rem;
                font-size: 1.2rem;
            }

            #sidebar-wrapper .list-group {
                width: 15rem;
            }

            #page-content-wrapper {
                min-width: 100vw;
            }

            #wrapper.toggled #sidebar-wrapper {
                margin-left: 0;
            }

            #menu-toggle {
                cursor: pointer;
            }

            .list-group-item {
                border: none;
                padding: 20px 30px;
            }

            .list-group-item.active {
                background-color: transparent;
                color: var(--main-text-color);
                font-weight: bold;
                border: none;
            }

            .popup .overlay{
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                background: rgba(0,0,0,0.7);
                z-index: 1;
                display: none;
            }

            .popup .content{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%) scale(0);
                background: #fff;
                width: 500px;
                height: 500px;
                z-index: 2;
                padding: 20px;
                box-sizing: border-box;
                text-align: center;
            }

            .popup .content2{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%) scale(0);
                background: #fff;
                width: 630px;
                height: 600px;
                z-index: 2;
                padding: 20px;
                box-sizing: border-box;
            }

            .popup .close-btn{
                position: absolute;
                right: 20px;
                top: 20px;
                width: 30px;
                height: 30px;
                background: #222;
                color: #fff;
                font-size: 25px;
                font-weight: 600;
                line-height: 30px;
                text-align: center;
                border-radius: 50%;
                cursor: pointer;
            }

            .popup.active .overlay{
                display: block;
            }

            .popup.active .content{
                transform: translate(-50%,-50%) scale(1);
                transition: all 300ms ease-in-out;
            }
            .popup.active .content2{
                transform: translate(-50%,-50%) scale(1);
                transition: all 300ms ease-in-out;
            }


            input[type="radio"] + label:before {
                content: "";
                display: inline-block;
                width: 25px;
                height: 25px;
                padding: 6px;
                margin-right: 3px;
                background-clip: content-box;
                border: 2px solid #bbb;
                background-color: #e7e6e7;
                border-radius: 50%;
            }

            input[type="radio"]:checked + label:before {
                background-color: #93e026;
            }

            label {
                display: flex;
                align-items: center;
            }

            .sub-but{
                width:100%;
            }

            .form .input-box {
                width: 100%;
                margin-top: 20px;
            }
            .input-box label {
                color: #333;
            }
            .form :where(.input-box input, .select-box) {
                position: relative;
                height: 50px;
                width: 100%;
                outline: none;
                font-size: 1rem;
                color: #707070;
                margin-top: 8px;
                border: 1px solid #ddd;
                border-radius: 6px;
                padding: 0 15px;
            }
            .input-box input:focus {
                box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
            }
            .form .column {
                display: flex;
                column-gap: 15px;
            }
            .form :where(.gender input, .gender label) {
                cursor: pointer;
            }


            .form button {
                height: 55px;
                width: 100%;
                color: #fff;
                font-size: 1rem;
                font-weight: 400;
                margin-top: 30px;
                border: none;
                cursor: pointer;
                transition: all 0.2s ease;
                background: rgb(130, 106, 251);
            }
            .form button:hover {
                background: rgb(88, 56, 250);
            }

            @media (min-width: 768px) {
                #sidebar-wrapper {
                    margin-left: 0;
                }

                #page-content-wrapper {
                    min-width: 0;
                    width: 100%;
                }

                #wrapper.toggled #sidebar-wrapper {
                    margin-left: -15rem;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar -->
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                        class="fas fa-user-secret me-2"></i>MANAGER PAGE</div>
                <div class="list-group list-group-flush my-3">
                    <a href="admin-page" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="product-admin" class="list-group-item list-group-item-action bg-transparent second-text  fw-bold"><i
                            class="fas fa-tachometer-alt me-2"></i>Products</a>        
                    <a href="orders-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                            class="fas fa-gift me-2"></i>Orders</a>
                    <a href="feedback-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comment-dots me-2"></i>Feedbacks</a>
                    <a href="sale-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comment-dots me-2"></i>Sales</a>
                    <a href="home-control" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                            class="fas fa-power-off me-2"></i>Home page</a>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Order Management</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>

                <div class="container-fluid px-4">
                    <div class="row my-5">
                        <div class="row mb-3">
                            <h3 class="fs-4 mb-3 d-inline col-sm-3">List of orders </h3>
                            <div class="col-sm-7">
                                <form action="search-by-time">
                                    <input class="py-1 w-25" type="number" min="2000" step="1" name="year" placeholder="Enter year..."/>
                                    <input class="py-1 w-25" type="number" min="1" max="12" step="1" name="month" placeholder="Enter month..."/>
                                    <input class="py-1 w-25" type="number" min="1" max="31" step="1" name="date" placeholder="Enter date..."/>
                                    <button type="submit" class="btn btn-success">Search</button>
                                </form>

                            </div>
                            <div class="dropdown col-sm-2">
                                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                                    Sort order by price
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="sort-orders-admin?ok=1">INCREASINGLY</a>
                                    <a class="dropdown-item" href="sort-orders-admin?ok=0">DECREASINGLY</a>
                                </div>
                            </div>

                        </div>

                        <form action="statusproduct" method="POST">
                            <div class="col">
                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%">Order ID</th>
                                            <th scope="col" style="font-size: 90%">Date</th>
                                            <th scope="col" style="font-size: 90%">Total Price</th>
                                            <th scope="col" style="font-size: 90%">Note</th>
                                            <th scope="col" style="font-size: 90%">Status</th>
                                            <th scope="col" style="font-size: 90%">View Detail</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${listSize != 0}">
                                            <c:forEach items="${list}" var="c" varStatus="status">
                                                <tr>
                                                    <td>${c.orderID}</td>
                                                    <td>${c.date}</td>
                                                    <td>${c.totalPrice}</td>
                                                    <td>${c.note}</td>
                                                    <td>
                                                        <input type="radio" name="status_${c.orderID}" value="PEND" ${c.status == 'PEND' ? 'checked' : ''}>Pending
                                                        <input type="radio" name="status_${c.orderID}" value="SUCC" ${c.status == 'SUCC' ? 'checked' : ''}>Success
                                                        <input type="radio" name="status_${c.orderID}" value="FAIL" ${c.status == 'FAIL' ? 'checked' : ''}>Fail
                                                    </td>
                                                    <td><a href="#"><button class="btn btn-success px-4 py-1">View Details</button></a></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${listSize == 0}">
                                            <tr><p class="text-center text-danger">The list is empty!</p></tr>

                                    </c:if>

                                    </tbody>

                                </table>
                                <button style="float:right;" class="btn btn-success px-3 col-sm-2" type="submit"><a class="view-modal text-decoration-none text-white">&nbsp; Submit</a></button>
                            </div>
                        </form>
                    </div>
                    <c:if test="${search == null && sort == null}">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <div class="pagination-wrap text-center">
                                    <ul class="d-flex text-center justify-content-center" style="margin-top: -30px">
                                        <c:forEach begin="1" end="${numberPage}" var="i">
                                            <li style="list-style: none"><a style="border: 1px solid black; border-radius: 50%" class="m-3 text-dark text-decoration-none px-2 py-1" href="orders-admin?index=${i}">${i}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${search != null && sort == null}">
                        
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <div class="pagination-wrap text-center">
                                    <ul class="d-flex text-center justify-content-center" style="margin-top: -30px">
                                        <c:forEach begin="1" end="${numberPage}" var="i">
                                            <li style="list-style: none"><a style="border: 1px solid black; border-radius: 50%" class="m-3 text-dark text-decoration-none px-2 py-1" href="search-by-time?index=${i}&year=${year}&month=${month}&date=${date}">${i}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    
                    <c:if test="${sort != null && search == null}">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <div class="pagination-wrap text-center">
                                    <ul class="d-flex text-center justify-content-center" style="margin-top: -30px">
                                        <c:forEach begin="1" end="${numberPage}" var="i">
                                            <li style="list-style: none"><a style="border: 1px solid black; border-radius: 50%" class="m-3 text-dark text-decoration-none px-2 py-1" href="sort-orders-admin?index=${i}&ok=${ok}">${i}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:if>


                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom JS -->
    <script src="js/scripts.js"></script>

</body>
</html>
