import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static class Employee {
        int id;
        String name, department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        int choice;

        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(sc, list);
                    break;
                case 2:
                    viewEmployees(list);
                    break;
                case 3:
                    updateEmployee(sc, list);
                    break;
                case 4:
                    deleteEmployee(sc, list);
                    break;
                case 5:
                    searchEmployee(sc, list);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Search Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Department: ");
        String dept = sc.nextLine();

        list.add(new Employee(id, name, dept));
        System.out.println("Employee added successfully!");
    }

    static void viewEmployees(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\nEmployee List:");
        for (Employee e : list) {
            e.display();
        }
    }

    static void updateEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Employee e : list) {
            if (e.id == id) {
                System.out.print("Enter new Name: ");
                e.name = sc.nextLine();

                System.out.print("Enter new Department: ");
                e.department = sc.nextLine();

                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    static void deleteEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                System.out.println("Employee deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    static void searchEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Employee e : list) {
            if (e.id == id) {
                System.out.println("Employee Found:");
                e.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
}
