package edu.jorge.nicolas.moctezuma.arellano.reto11.process;
import edu.jorge.nicolas.moctezuma.arellano.reto11.ui.Programmer;
import java.util.Objects;

public class JrEngineer extends Empleado implements Programmer{
    private String lenguajes;
    private String rfc;

    public JrEngineer(){}

    public JrEngineer(String Nombre, String Apellido, int Edad, int NumTel, int NumSegSo, String lenguajes, String rfc){
        super(Nombre, Apellido, Edad, NumTel, NumSegSo);
        this.lenguajes = lenguajes;
        this.rfc = rfc;
    }

    @Override
    public void chamba(){
        System.out.println("Chambea en soluciones");
    }

    @Override
    public void programar(){
        System.out.println("Programa lo que puede");
    }
    @Override
    public String toString(){
        return super.toString() + " ; " + this.lenguajes + " ; " + this.rfc;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JrEngineer that = (JrEngineer) o;
        return Objects.equals(lenguajes, that.lenguajes) && Objects.equals(rfc, that.rfc);
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), lenguajes, rfc);
    }

    public String getLenguajes(){
        return lenguajes;
    }
    public void setLenguajes(String lenguajes){
        this.lenguajes = lenguajes;
    }
    public String getRfc(){
        return rfc;
    }
    public void setRfc(String rfc){
        this.rfc = rfc;
    }
}