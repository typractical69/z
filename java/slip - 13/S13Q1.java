import java.sql.*;

public class S13Q1 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("\nDatabase Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());

            System.out.println("\n- Tables in the Database -\n");
            ResultSet rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next())
                System.out.println(rs.getString("TABLE_NAME"));

            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
