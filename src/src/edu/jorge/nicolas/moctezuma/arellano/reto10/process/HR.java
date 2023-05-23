/**
 * En esta pagina de process como varías otras, podrémos encontrar atributos, constructores, metodos y los getters y setters
 */
package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public class HR extends Empleado implements Interviewer {
    private int numEmpleados;
    public HR(){}
    public HR(String nombre, String apellido, int edad, int numTel, int numSegSo, int numEmpleados){
        super(nombre, apellido, edad, numTel, numSegSo);
        this.numEmpleados = numEmpleados;
    }

    @Override
    public void trabajar(){}
    @Override
    public void interview(){}

    public int getNumEmpleados() {
        return numEmpleados;
    }
    public void setNumEmpleados(int numEmpleados){
        this.numEmpleados = numEmpleados;
    }
}
