package com.example.comp1011200540101test1.DL;

import com.example.comp1011200540101test1.Misc.DBHandler;
import com.example.comp1011200540101test1.Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeDL {
    public static ArrayList<Employee> getLst(){
        ArrayList<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DBHandler.getDBConnection()) {
            String query = "SELECT ID, firstName, lastName, salary, email, birthday, department FROM employees ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    double salary = resultSet.getDouble("salary");
                    String email = resultSet.getString("email");
                    Date birthday = new Date(resultSet.getTimestamp("birthday").getTime());
                    String department = resultSet.getString("department");

                    Employee employee = new Employee(id, firstName, lastName, birthday, department, email,salary);
                    employeeList.add(employee);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
    public static float getAvgSalary(){

        try (Connection connection = DBHandler.getDBConnection()) {
            String query = "Select avg(salary) average from employees";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    float average = resultSet.getFloat("average");
                    return average;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static int getTotalEmployee() {
        try (Connection connection = DBHandler.getDBConnection()) {
            String query = "Select count(salary) average from employees";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int num = resultSet.getInt("average");
                    return num ;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
