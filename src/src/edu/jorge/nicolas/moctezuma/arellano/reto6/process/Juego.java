/**
 * Nuestro process está encargado de elegír las palabras dentro de su rango de opciones, cambiando con x as letras no encontradas
 * y luego cambiando por la letra correspondiente las letras ya adivinadas
 */

package edu.jorge.nicolas.moctezuma.arellano.reto6.process;
import java.util.*;

public class Juego {
    public static void Jugar(String palabraAleatoria){
        ArrayList<String> letrasAdivinadas = new ArrayList<>();
        ArrayList<Integer> letrasAdivinar = new ArrayList<>();
        String inputLetter;
        int tries = 0;
        Scanner scanner = new Scanner(System.in);

        while (letrasAdivinar.size() != palabraAleatoria.length()){
            boolean guessedLetter = false;
            inputLetter = scanner.next().toLowerCase();

            if (letrasAdivinadas.contains(inputLetter)){
                System.out.println("Ya has puesto esta letra, intenta con otra");
                tries++;
                continue;
            }

            for (int i = 0; i < palabraAleatoria.length(); i++){
                if (palabraAleatoria.charAt(i) == inputLetter.charAt(0)){
                    guessedLetter = true;
                    letrasAdivinar.add(i);
                }
            }
            if (guessedLetter){
                letrasAdivinadas.add(inputLetter);

                for (int i = 0; i < palabraAleatoria.length(); i++){
                    if ( (letrasAdivinar.contains(i))){
                        System.out.print(palabraAleatoria.charAt(i));
                    }else {
                        System.out.print("x");
                    }
                }
                System.out.println();
                tries++;
            }else {
                tries++;
                letrasAdivinadas.add(inputLetter);
                System.out.println("Intenta de nuevo");
            }
        }
        System.out.printf("\nSolo te tomo %d intentos, sigue así!", tries);
        System.out.println("Sí deseas seguir, presiona 1 \nDe lo contrario, presiona 4 para salir");
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void modoFacil(){

        List<String> palabrasFaciles = Arrays.asList("amor", "pez", "pato", "carro", "palo");
        Random random = new Random();
        int randomcoso = random.nextInt(palabrasFaciles.size());
        String randomEasyWord = palabrasFaciles.get(randomcoso);
        Juego.Jugar(randomEasyWord);
    }
    public static void modoNormal(){

        List<String> palabrasNormales = Arrays.asList("aturdir", "encajar", "dinosaurio", "espadas", "control");
        Random random = new Random();
        int randomcoso = random.nextInt(palabrasNormales.size());
        String randomNormalWord = palabrasNormales.get(randomcoso);
        Juego.Jugar(randomNormalWord);
    }
    public static void modoHeroico(){

        List<String> palabrasHeroicas = Arrays.asList("desoxirribonucleico", "arqueopterix", "electroencefalografista", "otorrinolaringólogo", "esternocleidomastoideo");
        Random random = new Random();
        int randomcoso = random.nextInt(palabrasHeroicas.size());
        String palabrasHeroico = palabrasHeroicas.get(randomcoso);
        Juego.Jugar(palabrasHeroico);
    }

}
