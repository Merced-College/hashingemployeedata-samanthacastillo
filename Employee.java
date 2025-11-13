import java.util.Objects;

public class Employee { //Samantha Castillo
    String lastName;
    String firstName;
    String jobTitle;
    String department;
    double annualSalary;
    double estimatedAnnualMinusFurloughs;

    public Employee(String lastName, String firstName, String jobTitle,
                    String department, double annualSalary, double estimatedAnnualMinusFurlough) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.annualSalary = annualSalary;
        this.estimatedAnnualMinusFurloughs = estimatedAnnualMinusFurlough;
     } // end public employee

     //no argument constructors
     public Employee() {
        this.lastName = "";
        this.firstName = "";
        this.jobTitle = "";
        this.department = "";
        this.annualSalary = 0.0;
        this.estimatedAnnualMinusFurloughs = 0.0;
    } // end constructor

    //getters and setters
     public void setLastName (String lastName) {
            this.lastName = lastName;
        }
    
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setJobTitle (String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void Department (String department) {
        this.department = department;
    }

    public void annualSalary (double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void EstimatedAnnualMinusFurloughs (double estimatedAnnualMinusFurloughs) {
        this.estimatedAnnualMinusFurloughs = estimatedAnnualMinusFurloughs;
    }

    //hashtable equals and to string
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
               Objects.equals(lastName, employee.lastName) &&
               Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + department + ")";
    }

    public String getLastName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }
} //end class
