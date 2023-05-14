package edu.jorge.nicolas.moctezuma.arellano.EvTheGame.ui;
import edu.jorge.nicolas.moctezuma.arellano.EvTheGame.process.JuegoMago;
import edu.jorge.nicolas.moctezuma.arellano.utils.MenuAction;
import edu.jorge.nicolas.moctezuma.arellano.utils.Menu;
import java.util.Scanner;

public class CLI {
    //Este de aquí es el que genera un menu opciones
    private static Menu menu = new Menu();
    //Estos de aquí son colores para hacer el texto bonito
    public static final String blanco = "\u001B[0m";
    public static final String amarillo = "\u001B[33m";
    public static final String rojo = "\u001B[31m";
    public static final String azul = "\u001B[34m";
    public static final String verde = "\u001B[32m";
    public static final String morado = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String amapato = "\u001B[93m";
//Salida para cerrar el juego en caso de querer salir
    public static void alternativeExit(){
        String alternativeExitNumber = "0";
        if (alternativeExitNumber.equals("0")){
            menu.killMenu();
        }
    }
    //Botones del menu
    private static String Instrucciones = "Instrucciones (Recomendado para nuevos jugadores)";
    private static String JugarJuegazo = "Jugar";
    //Nombre de jugador
    public static String Jugador;
    //Mensajes de introducción
    private static String bienvenida = "Hace muchos años, en un reino muy lejano, el malvado hechicero Pepe el Mago \natrapo " +
                                        "a las hadas para aumentar su dolor, pero no contaba con la valentía del heroe llamado...";
    private static String bienvenida2 = ",con su fuerza, el construiría un hogar para todas esas hadas, y al liberarlas el\n" +
                                        "podría acabar con el temible Pepe el mago para siempre, aquí inicia tu aventura";
    //Primera opción, Jugar
    private static MenuAction iniciarElJuegazo = (scanner) -> {
        System.out.println(bienvenida);
        Jugador = scanner.next();
        System.out.println(Jugador + bienvenida2);
        System.out.println();
        JuegoMago.inicioDelJuego();
        alternativeExit();
    };
    //Segunda opción, Instrucciones
    private static MenuAction InstruccionesDelJuegazo = (scanner)  -> {
        System.out.println("Este juego tiene mecánicas que poco o nada serán explicadas más adelante, así que, vamos a ver\n" +
                amapato + "Mecánicas de combate: \n" + rojo + "Atacar" + blanco +": Al entrar en combate, puedes elegir esta opción para atacar a tu enemigo" +
                "hay 3 ataques\n - Ataque normal: Infringes un daño normal con tus stats (Golpe más común)\n - Ataque fuerte: Infringes el doble de daño (Golpe muy raro)\n" + amarillo + " - Ataque critico:" + blanco +  "Infringes el doble de daño (Ultra raro)\n" + azul +
                "Defenderse:" + blanco +" Al entrar en combate puedes usar esta opción para bloquear los daños de tu enemigo, existiendo 3 tipos de defensas\n - Defensa base: Bloqueas la mitad del daño recibido (Defensa común)\n - Defensa ferrea: Bloqueas 3/4 del ataque recibido (Bloqueo raro)" + amarillo +
                "\n - Defensa perfecta: " + blanco + "Bloqueas todo el daño recibido" + verde +
                "\nItems: " + blanco + "Obtendrás objetos con los que podrás curarte cuando hadas vayan a vivir a las casas que construyas, recuperando una porción de tu salud!\n" + amapato +
                "Enemigos:\n" + cyan + " - Ogro: " + blanco + "El enemigo promedio del juego, puede atacar, defenderse, y se hará más fuerte y duradero mientras otros ogros mueran\n" + morado +
                " - Pepe el Mago: " + blanco + "Jefe final del juego, es tan poderoso como hadas hay capturadas, por lo que tendrás que liberarlas a todas para que su poder disminuya" + amapato +
                "\nMecánicas de juego: \n "+ cyan + "- Liberar hadas: " + blanco + "Al derrotar ogros en mazmorras, podrás liberar hadas, aleatoriamente entre 1 y 3, disminuyendo el poder del mago\n"+ amarillo + "     -> Escabullirse: " + blanco + "Hay una pequeña posibilidad de acercarse sigilosamente al ogro guardia, lo que te dará una ventaja en pelea,\n" +
                "                      pero si fallas, él te golpeará e iniciarás la pelea con menos vida!\n" + verde +
                " - Recolectar madera: " + blanco + "Al ir al bosque tendrás que pelear con un ogro para obtener la madera, pudiendo obtener de 1 a 3 maderas, pudiendo construir casas \n                      para las hadas\n" + amarillo + "     -> Escabullirse: " + blanco + "Hay una pequeña posibilidad de acercarse sigilosamente al ogro, lo que te dará la posibilidad de\n" +
                "                      obtener la madera sin necesidad de enfrentarlo, pero si fallas, él te golpeará e iniciarás la pelea con menos vida!\n" + morado + " - Construir casas: " + blanco +
                "Necesitarás 2 de madera para construir una casa y 2 hadas que vivan en ella, al tener eso listo, \n                    ellas te darán un obsequio por ayudarlas\n" + amapato +
                "Aumentar estadísticas: \n" + rojo + "Ataque: " + blanco + "Al matar algunos ogros, verás como tu fuerza empieza a crecer, aunque cuidado, mientras más ogros mates\nmás fuertes también se harán " + verde +
                "\nVida: " + blanco + "Al construir casas para las hadas, tus puntos de vida irán aumentando, aunque recuerda que necesitas madera y liberar hadas para ello ");
    };
    //El menu
    static {
        menu.addOptions(JugarJuegazo, iniciarElJuegazo);
        menu.addOptions(Instrucciones, InstruccionesDelJuegazo);
        menu.crearMenu();
    }
    //Iniciar el menu
    public static void iniciarJuegoMago(){
        do {
            menu.showMenu();
            var option = menu.readOption();
            menu.selectAndRunOption(option);
        }while (menu.isAlive());
    }
}
/**
 *
 * Dar referencias a:
 * https://www.campusmvp.es/recursos/post/como-cambiar-los-colores-de-la-consola-con-java-y-system-out-println.aspx
 *
 Puntero: una direccion de memoria
 va a los nodos, y ese nodo apunta al seguiente elemento, va "Creciendo" de manera dinamica.
 Arraylist: un arreglo encapsulado dentero de un objeto, sus elementos son continuos - bueno para leer rapido (por los elementos
    vecinos), lo usamos cuando queremos agregar cosas, pero no borrar
 Linked-list: sus elementos están dispersos por la memoria - los elementos se leen individualmente, no es el más rapido en lectura
    es mejor en borrar cosas (aunque no las borra, solo se las brinca y el caché lo borra después), si el algoritmo requiere borrar
    y agregar cosas

 Sort: ordenar por orden de ordenamiento (por clases específicas puestas en orden)

 Tiempo constante: No importa que tanta info tenga, simpre se va a tardar el mismo tiempo en buscarla y anotarla
 Tiempo lineal: Se va a tardar un tiempo definido para leer y escribir la información pedida/solicitado
 Tiempo exponencial: aumenta por si mismo (lo que pasa si tenemos un for dentro de un for)

 Hashmap: son eficientes en tiempo aunque no en memoria, es muy importante, "A mayor tiempo hay mayor memoria y vise versa"
    más comprimida la imagen = menos espacio pero más tiempo para descomprimirla
    menos comprimida la imagen = más espacio pero menos tiempo para descomprimirla

 JSON = JavaScript Object Notation

 Cuando usamos una @FuncionalInterface
    Static = Crear objeto q no se mueve / esta aqui por utilidad
    Default = algo ya predefinido (tu lo predefines) /esta aquí de manera opcional
    Abstract = / está aqui obligada

 Functional Descriptor:
    @FunctionalInterface
    public interface OperacionAritmetica {
    int operacion(int a, int b);

    default void operacion(int a, int b) {

     }
 }
 En este contexto es lo que hace, su firma es lo importante

 ╚==Buscar Cheat sheetÃ

 BUSCAR:
    -Predicate = Puede ser verdadero y falso, un predicamento que tiene una respuesta
    -Supplier = Aquel objeto que proporciona algo, es generico
    -Consumer = No devuelve información, solo la procesa
    -Function = Aquella funcion que recibe un dato, y lo transforma a otro tipo de dato



 Una exprecion final es una que ya ejecuta todo lo que está ahí
 una intermedia es la que espera algo más para poder terminar
 */