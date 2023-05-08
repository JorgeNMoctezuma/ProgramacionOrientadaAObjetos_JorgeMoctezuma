package edu.jorge.nicolas.moctezuma.arellano.reto11.Clase;

import java.util.ArrayList;
import java.util.List;

public class TestLambas {
    public static void main(String[] args) {
        OperacionAritmetica suma = (a, b) -> a + b;
        System.out.println(suma.apply(5, 6));
        StringOperation concatenar = (a, b) -> a + b;
        System.out.println(concatenar.applys("Waos ", "Causa "));

        List<String> lista = new ArrayList<>();
        lista.add("Pitufo");
        lista.add("Atun");
        lista.add("Gato");
        lista.add("Queso");
        lista.add("Cambio");

        lista.stream().filter(palabra -> palabra.length()>4)
                .map(palabra -> palabra.toUpperCase())
                .sorted()
                .limit(2)
                //.forEach(palabra -> System.out.println(palabra));
                .forEach(System.out::println);

    }
}