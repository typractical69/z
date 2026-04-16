class SharedResource {
    private int value = 0;

    public synchronized void increment() {
        value++;
        System.out.println("Value incremented to: " + value);
    }

    public synchronized void decrement() {
        value--;
        System.out.println("Value decremented to: " + value);
    }
}

class IncrementThread extends Thread {
    private SharedResource res;

    public IncrementThread(SharedResource res) {
        this.res = res;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            res.increment();
    }
}

class DecrementThread extends Thread {
    private SharedResource res;

    public DecrementThread(SharedResource res) {
        this.res = res;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            res.decrement();
    }
}

public class S30Q1 {
    public static void main(String args[]) {
        SharedResource res = new SharedResource();
        IncrementThread thread1 = new IncrementThread(res);
        DecrementThread thread2 = new DecrementThread(res);
        thread1.start();
        thread2.start();
    }
}
