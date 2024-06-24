import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenerarReporte extends JFrame{
    private JList list1;
    private JButton continuarButton;
    public JPanel panel;
    private JButton button1;
    private JButton individualButton;
    private JTextField ciResponsable;

    DefaultListModel model = new DefaultListModel<>();



    public GenerarReporte() {
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelControlEquipos panel = new PanelControlEquipos();
                panel.setContentPane(panel.panelControl);
                panel.setTitle("Registro y control de Equipos en Centro de Investigacion");
                panel.setSize(900, 600);
                panel.setVisible(true);
                panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido;
                try {
                    FileReader lectora = new FileReader("Inventario.txt");
                    BufferedReader leer = new BufferedReader(lectora);
                    contenido = leer.readLine();
                    while (contenido != null) {
                        model.addElement(contenido);
                        list1.setModel(model);
                        contenido = leer.readLine();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        individualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ci = ciResponsable.getText();
                Responsable resp = PanelControlEquipos.listadeResponsables.get(ci);
                model.addElement(resp);
                list1.setModel(model);
            }
        });
    }
}
