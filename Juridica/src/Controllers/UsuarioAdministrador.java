package Controllers;

import Interfaces.ConsultaInterface;
import Interfaces.LoginInterface;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;

import static Coneccion.Coneccion.getConnection;
import static javax.swing.JOptionPane.showMessageDialog;

public class UsuarioAdministrador extends Usuario implements ConsultaInterface {
    private String tipoUsu = "ADMINISTRADOR";

    public ResultSet HistoricoConsulta() {

        String sql = "SELECT * FROM bd_juridica.consulta ";

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




    @Override
    public String getTipoUsuario() {
        return tipoUsu;
    }
}
