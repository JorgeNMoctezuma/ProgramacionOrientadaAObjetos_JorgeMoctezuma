/**
 * En esta pagina de process como varías otras, podrémos encontrar atributos, constructores, metodos y los getters y setters
 */
package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public class JrEngineer extends Empleado implements Programmer{

    private String lenguaje;

    public JrEngineer(){}

    public JrEngineer(String nombre, String apellido, String lenguaje, int edad, int numTel, int numSegSo){
        super(nombre, apellido, edad, numTel, numSegSo);
        this.lenguaje = lenguaje;
    }

    @Override
    public void trabajar(){
        System.out.println("Sabe cosas de ingeniero");
    }
    @Override
    public void programar(){
        System.out.println("Sabe programar");
    }

    public String getLenguaje(){
        return lenguaje;
    }
    public void setLenguaje(String lenguaje){
        this.lenguaje = lenguaje;
    }
}
