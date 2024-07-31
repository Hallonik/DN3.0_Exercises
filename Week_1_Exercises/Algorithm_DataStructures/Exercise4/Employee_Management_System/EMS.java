package Algorithm_DataStructures.Exercise4.Employee_Management_System;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

public class EMS {
    private Employee[] employees;
    private int size;

    public EMS(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee database is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getEmployeeId() == employeeId) {
                System.out.println("Employee deleted: " + employees[i]);
                employees[i] = null;
                // Move the last employee record to the deleted position
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    public static void main(String[] args) {
       EMS empManagement = new EMS(5);

        empManagement.addEmployee(new Employee(101, "Alice", "Manager", 50000.0));
        empManagement.addEmployee(new Employee(202, "Bob", "Developer", 40000.0));
        empManagement.addEmployee(new Employee(303, "Charlie", "Analyst", 35000.0));

        System.out.println("\nTraversing all employees:");
        empManagement.traverseEmployees();

        System.out.println("\nSearch for employee with ID 202:");
        Employee foundEmployee = empManagement.searchEmployee(202);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 202:");
        empManagement.deleteEmployee(202);

        System.out.println("\nTraversing all employees after deletion:");
        empManagement.traverseEmployees();
    }
}


