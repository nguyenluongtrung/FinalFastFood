<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="VNPAY.Config"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>VNPAY RESPONSE</title>
        <!-- Bootstrap core CSS -->
        <link href="asset_vnpay/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="asset_vnpay/jumbotron-narrow.css" rel="stylesheet"> 
        <script src="asset_vnpay/jquery-1.11.3.min.js"></script>
    </head>
    <body>
        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

        %>
        <!--Begin display -->
        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted">VNPAY RESPONSE</h3>
            </div>
            <div class="table-responsive">
                <div class="form-group">
                    <label >Merchant Transaction Code:</label>
                    <label><%=request.getParameter("vnp_TxnRef")%></label>
                </div>    
                <div class="form-group">
                    <label >Amount:</label>
                    <label><%=Long.parseLong(request.getParameter("vnp_Amount")) / 100%></label>
                </div>  
                <div class="form-group">
                    <label >Order info:</label>
                    <label><%=request.getParameter("vnp_OrderInfo")%></label>
                </div> 
                <div class="form-group">
                    <label >VNPAY Response Code:</label>
                    <label><%=request.getParameter("vnp_ResponseCode")%></label>
                </div> 
                <div class="form-group">
                    <label >VNPAY Transaction Code:</label>
                    <label><%=request.getParameter("vnp_TransactionNo")%></label>
                </div> 
                <div class="form-group">
                    <label >Bank Code:</label>
                    <label><%=request.getParameter("vnp_BankCode")%></label>
                </div> 
                <div class="form-group">
                    <label >Pay Date:</label>
                    <label><%=request.getParameter("vnp_PayDate")%></label>
                </div> 
                <div class="form-group">
                    <label >Payment Status:</label>
                    <label>
                        <%
                            int ok = 0;
                            if (signValue.equals(vnp_SecureHash)) {
                                if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                    out.print("Success");
                                    ok = 1;
                                } else {
                                    out.print("Failed");
                                }

                            } else {
                                out.print("invalid signature");
                            }
                        %></label>
                </div> 
                <form action="checkout" method="post">

                    <p><input type="hidden" placeholder="Name" value="${sessionScope.vnpay_name}" name="name"></p>
                    <p><input type="hidden" placeholder="Email"value="${sessionScope.vnpay_email}" name="email"></p>
                    <p><input type="hidden" placeholder="Address" value="${sessionScope.vnpay_address}" name="address"></p>
                    <p><input type="hidden" placeholder="Phone" value="${sessionScope.vnpay_phone}" name="phone"></p>
                    <p><input type="hidden" value="${sessionScope.vnpay_code}" name="code"></p>
                    <p><input type="hidden" value="${sessionScope.vnpay_my_point}" name="my_point"></p>
                    <p><input type="hidden" value="${sessionScope.vnpay_note}" name="note" id="bill" ></p>
                    <p><input type="hidden" value="<%= (ok == 1) ? 1 : 0 %>" name="changeStatus"></p>
                    
                    <button type="submit" class="boxed-btn place-btn px-4 py-2">Confirm</button>


                </form>

            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2020</p>
            </footer>
        </div>  
    </body>
</html>
