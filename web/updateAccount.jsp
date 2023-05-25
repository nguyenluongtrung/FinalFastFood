<%-- 
    Document   : updateAccount
    Created on : May 24, 2023, 5:02:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <p style="color:red">${ms != null ? ms : ""}</p>
        </form>
    </body>
</html>
