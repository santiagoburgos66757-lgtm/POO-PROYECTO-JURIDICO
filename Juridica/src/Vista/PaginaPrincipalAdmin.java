package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipalAdmin extends JFrame {
    private JPanel panel1;
    private JButton consultasButton;
    private JLabel lblEmail;

    String correo;
    public void recibeEmailAdmin(String email){
        lblEmail.setText(email);
        correo = lblEmail.getText();
    }

    public PaginaPrincipalAdmin() {
        setTitle("PaginaPrincipalAdmin");
        setContentPane(panel1);
        setTitle("Formulario 3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        consultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarConsultaVista mostrarVista = new MostrarConsultaVista();
                mostrarVista.setVisible(true);
                mostrarVista.recibeEmail(correo);
            }
        });
    }
}
