import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class PanelControlEquipos extends JFrame{
    private JButton registrarDataButton1;
    public JPanel panelControl;
    private JButton generarReporteButton;
    private JButton salirButton;
    private JTextField ciResposable;
    private JTextField fecha;
    private JTextField nroFactura;
    private JTextField costo;
    private JTextField desc;
    private JTextField cantidad;
    private JLabel Costo;

    static File miArchivo = new File("Inventario.txt");

    public static HashMap<String, Responsable> listadeResponsables = new HashMap<>();



    public static void main(String[] args) {

        if(!miArchivo.exists()) {
            try {
                miArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        PanelControlEquipos panel = new PanelControlEquipos();
        panel.setContentPane(panel.panelControl);
        panel.setTitle("Registro y control de Equipos en Centro de Investigacion");
        panel.setSize(800, 600);
        panel.setVisible(true);
        panel.setLocation(0, 0);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public PanelControlEquipos() {
        registrarDataButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                guardarDato(ciResposable.getText(), desc.getText(), cantidad.getText(), costo.getText(), fecha.getText(), nroFactura.getText());
                long equiposTotal = Long.parseLong(cantidad.getText());
                long montoTotal = Long.parseLong(costo.getText());
                actualizarLista(ciResposable.getText(), equiposTotal, montoTotal);
                ciResposable.setText("");
                desc.setText("");
                cantidad.setText("");
                costo.setText("");
                fecha.setText("");
                nroFactura.setText("");
                JOptionPane.showMessageDialog(registrarDataButton1, "Se ha registrado");
            }

            });

        generarReporteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                GenerarReporte panel = new GenerarReporte();
                panel.setContentPane(panel.panel);
                panel.setTitle("Generar reporte");
                panel.setSize(1200, 600);
                panel.setVisible(true);
                panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }

        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void actualizarLista(String ci, Long ct, Long mt) {
        //actualizar lista de encargados
        if(listadeResponsables.containsKey(ci)) {
            Responsable prof = listadeResponsables.get(ci);
            long totalEq = prof.getTotalEquipos();
            long monto = prof.getMontoTotal();
            Responsable nuevoProf = new Responsable(ci, totalEq += ct, monto += mt);
            listadeResponsables.put(ci, nuevoProf);


        } else {
            Responsable ProfRegistrar = new Responsable(ci, ct, mt);
            listadeResponsables.put(ci, ProfRegistrar);
        }
    }

    private void guardarDato(String ci, String desc, String ct, String mu, String date, String nf) {
        try {
            FileWriter guardar = new FileWriter("Inventario.txt", true);
            guardar.write("Equipo: CI:" + ci + " Desc: " + desc + " Cantidad " + ct + " Costo " +  mu + " Fecha " + date + " Factura " + nf);
            guardar.write("\n");
            guardar.close();
            System.out.println("Guardado el registro");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
