//package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    Connection conectar = null;
 

    public Connection conexion() throws InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String dbURL = "jdbc:sqlserver://DESKTOP-8CBRJV8;databaseName=miselanea_hidalgo;encrypt = false;integratedSecurity=true;";
            conectar = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }

}
