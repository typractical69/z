import java.sql.*;

public class S26Q1 {
    public static void main(String args[]) {
        int empId = Integer.parseInt(args[0]);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");

            PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM Employee WHERE eno = ?");
            pstmt.setInt(1, empId);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0)
                System.out.println("\nDetails of employee with ID " + empId +
                    " deleted successfully!");
            else
                System.out.println("Employee with ID " + empId + " not found.");

            pstmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
