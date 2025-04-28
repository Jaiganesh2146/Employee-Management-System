import java.util.ArrayList;
import java.util.Scanner;

 class EmployeeManagement {

    // Employee class inside the same file
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

    // Main method and logic
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0; // Initialize choice to a default value

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            // Handle invalid input for menu choice
            try {
                choice = sc.nextInt();
                sc.nextLine();  // consume the leftover newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                sc.nextLine(); // clear the buffer
                continue;
            }

            switch (choice) {
                case 1 -> addEmployee(sc, list);
                case 2 -> viewEmployees(list);
                case 3 -> updateEmployee(sc, list);
                case 4 -> deleteEmployee(sc, list);
                case 5 -> searchEmployee(sc, list);
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }

    static void addEmployee(Scanner sc, ArrayList<Employee> list) {
        int id;
        String name, dept;

        // Handle invalid input for employee details
        try {
            System.out.print("Enter ID: ");
            id = sc.nextInt();
            sc.nextLine(); // clear the buffer
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            System.out.print("Enter Department: ");
            dept = sc.nextLine();
            list.add(new Employee(id, name, dept));
            System.out.println("Employee added.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // clear the buffer
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

    static void updateEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter ID to update: ");
        int id;
        try {
            id = sc.nextInt();
            sc.nextLine(); // consume the newline character
        } catch (Exception e) {
            System.out.println("Invalid ID. Please try again.");
            sc.nextLine(); // clear the buffer
            return;
        }

        for (Employee e : list) {
            if (e.id == id) {
                System.out.println("Employee found. What would you like to update?");
                System.out.println("1. Name");
                System.out.println("2. Department");
                System.out.println("3. Both");
                System.out.print("Enter your choice: ");
                
                int updateChoice;
                try {
                    updateChoice = sc.nextInt();
                    sc.nextLine(); // consume the newline character
                } catch (Exception ex) {
                    System.out.println("Invalid choice. Please try again.");
                    sc.nextLine(); // clear the buffer
                    return;
                }

                switch (updateChoice) {
                    case 1 -> {
                        System.out.print("Enter new Name: ");
                        e.name = sc.nextLine();
                    }
                    case 2 -> {
                        System.out.print("Enter new Department: ");
                        e.department = sc.nextLine();
                    }
                    case 3 -> {
                        System.out.print("Enter new Name: ");
                        e.name = sc.nextLine();
                        System.out.print("Enter new Department: ");
                        e.department = sc.nextLine();
                    }
                    default -> System.out.println("Invalid choice.");
                }
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void deleteEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter ID to delete: ");
        int id;
        try {
            id = sc.nextInt();
            sc.nextLine(); // consume the newline character
        } catch (Exception e) {
            System.out.println("Invalid ID. Please try again.");
            sc.nextLine(); // clear the buffer
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void searchEmployee(Scanner sc, ArrayList<Employee> list) {
        System.out.print("Enter ID to search: ");
        int id;
        try {
            id = sc.nextInt();
            sc.nextLine(); // consume the newline character
        } catch (Exception e) {
            System.out.println("Invalid ID. Please try again.");
            sc.nextLine(); // clear the buffer
            return;
        }

        for (Employee e : list) {
            if (e.id == id) {
                System.out.println("Employee Found:");
                e.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    }
