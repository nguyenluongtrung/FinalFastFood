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
        <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="style-sign-up/css/style.css">
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
            .form-control::placeholder{
                color: black !important;
            }
            .form-control::input{
                color: black !important;
            }
            .form-group {
  position: relative;
}
.form-group::after {
  
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  pointer-events: none;
}
.form-group{
    color: black !important;
}

.form-group select {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
}

.form-group select:focus {
  outline: none;
  border-color: blue;
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
                    <a href="dashboard" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                            class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="list-orders-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-gift me-2"></i>Orders</a>
                    <a href="feedback-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comment-dots me-2"></i>Feedback</a>
                            <a href="manager" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fa-solid fa-burger-soda"></i>Product</a>
                    <a href="home-control" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                            class="fas fa-power-off me-2"></i>Home page</a>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div class="container">
            <div class="table-wrapper">
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Dashboard</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>

                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <form action="editproduct" class="signin-form" method="GET">
                                <div class="form-group">
                                    <div style="color:black">Product ID</div>
                                    <input style="border:solid black;color: black !important" type="text" class="form-control" required name="id" value="${pro.productID}" readonly>
                                </div>
                                <div class="form-group">
                                    <div style="color:black">Product Name</div>
                                    <input style="border:solid black;color: black !important" type="text" class="form-control" required name="name" value="${pro.name}">
                                </div>
                                <div class="form-group">
                                    <div style="color:black">Product Image</div>
                                    <input style="border:solid black;color: black !important" type="text" class="form-control" required name="image" value="${pro.image}">
                                </div><!-- comment -->
                                <div class="form-group">
                                    <div style="color:black">Category ID</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="category" value="${pro.categoryID}">
                                </div><!-- comment -->
                                <div class="form-group">
                                    <div style="color:black"> uantity</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="quantity" value="${pro.quantity}">
                                </div>
                                <div class="form-group">
                                    <div style="color:black">Calories</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="calories" value="${pro.calories}">
                                </div>

                                <div class="form-group">
                                    <div style="color:black">Is Surprise</div>
                                        <select style="border:solid black;color: black !important" class="form-control" name="issurprise">
                                            <option value="" disabled selected hidden style="color:black;">Is surprise</option>
                                        <option value="1">Yes</option>
                                        <option value="0">No</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                 <div  class="form-group"><div>Rating</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="rating" value="${pro.rating}" readonly>
                                </div>
                                <div class="form-group">
                                    <div class="form-group"><div>Accumulated Point</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="accum" value="${pro.accumulatedPoint}">
                                </div>
                                <div class="form-group">
                                    <div class="form-group"><div>Exchanged Point</div>
                                    <input style="border:solid black;color: black !important" type="number" class="form-control" required name="exchanged" value="${pro.exchangedPoint}">
                                </div>
                               
                                <div class="form-group">
                                    <button type="submit" value="editproduct" class="form-control btn btn-primary submit px-3">Update product</button>
                                </div>
                                
                            </form>
                           
                        </div>
                    </div>
                </div>
            </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
    </script>
</body>
</html>
