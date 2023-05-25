<%-- 
    Document   : signup
    Created on : May 24, 2023, 7:38:52 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sign up</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="style-sign-up/css/style.css">

    </head>
    <body class="img js-fullheight" style="background-image: url(style-sign-up/images/z4373505915681_735607b4dfbe3d3d80f627e7495e773d.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">SIGN UP</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <form action="signup" class="signin-form" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name" name="name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Address" name="address">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Phone number" name="phone">
                                </div><!-- comment -->
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Email" name="email">
                                </div><!-- comment -->
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Date of birth" name="dob">
                                </div>

                                <div class="form-group">
                                    <select class="form-control" name="gender">
                                        <option value="1">Male</option>
                                        <option value="0">Female</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input id="password-field" type="password" class="form-control" placeholder="Password" name="pass">
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="form-control btn btn-primary submit px-3">Sign Up</button>
                                </div>
                                <div class="form-group d-md-flex">
                                    <div class="w-50">
                                        <a href="login.jsp" >Log in</a>   
                                    </div>
                                    <div class="w-50 text-md-right">
                                        <a href="#" style="color: #fff">Forgot Password</a>
                                    </div>
                                </div>
                            </form>
                           
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

