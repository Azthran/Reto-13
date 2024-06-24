import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CentroDeInv {
        public static Map<String, Profesor> listaEncargados = new HashMap<>();

    public static void main(String[] args) {
        //bandera para seguir corriengo el programa mientras el usurio siga interactuando
        boolean keepRunning = true;
        //crear archivo inventario
        File miArchivo = new File("Inventario.txt");
        // si no se crea el archivo
        if(!miArchivo.exists()) {
            try {
                miArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        while (keepRunning == true) {

            System.out.println("Bienvenido al registro y control de equipos de Centro de Investigacion");
            System.out.println("Por favor ingrese [1] para registro de equipo y [2] para consulta de equipos registrados");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            if (num == 1) {
                System.out.println("~~~~~~~~~~~~~~~~~~Reegistro~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                guardarNuevo(miArchivo);
                System.out.println("Quieres registrar otro equipo presione (Y) de lo contrario presione cualquier tecla");
                String resp = scanner.next();
                if(resp.equalsIgnoreCase("y")) {
                    guardarNuevo(miArchivo);
                } else {
                    // usurio sale del programa, no quiere registrar mas
                    keepRunning = false;
                }

            }
            else if(num == 2){
                System.out.println("~~~~~~~~~~~~~~~~~~Consulta~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                consultaDeEquipos();
                System.out.println("Quieres Consultar otro equipo presione (Y) de lo contrario presione cualquier tecla");
                String resp = scanner.next();
                if(resp.equalsIgnoreCase("y")) {
                    System.out.println(resp);
                    consultaDeEquipos();
                } else {
                    // usurio sale del programa, no quiere consultar mas
                    keepRunning = false;
                }
            }
            else {
                keepRunning = false;
            }
        }

    }

    private static void guardarNuevo(File miArchivo) {
        //se genera el equipo a registrar con los datos suministrados
        Equipo reg = registroEquipo();


        //se actualiza la informacion del profesor encargado
        actualizarListaDeEncargados(reg.getCi(), reg.getCt(), reg.getMu());

        // se guarda en memoria archivo el nuevo registro
        guardardato(miArchivo, reg);


        System.out.println("Registrado con exito " + reg.toString());
    }

    private static void guardardato(File miArchivo, Equipo reg) {
        try {
            FileWriter guardar = new FileWriter(miArchivo, true);
            guardar.write(""+ reg);
            guardar.write("\n");
            guardar.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actualizarListaDeEncargados(String ci, int ct, long mu) {
        // crear archivo de encargados
        File miArch = new File("ListaDeEncargados.txt");
        // si no se crea el archivo
        if(!miArch.exists()) {
            try {
                miArch.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // guardar un historial de encargados en ListaDeEncargados.txt
        try {
            FileWriter guardarEncargados = new FileWriter(miArch, true);
            guardarEncargados.write("ci Profesor= "+ ci + " cantidad= " + ct + " monto total= " + mu);
            guardarEncargados.write("\n");
            guardarEncargados.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //actualizar lista de encargados
        if(listaEncargados.containsKey(ci)) {
            Profesor prof = listaEncargados.get(ci);
            Profesor nuevoProf = new Profesor(ci, prof.totalEquipos += ct, prof.montoTotal += mu);
            listaEncargados.put(ci, nuevoProf);


        } else {
            Profesor ProfRegistrar = new Profesor(ci, (long) ct, mu);
            listaEncargados.put(ci, ProfRegistrar);
        }

    }

    private static void consultaDeEquipos() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor ingrese el ci del responsable del equipo");
        String ci = scan.next();
        if(listaEncargados.containsKey(ci)) {
            Profesor prof = listaEncargados.get(ci);
            System.out.println(prof);
        } else {
            System.out.println("No se encontro un registro con el CI suministrado");
        }

    }

    private static Equipo registroEquipo() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor ingrese descripcion del equipo");
        String desc = scan.next();
        System.out.println("Por favor ingrese cantidad del equipo");
        int ct = scan.nextInt();
        System.out.println("Por favor ingrese costo unitario del equipo");
        int mu = scan.nextInt();
        System.out.println("Por favor ingrese dia (dd) de adquisicion del equipo con numero entre 1-31");
        short dd = scan.nextShort();
        System.out.println("Por favor ingrese el mes (mm) de adquisicion del equipo con numero entre 1-12");
        short mm = scan.nextShort();
        System.out.println("Por favor ingrese ano (aaaa) de adquisicion del equipo");
        int aaaa = scan.nextInt();
        System.out.println("Por favor ingrese CI del responsable del equipo");
        String ci = scan.next();
        System.out.println("Por favor ingrese numero de factura del equipo");
        String nf = scan.next();
        Equipo equipo = new Equipo( ci, desc, ct, mu, dd, mm, aaaa, nf);
        return equipo;
    }


}
