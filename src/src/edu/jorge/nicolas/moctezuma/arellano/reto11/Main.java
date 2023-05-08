package edu.jorge.nicolas.moctezuma.arellano.reto11;
<<<<<<< Updated upstream
import edu.jorge.nicolas.moctezuma.arellano.reto11.ui.CLI;
public class Main {
    public static void main(String[] args){
        CLI.mostrarMenu();
    }
=======
import edu.jorge.nicolas.moctezuma.arellano.reto11.process.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Luego de muchas lágrimas termine pidiendo ayuda a @Eryx, así que este codigo funciona gracias a el,así q, bueno
 *presento mi trabajo lleno de "No entiendo que hago" y una pizca de "Dios, no soy tu mejor guerrero, ya suéltame"
 */
public class Main {

    /**
     * Aquí creamos nuestras variables de empleados
     */
    static void testClases(){
            Empleado uno = new JrEngineer();
            Empleado dos = new SrEngineer();
            Empleado tres = new Manager();

            JrEngineer jr = new SrEngineer();
            programar(jr);
            trabajar(new JrEngineer());


            ArrayList<Empleado> lista = new ArrayList<>();
            lista.add(new JrEngineer("Thomas", 19));
            lista.add(new SrEngineer("Cirilo", 20));

            System.out.println(lista.stream().sorted().collect(Collectors.toList()));
            System.out.println(lista);
            Collections.sort(lista);
            System.out.println(lista);
            System.out.println(Collections.max(lista, Comparator.comparing(Empleado :: getName)));
            Collections.sort(lista, Comparator.comparing(Empleado :: getName));
            System.out.println(lista);

            LinkedList<Empleado> link = new LinkedList<>();

            HashMap<Empleado, String> map = new HashMap<>();
            map.put(new JrEngineer("Thomas", 19), "Thomas");
            map.put(new SrEngineer("Cirilo", 20), "Cirilo");
            map.put(new JrEngineer("Carlos", 21), "Carlos");
            JrEngineer jr1 = new JrEngineer("Carlos", 21);
            System.out.println(jr1);

        }
        //Tenemos nuestra bonita lista de empleados
        static void testWriteFiles(){
            ArrayList<Empleado> list = new ArrayList<>();
            list.add(new JrEngineer ("Jose", 18, "B01873QPL"));
            list.add(new JrEngineer ("Andres", 19, "C02789CHE"));
            list.add(new JrEngineer ("Diego", 20, "D03123EDC"));
            list.add(new JrEngineer ("Roman", 21, "E04490CHS"));
            list.add(new JrEngineer ("Fabian", 22, "F05793DHC"));
            list.add(new JrEngineer ("Gabian", 23, "G06489SOC"));
            list.add(new JrEngineer ("Paco", 24, "H0734ICS"));
            list.add(new JrEngineer ("Ian", 25, "I08389AMC"));
            list.add(new JrEngineer ("Julio", 26, "J09367DHA"));
            list.add(new JrEngineer ("Tulio", 27, "K095453AWF"));
            String fileName = "Lista.txt";
            Path file = Paths.get(fileName);

            try{
                List<String> lines = list.stream().map(Empleado :: toString).collect(Collectors.toList());
                Files.write(file, lines);
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        static void readFiles(){
            ArrayList<Empleado> readList = new ArrayList<>();
            String fileName = "Lista.txt";
            Path file = Paths.get(fileName);

            try {
                for (String line : Files.readAllLines(file)) {
                    List<String> lines = readList.stream().map(Empleado::toString).collect(Collectors.toList());
                    System.out.println(line);
                    List<Empleado> empleadosMa20 = new ArrayList<>();
                    for (int i = 0; i < line.length(); i++);{
                        empleadosMa20.add(new JrEngineer());
                        printOver20emp(empleadosMa20);
                    }
                }
                System.out.println("!!!!!!!!");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        static List<Empleado> printOver20emp (List<Empleado> empleados){
            List<Empleado> empleadosMa20 = Collections.emptyList();
            for (int i = 0; i < empleados.size(); i++){
                if (empleados.get(i).getAge()> 20){
                    System.out.println(empleados.get(i));
                    empleadosMa20.add(empleados.get(i));
                }
            }return empleadosMa20;
        }
        static void trabajar (Empleado empleado){}
        static void programar (Empleado empleado){}

    public static void main(String[] args) {
            testWriteFiles();
            readFiles();

    }

>>>>>>> Stashed changes
}
