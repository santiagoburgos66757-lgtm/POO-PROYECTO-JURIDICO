package Vista;

import Controllers.Consulta;
import Controllers.Pagos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagosVista extends JFrame {
    private JTextField txtNumeroTarjeta;
    private JTextField txtNombreTarjeta;
    private JTextField txtFechaVencimiento;
    private JTextField txtSeguridad;
    private JButton confirmarPagoButton;
    private JPanel panel1;
    private JLabel lblEmail;

    String correo;
    public void recibeEmailPagos(String email){
        lblEmail.setText(email);
        correo = lblEmail.getText();
    }

    public PagosVista() {
        setTitle("Pagos");
        setContentPane(panel1); // ¡IMPORTANTE! Conecta el diseño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar en pantalla
        setSize(400, 300); // Tamaño opcional
        confirmarPagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
                String nombreTarjeta = txtNombreTarjeta.getText();
                String fechaVencimiento = txtFechaVencimiento.getText();
                int seguridad = Integer.parseInt(txtSeguridad.getText());

                Consulta consulta = new Consulta();
                int cedula = consulta.consultaCedula(correo);
                Pagos pagos = new Pagos();
                pagos.registrarPagos(cedula,correo,nombreTarjeta,numeroTarjeta,fechaVencimiento,seguridad);
                pagos.actualizarPlan(correo);

            }
        });
    }

}
