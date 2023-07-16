<%-- 
    Document   : thankyou
    Created on : 3 Mar, 2023, 9:37:41 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="vh-100 d-flex justify-content-center align-items-center">
            <div class="col-md-4">
                <div class="border border-3 border-danger"></div>
                <div class="card  bg-white shadow p-5">
                    <div class="mb-4 text-center">
                        <image src="image/fail.png" style="height: 100px; width: 100px">
                    </div>
                    <div class="text-center">
                        <h1>Sorry !</h1>
                        <p>The payment process was failed !</p>
                        <a href="shopping" class="btn btn-outline-danger">Continue shopping</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
