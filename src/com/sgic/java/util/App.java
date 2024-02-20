package com.sgic.java.util;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EmployeeTable employeeTable = new EmployeeTable();
        List<Employee> filteredEmployees = employeeTable.filterAndInsertEmployees("employee.xml");

        // Display filtered employees
        System.out.println("Filtered Employees:");
        for (Employee employee : filteredEmployees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("----------------------");
        }
    }
}
