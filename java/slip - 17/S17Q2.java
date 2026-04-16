import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class S17Q2 extends JFrame {
    JTextField textField;
    JButton startBtn;

    public S17Q2() {
        setTitle("Number Display");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        add(textField);

        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startDisplay();
            }
        });
        add(startBtn);

        setVisible(true);
    }

    private void startDisplay() {
        Thread displayThread = new Thread(new DisplayRunnable());
        displayThread.start();
    }

    private class DisplayRunnable implements Runnable {
        public void run() {
            for (int i = 1; i <= 100; i++) {
                textField.setText(Integer.toString(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            textField.setText("");
        }
    }

    public static void main(String args[]) {
        new S17Q2();
    }
}
