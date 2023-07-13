<%-- 
    Document   : cart
    Created on : 20 May, 2023, 8:45:04 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Cart</title>

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
            .continue-btn{
                cursor: pointer;
                border-radius: 30px;
                background-color: #f28123;
                color: white;
                border:none;
            }

            .continue-btn:hover{
                background-color: black;
                color: #f28123;
                border: none;
            }

            .btn-orange{
                cursor: pointer;
                border-radius: 30px;
                background-color: #f28123;
                color: white;
                border:none;
                padding: 15px;
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
                                <p>Fresh and Organic</p>
                                <h1>Cart</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

            <!-- cart -->
            <div class="cart-section mt-150 mb-150">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-12">
                            <div class="cart-table-wrap">
                                <table class="cart-table">
                                    <thead class="cart-table-head">
                                        <tr class="table-head-row">
                                            <th class="product-remove"></th>
                                            <th class="product-image">Product Image</th>
                                            <th class="product-name">Name</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-total">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${items}" var="c">
                                        <tr class="table-body-row">
                                            <td class="product-remove"><a href="remove-from-cart?id=${c.product.productID}"><i class="far fa-window-close"></i></a></td>
                                            <td class="product-image"><img src="${c.product.image}" alt="" style="height: 50px; width: 50px;"></td>
                                            <td class="product-name">${c.product.name}</td>
                                            <td class="product-price">${c.product.price}$</td>
                                            <td class="product-quantity"><input type="number" readonly placeholder="${c.quantity}"></td>
                                            <td class="product-total">${c.quantity * c.product.price}$</td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach items="${comboItems}" var="c">
                                        <tr class="table-body-row">
                                            <td class="product-remove"><a href="remove-from-cart?c_id=${c.combo.comboID}"><i class="far fa-window-close"></i></a></td>
                                            <td class="product-image"><img src="${c.combo.image}" alt="" style="height: 50px; width: 50px;"></td>
                                            <td class="product-name">${c.combo.comboName}</td>
                                            <td class="product-price">${c.combo.totalPrice}$</td>
                                            <td class="product-quantity"><input type="number" readonly placeholder="${c.quantity}"></td>
                                            <td class="product-total"><fmt:formatNumber value="${c.combo.totalPrice * c.quantity}" pattern="#.##" />$</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>


                            </table>

                        </div>
                        <div class="mt-5"><a href="shopping" class="px-5 py-3 mt-5 continue-btn">Continue shopping</a></div>

                    </div>

                    <div class="col-lg-4">

                        <c:if test="${ok == null}">
                            <div class="total-section">
                                <table class="total-table">
                                    <thead class="total-table-head">
                                        <tr class="table-total-row">
                                            <th>Name</th>
                                            <th>Price</th>
                                                <c:if test="${sessionScope.acc.role != null}">
                                                <th>Exchanged points</th>
                                                </c:if>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${items}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.product.name}</strong></td>
                                                <td id="price_${c.product.productID}">${c.product.price * c.quantity}$</td>
                                                <c:if test="${sessionScope.acc.role != null}">
                                                    <td>${c.product.exchangedPoint * c.quantity} points <input type="checkbox" id="check_${c.product.productID}" name="accPoint" onclick="useAccPoints('${c.product.productID}', ${c.product.price * c.quantity}, ${c.product.exchangedPoint * c.quantity})"/></td>
                                                    </c:if>
                                            </tr>
                                        </c:forEach>
                                        <c:forEach items="${comboItems}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.combo.comboName}</strong></td>
                                                <td id="price2_${c.combo.comboID}">
                                                    <fmt:formatNumber value="${c.combo.totalPrice * c.quantity}" pattern="#.##" />$
                                                </td>
                                                <c:if test="${sessionScope.acc.role != null}">
                                                    <td>${c.combo.exchangedPoint * c.quantity} points <input type="checkbox" id="check2_${c.combo.comboID}" name="accPoint" onclick="useAccPoints2('${c.combo.comboID}', ${c.combo.totalPrice * c.quantity}, ${c.combo.exchangedPoint * c.quantity})"/></td>
                                                    </c:if>
                                            </tr>
                                        </c:forEach>
                                        <tr class="total-data">
                                            <td><strong>Total: </strong></td>
                                            <td id="subtotalCell">${subtotal}$</td>
                                            <c:if test="${sessionScope.acc.role != null}">
                                                <td></td>
                                            </c:if>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="cart-buttons">


                                    <form action="checkout">
                                        <c:if test="${sessionScope.acc.role != null}">
                                            <p>Your points are: <span id="my-point">${sessionScope.acc.totalAccumulatedPoint} points</span></p>
                                        </c:if>

                                        <input type="hidden" name="subtotal" id="subtotalInput" value="<c:out value="${subtotal}"/>" />
                                        <input type="hidden" name="my_point" id="my-point2" value="<c:out value="${sessionScope.acc.totalAccumulatedPoint}"/>" />
                                        <button type="submit" class="btn-orange">Check Out</button>
                                        
                                        
                                    </form>
                                        

                                </div>
                            </div>
                        </c:if>

                        <c:if test="${ok != null}">
                            <div class="total-section">
                                <table class="total-table">
                                    <thead class="total-table-head">
                                        <tr class="table-total-row">
                                            <th>Name</th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="cnt" value="0"></c:set>
                                        <c:forEach items="${items}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.product.name}</strong></td>
                                                <c:forEach items="${saleList}" var="e">
                                                    <c:if test="${(e.productID == c.product.productID) && (e.saleQuantity > 0)}">
                                                        <c:if test="${c.quantity > e.saleQuantity}">
                                                            <td><del class="text-danger">${c.product.price * c.quantity}$</del> &nbsp; <fmt:formatNumber value="${c.product.price * e.saleQuantity * (1 - saleValue) + c.product.price * (c.quantity - e.saleQuantity)}" pattern="#.##" />$</td>
                                                            <c:set var="cnt" value="${cnt + 1}"></c:set>
                                                            <c:if test="${cnt == 1}">
                                                                <c:set var="q1" value="${e.saleQuantity}"></c:set>
                                                                <c:set var="n1" value="${c.product.name}"></c:set>
                                                            </c:if>
                                                            <c:if test="${cnt == 2}">
                                                                <c:set var="q2" value="${e.saleQuantity}"></c:set>
                                                                <c:set var="n2" value="${c.product.name}"></c:set>
                                                            </c:if>
                                                            <c:if test="${cnt == 3}">
                                                                <c:set var="q3" value="${e.saleQuantity}"></c:set>
                                                                <c:set var="n3" value="${c.product.name}"></c:set>
                                                            </c:if>
                                                            <c:if test="${cnt == 4}">
                                                                <c:set var="q4" value="${e.saleQuantity}"></c:set>
                                                                <c:set var="n4" value="${c.product.name}"></c:set>
                                                            </c:if>
                                                            <c:if test="${cnt == 5}">
                                                                <c:set var="q5" value="${e.saleQuantity}"></c:set>
                                                                <c:set var="n5" value="${c.product.name}"></c:set>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${c.quantity <= e.saleQuantity}">
                                                            <td><del class="text-danger">${c.product.price * c.quantity}$</del> &nbsp; <fmt:formatNumber value="${c.product.price * c.quantity * (1 - saleValue)}" pattern="#.##" />$</td>
                                                        </c:if>
                                                        <c:set var="k" value="1"></c:set>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${k != 1}">
                                                    <td>${c.product.price * c.quantity}$</td>
                                                </c:if>
                                                <c:set var="k" value="0"></c:set>
                                                </tr>
                                        </c:forEach>
                                        <c:forEach items="${comboItems}" var="c">
                                            <tr class="total-data">
                                                <td><strong>${c.combo.comboName}</strong></td>
                                                <td>
                                                    <fmt:formatNumber value="${c.combo.totalPrice * c.quantity}" pattern="#.##" />$
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        <!--                                        <tr class="total-data">
                                                                                    <td><strong>Shipping: </strong></td>
                                                                                    <td>$50</td>
                                                                                </tr>-->
                                        <tr class="total-data">
                                            <td><strong>Total: </strong></td>
                                            <td>${subtotal}$</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <c:if test="${cnt == 1}"><p class="text-danger" style="font-size: 80%; font-style: italic;">(*) Note: We only apply the sale value for ${n1} with ${q1} products.</p></c:if>
                                <c:if test="${cnt == 2}"><p class="text-danger" style="font-size: 80%; font-style: italic;">(*) Note: We only apply the sale value for ${n1} with ${q1} products, ${n2} with ${q2} products.</p></c:if>
                                <c:if test="${cnt == 3}"><p class="text-danger" style="font-size: 80%; font-style: italic;">(*) Note: We only apply the sale value for ${n1} with ${q1} products, ${n2} with ${q2} products, ${n3} with ${q3} products.</p></c:if>
                                <c:if test="${cnt == 4}"><p class="text-danger" style="font-size: 80%; font-style: italic;">(*) Note: We only apply the sale value for ${n1} with ${q1} products, ${n2} with ${q2} products, ${n3} with ${q3} products, ${n4} with ${q4} products.</p></c:if>
                                <c:if test="${cnt == 5}"><p class="text-danger" style="font-size: 80%; font-style: italic;">(*) Note: We only apply the sale value for ${n1} with ${q1} products, ${n2} with ${q2} products, ${n3} with ${q3} products, ${n4} with ${q4} products, ${n5} with ${q5} products.</p></c:if>

                                    <div class="cart-buttons">
                                    <c:if test="${(saleList != null) && (code != null)}">
                                        <a href="checkout?okela=${1}&code=${code}" class="boxed-btn black">Check Out</a>
                                    </c:if>
                                    <c:if test="${(saleList == null) || (code == null)}">
                                        <a href="checkout" class="boxed-btn black">Check Out</a>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>


                        <div class="coupon-section">
                            <h3>Apply Coupon</h3>
                            <div class="coupon-form-wrap">
                                <form action="add-to-cart" method="post">
                                    <input type="hidden" name="productID" value="${productID}">
                                    <p><input type="text" name="code" placeholder="Coupon"></p>
                                    <p><input type="submit" value="Apply"></p>
                                </form>
                                <p class="text-danger">${ms != null ? ms : ""}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end cart -->



        <jsp:include page="footer.jsp"></jsp:include>

        <script>
            function useAccPoints(productId, original_price, original_points) {
                // Get the table cell element for the price
                var priceCell = document.getElementById("price_" + productId);
                const subtotalCell = document.getElementById('subtotalCell');
                let subtotalInput = document.getElementById('subtotalInput');
                let my_point = document.getElementById("my-point");
                let my_point2 = document.getElementById("my-point2");
                const check = document.getElementById('check_' + productId);

                if (check.checked) {
                    if (parseInt(my_point.innerText) >= original_points) {
                        // Check the current price value
                        var currentPrice = priceCell.innerText;

                        // Toggle the price between original and 0
                        if (currentPrice === "0$") {
                            // Revert to the original price
                            priceCell.innerText = original_price + "$";
                            subtotalCell.innerText = parseFloat(subtotalCell.innerText) + original_price;
                            my_point.innerText = parseInt(my_point.innerText) + original_points;
                        } else {
                            // Set the price to 0
                            priceCell.innerText = "0$";
                            subtotalCell.innerText = parseFloat(subtotalCell.innerText) - original_price;
                            my_point.innerText = parseInt(my_point.innerText) - original_points;
                        }
                        subtotalInput.value = subtotalCell.innerText;
                        my_point2.value = my_point.innerText;
                    } else {
                        check.checked = false;
                    }
                } else {
                    priceCell.innerText = original_price + "$";
                    subtotalCell.innerText = parseFloat(subtotalCell.innerText) + original_price;
                    my_point.innerText = parseInt(my_point.innerText) + original_points;
                }



            }
            
            function useAccPoints2(comboId, original_price, original_points) {
                // Get the table cell element for the price
                var priceCell = document.getElementById("price2_" + comboId);
                const subtotalCell = document.getElementById('subtotalCell');
                let subtotalInput = document.getElementById('subtotalInput');
                let my_point = document.getElementById("my-point");
                let my_point2 = document.getElementById("my-point2");
                const check = document.getElementById('check2_' + comboId);

                if (check.checked) {
                    if (parseInt(my_point.innerText) >= original_points) {
                        // Check the current price value
                        var currentPrice = priceCell.innerText;

                        // Toggle the price between original and 0
                        if (currentPrice === "0$") {
                            // Revert to the original price
                            priceCell.innerText = original_price + "$";
                            subtotalCell.innerText = parseFloat(subtotalCell.innerText) + original_price;
                            my_point.innerText = parseInt(my_point.innerText) + original_points;
                        } else {
                            // Set the price to 0
                            priceCell.innerText = "0$";
                            subtotalCell.innerText = parseFloat(subtotalCell.innerText) - original_price;
                            my_point.innerText = parseInt(my_point.innerText) - original_points;
                        }
                        subtotalInput.value = subtotalCell.innerText;
                        my_point2.value = my_point.innerText;
                    } else {
                        check.checked = false;
                    }
                } else {
                    priceCell.innerText = original_price + "$";
                    subtotalCell.innerText = parseFloat(subtotalCell.innerText) + original_price;
                    my_point.innerText = parseInt(my_point.innerText) + original_points;
                }



            }

        </script>

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
