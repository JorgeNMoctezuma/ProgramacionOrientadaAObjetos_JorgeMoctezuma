package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process;

import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.CLI;
import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.FinalDelJuego;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;

public class PeleaMago {
    //Menu para preguntar sí de verdad quieres pelear con el mago
    public static MenuAcciones MenuInicioMago = new MenuAcciones();
    //Menu para pelear con el mago
    public static MenuAcciones MenuPeleaMago = new MenuAcciones();
    //Valores del mago
    public static int HadasCapturadas = 100;
    public static int vidaBaseDelMago = 800;
    public static int poderBaseDelMago = 90;
    public static int poderTotalDelMago = (poderBaseDelMago * (HadasCapturadas / 10));
    public static int vidaTotalDelMago = (vidaBaseDelMago * (HadasCapturadas / 10));
    //Botones del menu
    public static String regresar = "Volver...";
    public static String Adelante = "Seguir adelante";
    private static String Golpear = "Atacar";
    private static String Defender = "Defender";
    private static String Curarse = "Curarse";
    //Diálogo unico de la primera vez que entras
    public static int InicioV = 0;
    //defensa del jugador
    public static boolean defensaActiva = false;
    //Generador de valor random
    public static int accionRandom;
//Pregunta sí de verdad quieres hacer esto
    public static void InicioMago(){
        poderTotalDelMago = (poderBaseDelMago * (HadasCapturadas / 10));
        vidaTotalDelMago = (vidaBaseDelMago * (HadasCapturadas / 10));

        System.out.println("Estás a punto de ir contra " + CLI.morado + "Pepe el Mago"+ CLI.blanco +", recuerda que es más poderoso con las hadas que hay atrapadas\n" +
                "Estás seguro de querer hacer esto?");

        do {//Menu
            MenuInicioMago.showMenu();
            var option = MenuInicioMago.readOption();
            MenuInicioMago.selectAndRunOption(option);
        }while (MenuInicioMago.isAlive());
    }
//Decidir si seguir o regresar
    public static MenuAccionesAction Siguiente = (scanner) -> {
        System.out.println("Decides que es hora de darle fin a este terrible enemigo");
        PeleaMago.LaHoraFinal();

    };
    public static MenuAccionesAction Regresar = (scanner) -> {
        System.out.println("Decides volver por donde viniste...");
        JuegoMago.inicioDelJuego();

    };

    static {
        MenuInicioMago.addOptions(Adelante, Siguiente);
        MenuInicioMago.addOptions(regresar, Regresar);
        MenuInicioMago.crearMenu();
    }
//Inicio de la pelea
    public static void LaHoraFinal (){

        if (InicioV == 0){
            System.out.println("Entras a un enorme castillo, hay un gran pasillo, donde al fondo logras ver una silueta particular...\n" +
                    CLI.morado + "Pepe El Mago: " + CLI.blanco + "Veo que por fin has llegado...\"heroe\"...Sé que eres tu quien a estado derrotando a\n" +
                    "              mis secuaces, debo decir, estoy ligeramente sorprendido, pero, crees que será suficiente para poder derrotarme?");
            System.out.println("\nEl aire es pesado, sabes que no tendrás otra oportunidad como esta, es hora, cada músculo de tu cuerpo lo sabe" +
                    " es la hora final");
            InicioV = 1;

        }

//Imprime los stats de los peleadores

        System.out.println("Vida: " + PeleaPeleaPelea.vidaTotal + "                         " + "Vida del Mago: " + vidaTotalDelMago);
        System.out.println("Ataque: " + PeleaPeleaPelea.ataqueTotal + "                       " + "Ataque del Mago: " + poderTotalDelMago);

        do {//Menu de acción
            MenuPeleaMago.showMenu();
            var option = MenuPeleaMago.readOption();
            MenuPeleaMago.selectAndRunOption(option);
        }while (MenuPeleaMago.isAlive());

    }
    public static MenuAccionesAction Golpe = (scanner) -> {
        System.out.println("Cargas un ataque con tu espada!");

        defensaActiva = false;
        PeleaMago.turnoDelMago();

    };

