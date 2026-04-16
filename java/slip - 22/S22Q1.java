import java.sql.*;

public class S22Q1 {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/ty92";
    static final String USER = "ty92";
    static final String PASS = "ty92";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            boolean exit = false;
            while (!exit) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(System.console().readLine());

                switch (choice) {
                    case 1: insertEmployee(stmt); break;
                    case 2: updateEmployee(stmt); break;
                    case 3: displayEmployees(stmt); break;
                    case 4: exit = true; break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            }

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException se2) {}
            try { if (conn != null) conn.close(); } catch (SQLException se) { se.printStackTrace(); }
        }
    }

    static void insertEmployee(Statement stmt) throws SQLException {
        System.out.println("\nInsert Employee");
        System.out.print("Enter Employee Number: ");
        int eno = Integer.parseInt(System.console().readLine());
        System.out.print("Enter Employee Name: ");
        String ename = System.console().readLine();
        System.out.print("Enter Designation: ");
        String designation = System.console().readLine();
        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(System.console().readLine());

        String sql = "INSERT INTO Employee (eno, ename, designation, salary) VALUES (" +
            eno + ", '" + ename + "', '" + designation + "', " + salary + ")";
        stmt.executeUpdate(sql);
        System.out.println("Employee inserted successfully.");
    }

    static void updateEmployee(Statement stmt) throws SQLException {
        System.out.println("\nUpdate Employee");
        System.out.print("Enter Employee Number: ");
        int eno = Integer.parseInt(System.console().readLine());
        System.out.print("Enter new Salary: ");
        double salary = Double.parseDouble(System.console().readLine());

        String sql = "UPDATE Employee SET Salary=" + salary + " WHERE eno=" + eno;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0)
            System.out.println("Employee updated successfully.");
        else
            System.out.println("Employee not found.");
    }

    static void displayEmployees(Statement stmt) throws SQLException {
        System.out.println("\nEmployee List");
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
        while (rs.next()) {
            int eno = rs.getInt("eno");
            String ename = rs.getString("ename");
            String designation = rs.getString("designation");
            double salary = rs.getDouble("salary");
            System.out.println("Employee Number: " + eno +
                ", Employee Name: " + ename +
                ", Designation: " + designation +
                ", Salary: " + salary);
        }
        rs.close();
    }
}
