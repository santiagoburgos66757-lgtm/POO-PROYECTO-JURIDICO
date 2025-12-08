package Controllers;
import Coneccion.Coneccion;
import Interfaces.RegistroInterface;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Objects;

import static Coneccion.Coneccion.getConnection;
import static javax.swing.JOptionPane.showMessageDialog;

public class UsuarioCliente extends Usuario implements RegistroInterface {
    private int plan = 1;
    private String tipoUsu = "CLIENTE";

    public int getPlan() {
        return plan;
    }




    public void Registro( String nombre, String apellido , String password , String email , int cedula, String telefono, int edad, String direccion) {

        Coneccion coneccion = new Coneccion();

        String sql = "INSERT INTO usuario(cedula,nombre,apellido,email,telefono,direccion,edad,contraseña,tipousuario,plan) " +
                "VALUES ('"+cedula+"','"+nombre+"','"+apellido+"','"+email+"','"+telefono+"','"+direccion+"','"+edad+"','"+password+"','"+tipoUsu+"','"+plan+"')";

        int result;
        Statement stmt;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
            showMessageDialog(null,"Usuario registrado correctamente");
            registrarlogin(cedula,email,password);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }



    public void registrarlogin(int cedula, String email, String contraseña){

        String sql = "INSERT INTO login(cedula,emailUsu,contraseñaUsu,tipoUsu) " +
                "VALUES ('"+cedula+"','"+email+"','"+contraseña+"','"+tipoUsu+"')";

        int result;
        Statement stmt;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getTipoUsuario() {
       return tipoUsu;
    }
}
