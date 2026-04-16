import java.sql.*;

public class S11Q2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Donor");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.println("\n- Columns in the DONOR table -\n");
            System.out.println("--------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + rsmd.getColumnName(i));
                System.out.println("Data Type: " + rsmd.getColumnTypeName(i));
                System.out.println("Column Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
