package edu.jorge.nicolas.moctezuma.arellano.reto5.ui;
import edu.jorge.nicolas.moctezuma.arellano.reto5.process.Juego;

import java.util.Scanner;
import java.util.ArrayList;

public class CLI {
    public static void iniciarJuego() {
        ArrayList<String> letrasDadas = new ArrayList<>();
        ArrayList<Integer> letrasAdivinadas = new ArrayList<>();
        String palabraAObtener = "";
        String letraDada;

        System.out.println("Bienvenido!");
        System.out.println("Ingrese la dificultad que desea escoger");
        System.out.println("1) Facil \n2) Normal \n3) Heroico");

        Scanner scanner = new Scanner(System.in);
        int dificultad = scanner.nextInt();

        while (dificultad < 0 && dificultad > 3) {
            letrasDadas.clear();
            letrasAdivinadas.clear();

            System.out.println("Opccion invalida, porfavor intentalo de nuevo\n");
            System.out.println("Ingrese la dificultad que desea escoger");
            System.out.println("1) Facil \n2) Normal \n3) Heroico");
            dificultad = scanner.nextInt();

        }
        switch (dificultad){
            case 1:
                palabraAObtener = Juego.obtenerFacil();
                break;

            case 2:
                palabraAObtener = Juego.obtenerNormal();
                break;

            case 3:
                palabraAObtener = Juego.obtenerHeroico();
                break;
        }

      while ((letrasAdivinadas.size()) != palabraAObtener.length()){

          System.out.println("Introduce una letra");
          letraDada = scanner.next().toUpperCase();
          if (letrasDadas.contains(letraDada)){
              System.out.println("Valor previamente dado, de otro valor por favor");
              continue;
          }

          boolean letraDescubierta = false;
          for (int i = 0; i < palabraAObtener.length(); i++ ){
              if (palabraAObtener.charAt(i) == letraDada.charAt(0)){
                  letraDescubierta = true;
                  letrasAdivinadas.add(i);
              }
          }

          if (letraDescubierta){
              letrasDadas.add(letraDada);

              for (int i = 0; i <palabraAObtener.length(); i++){
                  if (letrasAdivinadas.contains(i)){
                      System.out.print(palabraAObtener.charAt(i));
                  } else {
                      System.out.print("x");
                  }
              }
              System.out.println();
          }

        }
    }
}
