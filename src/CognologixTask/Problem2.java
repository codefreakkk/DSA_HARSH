package CognologixTask;
import java.util.*;

public class Problem2 {

    class Employee {
        int employeeId;
        long salary;
        String name, department;
        public Employee(int employeeId, String name, String department, long salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    class Dictionary {
        String department;
        int employeeId;
        public Dictionary(String department, int employeeId) {
            this.department = department;
            this.employeeId = employeeId;
        }
    }

    // add raw data
    public void addRawData(List<Employee> data) {
        data.add(new Employee(22, "Rajan Anand", "Engineering", 1600000));
        data.add(new Employee(23, "Swati Patil", "Testing", 800000));
        data.add(new Employee(27, "Vijay Chawda", "Engineering", 800000));
        data.add(new Employee(29, "Basant Mahapatra", "Engineering", 600000));
        data.add(new Employee(32, "Ajay Patel", "Testing", 350000));
        data.add(new Employee(34, "Swaraj Birla", "Testing", 350000));
    }

    public List<Dictionary> highestSalaryInDept() {
        List<Employee> data = new ArrayList<>();
        addRawData(data);

        Set<String> departments = new HashSet<>();
        for (Employee employee : data) {
            departments.add(employee.department);
        }

        List<Dictionary> ans = new ArrayList<>();
        for (String department : departments) {
            long salary = 0;
            int employeeId = -1;

            for (Employee employee : data) {
                if (employee.department.equals(department) && employee.salary > salary) {
                    salary = employee.salary;
                    employeeId = employee.employeeId;
                }
            }
            ans.add(new Dictionary(department, employeeId));
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem2 o = new Problem2();
        List<Dictionary> ans = o.highestSalaryInDept();

        for (Dictionary it : ans) {
            System.out.println(it.department + " " + it.employeeId);
        }
    }
}
