package edu.jorge.nicolas.moctezuma.arellano.reto11.process;

public class Manager extends Empleado implements Interviewer {
    /**
     * nuestro Manager es capaz de hacer entrevistas y hereda a los empleados
     */
    @Override
    public void trabajar(){}

    @Override
    public void interview(){
        System.out.println("Se encarga de saber lo que puedes hacer");
    }
    @Override
    public int compareTo(Empleado empleado){ return name.compareTo(empleado.name); }
}
