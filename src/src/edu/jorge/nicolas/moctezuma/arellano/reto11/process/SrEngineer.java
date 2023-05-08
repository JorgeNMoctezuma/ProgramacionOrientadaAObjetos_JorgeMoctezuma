package edu.jorge.nicolas.moctezuma.arellano.reto11.process;

public class SrEngineer extends JrEngineer implements Interviewer{
    /**
     * aquí funcionando con más herencias, ya que los senior saben lo que los juniors saben
     * y saben hacer entrevistas
     */
    public SrEngineer(){}

    public SrEngineer(String name, int age){
        super(name, age);
    }
    @Override
    public void programar(){
        System.out.println("Programa cosas raras");
    }
    @Override
    public void interview(){
        System.out.println("Trabaja mucho muchito");
    }
}
