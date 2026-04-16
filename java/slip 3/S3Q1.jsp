<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Details</title>
</head>
<body>
    <h2>Patient Details</h2>
    <table border="1">
        <tr>
            <th>Patient Number</th>
            <th>Patient Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Disease</th>
        </tr>
        <%
            String[][] patients = {
                {"P001", "John Doe",       "123 Main St", "35", "Fever"},
                {"P002", "Jane Smith",     "456 Elm St",  "42", "Headache"},
                {"P003", "David Johnson",  "789 Oak St",  "28", "Allergy"}
            };
            for (String[] patient : patients) {
        %>
        <tr>
            <td><%= patient[0] %></td>
            <td><%= patient[1] %></td>
            <td><%= patient[2] %></td>
            <td><%= patient[3] %></td>
            <td><%= patient[4] %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
