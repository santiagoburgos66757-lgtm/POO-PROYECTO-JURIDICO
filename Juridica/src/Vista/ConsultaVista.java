package Vista;
import Controllers.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaVista extends JFrame{
    private JTextArea txtConsulta;
    private JButton btnSubirConsulta;
    private JPanel panel1;
    private JLabel lblEmail;

    String emailConsulta;
    public void recibeEmail(String email){
        lblEmail.setText(email);
        emailConsulta = lblEmail.getText();
    }



    public ConsultaVista() {

        setTitle("PaginaConsulta");
        setContentPane(panel1);
        setTitle("Formulario 4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        btnSubirConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = txtConsulta.getText();
                UsuarioCliente cliente = new UsuarioCliente();
                System.out.println();
                PaginaPrincipal p = new PaginaPrincipal();
                Consulta con = new Consulta();
                con.RegistroConsulta(con.consultaCedula(emailConsulta),consulta);
                setVisible(false);
            }
        });
    }
}
