import java.util.*;

public class S3Q2 {
    public static void main(String args[]) {
        LinkedList<String> l1 = new LinkedList<String>();
        l1.add("Apple");
        l1.add("Banana");
        l1.add("Orange");

        System.out.println("\nOriginal linked list: ");
        System.out.println(l1);

        l1.removeFirst();
        System.out.println("\nLinked list after removing the first element: ");
        System.out.println(l1);

        System.out.println("\n- Linked list in reverse order -\n");
        ListIterator<String> itr = l1.listIterator(l1.size());
        while (itr.hasPrevious())
            System.out.println(itr.previous());
    }
}
