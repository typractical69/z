<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Prime Number Checker</title>
</head>
<body>
    <h1>Prime Number Checker</h1>
    <form action="" method="get">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Check">
    </form>

    <%!
        boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    %>

    <%
        String numberStr = request.getParameter("number");
        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            boolean isPrimeNumber = isPrime(number);
            if (isPrimeNumber) {
    %>
        <p style="color: red;"><%= number %> is a prime number.</p>
    <%
            } else {
    %>
        <p style="color: red;"><%= number %> is not a prime number.</p>
    <%
            }
        } else if (numberStr != null && numberStr.isEmpty()) {
    %>
        <p style="color: red;">Please enter a number.</p>
    <%
        }
    %>
</body>
</html>
