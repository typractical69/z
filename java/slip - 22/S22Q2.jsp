<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Greeting</title>
</head>
<body>
    <h2>Greeting</h2>
    <form action="" method="post">
        Enter your name: <input type="text" name="username"><br>
        <input type="submit" value="Submit">
    </form>

    <%
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            String greeting;

            if (hour >= 5 && hour < 12)
                greeting = "Good Morning, " + username + "!";
            else if (hour >= 12 && hour < 17)
                greeting = "Good Afternoon, " + username + "!";
            else if (hour >= 17 && hour < 21)
                greeting = "Good Evening, " + username + "!";
            else
                greeting = "Good Night, " + username + "!";
    %>
    <p><%= greeting %></p>
    <%
        }
    %>
</body>
</html>
