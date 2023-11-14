package com.example.comp1011200540101test1.Controller;

import com.example.comp1011200540101test1.Misc.DBHandler;
import com.example.comp1011200540101test1.Model.Employee;
import com.example.comp1011200540101test1.DL.EmployeeDL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Date;

public class MainPageController {
    @FXML
    private Label avgSalary;

    @FXML
    private BarChart<?, ?> chart;

    @FXML
    private TableView<Employee> dataTable;

    @FXML
    private TextField filterLstTxt;

    @FXML
    private Label numOfEmployee;


    @FXML
    private void initialize(){

    }
    public void updateTable(ArrayList<Employee> employeeList) {
        ObservableList<Employee> observableEmployeeList = FXCollections.observableArrayList(employeeList);
        // Clear existing items in the table
        dataTable.getItems().clear();

        // Create columns for the TableView
        TableColumn<Employee, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().iDProperty().asObject());

        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());

        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());


        // Add the columns to the TableView
        dataTable.getColumns().setAll(idColumn, firstNameColumn, lastNameColumn, departmentColumn, emailColumn, salaryColumn);

        // Add the list of employees to the TableView
        dataTable.setItems(observableEmployeeList);
    }

}
