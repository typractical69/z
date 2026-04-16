public class S28Q2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        System.out.println("Main thread name: " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Currently executing thread name: " +
            Thread.currentThread().getName());
    }
}
