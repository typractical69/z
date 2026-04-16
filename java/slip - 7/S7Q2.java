import java.sql.*;

public class S7Q2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            Statement stmt = con.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS Product(" +
                "PID int primary key, PNAME varchar(20), PRICE int)");
            System.out.println("Table created successfully!");

            insertRecords(stmt);
            displayRecords(stmt);

            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void insertRecords(Statement stmt) throws SQLException {
        String insertSQL = "INSERT INTO Product (PID, PNAME, PRICE) VALUES ";
        String[] records = {
            "(1, 'A', 12)",
            "(2, 'B', 32)",
            "(3, 'C', 24)",
            "(4, 'D', 14)",
            "(5, 'E', 10)"
        };
        for (String record : records)
            stmt.executeUpdate(insertSQL + record);
        System.out.println("\nRecords inserted into product table successfully!");
    }

    private static void displayRecords(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
        System.out.println("\n- Records from Product Table -\n");
        System.out.println("\nPID\tPNAME\tPRICE");
        while (rs.next()) {
            int pid = rs.getInt("PID");
            String pname = rs.getString("PNAME");
            int price = rs.getInt("PRICE");
            System.out.println(pid + "\t" + pname + "\t" + price);
        }
        rs.close();
    }
}