    public static MenuAccionesAction Defensa = (scanner)  -> {
        System.out.println("Te preparas para recibir un ataque!");
        defensaActiva = true;
        PeleaMago.turnoDelMago();

    };

    public static MenuAccionesAction Curación = (scanner)  -> {
        if (ConstruirCasas.pizzas == 0){
            System.out.println("No tienes con que curarte...quizá debiste guardar un poco más...");
            PeleaMago.LaHoraFinal();
        }else {
            System.out.println("Das una buena mordida a esa pizza y obtienes vida!");
            System.out.println("Tienes " + CLI.verde + ConstruirCasas.pizzas +"pizzas!" + CLI.blanco);
            PeleaPeleaPelea.vidaTotal = PeleaPeleaPelea.vidaTotal + (PeleaPeleaPelea.vidaTotal / 2);
            ConstruirCasas.pizzas = ConstruirCasas.pizzas - 1;
            PeleaMago.LaHoraFinal();
        }
    };

    static {//Menu
        MenuPeleaMago.addOptions(Golpear, Golpe);
        MenuPeleaMago.addOptions(Defender, Defensa);
        MenuPeleaMago.addOptions(Curarse, Curación);
        MenuPeleaMago.crearMenu();
    }
//Menu donde el mago toma acción y pasan todos los calculos
    public static void turnoDelMago(){
        accionRandom = (int)(Math.random() * 2 + 1); //Sí el random es 1 el mago ataca, sí es 2 se defiende
        if (accionRandom == 1) {
            System.out.println("El mago te a atacado!");
            if (defensaActiva == true){//Sí el jugador se defiende volvemos a generar un numero aleatorio
                accionRandom = (int)(Math.random() * 10 + 1);
                //Sí el número está entre 1 y 6, bloquea la mitad del daño
                if (accionRandom >= 1 && accionRandom <= 6){
                    PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - (poderTotalDelMago/ 2));
                    PeleaMago.revisionSalud();
                }
                //Sí el numero esta entre 7 y 9 bloquea 3/4 del ataque
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El heroe se defiende de manera genial!" + CLI.blanco);
                    PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - (poderTotalDelMago/ 4));
                    PeleaMago.revisionSalud();
                }
                //Sí el numero es 10 bloquea completamente el ataque
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El heroe se defiende de manera perfecta!" + CLI.blanco);
                    PeleaMago.revisionSalud();
                }


            }else {//Sí el jugador ataca, tambien generamos otro numero
                accionRandom = (int)(Math.random() * 10 + 1);
                //Sí el numero está entre 1 y 6, ambos reciben un daño normal
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaTotalDelMago = vidaTotalDelMago - PeleaPeleaPelea.ataqueTotal;
                    PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - (poderTotalDelMago));
                    PeleaMago.revisionSalud();
                }
//Sí esta entre 7 y 9 se vuelve a generar un numero aleatorio
                if (accionRandom >= 7 && accionRandom <= 9){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    //Sí cae entre 1 y 5 el mago golpea con bonus al heroe
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.azul + "El mago lanza un fuerte hechizo!" + CLI.blanco);
                        PeleaPeleaPelea.vidaTotal = (int) (PeleaPeleaPelea.vidaTotal - (poderTotalDelMago * 1.5));
                        vidaTotalDelMago = vidaTotalDelMago - PeleaPeleaPelea.ataqueTotal;

                    }
                    //Sí cae entre 6 y 10 el heroe golpea con bonus al mago
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.azul + "El heroe da un buen golpe!" + CLI.blanco);
                        PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - poderTotalDelMago);
                        vidaTotalDelMago = (int) (vidaTotalDelMago - (PeleaPeleaPelea.ataqueTotal * 1.5));

                    }

                    PeleaMago.revisionSalud();

