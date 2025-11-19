import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.*; 
import org.springframework.stereotype.Component; 
 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
 
// Configuration class 
@Configuration 
@ComponentScan 
class AppConfig {} 
 
// Employee class 
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
 
// HR Service 
@Component 
class HRService { 
    private List<Employee> employees = new ArrayList<>(); 
 
    public HRService() { 
        // default employees 
        employees.add(new Employee("Ram", "Developer")); 
        employees.add(new Employee("Vaibhav", "Tester")); 
    } 
 
    public void addEmployee(String name, String role) { 
        employees.add(new Employee(name, role)); 
    } 
 
    public List<Employee> getAllEmployees() { 
        return employees; 
    } 
} 
 
// Main class 
public class slip9a { 
    public static void main(String[] args) { 
        ApplicationContext context = new 
AnnotationConfigApplicationContext(AppConfig.class); 
        HRService hr = context.getBean(HRService.class); 
 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter employee name: "); 
        String name = sc.nextLine(); 
        System.out.print("Enter employee role: "); 
        String role = sc.nextLine(); 
 
        hr.addEmployee(name, role); 
 
        System.out.println("\n=== HR Employee List ==="); 
        for(Employee e : hr.getAllEmployees()) { 
            System.out.println("Name: " + e.getName() + ", Role: " + e.getRole()); 
        } 
 
sc.close(); 
} 
} 
/* 
Example Input (from terminal): 
Enter employee name: Sita 
Enter employee role: Manager 
Example Output: 
=== HR Employee List === 
Name: Ram, Role: Developer 
*/ 
/* 
IMPORTANT: 
You need Spring framework JARs in a folder named "libs" in the same directory. 
Required JARs: spring-core, spring-context, spring-beans, spring-expression 
Windows: 
javac -cp "libs/*" slip9a.java 
java -cp ".;libs/*" slip9a 
Linux/Mac: 
javac -cp "libs/*" slip9a.java 
java -cp ".:libs/*" slip9a 
*/