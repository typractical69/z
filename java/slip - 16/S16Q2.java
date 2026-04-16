import java.sql.*;

public class S16Q2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");

            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Teacher " +
                "(TNO int primary key, TNAME varchar(20), SUBJECT varchar(20))");
            System.out.println("Table exists / created!");

            System.out.println("Inserting values into the table...");
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO Teacher(TNO, TNAME, SUBJECT) VALUES (?, ?, ?)");
            insertTeacher(pstmt, 101, "Taskar", "JAVA");
            insertTeacher(pstmt, 102, "Mahale", "DSA");
            insertTeacher(pstmt, 103, "Deore", "C");
            insertTeacher(pstmt, 104, "Patil", "CN");
            insertTeacher(pstmt, 105, "Kapse", "OS");
            System.out.println("\nRecords inserted successfully!");

            System.out.println("\nDisplaying details of teachers teaching 'JAVA' subject...");
            pstmt = con.prepareStatement("SELECT * FROM Teacher WHERE SUBJECT = ?");
            pstmt.setString(1, "JAVA");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("\nTeacher No.: " + rs.getInt("TNO"));
                System.out.println("Teacher Name: " + rs.getString("TNAME"));
                System.out.println("Subject: " + rs.getString("SUBJECT"));
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void insertTeacher(PreparedStatement pstmt, int tno,
            String tname, String sub) throws SQLException {
        pstmt.setInt(1, tno);
        pstmt.setString(2, tname);
        pstmt.setString(3, sub);
        pstmt.executeUpdate();
    }
}
