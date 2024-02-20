package com.sgic.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EmployeeTable {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/book_reader_xml";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public List<Employee> filterAndInsertEmployees(String filename) {
        List<Employee> filteredEmployees = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filename);

            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String position = element.getElementsByTagName("position").item(0).getTextContent();
                if ("Quality Engineer".equals(position)) {
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                    employee.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    employee.setPosition(position);
                    employee.setDepartment(element.getElementsByTagName("department").item(0).getTextContent());
                    filteredEmployees.add(employee);
                    insertEmployeeToDatabase(employee);
                }
            }
            System.out.println("Filtered employees inserted successfully into the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredEmployees;
    }

    private void insertEmployeeToDatabase(Employee employee) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO employees (id, name, position, department) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setString(3, employee.getPosition());
                statement.setString(4, employee.getDepartment());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
