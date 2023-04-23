package edu.jorge.nicolas.moctezuma.arellano.reto11.ui;
import edu.jorge.nicolas.moctezuma.arellano.reto11.process.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

public class CLI {
    public static void mostrarMenu(){
        ArrayList<Empleado> lista = new ArrayList<>();

        lista.add(new JrEngineer("A", "a", 17 , 00000, 00000, "Java", "A00"));
        lista.add(new JrEngineer("B", "b", 18 , 00001, 00010, "Python", "B01"));
        lista.add(new JrEngineer("C", "c", 19 , 00002, 00020, "C", "C02"));
        lista.add(new JrEngineer("D", "d", 20 , 00003, 00030, "C++", "D03"));
        lista.add(new JrEngineer("E", "e", 21 , 00004, 00040, "C#", "E04"));
        lista.add(new JrEngineer("F", "f", 22 , 00005, 00050, "HTML", "F05"));
        lista.add(new JrEngineer("G", "g", 23 , 00006, 00060, "JavaScript", "G06"));
        lista.add(new JrEngineer("H", "h", 24 , 00007, 00070, "PHP", "H07"));
       // lista.add(new JrEngineer("I", "i", 25 , 00008, 00080, "Java", "I08"));
       // lista.add(new JrEngineer("J", "j", 26 , 00009, 00090, "Python", "J09"));

        try{
            FileWriter writer = new FileWriter("src/edu/Jorge/Nicolas/Moctezuma/Arellano/reto11/ui/Lista.txt");
            for (Empleado i:lista){
                writer.write(i + "\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<String> Lista2 = new ArrayList<>();
        Path path = Paths.get("src/edu/Jorge/Nicolas/Moctezuma/Arellano/reto11/ui/Lista.txt");

        try {
            List<String> lineasArchivadas = Files.readAllLines(path);
            for (String linea : lineasArchivadas){
                Lista2.add(linea);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        imprimirMas20(Lista2);
    }

    public static void imprimirMas20(ArrayList<String> lista){
        for (String empleados : lista){
            String[] atributo = empleados.split(" ; ");
            int edad = Integer.parseInt(atributo[3]);

            if (edad > 20){
                System.out.println(empleados);
            }
        }
    }
}
