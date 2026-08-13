package pack01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PackageExplorer {
    public static void main(String[] args) {
        String title = "Weekend Trip";
        List<String> destinations = new ArrayList<>();
        destinations.add("Seoul");
        destinations.add("Busan");
        destinations.add("Jeju");

        java.util.Random random = new java.util.Random(7);
        String selected = destinations.get(random.nextInt(destinations.size()));

        System.out.println("Current class: " + PackageExplorer.class.getName());
        System.out.println("Current package: " + PackageExplorer.class.getPackageName());
        System.out.println("String package: " + title.getClass().getPackageName());
        System.out.println("List implementation: " + destinations.getClass().getName());
        System.out.println("Travel date: " + LocalDate.now());
        System.out.println("Random destination: " + selected);
    }
}
