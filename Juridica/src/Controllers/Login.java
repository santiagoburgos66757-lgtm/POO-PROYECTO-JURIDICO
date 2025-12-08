package Controllers;


import Coneccion.Coneccion;
import Interfaces.LoginInterface;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import static Coneccion.Coneccion.getConnection;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login extends UsuarioCliente implements LoginInterface {


    public boolean  iniciarSesion(String emailUsu, String contraseñaUsu){

        boolean respuesta = false;

        String sql = "SELECT * FROM bd_juridica.login where emailUsu ='"+emailUsu +"'";

        Statement stmt;
        ResultSet result;



        try{

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);

            if (result.next()) {
                setCedula(result.getInt("cedula"));
                email = result.getString("emailUsu");
                contraseña = result.getString("contraseñaUsu");
                System.out.println(email +" "+ contraseña );
                if(email.equals(emailUsu))  {

                    if(Objects.equals(contraseñaUsu, contraseña)) {
                        showMessageDialog(null,"Inicio de sesion correcto");

                        respuesta = true;
                    } else {
                        showMessageDialog(null,"Contraseña Incorrecta");

                    }
                } else {
                    showMessageDialog(null,"Email Incorrecto");


                }
            }else {
                showMessageDialog(null,"Usuario no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return respuesta;

    }
    public String consultarTipoUsu(String emailUsu, String contraseñaUsu){

        String tipoUsu = null;

        String sql = "SELECT * FROM bd_juridica.login where emailUsu ='"+emailUsu +"'";

        Statement stmt;
        ResultSet result;



        try{

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);

            if (result.next()) {

                tipoUsu = result.getString("tipoUsu");
                System.out.println(tipoUsu);
                if(email.equals(emailUsu))  {

                    if(Objects.equals(contraseñaUsu, contraseña) && tipoUsu.equals("ADMINISTRADOR")) {


                        tipoUsu = "ADMINISTRADOR";
                    } else {
                        tipoUsu = "CLIENTE";

                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return tipoUsu;

    }

}
