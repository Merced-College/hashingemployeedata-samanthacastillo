import java.util.ArrayList;

public class Crud { //Samantha Castillo
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // add employees
        Employee e1 = new Employee("Bieber", "Justin", "Manager", "Target", 80000, 9000000);
        Employee e2 = new Employee("Uchis", "Kali", "Accountant", "Walmart", 800090, 90005000);

        employees.add(e1);
        employees.add(e2);

        for (Employee e : employees) {
            System.out.println("Added employee: " + e);
        }

        // search employee
        System.out.println("\nSearching for employee");
        String searchLastName = "Bieber";
        boolean found = false;

        for (Employee e : employees) {
            if (e.lastName.equalsIgnoreCase(searchLastName)) {
                System.out.println("Found employee: " + e);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }

        // remove employee
        System.out.println("\nRemoving employee");
        Employee toRemove = e2;
        if (employees.remove(toRemove)) {
            System.out.println("Removed employee: " + toRemove);
        } else {
            System.out.println("Could not remove employee: " + toRemove);
        }

        //remaining employees
        System.out.println("\nEmployees left:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
