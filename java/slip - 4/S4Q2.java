import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class S4Q2 extends JFrame {
    private Map<String, String> cityCodes;
    private JTextField cityNameTextField;
    private JTextField stdCodeTextField;

    public S4Q2() {
        cityCodes = new HashMap<>();
        setTitle("City Code App");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        cityNameTextField = new JTextField(20);
        stdCodeTextField = new JTextField(20);

        JButton addButton = new JButton("Add City");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCity();
            }
        });

        JButton removeButton = new JButton("Remove City");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCity();
            }
        });

        JButton searchButton = new JButton("Search City");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCity();
            }
        });

        panel.add(new JLabel("City Name:"));
        panel.add(cityNameTextField);
        panel.add(new JLabel("STD Code:"));
        panel.add(stdCodeTextField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);

        add(panel);
    }

    private void addCity() {
        String cityName = cityNameTextField.getText().trim();
        String stdCode = stdCodeTextField.getText().trim();
        if (!cityName.isEmpty() && !stdCode.isEmpty()) {
            if (!cityCodes.containsKey(cityName)) {
                cityCodes.put(cityName, stdCode);
                JOptionPane.showMessageDialog(this, "City added successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "City already exists. Please use a different name.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both City Name and STD Code.");
        }
        clearFields();
    }

    private void removeCity() {
        String cityName = cityNameTextField.getText().trim();
        if (!cityName.isEmpty()) {
            if (cityCodes.containsKey(cityName)) {
                cityCodes.remove(cityName);
                JOptionPane.showMessageDialog(this, "City removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "City not found in the collection.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter City Name to remove.");
        }
        clearFields();
    }

    private void searchCity() {
        String cityName = cityNameTextField.getText().trim();
        if (!cityName.isEmpty()) {
            if (cityCodes.containsKey(cityName)) {
                String stdCode = cityCodes.get(cityName);
                JOptionPane.showMessageDialog(this, "STD Code for " + cityName + ": " + stdCode);
            } else {
                JOptionPane.showMessageDialog(this, "City not found in the collection.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter City Name to search.");
        }
        clearFields();
    }

    private void clearFields() {
        cityNameTextField.setText("");
        stdCodeTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                S4Q2 app = new S4Q2();
                app.setVisible(true);
            }
        });
    }
}
