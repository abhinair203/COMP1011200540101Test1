package com.example.comp1011200540101test1.Misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBHandler {
    private  static String username="root";
    private  static String userpass="Allahpak~1";
    private  static String DBConnectionStr="jdbc:mysql://localhost:3306/test1nair";

    public static Connection getDBConnection() {
        try {
            Connection con = DriverManager.getConnection(DBConnectionStr, username, userpass);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
