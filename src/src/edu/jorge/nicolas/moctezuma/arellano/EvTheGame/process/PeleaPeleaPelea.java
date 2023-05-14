package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process;

import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.CLI;
import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui.FinalDelJuego;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAcciones;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAccionesAction;


public class PeleaPeleaPelea {
    //menu de acciones en la pelea del bosque
    private static MenuAcciones menuPelea = new MenuAcciones();
    //menu de acciones en la pelea de la mazmorra
    private static MenuAcciones menuPeleaMazmorra = new MenuAcciones();
    //Botones del menu
    private static String Golpear = "Atacar";
    private static String Defender = "Defender";
    private static String Curarse = "Curarse";
    //Contadores de hadas
    static int HadasLiberadas ;
    static int hadasSinCasa = 0;
    //Multiplicadores
    static double multiplicadordeFuerza;
    static double multiplicadorDeVida = (ConstruirCasas.HadasConCasa * 0.1);
    //Vida Heroe
    static int vidaBase = 40;
    static int vidaTotal = (int) (vidaBase * (multiplicadorDeVida + 1));
    //Vida ogro
    static int vidaOgro = 50;
    //Ataque heroe
    static int ataqueBase = 8;
    static int ataqueTotal = (int) (ataqueBase * (multiplicadordeFuerza + 1));
    //Ataque ogro
    static int ataqueOgro = 9;
    //generador de numero aleatorio
    static int accionRandom;
    //dialogo unico
    static int peleaV = 0;
    //defensa del jugador
    static boolean defensaActiva = false;
    //contador de ogros muertos
    static double ogrosMuertos;
    //multiplicador de fuerza ogro
    static double fuerzaOgro;
    //Generador de ataque ogro total
    static double ataqueOgroTotal = (int) (ataqueOgro * (fuerzaOgro + 1));

//Pelea ogro del bosque
    public static void PeleaOgro(){
        if (peleaV == 0){
            System.out.println("Tienes al ogro frente a ti, es hora de probar tus habilidades!");
            peleaV = 1;
        }
//Aclarar desventaja
        if (IrAlBosque.desventaja == true){
            vidaTotal = vidaTotal / 2;
            IrAlBosque.desventaja = false;
        }

//mostrar stats
        System.out.println("Vida: " + vidaTotal + "                         " + "Vida del ogro: " + vidaOgro);
        System.out.println("Ataque: " + ataqueTotal + "                       " + "Ataque del ogro: " + ataqueOgroTotal);

        do {
            menuPelea.showMenu();
            var option = menuPelea.readOption();
            menuPelea.selectAndRunOption(option);
        }while (menuPelea.isAlive());

    }//Opciones
    public static MenuAccionesAction Golpe = (scanner) -> {
        System.out.println("Cargas un ataque con tu espada!");

        defensaActiva = false;
        PeleaPeleaPelea.TurnoDelOgro();

    };

    public static MenuAccionesAction Defensa = (scanner)  -> {
        System.out.println("Te preparas para recibir un ataque!");
        defensaActiva = true;
        PeleaPeleaPelea.TurnoDelOgro();

    };

    public static MenuAccionesAction Curación = (scanner)  -> {
        if (ConstruirCasas.pizzas == 0){
            System.out.println("No tienes con que curarte...quizá las hadas te den algo al darles un hogar!");
            PeleaPeleaPelea.PeleaOgro();
        }else {
            System.out.println("Das una buena mordida a esa pizza y obtienes vida!");
            System.out.println("Te quedan " + CLI.verde + ConstruirCasas.pizzas + "pizzas!" + CLI.blanco);
            vidaTotal = vidaTotal + (vidaTotal / 2);
            ConstruirCasas.pizzas = ConstruirCasas.pizzas - 1;
             PeleaPeleaPelea.PeleaOgro();
        }
    };

