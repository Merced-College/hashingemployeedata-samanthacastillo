import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TODO: create your ChainingHashTable using zyBook code
        //DONE
        ChainingHashTable<String, Employee> table = new ChainingHashTable<>(11);

        // TODO: make an ArrayList to store duplicate Employee objects
        //DONE
         ArrayList<Employee> duplicates = new ArrayList<>();

        // TODO: make counters to keep track of total employees and duplicates
        //DONE
        int totalLoaded = 0;
        int duplicatesFound = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Employee_data.csv"))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",", -1);
                if (cols.length < 6) continue;

                // Create the Employee object from the CSV
                Employee emp = new Employee(
                        cols[0].trim(),  // LAST NAME
                        cols[1].trim(),  // FIRST NAME
                        cols[2].trim(),  // JOB TITLE
                        cols[3].trim(),  // DEPARTMENT
                        parseMoney(cols[4]),
                        parseMoney(cols[5])
                );
               

                // Create the hash key using last + first name
                //DONE
                String key = (emp.lastName + emp.firstName).toLowerCase();
           

                // duplicate check Confirmed!
                Employee existing = table.get(key);
                 if (existing != null) {
                     if (existing.firstName.equalsIgnoreCase(emp.firstName) && existing.lastName.equalsIgnoreCase(emp.lastName)) {
                         duplicates.add(emp);
                         duplicatesFound++;
                     } else {
                         table.insert(key, emp);
                     }
                 } else {
                     table.insert(key, emp);
                     totalLoaded++;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         

        // TODO: print total employees, duplicates found, and duplicate list
        //print Chaining Hash table
        //for(int i = 0; i < table.length; i++) {
        //    System.out.print(table.getLength());
        //}
        System.out.println("Total Employees Loaded: " + totalLoaded);
        System.out.println("Duplicate Employees Found: " + duplicatesFound);
        System.out.println("List of Duplicate Employees:");
        for (Employee dup : duplicates) {
            System.out.println(dup);
        }

        //System.out.println("\n--- Hash Table Contents ---");
           // table.print(System.out);
    }

   

    // helper for cleaning up salary strings
    private static double parseMoney(String s) {
        if (s == null || s.isBlank()) return 0.0;
        try {
            return Double.parseDouble(s.replace("$", "").replace(",", "").trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}