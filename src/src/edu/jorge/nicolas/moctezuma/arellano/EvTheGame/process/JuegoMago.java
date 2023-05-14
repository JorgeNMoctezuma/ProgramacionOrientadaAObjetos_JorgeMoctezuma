package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;


public class JuegoMago {
//Menu de acciones
    private static MenuAcciones menuAccion= new MenuAcciones();
    //Para el diálogo unico cuando inicias por primera vez
    static int inicioV = 0;
    //Botones del menu
    private static String Bosque = "Ir al Bosque";
    private static String Construir = "Construir casas";
    private static String LiberarHadas = "Liberar Hadas";
    private static String Mago = "Ir contra el mago";
    //Inicio del juego
    public static void inicioDelJuego(){

        if (inicioV == 0){
            System.out.println("Bienvenido al menu principal, aquí podrás decidir que hacer, podrás ir al bosque, a construir " +
                    "casas o enfrentarte a Pepe el Mago,\naunque ten cuidado, el será demasiado poderoso hasta que le quites a sus" +
                    " hadas trata de contruir casas para ellas en el pueblo");
            inicioV = +1;
        }

//Menu inicial
        do {
            menuAccion.showMenu();
            var option = menuAccion.readOption();
            menuAccion.selectAndRunOption(option);
        }while (menuAccion.isAlive());
    }
//Opciones del menu, cada uno te lleva a una parte especial
    public static MenuAccionesAction accionBosque = (scanner) -> {
        System.out.println("Caminas al norte hacia la arboleda...");
        IrAlBosque.RecojerMadera();

    };
    public static MenuAccionesAction accionConstruir = (scanner) ->{
        System.out.println("Tomas tus recursos y te diriges a un claro cercano");
        ConstruirCasas.ConstruirCasas();

    };
    public static MenuAccionesAction FinallBoss = (scanner) ->{
        System.out.println("Decides caminar hacia el castillo del mago, decidido a darle pelea por todo lo que a causado");
        PeleaMago.InicioMago();

    };
    public static MenuAccionesAction LiberarHaditas = (scanner) -> {
        System.out.println("Te acercas lentamente a uno de los calabozos cercanas al castillo del mago");
        IrAlBosque.Mazmorra();


    };//Menu
    static{
        menuAccion.addOptions(Bosque, accionBosque);
        menuAccion.addOptions(LiberarHadas, LiberarHaditas);
        menuAccion.addOptions(Construir, accionConstruir);
        menuAccion.addOptions(Mago, FinallBoss);
        menuAccion.crearMenu();
    }


}
