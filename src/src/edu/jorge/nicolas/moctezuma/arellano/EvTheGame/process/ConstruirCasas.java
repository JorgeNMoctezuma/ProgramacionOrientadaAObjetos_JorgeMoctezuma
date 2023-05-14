package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process;

import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.CLI;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;
//Está parte de aquí será para la mecanica de construir casas
public class ConstruirCasas {
    //Menu de acciones
    private static MenuAcciones menuConstruccion = new MenuAcciones();
    //Este de aquí es para dar un diálogo unico la primera vez que entras aquí
    static int construccionV = 0;
    //Este de aquí es para dar un diálogo unico la primera vez que entras a su parte
    static int recompensaV = 0;
    //Items de curación que te dan las hadas
    static int pizzas = 0;
    //Contador de hadas con casa
    static int HadasConCasa = 0;
    //Contador de casas
    static int CasasConstruidas = 0;
    //Opciones de botones
    static String Volver = "Volver";
    static String Construir = "Construir";

    //Mecanica de construir las casas
    public static void ConstruirCasas(){

        if (construccionV == 0){
            System.out.println("Aquí podrás construir casas para las hadas, sí lo haces, te ayudaran a aumentar tus " +
                    "niveles de vida");
            construccionV = 1;
        }
        System.out.println("Construir una casa costará 2 de madera, y 2 hadas podrán vivir ahí");
        System.out.println("Por ahora tienes " + IrAlBosque.maderaObtenida + " maderas y hay "+ PeleaPeleaPelea.hadasSinCasa +
                " hadas sin hogar");
        System.out.println("Y hay " + CasasConstruidas + " casas construidas");

        do {
            menuConstruccion.showMenu();
            var option = menuConstruccion.readOption();
            menuConstruccion.selectAndRunOption(option);
        }while (menuConstruccion.isAlive());

    }
//Recibir la recompensa por construir casas
    public static void Recompensa(){
        PeleaPeleaPelea.hadasSinCasa = PeleaPeleaPelea.hadasSinCasa - 2;
        HadasConCasa = HadasConCasa + 2;
        System.out.println( CLI.amarillo + "Hada" + CLI.blanco + ": Hey, muchas gracias por todo, dejame darte esto!");
        System.out.println(CLI.Jugador + "a recibido una " + CLI.verde + "rebanada de pizza!" + CLI.blanco);
        if (recompensaV == 0){
            System.out.println("Esto te servirá para curarte durante la pelea, usala sabiamente!");
            recompensaV = 1;
        }
        pizzas = pizzas + 1;
        ConstruirCasas.ConstruirCasas();

    }
    //Opciones del menu
    public static MenuAccionesAction Regresar = (scanner) -> {
        System.out.println("Decides volver por donde viniste...");
        JuegoMago.inicioDelJuego();

    };

    public static MenuAccionesAction Chambear = (scanner)  -> {
        System.out.println("Decides ponerte manos a la obra y construir casas!");
        if (IrAlBosque.maderaObtenida <= 1){
            System.out.println("hmmm, parece que no tienes madera para esto, será mejor ir al bosque primero...");
            ConstruirCasas.ConstruirCasas();
        }
        else {
            System.out.println("Bien! Manos a la obra!");
            CasasConstruidas = CasasConstruidas + 1;
            IrAlBosque.maderaObtenida = IrAlBosque.maderaObtenida - 2;
            PeleaPeleaPelea.multiplicadorDeVida = PeleaPeleaPelea.multiplicadorDeVida + 0.2;
            if (PeleaPeleaPelea.hadasSinCasa <= 1){
                System.out.println("Aun no hay suficientes hadas libres, pero quizá pronto " +
                        ",y quizá te den una recompensa");
                ConstruirCasas.ConstruirCasas();
            }
            ConstruirCasas.Recompensa();

        }

    };

    //Menu de acciones

    static {
        menuConstruccion.addOptions(Construir, Chambear);
        menuConstruccion.addOptions(Volver, Regresar);
        menuConstruccion.crearMenu();
    }
}
