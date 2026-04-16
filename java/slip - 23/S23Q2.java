import java.util.*;

public class S23Q2 {
    public static void main(String args[]) {
        List<String> studentNames = new ArrayList<>();
        for (String arg : args)
            studentNames.add(arg);

        System.out.println("\nStudent names using Iterator:-");
        Iterator<String> itr = studentNames.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println("\nStudent names using ListIterator:-");
        ListIterator<String> listItr = studentNames.listIterator();
        while (listItr.hasNext())
            System.out.println(listItr.next());
    }
}
