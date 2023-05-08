package edu.jorge.nicolas.moctezuma.arellano.reto11.process;

public class HR extends Empleado implements Interviewer {
    /**
     * Heredando de empleado, podemos poner a trabajar a los de recursos humanos
     */
    @Override
    public void trabajar(){
        System.out.println("Trabaja a punto de llorar");
    }
    @Override
    public void interview(){
        System.out.println("Revisando sí eres capaz");
    }
    @Override
    public int compareTo(Empleado empleado){
        return name.compareTo(empleado.name);
    }
}
