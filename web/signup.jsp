<%-- 
    Document   : signup
    Created on : May 24, 2023, 7:38:52 PM
    Author     : PC
--%>

<%@page import="java.time.LocalDate"%>
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
                            <form action="signup" class="signin-form" method="POST" onsubmit="return validateForm()">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name" name="name" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Address" name="address" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Phone number" name="phone" required>
                                    <div id="error-phone" class="text-warning"></div>
                                </div><!-- comment -->
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Email" name="email" required>
                                    <div id="error-email" class="text-warning"></div>
                                </div><!-- comment -->
                                <div class="form-group">
                                    <input type="date" class="form-control" placeholder="Date of birth" name="dob" min="1900-01-01" max="<%= LocalDate.now()%>" required>
                                </div>

                                <div class="form-group">
                                    <select required class="form-control" name="gender">
                                        <option value="1">Male</option>
                                        <option value="0">Female</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input required id="password-field" type="password" class="form-control" placeholder="Password" name="pass">
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                    <div id="error-pass" class="text-warning"></div>
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

        <script>
            function validateForm() {

                const phone = document.getElementsByName('phone')[0].value;
                const email = document.getElementsByName('email')[0].value;
                const pass = document.getElementsByName('pass')[0].value;


                let errorPhone = document.getElementById('error-phone');
                let errorEmail = document.getElementById('error-email');
                let errorPass = document.getElementById('error-pass');

                const emailRegex = /^[^\s@]+@[^\s@]+(\.[^\s@]+)+$/;
                const phoneRegex = /^0(\d){9,10}$/;
                const passRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d!@#$%^&*]{8,}$/;

                let isValid = true;

                // Clear error messages
                errorPhone.innerText = '';
                errorEmail.innerText = '';
                errorPass.innerText = '';


                if (!phoneRegex.test(phone)) {
                    errorPhone.innerText = 'Phone is invalid!';
                    isValid = false;
                }

                if (!emailRegex.test(email)) {
                    errorEmail.innerText = 'Email is invalid!';
                    isValid = false;
                }

                if (!passRegex.test(pass)) {
                    errorPass.innerText = 'Password is invalid!';
                    isValid = false;
                }

                return isValid;
            }
        </script>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

