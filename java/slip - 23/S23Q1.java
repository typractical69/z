import java.util.*;

class VowelThread extends Thread {
    private String inputString;

    public VowelThread(String inputString) {
        this.inputString = inputString;
    }

    public void run() {
        try {
            for (int i = 0; i < inputString.length(); i++) {
                char ch = inputString.charAt(i);
                if (isVowel(ch)) {
                    System.out.println(ch);
                    Thread.sleep(3000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

public class S23Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String inputString = sc.nextLine();
        VowelThread thread = new VowelThread(inputString);
        thread.start();
        sc.close();
    }
}
