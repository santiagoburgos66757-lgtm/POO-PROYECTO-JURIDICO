package Controllers;

import Coneccion.Coneccion;
import Interfaces.RegistroConsultaInterface;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import static Coneccion.Coneccion.getConnection;
import static javax.swing.JOptionPane.showMessageDialog;

public class Consulta extends UsuarioCliente implements RegistroConsultaInterface {
    private int idConsulta;
    private String consulta;

    public Consulta() {
    }

    public void RegistroConsulta(int cedula, String consulta) {

        Coneccion coneccion = new Coneccion();


        String sql = "INSERT INTO consulta(cedula,consulta) " +
                "VALUES ('"+cedula+"','"+consulta+"')";

        int result;
        Statement stmt;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
            showMessageDialog(null,"Consulta Registrada");



        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public ResultSet HistoricoConsulta(int cedula) {


        String sql = "SELECT * FROM bd_juridica.consulta where cedula ='" + cedula + "'";

        Statement stmt;
        ResultSet result;


        String consulta1 = null;
        try {

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);
            System.out.println("Consulta Resultado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;

    }

    public int consultaCedula(String email){

        int resultado = 1;

        String sql = "SELECT * FROM bd_juridica.login where emailUsu ='"+email +"'";

        Statement stmt;
        ResultSet result;



        try{

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);

            if (result.next()) {
                resultado = result.getInt("cedula");
                email = result.getString("emailUsu");
                contraseña = result.getString("contraseñaUsu");
                System.out.println(email +" "+ contraseña );
            }else {
                showMessageDialog(null,"Usuario no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return resultado;

    }

    public String consultaTipoUsu(String email){

        String tipoUsu = null;

        String sql = "SELECT * FROM bd_juridica.login where emailUsu ='"+email +"'";

        Statement stmt;
        ResultSet result;



        try{

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);

            if (result.next()) {

                tipoUsu = result.getString("tipoUsu");
                System.out.println(tipoUsu);
            }else {
                tipoUsu = null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return tipoUsu;

    }



    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    public String getConsulta() {
        return consulta;
    }
}
