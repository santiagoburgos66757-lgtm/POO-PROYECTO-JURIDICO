package Controllers;

import Coneccion.Coneccion;
import Interfaces.PagosInterface;

import java.sql.Statement;

import static Coneccion.Coneccion.getConnection;
import static javax.swing.JOptionPane.showMessageDialog;

public class Pagos extends UsuarioCliente implements PagosInterface {

    private String nombreTarjeta;
    private int numeroTarjeta;
    private String fechaVencimientoTarjeta;
    private int codigoSeguridadTarjeta;

    public Pagos() {

    }

    public boolean  registrarPagos(int cedula, String email, String nombreTarjeta, int numeroTarjeta, String fechaVencimientoTarjeta,
                                   int codigoSeguridadTarjeta) {

        boolean pago = false;
        Coneccion coneccion = new Coneccion();

        String sql2 = "UPDATE usuario"+"SET plan=2 WHERE email='"+email+"'";
        String sql = "INSERT INTO pagos(cedula,emailUsu,nombreTarjeta,numeroTarjeta,fechaVencimiento,codigoSeguridadTarjeta) " +
                "VALUES ('"+cedula+"','"+email+"','"+nombreTarjeta+"','"+numeroTarjeta+"','"+fechaVencimientoTarjeta+"','"+codigoSeguridadTarjeta+"')";

        int result;
        Statement stmt;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
            showMessageDialog(null,"Pago registrado correctamente");
            pago = true;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

return pago;

    }


    public int actualizarPlan(String email){


        Coneccion coneccion = new Coneccion();

        String sql = "UPDATE usuario"+"SET plan=2 WHERE email='"+email+"'";
        int result;
        Statement stmt;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Usuario Actualizado correctamente");
            setPlan(2);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return getPlan();

    }



    public Pagos(int codigoSeguridadTarjeta, String fechaVencimientoTarjeta, String nombreTarjeta, int numeroTarjeta) {
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCodigoSeguridadTarjeta() {
        return codigoSeguridadTarjeta;
    }

    public void setCodigoSeguridadTarjeta(int codigoSeguridadTarjeta) {
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
    }

    public String getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
