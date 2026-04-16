import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class S14Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the string to search: ");
        String searchString = sc.nextLine();
        sc.close();

        File folder = new File(System.getProperty("user.dir"));
        File[] files = folder.listFiles();

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(files.length);
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    executor.execute(new SearchTask(file, searchString));
                }
            }
            executor.shutdown();
        }
    }

    private static class SearchTask implements Runnable {
        private File file;
        private String searchString;

        public SearchTask(File file, String searchString) {
            this.file = file;
            this.searchString = searchString;
        }

        public void run() {
            searchInFile(file);
        }

        private void searchInFile(File file) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(searchString)) {
                        System.out.println("\nFound in file: " + file.getName() +
                            ", Line: " + lineNumber);
                    }
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
