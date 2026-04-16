import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class S1Q2 extends JFrame implements ActionListener {
    JLabel enoLabel, enameLabel, designationLabel, salaryLabel;
    JTextField enoField, enameField, designationField, salaryField;
    JButton saveBtn, displayBtn;
    JPanel panel, displayPanel;

    public S1Q2() {
        setTitle("Employee Detail Form");
        panel = new JPanel(new GridLayout(5, 2));
        displayPanel = new JPanel(new BorderLayout());

        enoLabel = new JLabel("Employee Number:");
        panel.add(enoLabel);
        enoField = new JTextField(20);
        panel.add(enoField);

        enameLabel = new JLabel("Employee Name:");
        panel.add(enameLabel);
        enameField = new JTextField(20);
        panel.add(enameField);

        designationLabel = new JLabel("Employee Designation:");
        panel.add(designationLabel);
        designationField = new JTextField(20);
        panel.add(designationField);

        salaryLabel = new JLabel("Employee Salary:");
        panel.add(salaryLabel);
        salaryField = new JTextField(20);
        panel.add(salaryField);

        saveBtn = new JButton("Save Details");
        saveBtn.addActionListener(this);
        panel.add(saveBtn);

        displayBtn = new JButton("Display Details");
        displayBtn.addActionListener(this);
        panel.add(displayBtn);

        add(panel, BorderLayout.PAGE_START);
        add(displayPanel, BorderLayout.CENTER);
        setSize(450, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn)
            saveEmployeeDetails();
        else if (e.getSource() == displayBtn)
            displayEmployeeDetails();
    }

    public void saveEmployeeDetails() {
        String strEno = enoField.getText();
        int eno = Integer.parseInt(strEno);
        String ename = enameField.getText();
        String designation = designationField.getText();
        String salary = salaryField.getText();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Employee (ENO, ENAME, DESIGNATION, SALARY) VALUES (?, ?, ?, ?)");
            ps.setInt(1, eno);
            ps.setString(2, ename);
            ps.setString(3, designation);
            ps.setString(4, salary);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee details saved successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save employee details",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void displayEmployeeDetails() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Employee Number");
            model.addColumn("Employee Name");
            model.addColumn("Employee Designation");
            model.addColumn("Employee Salary");
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("ENO"),
                    rs.getString("ENAME"),
                    rs.getString("DESIGNATION"),
                    rs.getString("SALARY")
                };
                model.addRow(row);
            }
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            displayPanel.removeAll();
            displayPanel.add(scrollPane);
            displayPanel.revalidate();
            displayPanel.repaint();
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new S1Q2();
    }
}
