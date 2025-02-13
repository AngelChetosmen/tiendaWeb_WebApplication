package com.mycompany.tiendaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tiendita";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                System.out.println("Producto: " + rs.getString("Nombre"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
