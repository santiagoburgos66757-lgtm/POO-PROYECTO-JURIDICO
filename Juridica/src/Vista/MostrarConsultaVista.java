package Vista;
import Controllers.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;


public class MostrarConsultaVista extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JLabel lblEmail;
    private JButton btnConsultar;

    String emailConsulta;
    public void recibeEmail(String email){
        lblEmail.setText(email);
        emailConsulta = lblEmail.getText();
    }



    public MostrarConsultaVista() {

        setTitle("PaginaHistoricoConsulta");
        setContentPane(panel1);
        setTitle("Formulario 5");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);




        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoUsuario;
                Consulta consulta = new Consulta();
                UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
                tipoUsuario = consulta.consultaTipoUsu(emailConsulta);
                if (tipoUsuario.equals("ADMINISTRADOR")) {
                    ResultSet rs;
                    DefaultTableModel modelo = new DefaultTableModel();
                    table1.setModel(modelo);
                    modelo.setColumnIdentifiers(new Object[]{"consulta"});
                    rs = usuarioAdministrador.HistoricoConsulta();
                    try{
                        while (rs.next()){
                            modelo.addRow(new Object[]{rs.getString("consulta")});
                        }
                    }catch (Exception a){
                        JOptionPane.showMessageDialog(null, e);

                    }

                }else if (tipoUsuario.equals("CLIENTE")) {
                    ResultSet rs;
                    int cedula;


                    cedula = consulta.consultaCedula(emailConsulta);



                    DefaultTableModel modelo = new DefaultTableModel();
                    table1.setModel(modelo);
                    modelo.setColumnIdentifiers(new Object[]{"consulta"});
                    rs = consulta.HistoricoConsulta(cedula);
                    try{
                        while (rs.next()){
                            modelo.addRow(new Object[]{rs.getString("consulta")});
                        }
                    }catch (Exception a){
                        JOptionPane.showMessageDialog(null, e);

                    }
                }

                }



        });
    }
}
