package edu.jorge.nicolas.moctezuma.arellano.reto11.process;
import java.util.Objects;

<<<<<<< Updated upstream
public abstract class Empleado {
    private String Nombre;
    private String Apellido;
    private int Edad;
    private int NumTel;
    private int NumSegSo;

    public Empleado(){}

    public Empleado(String Nombre, String Apellido, int Edad, int NumTel, int NumSegSo){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.NumTel = NumTel;
        this.NumSegSo = NumSegSo;
    }

    public abstract void chamba();
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " ; " + this.Nombre + " ; " + this.Apellido + " ; " + this.Edad + " ; " +
                this.NumTel + " ; " + this.NumSegSo;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Edad == empleado.Edad && NumTel == empleado.NumTel && NumSegSo == empleado.NumSegSo &&
                Objects.equals(Nombre, empleado.Nombre) && Objects.equals(Apellido, empleado.Apellido);
    }

    @Override
    public int hashCode(){
        return Objects.hash(Nombre, Apellido, Edad, NumTel, NumSegSo);
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public void setApellido(){
        this.Apellido = Apellido;
    }
    public int getEdad(){
        return Edad;
    }
    public void setEdad(int edad){
        this.Edad = Edad;
    }
    public int getNumTel(){
        return NumTel;
    }
    public void setNumTel(int numTel){
        this.NumTel = numTel;
    }
    public int getNumSegSo(){
        return NumSegSo;
    }
    public void setNumSegSo(int numSegSo){
        this.NumSegSo = NumSegSo;
    }
=======
/**
 * Aquí es donde sucede la magia sobre nuestros empleados y sus trabajos
 */
public abstract class Empleado implements  Comparable <Empleado>{
        int age;
        String name;
        public Empleado() {}

        @Override
        public int compareTo(Empleado empleado){
            return name.compareTo(empleado.name);
        }

        public Empleado(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public void trabajar(){
            System.out.println("Trabajo genérico");
        };

        @Override
        public String toString() {
            return "Employee: " +
                    name +
                    "; Age: " + age ;
        }
>>>>>>> Stashed changes

}
