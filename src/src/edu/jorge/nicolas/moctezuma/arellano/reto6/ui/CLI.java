/**
 * Aquí le darémos las instrucciones al creador de menu, creando opciones y dialogo de bienvenida
 * Nuestro CLI manda a llamar a las instancias generadaws en Process y lo que debe hacer con cada una de ellas
 */

package edu.jorge.nicolas.moctezuma.arellano.reto6.ui;
import edu.jorge.nicolas.moctezuma.arellano.reto6.process.Juego;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAction;
import edu.jorge.nicolas.moctezuma.arellano.utils.Menu;

public class CLI {
    private static void alternativeExit(){
        String alternativeExitNumber = "0";
        if (alternativeExitNumber.equals("0")){
            menu.killMenu();
        }
    }

    private static String instruction = "Adivina la palabra";
    private static String modoFacil = "Modo Facil";
    private static String modoNormal = "Modo Normal";
    private static String modoHeroico = "Modo Heroico";
    private static String opcionFacil = "Facil";
    private static String opcionNormal = "Normal";
    private static String opcionHeroico = "Heroico";
    private static Menu menu = new Menu();

    private static MenuAction easyAction = (scanner) -> {
        System.out.println(modoFacil);
        System.out.println(instruction);
        String randomEasyWords = "";
        Juego.modoFacil();
        System.out.println(randomEasyWords);
        System.out.println();
        alternativeExit();
    };
    private static MenuAction normalAction = (scanner) -> {
        System.out.println(modoNormal);
        System.out.println(instruction);
        String randomNormalWords = "";
        Juego.modoNormal();
        System.out.println(randomNormalWords);
        System.out.println();
        alternativeExit();
    };
    private static MenuAction heroicoAction = (scanner) -> {
        System.out.println(modoHeroico);
        System.out.println(instruction);
        String palabrasHeroico = "";
        Juego.modoHeroico();
        System.out.println(palabrasHeroico);
        System.out.println();
        alternativeExit();
    };

    static {
        menu.addOptions(opcionFacil, easyAction);
        menu.addOptions(opcionNormal, normalAction);
        menu.addOptions(opcionHeroico, heroicoAction);
        menu.crearMenu();
    }

    public static void iniciarJuego(){
        do {
            menu.showMenu();
            var option = menu.readOption();
            menu.selectAndRunOption(option);
        }while (menu.isAlive());
    }
}
