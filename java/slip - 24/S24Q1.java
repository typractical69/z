import javax.swing.*;

public class S24Q1 extends JFrame implements Runnable {
    private JLabel label;

    public S24Q1() {
        setTitle("Text Scrolling");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("This is the scrolling text!");
        add(label);

        Thread thread = new Thread(this);
        thread.start();

        setVisible(true);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                String text = label.getText();
                text = text.substring(1) + text.charAt(0);
                label.setText(text);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new S24Q1();
    }
}
