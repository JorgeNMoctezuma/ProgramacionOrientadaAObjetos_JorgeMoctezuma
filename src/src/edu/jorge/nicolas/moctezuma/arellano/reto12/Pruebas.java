package edu.jorge.nicolas.moctezuma.arellano.reto12;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Agradecimientos especiales a @Oscar porque estaba más perdido que vieja en un columpio
 */
public class Pruebas {
    public static void main(String[] args) {
        //Almacenamos los metodos
        ArrayList<String> empleados = procesarEmpleados();

        System.out.println("\n" + "Los empleados cuya edad está entre los 20 y 25 años son:");
        entre20Y25(empleados);

        System.out.println("\n" + "Los primeros 10 empleados en orden alfabético son:");
        ordenAlfabetico10(empleados);

        System.out.println("\n" + "La edad promedio es de:");
        imprimirEdadPromedio(empleados);

        System.out.println("\n" + "El último empleado es:");
        imprimirUltimoEmpleado(empleados);
    }

    //Aquí buscamos la lista que hicimos en el salon
    public static ArrayList<String> procesarEmpleados() {
        ArrayList<String> empleados = new ArrayList<>();

        Path filePath = Paths.get("src/edu/jorge/nicolas/moctezuma/arellano/reto12/Lista12");

        try {
            empleados = (ArrayList<String>) Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String empleado : empleados) {
            System.out.println(empleado);
        }
        return empleados;
    }

    //Separamos a los empleados entre 20 y 25 años con calculo basico
    public static void entre20Y25(ArrayList<String> lista) {
        lista.stream()
                .filter(string -> {
                    int edad = Integer.parseInt(string.split(";")[2]);
                    return edad >= 20 && edad <= 25;
                })
                .forEach(System.out::println);
    }

    //Empleados separados por orden alfabetico, solo los primeros 10
    public static void ordenAlfabetico10(ArrayList<String> lista) {
        lista.stream()
                .sorted(Comparator.comparing(string -> string.split(";")[1]))
                .limit(10)
                .forEach(System.out::println);
    }

    //Calculamos la edad promedio de los empleados
    public static void imprimirEdadPromedio(ArrayList<String> lista){
        double edadPromedio = lista.stream()
                .mapToInt(string -> Integer.parseInt(string.split(";")[2]))
                .average()
                .orElse(0.0);
        System.out.println(edadPromedio + " años");
    }

    //Sacar al ultimo ultimo empleado
    public static void imprimirUltimoEmpleado(ArrayList<String> lista){
        String ultimoEmpleado = lista.stream()
                .sorted(Comparator.comparingInt((String edad) -> Integer.parseInt(edad.split(";")[2]))
                        .thenComparing(string -> string.split(";")[1])
                )
                .reduce((first, second) -> second)
                .orElse(null);
        System.out.println(ultimoEmpleado);
    }
}
