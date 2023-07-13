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
                width: 880px;
                height: 450px;
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
                        <h2 class="fs-2 m-0">Combo Management</h2>
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
                            <h3 class="fs-4 mb-3 d-inline col-sm-10">List of combos </h3>
                            <button class="btn btn-success px-3 py-1 col-sm-2"><a class="view-modal text-decoration-none text-white" href="add-combo"><span><i class="fa-sharp fa-solid fa-plus"></i></span>&nbsp; Add a new combo</a></button>
                        </div>


                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Combo ID</th>
                                        <th scope="col">Combo Name</th>
                                        <th scope="col">Total Price</th>
                                        <th scope="col">Total Calories</th>
                                        <th scope="col">Rating</th>
                                        <th scope="col">Accumulated Point</th>
                                        <th scope="col">Exchanged Point</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${combos}" var="c">
                                        <tr>
                                            <td>${c.comboID}</td>
                                            <td>${c.comboName}</td>
                                            <td>${c.totalPrice}</td>
                                            <td>${c.totalCalories}</td>
                                            <td>${c.rating}</td>
                                            <td>${c.accumulatedPoint}</td>
                                            <td>${c.exchangedPoint}</td>
                                            <td>
                                                <a href="update-combo?id=${c.comboID}" class="edit"><i class="view-modal fa-sharp fa-regular fa-pen-to-square  text-dark"></i></a> &nbsp;&nbsp;&nbsp;
                                                <a href="delete-combo?id=${c.comboID}" class="delete"><i class="fa-sharp fa-solid fa-trash  text-dark"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /#page-content-wrapper -->
            <c:if test="${ok != null}">
                <div class="popup active" id="popup-2">
                    <div class="overlay"></div>
                    <div class="content2">
                        <div class="close-btn" onclick="togglePopup2()">&times;</div>
                        <p style="font-weight: bold; text-align: center">ADD NEW COMBO</p><br>
                        <div>
                            <form action="add-combo" method="post">
                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%"></th>
                                            <th scope="col" style="font-size: 90%">Category Name</th>
                                            <th scope="col" style="font-size: 90%">Product Name</th>
                                            <th scope="col" style="font-size: 90%">Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Main course</td>
                                        <td>
                                            <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                                <option value="">Select</option>
                                                    <option value="search-product-by-category?id=${1}&ok=${1}">Chicken</option>
                                                    <option value="search-product-by-category?id=${3}&ok=${1}">Burger</option>
                                                    <option value="search-product-by-category?id=${5}&ok=${1}">Spaghetti</option>
                                                    <option value="search-product-by-category?id=${7}&ok=${1}">Taco</option>
                                            </select>
                                        </td>
                                        <td>
                                            <select required style="width: 200px;" name="main">
                                                <c:if test="${mainCourse != null}">
                                                    <c:forEach items="${mainCourse}" var="c">
                                                        <option class="py-1" value="${c.productID}">${c.name}</option>
                                                    </c:forEach>
                                                </c:if>
                                            </select>
                                        </td>
                                        <td><input type="number" name="m_quantity" min="1" required></td>
                                    </tr>
                                    <tr>
                                        <td>Side dish</td>

                                        <td>
                                            <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                                    <option value="">Select</option>
                                                    <option  value="search-product-by-category?id=${2}&ok=${2}">Sandwich</option>
                                                    <option  value="search-product-by-category?id=${6}&ok=${2}">Salad</option>
                                                    <option value="search-product-by-category?id=${8}&ok=${2}">French Fries</option>
                                                </select>
                                        </td>
                                        <td>
                                            <select required style="width: 200px;" name="side">
                                                <c:if test="${sideDish != null}">
                                                    <c:forEach items="${sideDish}" var="c">
                                                        <option value="${c.productID}">${c.name}</option>
                                                    </c:forEach>

                                                </c:if>
                                            </select>
                                        </td>
                                        <td><input type="number" name="s_quantity" min="1" required></td>
                                    </tr>
                                    <tr>
                                        <td>Bevarage</td>

                                        <td>
                                            <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                                    <option value="">Select</option>
                                                    <option value="search-product-by-category?id=${4}&ok=${3}">Bevarage</option>
                                                </select>
                                        </td>
                                        <td>
                                            <select required style="width: 200px;" name="bevarage">
                                                <c:if test="${bevarage != null}">
                                                    <c:forEach items="${bevarage}" var="c">
                                                        <option value="${c.productID}">${c.name}</option>
                                                    </c:forEach>

                                                </c:if>
                                            </select>
                                        </td>
                                        <td><input type="number" name="b_quantity" min="1" required></td>
                                    </tr>

                                    </tbody>
                                </table>

                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%">Combo Name</th>
                                            <th scope="col" style="font-size: 90%">Exchanged points</th>
                                            <th scope="col" style="font-size: 90%">Accumulated points</th>
                                            <th scope="col" style="font-size: 90%">Discount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input class="py-1" type="text" name="comboName" placeholder="Please give a name..." required></td>
                                            <td><input class="py-1" type="number" name="exPoint" min="1" required></td>
                                            <td><input class="py-1" type="number" name="accPoint" min="1" required></td>
                                            <td><input class="py-1" type="number" name="discount" min="0" max="1" step="0.01" required></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td colspan="2"><button class="btn btn-success py-2" style="width: 100%" type="submit">SUBMIT</button></td>
                                        </tr>
                                    </tbody>

                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>


            <c:if test="${okela != null}">
                <div class="popup active" id="popup-2">
                    <div class="overlay"></div>
                    <div class="content2">
                        <div class="close-btn" onclick="togglePopup2()">&times;</div>
                        <p style="font-weight: bold; text-align: center">UPDATE COMBO</p><br>
                        <div>
                            <form action="update-combo" method="post">
                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%"></th>
                                            <th scope="col" style="font-size: 90%">Category Name</th>
                                            <th scope="col" style="font-size: 90%">Product Name</th>
                                            <th scope="col" style="font-size: 90%">Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                    <input type="hidden" name="comboID" value="${id}">
                                    <td>Main course</td>
                                    <td>
                                        <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                            <option value="">Select</option>
                                            <option value="search-product-by-category?id=${1}&ok=${1}">Chicken</option>
                                            <option value="search-product-by-category?id=${3}&ok=${1}">Burger</option>
                                            <option value="search-product-by-category?id=${5}&ok=${1}">Spaghetti</option>
                                            <option value="search-product-by-category?id=${7}&ok=${1}">Taco</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select required style="width: 200px;" name="main">
                                            <c:if test="${mainCourse != null}">
                                                <c:forEach items="${mainCourse}" var="c">
                                                    <option class="py-1" value="${c.productID}">${c.name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </td>
                                    <td><input type="number" name="m_quantity" min="1" required></td>
                                    </tr>
                                    <tr>
                                        <td>Side dish</td>

                                        <td>
                                            <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                                <option value="">Select</option>
                                                <option value="search-product-by-category?id=${2}&ok=${2}">Sandwich</option>
                                                <option value="search-product-by-category?id=${6}&ok=${2}">Salad</option>
                                                <option value="search-product-by-category?id=${8}&ok=${2}">French Fries</option>
                                            </select>
                                        </td>
                                        <td>
                                            <select required style="width: 200px;" name="side">
                                                <c:if test="${sideDish != null}">
                                                    <c:forEach items="${sideDish}" var="c">
                                                        <option value="${c.productID}">${c.name}</option>
                                                    </c:forEach>

                                                </c:if>
                                            </select>
                                        </td>
                                        <td><input type="number" name="s_quantity" min="1" required></td>
                                    </tr>
                                    <tr>
                                        <td>Bevarage</td>

                                        <td>
                                            <select style="width: 200px;" onchange="redirectToURL(this)" name="" value="">
                                                <option value="">Select</option>
                                                <option value="search-product-by-category?id=${4}&ok=${3}">Bevarage</option>
                                            </select>
                                        </td>
                                        <td>
                                            <select required style="width: 200px;" name="bevarage">
                                                <c:if test="${bevarage != null}">
                                                    <c:forEach items="${bevarage}" var="c">
                                                        <option value="${c.productID}">${c.name}</option>
                                                    </c:forEach>

                                                </c:if>
                                            </select>
                                        </td>
                                        <td><input type="number" name="b_quantity" min="1" required></td>
                                    </tr>

                                    </tbody>
                                </table>

                                <table class="table bg-white rounded shadow-sm table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="font-size: 90%">Combo Name</th>
                                            <th scope="col" style="font-size: 90%">Exchanged points</th>
                                            <th scope="col" style="font-size: 90%">Accumulated points</th>
                                            <th scope="col" style="font-size: 90%">Discount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input class="py-1" type="text" name="comboName" value="${combo.comboName}" placeholder="Please give a name..." required></td>
                                            <td><input class="py-1" type="number" name="exPoint" value="${combo.exchangedPoint}" min="1" required></td>
                                            <td><input class="py-1" type="number" name="accPoint" value="${combo.accumulatedPoint}" min="1" required></td>
                                            <td><input class="py-1" type="number" name="discount" min="0" max="1" step="0.01" required></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td colspan="2"><button class="btn btn-success py-2" style="width: 100%" type="submit">SUBMIT</button></td>
                                        </tr>
                                    </tbody>

                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
            <!-- Custom JS -->
            <script src="js/scripts.js"></script>
            <script>
                                                function redirectToURL(selectElement) {
                                                    var selectedOption = selectElement.options[selectElement.selectedIndex];
                                                    if (selectedOption.value !== '') {
                                                        window.location.href = selectedOption.value;
                                                    }
                                                }

                                                var el = document.getElementById("wrapper");
                                                var toggleButton = document.getElementById("menu-toggle");

                                                toggleButton.onclick = function () {
                                                    el.classList.toggle("toggled");
                                                };

                                                $(document).ready(function () {
                                                    // Activate tooltip
                                                    $('[data-toggle="tooltip"]').tooltip();

                                                    // Select/Deselect checkboxes
                                                    var checkbox = $('table tbody input[type="checkbox"]');
                                                    $("#selectAll").click(function () {
                                                        if (this.checked) {
                                                            checkbox.each(function () {
                                                                this.checked = true;
                                                            });
                                                        } else {
                                                            checkbox.each(function () {
                                                                this.checked = false;
                                                            });
                                                        }
                                                    });
                                                    checkbox.click(function () {
                                                        if (!this.checked) {
                                                            $("#selectAll").prop("checked", false);
                                                        }
                                                    });
                                                });

                                                function togglePopup() {
                                                    document.getElementById("popup-1").classList.toggle("active");
                                                }

                                                function togglePopup2() {
                                                    document.getElementById("popup-2").classList.toggle("active");
                                                }
            </script>
    </body>
</html>
