import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class S12Q2 extends JFrame implements ActionListener {
    private JLabel pidLabel, pnameLabel, pdescLabel, pstatusLabel;
    private JTextField pidField, pnameField, pdescField, pstatusField;
    private JButton insertButton, displayButton, resetButton;
    private JPanel inputPanel, displayPanel;
    private Connection con;
    private JTable table;

    S12Q2() {
        pidLabel = new JLabel("PID:");
        pnameLabel = new JLabel("Name:");
        pdescLabel = new JLabel("Description:");
        pstatusLabel = new JLabel("Status:");

        pidField = new JTextField(20);
        pnameField = new JTextField(20);
        pdescField = new JTextField(20);
        pstatusField = new JTextField(20);

        insertButton = new JButton("INSERT");
        displayButton = new JButton("DISPLAY");
        resetButton = new JButton("RESET");

        insertButton.addActionListener(this);
        displayButton.addActionListener(this);
        resetButton.addActionListener(this);

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(pidLabel);
        inputPanel.add(pidField);
        inputPanel.add(pnameLabel);
        inputPanel.add(pnameField);
        inputPanel.add(pdescLabel);
        inputPanel.add(pdescField);
        inputPanel.add(pstatusLabel);
        inputPanel.add(pstatusField);
        inputPanel.add(insertButton);
        inputPanel.add(displayButton);
        inputPanel.add(resetButton);

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Display"));

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

        setSize(500, 300);
        setTitle("Project Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertButton) {
            insertRecord();
        } else if (e.getSource() == displayButton) {
            displayRecords();
        } else if (e.getSource() == resetButton) {
            resetFields();
        }
    }

    private void insertRecord() {
        int pid = Integer.parseInt(pidField.getText());
        String pname = pnameField.getText();
        String pdesc = pdescField.getText();
        String pstatus = pstatusField.getText();
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            }
            String sql = "INSERT INTO project VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, pid);
                ps.setString(2, pname);
                ps.setString(3, pdesc);
                ps.setString(4, pstatus);
                int n = ps.executeUpdate();
                if (n != 0) {
                    JOptionPane.showMessageDialog(this, "Record inserted successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to insert record.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void displayRecords() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ty92", "ty92", "ty92");
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project");
            Vector<String> columnNames = new Vector<>();
            Vector<Vector<Object>> data = new Vector<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();

            for (int i = 1; i <= columns; i++)
                columnNames.addElement(rsmd.getColumnName(i));

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columns; i++)
                    row.addElement(rs.getObject(i));
                data.addElement(row);
            }

            table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            displayPanel.removeAll();
            displayPanel.add(scrollPane, BorderLayout.CENTER);
            displayPanel.revalidate();
            displayPanel.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void resetFields() {
        pidField.setText("");
        pnameField.setText("");
        pdescField.setText("");
        pstatusField.setText("");
    }

    public static void main(String args[]) {
        new S12Q2();
    }
}
