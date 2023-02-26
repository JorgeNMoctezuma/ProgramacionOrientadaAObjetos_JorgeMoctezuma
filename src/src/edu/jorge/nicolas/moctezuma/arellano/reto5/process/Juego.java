/**
 * Estás son las listas de palabras para las 3 dificultades del juego
 */

package edu.jorge.nicolas.moctezuma.arellano.reto5.process;
import edu.jorge.nicolas.moctezuma.arellano.reto5.ui.CLI;


import java.util.Random;

public class Juego {

    public static String obtenerFacil(){
            String [] facil = {"amor", "pez", "pato", "carro", "palo"};
            Random random = new Random();

            return facil[random.nextInt(facil.length)];
    }



    public static String obtenerNormal(){
        String [] normal = {"aturdir", "encajar", "dinosaurio", "espadas", "control"};
        Random random = new Random();


        return normal[random.nextInt(normal.length)];
    }

        public static String obtenerHeroico(){
            String [] heroico = {"desoxirribonucleico", "Arqueopterix", "Electroencefalografista", "Otorrinolaringólogo", "Esternocleidomastoideo"};
            Random random = new Random();

            return heroico[random.nextInt(heroico.length)];
    }


}
