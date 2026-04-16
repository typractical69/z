<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && username.equals(password)) {
    %>
        <h1>Login Successfully</h1>
    <%
        } else if (username != null && password != null) {
            response.sendRedirect("Error.html");
        } else {
    %>
        <h2>Login</h2>
        <form action="" method="post">
            Username: <input type="text" name="username"><br><br>
            Password: <input type="password" name="password"><br><br>
            <input type="submit" value="Login">
        </form>
    <%
        }
    %>
</body>
</html>
