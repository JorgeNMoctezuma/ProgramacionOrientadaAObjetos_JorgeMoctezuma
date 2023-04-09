/**
 * En esta pagina de process como varías otras, podrémos encontrar atributos, constructores, metodos y los getters y setters
 */
package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public class Manager extends Empleado implements Interviewer{
    private int presupuesto;

    public Manager(){}

    public Manager(String nombre, String apellido, int edad, int numTel, int numSegSo, int presupuesto){
        super(nombre, apellido, edad, numTel, numSegSo);
        this.presupuesto = presupuesto;
    }

    @Override
    public void trabajar(){}
    @Override
    public void interview(){}

    public int getPresupuesto(){
        return presupuesto;
    }
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }

}
