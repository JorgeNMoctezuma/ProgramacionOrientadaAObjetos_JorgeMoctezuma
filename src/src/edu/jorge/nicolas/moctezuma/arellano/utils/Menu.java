package edu.jorge.nicolas.moctezuma.arellano.utils;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    private String Opcion = "Seleccione una opción";
    private String Error = "El valor debe ser un numero, por favor, vuelva a ingresar un valor";
    private String Invalido = "Valor invalido, por favor, introduzca una opción valida";

    private ArrayList<String> optionList = new  ArrayList<>();
    private ArrayList<MenuAction> actionList = new ArrayList<>();
    private boolean alive = true;

    public boolean isAlive(){
        return alive;
    }
    public void killMenu(){
        alive = false;
    }

    public Menu addOptions(String opcion, MenuAction action){
        optionList.add(opcion);
        actionList.add(action);
        return this;
    }

    public void crearMenu(){
        optionList.add("Salir");
    }
    public void cleanMenu(){
        optionList.clear();
    }

    public void showMenu(){
        System.out.print("      Menu\n");
        for (int i = 0; i < optionList.size(); i++){
            System.out.printf("%d.- %s \n", i + 1, optionList.get(i));
        }
        System.out.println();
        System.out.println(Opcion);
    }

    public int readOption(){

        while (true){

            try {
                int numeroOpcion = scanner.nextInt(); scanner.nextLine();

                if (numeroOpcion < 1 || numeroOpcion > actionList.size() + 1){
                    System.out.print(Invalido);
                    continue;
                }return numeroOpcion;
            }catch (InputMismatchException error){
                scanner.nextLine();
                System.out.println(Error);
            }
        }
    }
    public void selectAndRunOption(int option){
        if (option == optionList.size()){
            killMenu();
            System.out.println("Terminando programa, tenga un buen día");
            return;
        }
        actionList.get(option - 1).run(scanner);
    }
}

