package Coneccion;

import Controllers.Usuario;

import java.sql.*;
import java.sql.Statement;
import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Coneccion
{
    static String URL = "jdbc:mysql://localhost:3306/bd_juridica";
    static String USER = "root";
    static String PASSWORD = "";
     Statement stmt;



    public static Connection getConnection(){

        Connection conexion = null;



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            System.out.println("error 2");
        }

            return  conexion;
    }
}
