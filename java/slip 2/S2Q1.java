import java.util.*;

public class S2Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter total number of friends: ");
        int n = sc.nextInt();
        sc.nextLine();

        HashSet<String> friendsSet = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the name of friend " + (i + 1) + ": ");
            String name = sc.nextLine();
            friendsSet.add(name);
        }

        ArrayList<String> sortedFriendsList = new ArrayList<String>(friendsSet);
        Collections.sort(sortedFriendsList);

        System.out.println("\n- Sorted friend's list -\n");
        for (String friend : sortedFriendsList)
            System.out.println(friend);

        sc.close();
    }
}
