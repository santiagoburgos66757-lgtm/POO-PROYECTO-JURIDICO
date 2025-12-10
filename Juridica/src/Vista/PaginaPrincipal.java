package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal extends JFrame {
    private JPanel panel1;
    private JButton btnConsulta;
    private JButton btnHistorico;
    private JButton btnPerfil;
    private JButton btnPagos;
    private JLabel lblEmail;
    String correo;
    public void recibeEmail(String email){
        lblEmail.setText(email);
        correo = lblEmail.getText();
    }


    public PaginaPrincipal() {
        setTitle("PaginaPrincipal");
        setContentPane(panel1);
        setTitle("Formulario 3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaVista consultaVista = new ConsultaVista();
                consultaVista.setVisible(true);
                consultaVista.recibeEmail(correo);
            }
        });
        btnHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MostrarConsultaVista mostrarVista = new MostrarConsultaVista();
                mostrarVista.setVisible(true);
                mostrarVista.recibeEmail(correo);
            }
        });
        btnPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagosVista pagosVista = new PagosVista();
                pagosVista.setVisible(true);
                pagosVista.recibeEmailPagos(correo);


            }
        });
    }

}


