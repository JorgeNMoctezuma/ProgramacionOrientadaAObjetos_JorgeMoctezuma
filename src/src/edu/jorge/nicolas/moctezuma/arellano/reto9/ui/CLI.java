/**
 * Usando el Menu que aprendimos a hacer gracias a lo que el profe enseño y @Eryx me explico, podemos tener un menu más
 * simple que se despliega solo al generar las opciones que le damos, lo que lo hace más rapido
 */
package edu.jorge.nicolas.moctezuma.arellano.reto9.ui;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAction;
import edu.jorge.nicolas.moctezuma.arellano.utils.Menu;
import edu.jorge.nicolas.moctezuma.arellano.reto9.process.GeneradorDeAyudantes;

public class CLI {
    /**
     * Está parte de aquí mata al menu
     */
    private static void alternativeExit(){
        String alternativeExitNumber = "0";
        if (alternativeExitNumber.equals("0")){
            menu.killMenu();
        }
    }
    private static Menu menu = new Menu();
    /**
     * Los dialogos del menu
     */
    private static String CrearAyudantes = "Crear Ayudantes";
    private static String bienvenida = "Generando Chalanes...";
    /**
     * unica opcion del menu
     */
    private static MenuAction GenerarChalanes = (scanner) -> {
        System.out.println(bienvenida);
        System.out.println();
        GeneradorDeAyudantes.GenerarAyudantes();
        alternativeExit();
    };

    static {
        menu.addOptions(CrearAyudantes, GenerarChalanes);
        menu.crearMenu();
    }

    /**
     * está es la parte especifica que llama al menu
     */
    public static void iniciarConteoDeAyudantes(){
        do {
            menu.showMenu();
            var option = menu.readOption();
            menu.selectAndRunOption(option);
        }while (menu.isAlive());
    }

}
