<%-- 
    Document   : dashboard-admin
    Created on : 6 Mar, 2023, 9:36:54 PM
    Author     : ADMIN
--%>

<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
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
                width: 450px;
                height: 650px;
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
                width: 550px;
                height: 570px;
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
                        class="fas fa-user-secret me-2"></i>MANAGER PAGE</div>
                <div class="list-group list-group-flush my-3">
                    <a href="admin-page" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="product-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-tachometer-alt me-2"></i>Products</a> 
                    <a href="orders-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-gift me-2"></i>Orders</a>
                    <a href="feedback-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comment-dots me-2"></i>Feedbacks</a>
                    <a href="sale-admin" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
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
                        <h2 class="fs-2 m-0">Sale Management</h2>
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
                            <h3 class="fs-4 mb-3 d-inline col-sm-10">Sale events </h3>
                            <button class="btn btn-success px-3 py-1 col-sm-2"><a class="view-modal text-decoration-none text-white" href="add-sale"><span><i class="fa-sharp fa-solid fa-plus"></i></span>&nbsp; Add a sale event</a></button>
                        </div>


                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Sale ID</th>
                                        <th scope="col">Sale Name</th>
                                        <th scope="col">Sale Value</th>
                                        <th scope="col">Start Date</th>
                                        <th scope="col">End Date</th>
                                        <th scope="col">Sale Code</th>
                                        <th scope="col">See Details</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${sList}" var="c">
                                        <tr>
                                            <td>${c.saleID}</td>
                                            <td>${c.saleName}</td>
                                            <td>${c.saleValue}</td>
                                            <td>${c.startDate}</td>
                                            <td>${c.endDate}</td>
                                            <td>${c.saleCode}</td>
                                            <td><a href="view-sale-products?id=${c.saleID}"><i class="view-modal fa-solid fa-eye text-dark text-center"></i></a></td>
                                            <td>
                                                <a href="update-sale?id=${c.saleID}" class="edit"><i class="view-modal fa-sharp fa-regular fa-pen-to-square  text-dark"></i></a> &nbsp;&nbsp;&nbsp;
                                                <a href="delete-sale?id=${c.saleID}" class="delete"><i class="fa-sharp fa-solid fa-trash  text-dark"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div class="row">
                            <div class="col-lg-12 text-center">
                                <div class="pagination-wrap text-center">
                                    <ul class="d-flex text-center justify-content-center" style="margin-top: 10px">
                                        <c:forEach begin="1" end="${numberPage}" var="i">
                                            <li style="list-style: none"><a style="border: 1px solid black; border-radius: 50%" class="m-3 text-dark text-decoration-none px-2 py-1" href="sale-admin?index=${i}">${i}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>

                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>

    <c:if test="${ok != null}">
        <div class="popup active" id="popup-2">
            <div class="overlay"></div>
            <div class="content2">
                <div class="close-btn" onclick="togglePopup2()">&times;</div>
                <p style="font-weight: bold; text-align: center">ADD NEW SALE</p><br>
                <div>
                    <form class="form" action="add-sale" method="post" onsubmit="return validateAddForm()">

                        <div class="column">
                            <div class="input-box">
                                <label>Sale Name</label>
                                <input type="text" name="s-name" placeholder="Enter sale name" required />
                            </div>
                            <div class="input-box">
                                <label>Sale Quantity / 1 Product</label>
                                <input type="number" name="s-quantity" placeholder="Enter sale quantity" required min="1" />
                            </div>
                        </div>
                        <div class="column">
                            <div class="input-box">
                                <label>Sale Value</label>
                                <input type="number" name="s-value" placeholder="Enter sale value" required min="0" max="1" step="0.01"/>
                            </div>
                            <div class="input-box">
                                <label>Sale Code</label>
                                <input type="text" name="s-code" placeholder="Enter sale code" required />
                            </div>
                        </div>
                        <div class="column">
                            <div class="input-box">
                                <label>Start Date</label>
                                <input type="date" name="s-start" placeholder="Enter start date"  min="<%= LocalDate.now() %>" required id="s_start"/>
                            </div>
                            <div class="input-box">
                                <label>End Date &nbsp; <span class="text-danger" id="error-end"></span></label>
                                <input type="date" name="s-end" placeholder="Enter end date"  min="<%= LocalDate.now() %>" required id="s_end" />
                            </div>
                        </div>
                        <div class="column mt-3">
                            <p class="text-secondary" style="font-size: 80%; font-style: italic">(*) This sale is only applied for the 5 worst products including: ${wItems}
                        </div>
                        <button>Submit</button>
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
                <p style="font-weight: bold; text-align: center">UPDATE SALE</p><br>
                <div>
                    <form class="form" action="update-sale" method="post" onsubmit="return validateUpdateForm()">
                        <input type="hidden" name="id" value="${id}">
                        <div class="column">
                            <div class="input-box">
                                <label>Sale Name</label>
                                <input type="text" name="s-name" placeholder="Enter sale name" required value="${sale.saleName}"/>
                            </div>
                        </div>
                        <div class="column">
                            <div class="input-box">
                                <label>Sale Value</label>
                                <input type="number" name="s-value" placeholder="Enter sale value" required value="${sale.saleValue}" min="0" max="1" step="0.01" />
                            </div>
                            <div class="input-box">
                                <label>Sale Code</label>
                                <input type="text" name="s-code" placeholder="Enter sale code" required value="${sale.saleCode}" />
                            </div>
                        </div>
                        <div class="column">
                            <div class="input-box">
                                <label>Start Date</label>
                                <input type="date" name="s-start" placeholder="Enter start date" required value="${sale.startDate}" id="s_start2"/>
                            </div>
                            <div class="input-box">
                                <label>End Date &nbsp; <span class="text-danger" id="error-end2" ></span></label>
                                <input type="date" name="s-end" placeholder="Enter end date" required value="${sale.endDate}" id="s_end2"/>
                            </div>
                        </div>
                        <button>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${oki != null}">
        <div class="popup active" id="popup-2" >
            <div class="overlay"></div>
            <div class="content2" style='height: 400px;'>
                <div class="close-btn" onclick="togglePopup2()">&times;</div>
                <p style="font-weight: bold; text-align: center">SALE PRODUCTS' DETAILS</p><br>
                <div>
                    <table class="table bg-white rounded shadow-sm  table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Sale ID</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Product ID</th>
                                <th scope="col">Sale Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${saleProducts}" var="c">
                                <tr>
                                    <td>${c.saleID}</td>
                                    <td>${c.productName}</td>
                                    <td>${c.productID}</td>
                                    <td>${c.saleQuantity}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
    <!-- Custom JS -->
    <script src="js/scripts.js"></script>
    <script>
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
                    
                    function validateAddForm() {
                            const s_start = document.getElementById('s_start').value;
                            const s_end = document.getElementById('s_end').value;

                            let errorEnd = document.getElementById('error-end');

                            let isValid = true;

                            // Clear error messages
                            errorEnd.innerText = '';

                            if (new Date(s_end) <= new Date(s_start)) {
                                errorEnd.innerText = 'End Date is invalid!';
                                isValid = false;
                            }

                            return isValid;
                        }
                        
                        function validateUpdateForm() {
                            const s_start = document.getElementById('s_start2').value;
                            const s_end = document.getElementById('s_end2').value;

                            let errorEnd = document.getElementById('error-end2');

                            let isValid = true;

                            // Clear error messages
                            errorEnd.innerText = '';

                            if (new Date(s_end) <= new Date(s_start)) {
                                errorEnd.innerText = 'End Date is invalid!';
                                isValid = false;
                            }

                            return isValid;
                        }
    </script>

</body>
</html>
