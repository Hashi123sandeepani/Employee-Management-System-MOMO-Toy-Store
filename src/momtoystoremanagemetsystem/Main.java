/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package momtoystoremanagemetsystem;

import model.Employee;
import service.SystemManager;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Welcome to MOMO Toy Store Employee Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    adminLogin();
                    break;
                case "2":
                    employeeLogin();
                    break;
                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (SystemManager.adminLogin(username, password)) {
            System.out.println("Admin login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid Admin credentials!");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search Employee by Name");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> updateEmployee();
                case "3" -> deleteEmployee();
                case "4" -> viewAllEmployees();
                case "5" -> searchEmployeeByName();
                case "6" -> sortEmployeesBySalary();
                case "7" -> {
                    System.out.println("Admin logged out.");
                    return;
                }
                default -> System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary (without commas): ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        SystemManager.addEmployee(name, salary, password);
        System.out.println("Employee added successfully!");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to Update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Salary (without commas): ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter New Password: ");
        String password = scanner.nextLine();

        boolean updated = SystemManager.updateEmployee(id, name, salary, password);
        if (updated) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to Delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = SystemManager.deleteEmployee(id);
        if (deleted) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void viewAllEmployees() {
        List<Employee> employees = SystemManager.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n--- Employee List ---");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    private static void searchEmployeeByName() {
        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();
        List<Employee> employees = SystemManager.searchEmployeeByName(name);

        if (employees.isEmpty()) {
            System.out.println("No matching employees found.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    private static void sortEmployeesBySalary() {
        List<Employee> employees = SystemManager.sortEmployeesBySalary();
        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
        } else {
            System.out.println("\n--- Employees Sorted by Salary ---");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    private static void employeeLogin() {
        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Employee emp = SystemManager.employeeLogin(id, password);
        if (emp != null) {
            System.out.println("Employee login successful!");
            System.out.println("Welcome, " + emp.getName() + "!");
            
        
        // 🆕 Show employee details here
        System.out.println("\n--- Your Details ---");
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
        
   

        } else {
            System.out.println("Invalid Employee credentials!");
        }
    }
}
