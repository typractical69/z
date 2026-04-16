<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Calculate Sum of First and Last Digits</h2>
    <form action="" method="post">
        Enter a number: <input type="text" name="number"><br>
        <input type="submit" value="Calculate">
    </form>

    <%
        String numberStr = request.getParameter("number");
        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            int firstDigit = Character.getNumericValue(numberStr.charAt(0));
            int lastDigit = number % 10;
            int sum = firstDigit + lastDigit;
    %>
    <p style="color: red; font-size: 18px;">
        Sum of first and last digit of <%= number %>: <%= sum %>
    </p>
    <%
        }
    %>
</body>
</html>
