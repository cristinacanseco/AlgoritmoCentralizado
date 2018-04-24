/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC;

/**
 *
 * @author Alumno
 */
public class Test {
    
    public static void main(String args[]){
        Coordinador coo = new Coordinador("Coordinador");
        Proceso p1 = new Proceso(1, coo);
        Proceso p2 = new Proceso(2, coo);
        Proceso p3 = new Proceso(3, coo);
        p1.start();
        p2.start();
        p3.start();
    }
    
}
