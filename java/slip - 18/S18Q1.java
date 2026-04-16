// Slip 18 Q1 is a repeat of Slip 15 Q1
// Write a java program to display name and priority of a Thread.

public class S18Q1 {
    public static void main(String args[]) {
        Thread thread = Thread.currentThread();
        System.out.println("\nThread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}
