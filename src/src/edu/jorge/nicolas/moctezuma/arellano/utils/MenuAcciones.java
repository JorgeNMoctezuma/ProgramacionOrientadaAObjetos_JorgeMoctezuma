package edu.jorge.nicolas.moctezuma.arellano.utils;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MenuAcciones {
    Scanner scanner = new Scanner(System.in);

    private String Error = "El valor debe ser un numero, por favor, vuelva a ingresar un valor";
    private String Invalido = "Valor invalido, por favor, introduzca una opción valida";

    private ArrayList<String> opciones = new  ArrayList<>();
    private ArrayList<MenuAccionesAction> acciones = new ArrayList<>();
    private boolean alive = true;

    public boolean isAlive(){
        return alive;
    }
    public void killMenu(){
        alive = false;
    }

    public MenuAcciones addOptions(String opcion, MenuAccionesAction action){
        opciones.add(opcion);
        acciones.add(action);
        return this;
    }

    public void crearMenu(){ }
    public void cleanMenu(){
        opciones.clear();
    }

    public void showMenu(){
        System.out.print("    ¿Qué acción tomas?\n");
        for (int i = 0; i < opciones.size(); i++){
            System.out.printf("%d.- %s \n", i + 1, opciones.get(i));
        }
        System.out.println();
    }

    public int readOption(){

        while (true){

            try {
                int numeroOpcion = scanner.nextInt(); scanner.nextLine();

                if (numeroOpcion < 1 || numeroOpcion > acciones.size() + 1){
                    System.out.println(Invalido);
                    continue;
                }return numeroOpcion;
            }catch (InputMismatchException error){
                scanner.nextLine();
                System.out.println(Error);
            }
        }
    }
   public void selectAndRunOption(int option){
        if (option == opciones.size()+ 1){
            System.out.println(Invalido);
            return;
        }
        acciones.get(option - 1).run(scanner);
    }


}
