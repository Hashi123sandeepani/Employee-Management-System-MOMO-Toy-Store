/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SystemManager {

   private static final List<Employee> employeeList = new ArrayList<>();
    private static int employeeIdCounter = 1;

    // Admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    // Admin login method
    public static boolean adminLogin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    // Add a new employee
    public static void addEmployee(String name, double salary, String password) {
        Employee employee = new Employee(employeeIdCounter++, name, salary, password);
        employeeList.add(employee);
    }

    // Update existing employee
    public static boolean updateEmployee(int id, String newName, double newSalary, String newPassword) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setSalary(newSalary);
            emp.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // Delete employee
    public static boolean deleteEmployee(int id) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            return true;
        }
        return false;
    }

    // View all employees
    public static List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Search employee by name
    public static List<Employee> searchEmployeeByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }

    // Sort employees by salary
    public static List<Employee> sortEmployeesBySalary() {
        List<Employee> sortedList = new ArrayList<>(employeeList);
        Collections.sort(sortedList, Comparator.comparingDouble(Employee::getSalary));
        return sortedList;
    }

    // Employee login method
    public static Employee employeeLogin(int id, String password) {
        Employee emp = getEmployeeById(id);
        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }
        return null;
    }

    // Get employee by ID
    public static Employee getEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}
