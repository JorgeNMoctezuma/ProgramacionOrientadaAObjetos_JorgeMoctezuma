package edu.jorge.nicolas.moctezuma.arellano.reto10.ui;
import edu.jorge.nicolas.moctezuma.arellano.reto10.process.*;

public class CLI {
    public static void mostrarMenu(){
        JrEngineer jr1 = new JrEngineer("A", "B", "Java, C#", 11111, 22222, 20);
        SrEnginner sr1 = new SrEnginner("C", "D", 21, 33333, 44444, "PHP, C++, C", 5);
        Manager mng1 = new Manager("E", "F", 22, 55555, 66666, 121212);
        CEO ceo1 = new CEO("G", "H", 23, 77777, 88888, 13131313, 6);
        HR hr1 = new HR("I", "J", 23, 99999, 00000, 7);

        JrEngineer jr2 = new JrEngineer("A", "B", "Java, C#", 11111, 22222, 20);
        JrEngineer jr3 = new JrEngineer("A", "B", "Java, C#", 11111, 22222, 20);
        SrEnginner sr2 = new SrEnginner("C", "D", 21, 33333, 44444, "PHP, C++, C", 5);

        testEmpleado(jr1);
        testEmpleado(mng1);
        System.out.println();

        testProgrammer(sr1);
        testProgrammer(hr1);
        System.out.println();

        testInterviewer(jr2);
        testInterviewer(sr1);
    }

    public static void testEmpleado(Object object){
        if (object instanceof Empleado){
            System.out.println("Trabaja para nosotros");
        }else {
            System.out.println("No trabaja para nosotros");
        }
    }

    public static void testProgrammer(Object object){
        if (object instanceof Programmer){
            System.out.println("Sí sabe programar");
        }else {
            System.out.println("No sabe programar");
        }
    }
    public static void testInterviewer(Object object){
        if (object instanceof Interviewer){
            System.out.println("Sí sabe entrevistar");
        }else {
            System.out.println("No sabe entrevistar");
        }
    }
}
