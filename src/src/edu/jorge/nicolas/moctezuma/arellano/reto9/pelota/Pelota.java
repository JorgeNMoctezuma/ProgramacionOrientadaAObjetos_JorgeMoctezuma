/**
 * Pelota
 * Tenemos todas las caracteristicas de color, rapidez, poder, y luego el disminuri la rapidez y aunmentar poder
 * Quería poner una opción para reiniciar todo el programa, pero lo mejor que conseguí fue un loop en cada parte del codigo
 * Fuera de eso, creo que está bien
 * La verdad no entendí a que se refería con el primer punto y fue lo que entendí con lo que me explicaron
 */
package edu.jorge.nicolas.moctezuma.arellano.reto9.pelota;
import java.util.Scanner;
public class Pelota {


    static String color = "blanca";
    static int rapidez = 5;
    static int poder = 10;

        public static void disRap () {
        int otravez = 1;
        while (otravez != 0) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("La pelota " + color + " tiene una rapidez de " + rapidez + "\nCúanto desea que disminuya?");
            int resistencia = scanner.nextInt();
            int rapFin = rapidez - resistencia;
            System.out.println("La velocidad final es de " + rapFin);

            if (rapFin == 0) {
                System.out.println("Dejaste caer la pelota...");
            }

            if (rapFin < 0) {
                System.out.println("Lanzaste la pelota hacía atrás...");
            }

            System.out.println("Sí desea lanzar otra pelota, precione 1\nDe lo contrario, precione 0");
            Scanner scannerl = new Scanner(System.in);
            otravez = scannerl.nextInt();
        }

    }

        public static void aumPod () {

            int otravez = 1;
            while (otravez != 0) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("\nLa pelota " + color + " tiene un poder de " + poder + "\nCúanto desea que aumente?");
                int fuerza = scanner.nextInt();
                int podFin = poder + fuerza;
                System.out.println("Su poder final es de " + podFin);

                if (podFin == 0) {
                    System.out.println("Solo la soltaste...");
                }

                if (podFin < 0) {
                    System.out.println("Ni siquiera la levantaste...");
                }

                System.out.println("Sí desealanzar otra pelota, precione 1\nDe lo contrario, precione 0");
                Scanner scannerl = new Scanner(System.in);
                otravez = scannerl.nextInt();

            }
            System.out.println("Simulador de pelotas finalizando, lindo día...");
        }


    public static void main(String[] args) {
        disRap();
        aumPod();
    }
}
