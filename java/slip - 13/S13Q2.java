import java.util.Random;

public class S13Q2 {
    public static void main(String args[]) {
        Thread thread = new CustomThread("CustomThread");
        thread.start();
    }

    static class CustomThread extends Thread {
        public CustomThread(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + " is created.");
            Random random = new Random();
            int sleepTime = random.nextInt(5000);
            System.out.println(getName() + " will sleep for " + sleepTime + " milliseconds.");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(getName() + " is dead.");
        }
    }
}
