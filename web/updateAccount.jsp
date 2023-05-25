<%-- 
    Document   : updateAccount
    Created on : May 24, 2023, 5:02:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <form action="UpdateAccountConfirmServlet" method="POST">
            <table>
                <tr><td>Role</td></tr>
                <tr><td><input type="text" required name="role" value="${sessionScope.acc.role}" readonly></td></tr>
                <tr><td>Created Date</td></tr>
                <tr><td><input type="text" required name="createdDate" value="${sessionScope.acc.createdDate}" readonly></td></tr>
                <tr><td>Name</td></tr>
                <tr><td><input type="text" required name="name" value="${sessionScope.acc.name}"></td></tr>
                <tr><td>Address</td></tr>
                <tr><td><input type="text" required name="address" value="${sessionScope.acc.address}"></td></tr>
                <tr><td>Phone</td></tr>
                <tr><td><input type="text" required name="phone" value="${sessionScope.acc.phone}"></td></tr>
                <tr><td>email</td></tr>
                <tr><td><input type="text" required name="email" value="${sessionScope.acc.email}" readonly></td></tr>
                <tr><td>Date Of Birth</td></tr>
                <tr><td><input type="date" required name="dob" value="${sessionScope.acc.dob}"></td></tr>
                <tr><td>Gender</td></tr>
                <tr><td><input type="text" required name="gender" value="${sessionScope.acc.gender == true ? 'Male' : 'Female'}"></td></tr>
                <tr><td>Total Accumulated Point</td></tr>
                <tr><td><input type="text" required name="totalAccumulatedPoint" value="${sessionScope.acc.totalAccumulatedPoint}" readonly></td></tr>
                <tr><td>Password</td></tr>
                <tr><td><input type="text" required name="password" value="${sessionScope.acc.password}"></td></tr>
                <tr><td>Re-Enter Password</td></tr>
                <tr><td><input type="text" required name="password2" value="${sessionScope.acc.password}"></td></tr>
            </table>
            <input type="submit" value="Update" />
            <p style="color:red">${msg != null ? msg : ""}</p>
        </form>
    </body>
</html>-->

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="index.css">
        <title>HASH TECHIE OFFICIAL</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');
            *{
                margin: 0;
                padding: 0;
                font-family: 'poppins',sans-serif;
            }
            section{
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                width: 100%;

                background-image: url(assets/img/bglogin.jpg);
                background-position: center;
                background-size: cover;
            }
            .form-box{
                position: relative;
                width: 600px;
                height: 1250px;
                background: transparent;
                border: 2px solid rgba(255,255,255,0.5);
                border-radius: 20px;
                backdrop-filter: blur(15px);
                display: flex;
                justify-content: center;
                align-items: center;

            }
            h2{
                font-size: 2em;
                color: #fff;
                text-align: center;
            }
            .inputbox{
                position: relative;
                margin: 30px 0;
                width: 310px;
                border-bottom: 2px solid #fff;
            }
            .inputbox label{
                /*                text-shadow: -1px 0 black, 0 1px black; */
                position: absolute;
                top: 50%;
                left: 5px;
                transform: translateY(-50%);
                color: #fff;
                font-size: 1em;
                pointer-events: none;
                transition: .5s;
            }
            input:focus ~ label{
                top: -5px;
            }
            input:valid ~ label{
                top: -5px;
            }
            .inputbox input {
                width: 100%;
                height: 50px;
                background: transparent;
                border: none;
                outline: none;
                font-size: 1em;
                padding:0 35px 0 5px;
                color: #fff;
            }
            .inputbox ion-icon{
                position: absolute;
                right: 8px;
                color: #fff;
                font-size: 1.2em;
                top: 20px;
            }
            .forget{
                margin: -15px 0 15px ;
                font-size: .9em;
                color: #fff;
                display: flex;
                justify-content: space-between;
            }

            .forget label input{
                margin-right: 3px;

            }
            .forget label a{
                color: #fff;
                text-decoration: none;
            }
            .forget label a:hover{
                text-decoration: underline;
            }
            button{
                width: 100%;
                height: 40px;
                border-radius: 40px;
                background: #fff;
                border: none;
                outline: none;
                cursor: pointer;
                font-size: 1em;
                font-weight: 600;
            }
            .register{
                font-size: .9em;
                color: #fff;
                text-align: center;
                margin: 25px 0 10px;
            }
            .register p a{
                text-decoration: none;
                color: #fff;
                font-weight: 600;
            }
            .register p a:hover{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="UpdateAccountConfirmServlet" method="post">
                        <h2>Update Account</h2>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" value="Role">
                            <input type="text" required name="role" value="${sessionScope.acc.role}" readonly>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" value="Create Date">
                            <input type="text" required name="createdDate" value="${sessionScope.acc.createdDate}" readonly>
                        </div>        
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="name" value="${sessionScope.acc.name}">
                            <label for="">Name</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="address" value="${sessionScope.acc.address}">
                            <label for="">Address</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="phone" value="${sessionScope.acc.phone}">
                            <label for="">Phone</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" value="Email">
                            <input type="text" required name="email" value="${sessionScope.acc.email}" readonly>
                            <!--<label for="">Email</label>-->
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="date" required name="dob" value="${sessionScope.acc.dob}">
                            <label for="">Date Of Birth</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="gender" value="${sessionScope.acc.gender == true ? 'Male' : 'Female'}">
                            <label for="">Gender</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" value="Total Accumulated Point">
                            <input type="text" required name="totalAccumulatedPoint" value="${sessionScope.acc.totalAccumulatedPoint}" readonly>
                            <!--<label for="">Total Accumulated Point</label>-->
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="password" value="${sessionScope.acc.password}">
                            <label for="">Password</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="text" required name="password2" value="${sessionScope.acc.password}">
                            <label for="">Re-enter Password</label>
                        </div>
                        <button>Update Account</button>
                    </form>
                    <br>
                    <br>
                    <p style="color:red">${msg != null ? msg : ""}</p>
                    <form action="LoginServlet" method="POST">
                        <tr>
                            <td>
                                <button type="submit">Back To HomePage</button>
                            </td>
                        </tr>
                    </form>
                </div>
            </div>
        </section>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>
