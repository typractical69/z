import java.util.Random;

class NumberGenerator extends Thread {
    Random random = new Random();
    NumberProcessor processor;

    public NumberGenerator(NumberProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        while (true) {
            int num = random.nextInt(100);
            processor.processNumber(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class NumberProcessor {
    public synchronized void processNumber(int num) {
        if (num % 2 == 0)
            new SquareCalculator(num).start();
        else
            new CubeCalculator(num).start();
    }
}

class SquareCalculator extends Thread {
    int num;

    public SquareCalculator(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("\nSquare of " + num + " is " + (num * num));
    }
}

class CubeCalculator extends Thread {
    int num;

    public CubeCalculator(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("\nCube of " + num + " is " + (num * num * num));
    }
}

public class S7Q1 {
    public static void main(String args[]) {
        NumberProcessor processor = new NumberProcessor();
        new NumberGenerator(processor).start();
    }
}
