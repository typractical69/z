import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class S27Q1 extends JFrame {

    public S27Q1() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        ArrayList<College> colleges = new ArrayList<>();
        colleges.add(new College(1, "ABC College", "123 Main St", 2000));
        colleges.add(new College(2, "XYZ College", "456 Elm St",  1995));
        colleges.add(new College(3, "PQR College", "789 Oak St",  2010));

        String[] columnNames = {"CID", "CName", "Address", "Year"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (College college : colleges) {
            Object[] rowData = {
                college.getCID(),
                college.getCName(),
                college.getAddress(),
                college.getYear()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new S27Q1().setVisible(true);
    }
}

class College {
    private int CID;
    private String CName;
    private String address;
    private int year;

    public College(int CID, String CName, String address, int year) {
        this.CID = CID;
        this.CName = CName;
        this.address = address;
        this.year = year;
    }

    public int getCID()       { return CID; }
    public String getCName()  { return CName; }
    public String getAddress(){ return address; }
    public int getYear()      { return year; }
}
