package org.hello;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    private static String URL = "jdbc:mysql://localhost:3306/accounting_system?user=root";
    private static String USER = "root";
    private static String PASSWORD = "123456";
    private static Connection CONNECTION = getCONNECTION();

    private static Connection getCONNECTION() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Select List Employees From DataBase
    public List<Employees> findAll() {
        List<Employees> list = new ArrayList<>();
        try {
            ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                Employees employees = new Employees();
                employees.setId(resultSet.getInt("id"));
                employees.setName(resultSet.getString("name"));
                employees.setSalary(resultSet.getInt("salary"));
                employees.setWorking_days(resultSet.getInt("working_days"));
                list.add(employees);
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Add employees
    public boolean add(Employees employees) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO employees (name, salary, working_days) VALUES (?, ?, ?);");
            preparedStatement.setString(1, employees.getName());
            preparedStatement.setInt(2, employees.getSalary());
            preparedStatement.setInt(3, employees.getWorking_days());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Get employees by id
    public Employees findById(int id) {
        Employees employee = null;
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM employees WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employees();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setWorking_days(resultSet.getInt("working_days"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Update employees
    public boolean update(Employees employees) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE employees SET name = ?, salary = ?, working_days = ? WHERE id = ?");
            preparedStatement.setString(1, employees.getName());
            preparedStatement.setInt(2, employees.getSalary());
            preparedStatement.setInt(3, employees.getWorking_days());
            preparedStatement.setInt(4, employees.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete employees
    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("DELETE FROM employees WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
