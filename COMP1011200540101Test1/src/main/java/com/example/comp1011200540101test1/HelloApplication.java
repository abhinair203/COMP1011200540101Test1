package com.example.comp1011200540101test1;

import com.example.comp1011200540101test1.Misc.DBHandler;
import com.example.comp1011200540101test1.Model.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Employee e=new Employee(2,"ABC","ABC", new Date(),"HR","abc@gmail.com",50000);
        Connection con= DBHandler.getDBConnection();
        Image icon = new Image(getClass().getResourceAsStream("icon.jpg"));
        stage.getIcons().add(icon);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}