    static {
        menuPelea.addOptions(Golpear,Golpe);
        menuPelea.addOptions(Defender, Defensa);
        menuPelea.addOptions(Curarse, Curación);
        menuPelea.crearMenu();
    }


//Menu turno del ogro (Funciona igual que PeleaMago
    public static void TurnoDelOgro(){
        accionRandom = (int)(Math.random() * 2 + 1);
        if (accionRandom == 1) {
            System.out.println("El ogro te a atacado!");
            if (defensaActiva == true){
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal/ 2));
                    PeleaPeleaPelea.revisionDeSalud();
                }
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El heroe se defiende de manera genial!" + CLI.blanco);
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal/ 4));
                    PeleaPeleaPelea.revisionDeSalud();
                }
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El heroe se defiende de manera perfecta!" + CLI.blanco);
                    PeleaPeleaPelea.revisionDeSalud();
                }


            }else {
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaOgro = vidaOgro - ataqueTotal;
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                    PeleaPeleaPelea.revisionDeSalud();
                }

                if (accionRandom >= 7 && accionRandom <= 9){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.azul + "El ogro da un buen golpe!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal * 1.5));
                        vidaOgro = vidaOgro - ataqueTotal;

                    }
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.azul + "El heroe da un buen golpe!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                        vidaOgro = (int) (vidaOgro - (ataqueTotal * 1.5));

                    }

                    PeleaPeleaPelea.revisionDeSalud();
                }
                if (accionRandom == 10){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.amarillo + "El ogro acierta un critico!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal * 2));
                        vidaOgro = vidaOgro - ataqueTotal;

                    }
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.amarillo + "El heroe acierta un critico!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                        vidaOgro = (vidaOgro - (ataqueTotal * 2));
                    }

                    PeleaPeleaPelea.revisionDeSalud();
                }

            }

        }
        if (accionRandom == 2){
            System.out.println("El ogro se defiende del golpe!");
            if (defensaActiva == true){
                accionRandom = 0;
                PeleaPeleaPelea.defensaActiva = false;
                PeleaPeleaPelea.revisionDeSalud();
            }
            else {
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaOgro = vidaOgro - (ataqueTotal / 2);
                    PeleaPeleaPelea.revisionDeSalud();
                }
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El ogro hace una gran defensa!" + CLI.blanco);
                    vidaOgro = vidaOgro - (ataqueTotal / 4);
                    PeleaPeleaPelea.revisionDeSalud();
                }
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El ogro se defiende perfectamente!" + CLI.blanco);
                    PeleaPeleaPelea.revisionDeSalud();
                }


            }

        }

    }

    public static void revisionDeSalud(){

        if (vidaOgro > 0 && vidaTotal > 0){
            accionRandom = 0;
            PeleaPeleaPelea.defensaActiva = false;
            PeleaPeleaPelea.PeleaOgro();
        }

        if (vidaOgro <= 0){
            System.out.println("Felicidades! Derrotaste al ogro!\nAhora tu recompensa");
            vidaBase = 40;
            vidaOgro = 50;
            vidaOgro = (int) (vidaOgro * (ogrosMuertos + 1));
            vidaTotal = (int) (vidaBase * (multiplicadorDeVida + 1));
            multiplicadordeFuerza = multiplicadordeFuerza + .1;
            ataqueTotal = (int) (ataqueBase * (multiplicadordeFuerza + 1));
            ogrosMuertos = ogrosMuertos + .1;
            peleaV = 0;
            IrAlBosque.resultadoMadera();
        }

        if (vidaTotal <= 0){
            System.out.println("Oh no...el heroe ha caído...quizá en otra vida...");
            System.out.println("Fin del juego...");
            vidaBase = 40;
            vidaOgro = 50;
            vidaOgro = (int) (vidaOgro * (ogrosMuertos + 1));
            ataqueOgroTotal = (int) (ataqueOgro * (fuerzaOgro + 1));
            vidaTotal = (int) (vidaBase * (multiplicadorDeVida + 1));
            ataqueTotal = (int) (ataqueBase * (multiplicadordeFuerza + 1));
            peleaV = 0;
            FinalDelJuego.Derrota();
        }

    }

    public static void PeleaOgroMazmo(){
        if (peleaV == 0){
            System.out.println("Tienes al ogro frente a ti, es hora de probar tus habilidades!");
            peleaV = +1;
        }

        if (IrAlBosque.desventaja == true){
            vidaTotal = vidaTotal / 2;
            IrAlBosque.desventaja = false;
        }
        if (IrAlBosque.ventaja == true){
            vidaOgro = vidaOgro / 2;
            IrAlBosque.ventaja = false;
        }


        System.out.println("Vida: " + vidaTotal + "                       " + "Vida del ogro: " + vidaOgro);
        System.out.println("Ataque: " + ataqueTotal + "                       " + "Ataque del ogro: " + ataqueOgroTotal);

        do {
            menuPeleaMazmorra.showMenu();
            var option = menuPeleaMazmorra.readOption();
            menuPeleaMazmorra.selectAndRunOption(option);
        }while (menuPeleaMazmorra.isAlive());

    }
    public static MenuAccionesAction GolpeMazmo = (scanner) -> {
        System.out.println("Cargas un ataque con tu espada!");
        defensaActiva = false;
        PeleaPeleaPelea.TurnoDelOgroMazmo();

    };

    public static MenuAccionesAction DefensaMazmo = (scanner)  -> {
        System.out.println("Te preparas para recibir un ataque!");
        defensaActiva = true;
        PeleaPeleaPelea.TurnoDelOgroMazmo();

    };
    public static MenuAccionesAction CuraciónMazmo = (scanner)  -> {
        if (ConstruirCasas.pizzas == 0){
            System.out.println("No tienes con que curarte...quizá las hadas te den algo al darles un hogar!");
            PeleaPeleaPelea.PeleaOgro();
        }else {
            System.out.println("Das una buena mordida a esa pizza y obtienes vida!");
            System.out.println("Te quedan " + CLI.verde + ConstruirCasas.pizzas + "pizzas!" + CLI.blanco);
            vidaTotal = vidaTotal + (vidaTotal / 2);
            ConstruirCasas.pizzas = ConstruirCasas.pizzas - 1;
            PeleaPeleaPelea.PeleaOgro();
        }
    };

    static {
        menuPeleaMazmorra.addOptions(Golpear,GolpeMazmo);
        menuPeleaMazmorra.addOptions(Defender, DefensaMazmo);
        menuPeleaMazmorra.addOptions(Curarse, CuraciónMazmo);
        menuPeleaMazmorra.crearMenu();
    }



    public static void TurnoDelOgroMazmo(){
        accionRandom = (int)(Math.random() * 2 + 1);
        if (accionRandom == 1) {
            System.out.println("El ogro te a atacado!");
            if (defensaActiva == true){
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal/ 2));
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El heroe se defiende de manera genial!" + CLI.blanco);
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal/ 4));
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El heroe se defiende de manera perfecta!" + CLI.blanco);
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }


            }else {
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaOgro = vidaOgro - ataqueTotal;
                    vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }

                if (accionRandom >= 7 && accionRandom <= 9){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.azul + "El ogro da un buen golpe!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal * 1.5));
                        vidaOgro = vidaOgro - ataqueTotal;

                    }
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.azul + "El heroe da un buen golpe!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                        vidaOgro = (int) (vidaOgro - (ataqueTotal * 1.5));

                    }

                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }
                if (accionRandom == 10){
                    accionRandom = (int)(Math.random() * 10 + 1);
                    if (accionRandom >= 1 && accionRandom <= 5){
                        System.out.println(CLI.amarillo + "El ogro acierta un critico!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal * 2));
                        vidaOgro = vidaOgro - ataqueTotal;

                    }
                    if(accionRandom >= 6 && accionRandom <= 10){
                        System.out.println(CLI.amarillo + "El heroe acierta un critico!" + CLI.blanco);
                        vidaTotal = (int) (vidaTotal - (ataqueOgroTotal));
                        vidaOgro = (vidaOgro - (ataqueTotal * 2));
                    }

                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }

            }

        }
        if (accionRandom == 2){
            System.out.println("El ogro se defiende del golpe!");
            if (defensaActiva == true){
                accionRandom = 0;
                PeleaPeleaPelea.defensaActiva = false;
                PeleaPeleaPelea.revisionDeSaludMazmorra();
            }
            else {
                accionRandom = (int)(Math.random() * 10 + 1);
                if (accionRandom >= 1 && accionRandom <= 6){
                    vidaOgro = vidaOgro - (ataqueTotal / 2);
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }
                if (accionRandom >= 7 && accionRandom <= 9){
                    System.out.println(CLI.azul + "El ogro hace una gran defensa!" + CLI.blanco);
                    vidaOgro = vidaOgro - (ataqueTotal / 4);
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }
                if (accionRandom == 10){
                    System.out.println(CLI.amarillo + "El ogro se defiende perfectamente!" + CLI.blanco);
                    PeleaPeleaPelea.revisionDeSaludMazmorra();
                }


            }

        }

    }

    public static void revisionDeSaludMazmorra(){

        if (vidaOgro > 0 && vidaTotal > 0){
            PeleaPeleaPelea.PeleaOgroMazmo();
        }

        if (vidaOgro <= 0){
            System.out.println("Felicidades! Derrotaste al ogro!\nAhora tu recompensa");
            vidaBase = 40;
            vidaOgro = 50;
            vidaOgro = (int) (vidaOgro * (ogrosMuertos + 1));
            ataqueOgroTotal = (int) (ataqueOgro * (fuerzaOgro + 1));
            vidaTotal = (int) (vidaBase * (multiplicadorDeVida + 1));
            multiplicadordeFuerza = multiplicadordeFuerza + .2;
            ataqueTotal = (int) (ataqueBase * (multiplicadordeFuerza + 1));
            fuerzaOgro = fuerzaOgro + .1;
            ogrosMuertos = ogrosMuertos + .2;
            peleaV = 0;
            IrAlBosque.resultadoHadas();
        }

        if (vidaTotal <= 0){
            System.out.println("Oh no...el heroe ha caído...quiza en otra vida...");
            System.out.println("Fin del juego...");
            vidaBase = 40;
            vidaOgro = 50;
            vidaOgro = (int) (vidaOgro * (ogrosMuertos + 1));
            ataqueOgroTotal = (int) (ataqueOgro * (ogrosMuertos + 1));
            vidaTotal = (int) (vidaBase * (multiplicadorDeVida + 1));
            peleaV = 0;
            FinalDelJuego.Derrota();
        }

    }


}
