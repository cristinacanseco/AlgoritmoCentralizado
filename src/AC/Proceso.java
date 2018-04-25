/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Proceso extends Thread{
    private int idP;
    Coordinador coo;
    
    public Proceso(int id, Coordinador c){
        idP = id;
        coo = new Coordinador(id);
    }

    public int getIdP() {
        return idP;
    }
    
    @Override
    public void run(){
        
    }
    
}
