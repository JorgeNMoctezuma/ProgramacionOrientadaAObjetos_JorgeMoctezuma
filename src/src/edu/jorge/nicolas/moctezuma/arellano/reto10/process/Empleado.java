package edu.jorge.nicolas.moctezuma.arellano.reto10.process;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private int numTel;
    private int numSegSo;

    public Empleado(){}

    public Empleado(String nombre, String apellido, int edad, int numTel, int numSegSo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numTel = numTel;
        this.numSegSo = numSegSo;
    }

    public abstract void trabajar();

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public int getNumTel(){
        return numTel;
    }
    public void setNumTel(int numTel){
        this.numTel = numTel;
    }
    public int getNumSegSo(){
        return numSegSo;
    }
    public void setNumSegSo(int numSegSo){
        this.numSegSo = numSegSo;
    }
}
