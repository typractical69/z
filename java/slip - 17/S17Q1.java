import java.util.*;

public class S17Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        System.out.print("\nEnter the number of integers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            set.add(sc.nextInt());
        }

        System.out.println("\nSorted set without duplicates:-");
        for (int num : set)
            System.out.println(num);

        sc.close();
    }
}