//Sí es 10, se vuelve a generar un numero aleatorio
                }
                if (accionRandom == 10){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    //Sí cae entre 1 y 5 el mago golpea con el doble al heroe
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.amarillo + "El mago lanza un hechizo critico!" + CLI.blanco);
                        PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - (poderTotalDelMago * 2));
                        vidaTotalDelMago = vidaTotalDelMago - PeleaPeleaPelea.ataqueTotal;

                    }
                    //Sí cae entre 6 y 10 el heroe golpea con critico al mago
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.amarillo + "El heroe acierta un critico!" + CLI.blanco);
                        PeleaPeleaPelea.vidaTotal = (PeleaPeleaPelea.vidaTotal - poderTotalDelMago);
                        vidaTotalDelMago = (vidaTotalDelMago - (PeleaPeleaPelea.ataqueTotal * 2));
                    }

                    PeleaMago.revisionSalud();
                }

            }

        }
        if (accionRandom == 2){//El mago se defiende
            System.out.println("El mago se defiende del golpe!");
            if (defensaActiva == true){//Sí ambos se defienden, no pasa nada
                accionRandom = 0;
                PeleaPeleaPelea.defensaActiva = false;
                PeleaMago.revisionSalud();
            }
            else {//Sí el número está entre 1 y 6, bloquea la mitad del daño
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaTotalDelMago = vidaTotalDelMago - (PeleaPeleaPelea.ataqueTotal / 2);
                    PeleaMago.revisionSalud();
                }//Sí el número está entre 7 y 9, bloquea 3/4 del daño
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El mago invoca un escudo!" + CLI.blanco);
                    vidaTotalDelMago = vidaTotalDelMago - (PeleaPeleaPelea.ataqueTotal / 4);
                    PeleaMago.revisionSalud();
                }//Sí el numero es 10 bloquea todo el daño
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El mago repele el ataque!" + CLI.blanco);
                    PeleaMago.revisionSalud();
                }


            }

        }

    }
//Revisamos la salud de los personajes
    public static void revisionSalud(){
        //Sí ambos tienen más de 0 de vida, la pelea continua
        if (vidaTotalDelMago > 0 && PeleaPeleaPelea.vidaTotal > 0){
            accionRandom = 0;
            PeleaPeleaPelea.defensaActiva = false;
            PeleaMago.LaHoraFinal();
        }

        if (vidaTotalDelMago <= 0){
            //Sí el mago queda sin vida, el heroe gana y vamos a la victoria
            System.out.println("Felicidades! Derrotaste al Mago!\nSe viene un mañana brillante para el bosque");

            FinalDelJuego.Victoria();
        }
//Sí el heroe queda sin vida, vamos al menu de derrota
        if (PeleaPeleaPelea.vidaTotal <= 0){
            System.out.println("Oh no...el heroe ha caído...quizá en otra vida...");
            System.out.println("Fin del juego...");
            PeleaPeleaPelea.vidaBase = 40;
            PeleaPeleaPelea.vidaOgro = 50;
            PeleaPeleaPelea.vidaOgro = (int) (PeleaPeleaPelea.vidaOgro * (PeleaPeleaPelea.ogrosMuertos + 1));
            PeleaPeleaPelea.ataqueOgroTotal = (int) (PeleaPeleaPelea.ataqueOgro * (PeleaPeleaPelea.ogrosMuertos + 1));
            PeleaPeleaPelea.vidaTotal = (int) (PeleaPeleaPelea.vidaBase * (PeleaPeleaPelea.multiplicadorDeVida + 1));
            PeleaPeleaPelea.ataqueTotal = (int) (PeleaPeleaPelea.ataqueBase * (PeleaPeleaPelea.multiplicadordeFuerza + 1));
            PeleaPeleaPelea.peleaV = 0;
            FinalDelJuego.Derrota();
        }

    }

}

