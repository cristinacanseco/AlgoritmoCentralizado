/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Recurso {
    private ArrayList<Integer> cola;
    private int recurso;

    public Recurso(){
        cola = new ArrayList<Integer>();
        recurso = -1;
    }
    
    public ArrayList<Integer> getCola() {
        return cola;
    }

    public void agregarCola(int id) {
        this.cola.add(id);
    }
    
    public void recorrerCola(){
        cola.remove(0);
    }

    
    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }
    
    public boolean recibirPeticion(int id){
        //Revisar el recurso

         if(recurso == -1){
             //Asigna recurso
             if(cola.isEmpty()){
                recurso = id;      
             }else{
                 recurso = cola.get(0);
                 cola.remove(0);
             }
            liberarRecurso();
            return true;
         }else{
            //Agrega a la cola
            cola.add(id);
            
            return false;
         }
        
    }
    
    public void liberarRecurso(){
        try {
            System.out.println("El recurso está siendo utilizado por : " +recurso);
            Random ran = new Random();
            int t = ran.nextInt(5000);
            Thread.sleep(t);
            recurso = -1;
           
            
            if(!cola.isEmpty()){
                System.out.println("La cola de peticiones actualizada es: ");
                for(int i=0; i<cola.size(); i++)
                    System.out.println("CA "+cola.get(i));
                recibirPeticion(cola.get(0));
            }else{
                System.out.println("La cola de peticiones actualizada está vacía ");
            }
            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
