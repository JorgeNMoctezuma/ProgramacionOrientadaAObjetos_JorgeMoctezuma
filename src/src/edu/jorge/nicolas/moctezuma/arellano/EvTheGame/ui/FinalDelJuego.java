package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui;

import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process.JuegoMago;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;

public class FinalDelJuego {
    //Menu diálogo de muerte
    private static MenuAcciones menuDerrota = new MenuAcciones();
    //Opciones de muerte
    static String Derrota = "Ponerse de pie e intentarlo una vez más";
    static String MenuPrincipal = "Volver al menu principal";
    //Menu derrota
    public static void Derrota(){
        System.out.println("No te rindas...Este no puede ser el final!");
        do{
            menuDerrota.showMenu();
            var option = menuDerrota.readOption();
            menuDerrota.selectAndRunOption(option);
        }while (menuDerrota.isAlive());
    }
//Primera opción, seguir jugando
    public static MenuAccionesAction VolverAJugar = (scanner)  -> {
        System.out.println(CLI.Jugador + " se levanta una vez más...");
        JuegoMago.inicioDelJuego();

    };
//Segunda opción, volver al menu principal
    public static MenuAccionesAction RegresarAlMenuPrincipal = (scanner)  -> {
        System.out.println("Parece que " + CLI.Jugador + " no volverá a levantarse...");
        CLI.iniciarJuegoMago();

    };
//Menu de derrota
    static {
        menuDerrota.addOptions(Derrota, VolverAJugar);
        menuDerrota.addOptions(MenuPrincipal, RegresarAlMenuPrincipal);
        menuDerrota.crearMenu();
    }
//Ganar el juego
    public static void Victoria(){
        System.out.println("Ganates jijijiji");
        CLI.iniciarJuegoMago();
    }
}
