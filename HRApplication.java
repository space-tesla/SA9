import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Spring Configuration
@Configuration
@ComponentScan
class AppConfig {}

// Employee Class (Model)
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
}

// HR Service (Spring Bean)
@Component
class HRService {
    private List<Employee> employees = new ArrayList<>();

    public HRService() {
        // default employees
        employees.add(new Employee("Ram", "Developer"));
        employees.add(new Employee("Sita", "Tester"));
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

// Main Application
public class HRApplication {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HRService hr = context.getBean(HRService.class);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role: ");
        String role = sc.nextLine();

        hr.addEmployee(name, role);

        System.out.println("\n=== HR Employee List ===");
        for (Employee e : hr.getAllEmployees()) {
            System.out.println("Name: " + e.getName() + ", Role: " + e.getRole());
        }

        sc.close();
    }
}
