/**
 * En esta pagina de process como varías otras, podrémos encontrar atributos, constructores, metodos y los getters y setters
 */
package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public class CEO extends Manager{
    private int dictadura;

    public CEO(){}
    public CEO(String nombre, String apellido, int edad, int numTel, int numSegSo, int presupuesto, int dictadura){
        super(nombre, apellido, edad, numTel, numSegSo, presupuesto);
        this.dictadura = dictadura;
    }

    @Override
    public void trabajar(){
    }
    @Override
    public void interview(){
    }

    public void setDictadura(int dictadura){
        this.dictadura = dictadura;
    }
}
