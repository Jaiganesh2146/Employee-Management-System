import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static class Employee {
        int id;
        String name;
        String department;

        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        public void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> addEmployee(sc, list);
                case 2 -> viewEmployees(list);
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }

    static void addEmployee(Scanner sc, ArrayList<Employee> list) {
        int id;
        String name, dept;

        try {
            System.out.print("Enter ID: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            System.out.print("Enter Department: ");
            dept = sc.nextLine();
            list.add(new Employee(id, name, dept));
            System.out.println("Employee added.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }

    static void viewEmployees(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee e : list) {
            e.display();
        }
    }
}
