/**
 * Profe una disculpa, en mi cabeza sabía que iba a hacer, pero fui incapaz de traer tal genialidad a la vida real
 * Esta parte del codigo sería la que creará de manera aleatoria a los ayudantes, por medio de arraylist (fue una de las
 * cosas qu eme falló), declaramos todas las caracteristicas como ojos, color, altura, etc. Generamos las opciones para todos
 * los int (del 1 al 5), generamos las opciones para Strings (diferentes colores y tamaños) y hacemos qye esos valores
 * regresen al texto que pedimos para describir ayudantes
 * Luego imprime a los ayudantes creados con la información previa
 */
package edu.jorge.nicolas.moctezuma.arellano.reto9.process;
import java.util.ArrayList;
import java.util.Random;

public class GeneradorDeAyudantes {
    private int numOjos;
    private String colorPiel;
    private String altura;
    private int nivCrea;
    private int nivArre;
    private int nivDest;

    private String ayudante;

    public GeneradorDeAyudantes(int numOjos, String colorPiel, String altura, int nivCrea, int nivArre, int nivDest){
        this.numOjos = numOjos;
        this.colorPiel = colorPiel;
        this.altura = altura;
        this.nivArre = nivArre;
        this.nivCrea = nivCrea;
        this.nivDest = nivDest;
    }
    public int getNumOjos(){
        return numOjos;
    }
    public void setNumOjos(int numOjos){
        this.numOjos = numOjos;
    }
    public String getColorPiel(){
        return colorPiel;
    }
    public String getAltura(){
        return altura;
    }
    public int getNivCrea() {
        return nivCrea;
    }
    public int getNivDest(){
        return nivDest;
    }
    public int getNivArre(){
        return nivArre;
    }
    //private ArrayList<> losAyudantes = new ArrayList<>();


    public static void GenerarAyudantes(){

        Random random = new Random();
        int numAyudantes = 5;

        for (int i = 0; i <= numAyudantes; i++){
            int numOjos = random.nextInt(5) + 1;
            String colorPiel = obtenerColor(random);
            String altura = obtenerAltura(random);
            int nivCrea = random.nextInt(5) + 1;
            int nivArre = random.nextInt(5) + 1;
            int nivDest = random.nextInt(5) + 1;

            System.out.println("Prueba");
        }

    }
    private static String obtenerColor(Random random){
        String[] coloresPiel = {"amarilla", "morada", "roja", "azul", "verde"};
        int dizz = random.nextInt(coloresPiel.length);
        return coloresPiel[dizz];
    }
    private static String obtenerAltura(Random random){
        String[] alturas = {"pequeño", "mediano", "alto"};
        int dizz = random.nextInt(alturas.length);
        return alturas[dizz];
    }
}
