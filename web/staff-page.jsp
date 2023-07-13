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

            input[type="radio"] {
                display: none;
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
                        class="fas fa-user-secret me-2"></i>STAFF PAGE</div>
                <div class="list-group list-group-flush my-3">
                    <a href="manage-combo" class="list-group-item list-group-item-action bg-transparent fw-bold"><i
                            class="fas fa-box me-2"></i>Combo</a>
                </div>
                <div class="list-group list-group-flush my-3">
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
                        <h2 class="fs-2 m-0">Product's Status Management</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>
                <form action="staff-page" method="post">
                    <div class="container-fluid px-4">
                        <div class="row my-5">
                            <div class="row mb-3">
                                <h3 class="fs-4 mb-3 d-inline col-sm-8">List of products </h3>
                                <div class="col-sm-4 float-right" style="padding-left: 60px;">
                                    <input class="btn btn-dark px-3 py-1" style="width: 100px; color: white" type="button" id="btn1" value="All"/>
                                    <input class="btn btn-dark px-3 py-1" style="width: 100px; color: white" type="button" id="btn2" value="None"/>
                                    <button type="submit" class="btn btn-success px-3 py-1"><a class="view-modal text-decoration-none text-white" href="#"><span><i class="fa-sharp fa-solid fa-plus"></i></span>&nbsp; Submit</a></button>
                                </div>

                            </div>


                            <div class="col">
                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%">Name</th>
                                            <th scope="col" style="font-size: 90%">Image</th>
                                            <th scope="col" style="font-size: 90%">Category ID</th>
                                            <th scope="col" style="font-size: 90%">Calories</th>
                                            <th scope="col" style="font-size: 90%">Is Surprise</th>
                                            <th scope="col" style="font-size: 90%">Rating</th>
                                            <th scope="col" style="font-size: 90%">Accumulated Point</th>
                                            <th scope="col" style="font-size: 90%">Exchanged Point</th>
                                            <th scope="col" style="font-size: 90%">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="c">
                                            <tr>
                                                <td>${c.name}</td>
                                                <td><image src="${c.image}" style="width: 40px; height: 40px;"></td>
                                                <td>${c.categoryID}</td>
                                                <td>${c.calories}</td>
                                                <td>${c.isSurprise}</td>
                                                <td>${c.rating}</td>
                                                <td>${c.accumulatedPoint}</td>
                                                <td>${c.exchangedPoint}</td>
                                                <td><input type="checkbox" name="status" value="${c.productID}" ${c.status == true ? 'checked' : ''}></td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>

                </form>
            </div>
            
            
            
            
     
        </div>
        <!-- /#page-content-wrapper -->


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
        <!-- Custom JS -->
        <script src="js/scripts.js"></script>
        <script>
            document.getElementById("btn1").onclick = function ()
            {
                // Lấy danh sách checkbox
                var checkboxes = document.getElementsByName('status');

                // Lặp và thiết lập checked
                for (var i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].checked = true;
                }
            };

            document.getElementById("btn2").onclick = function ()
            {
                // Lấy danh sách checkbox
                var checkboxes = document.getElementsByName('status');

                // Lặp và thiết lập Uncheck
                for (var i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].checked = false;
                }
            };
        </script>
    </body>
</html>
