package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public class SrEnginner extends JrEngineer implements Interviewer{
    private int antiguedad;

    public SrEnginner(){}

    public SrEnginner(String nombre, String apellido, int edad, int numTel, int numSegSo, String lenguaje, int antiguedad){
        super(nombre, apellido, lenguaje, edad, numTel, numSegSo);
        this.antiguedad = antiguedad;
    }

    @Override
    public void trabajar(){
        System.out.println("Trabaja bien");
    }
    @Override
    public void programar(){
        System.out.println("Le sabe a programar");
    }
    @Override
    public void interview(){
        System.out.println("Te pregunta que es un hash map");
    }

    public int getAntiguedad(){
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad){
        this.antiguedad = antiguedad;
    }
}
