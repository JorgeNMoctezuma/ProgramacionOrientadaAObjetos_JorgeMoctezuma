package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process;
import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.CLI;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;

public class IrAlBosque {
    //Menu para acciones del bosque
    private static MenuAcciones menuBosque= new MenuAcciones();
    //Menu para la mazmorra
    private static MenuAcciones menuMazmorra= new MenuAcciones();
    //Dialo para la primera vez que entras a sus respectivas áreas
    static int bosqueV = 0;
    static int mazmorraV = 0;
    //El contador de la madera obtenida
    static int maderaObtenida = 0;
    //Un generador de numeros aleatorios
    static int aleatorio;
    //Los checadores de ventajas y desventajas para entrar a combate
    public static boolean desventaja = false;
    public static boolean ventaja = false;
    //Dialogos de los botones del menu
    private static String Atacar = "Atacar";
    private static String Volver = "Volver";
    private static String Escabullirse = "Escabullirse";
//Recojer la madera del bosque (es pelea)
    public static void RecojerMadera() {
        if (bosqueV == 0){
            System.out.println("Llegas a un hermoso bosque lleno de arboles hasta donde la vista puede llegar" +
                    " sientes una gran calma, hasta que...");
            bosqueV =+ 1;
        }
        System.out.println("A lo lejos logras ver a un ogro, sabes que sí haces ruido, vendrá a atacarte");

        do {//Menu de bosque
            menuBosque.showMenu();
            var option = menuBosque.readOption();
            menuBosque.selectAndRunOption(option);
        }while (menuBosque.isAlive());

    }
    public static MenuAccionesAction Atacando = (scanner) -> {
        System.out.println("Desenvainas tu espada mientras retas al ogro a un combate ¡preparate!");
        PeleaPeleaPelea.PeleaOgro();

    };

    public static MenuAccionesAction Regresar = (scanner) ->{
        System.out.println("Decides volver por donde viniste...");
        JuegoMago.inicioDelJuego();
    };

    public static MenuAccionesAction Sigilo = (scanner) ->{
        System.out.println("Intentas pasar desapercibido...");
        aleatorio = (int)(Math.random() * 4 + 1);

        if (aleatorio == 1){
            System.out.println("Lograste pasar desapercibido y tomaste la madera del ogro!");
            IrAlBosque.resultadoMadera();

        }else {
            System.out.println("Oh no! El ogro te noto y dio un golpe por la espalda!");
            desventaja = true;
            PeleaPeleaPelea.PeleaOgro();

        }

    };

    static {
        menuBosque.addOptions(Atacar, Atacando);
        menuBosque.addOptions(Volver, Regresar);
        menuBosque.addOptions(Escabullirse, Sigilo);
        menuBosque.crearMenu();
    }
//Mazmorra, lo mismo que arriba pero con la mazmorra
    public static void Mazmorra(){
        if (mazmorraV == 0){
            System.out.println("Caminas hacia la zona más oscuro hasta llegar a una misteriosa cueva custodiada" +
                    " por un ogro...");
            mazmorraV = +1 ;
        }
        System.out.println();


        do {
            menuMazmorra.showMenu();
            var option = menuMazmorra.readOption();
            menuMazmorra.selectAndRunOption(option);
        }while (menuMazmorra.isAlive());
    }

    public static MenuAccionesAction AtacandoMazmo = (scanner) -> {
        System.out.println("Desenvainas tu espada mientras retas al ogro a un combate ¡preparate!");
        PeleaPeleaPelea.PeleaOgroMazmo();

    };


    public static MenuAccionesAction escabullirseMazmo = (scanner) ->{
        System.out.println("Intentas pasar desapercibido...");
        aleatorio = (int)(Math.random() * 4 + 1);

        if (aleatorio == 1){
            System.out.println("Tomaste la ventaja, das un golpe al ogro desprevenido!");
            ventaja = true;
            PeleaPeleaPelea.PeleaOgroMazmo();


        }else {
            System.out.println("Oh no! El ogro te noto y dio un golpe por la espalda!");
            desventaja = true;
            PeleaPeleaPelea.PeleaOgroMazmo();

        }


    };

    static {
        menuMazmorra.addOptions(Atacar, AtacandoMazmo);
        menuMazmorra.addOptions(Volver, Regresar);
        menuMazmorra.addOptions(Escabullirse, escabullirseMazmo);
        menuMazmorra.crearMenu();
    }
//Resultados de ganar en la Mazmorra
    public static void resultadoHadas(){

        if (PeleaMago.HadasCapturadas <= 0){
            System.out.println("Has liberado a todas las hadas, muy bien! "+ CLI.morado + "Pepe el mago" + CLI.blanco +" debe estar debil!");
        }else {
            aleatorio = (int)(Math.random() * 3 + 1);
            PeleaPeleaPelea.HadasLiberadas = PeleaPeleaPelea.HadasLiberadas + aleatorio;
            PeleaPeleaPelea.hadasSinCasa = PeleaPeleaPelea.hadasSinCasa + aleatorio;
            System.out.println("Liberaste "+ aleatorio + " Hadas!");
            System.out.println("Hay " + PeleaPeleaPelea.HadasLiberadas+ " hadas libres en total");
            PeleaMago.HadasCapturadas = PeleaMago.HadasCapturadas - aleatorio;

            System.out.println("Regresas triunfante por donde viniste...");

        }

        JuegoMago.inicioDelJuego();

    }
//Resultados de ganar la pelea del bosque
    public static void resultadoMadera(){
        aleatorio = (int)(Math.random() * 3 + 1);
        maderaObtenida = maderaObtenida + aleatorio;
        System.out.println("Obtuviste "+ aleatorio + " de madera!");
        System.out.println("Tu total de madera es de " + maderaObtenida);
        System.out.println("Regresas pór donde viniste...");

        JuegoMago.inicioDelJuego();

    }
}
