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
public class Coordinador {
    private String name;
    Recurso rec = new Recurso();
    
    public Coordinador(String name){
        this.name = name;
    }
    
    public boolean recibirPeticion(int id){
        System.out.println(this.name + " recibe una petición de "+ id);
        System.out.println("Cola: "+ id);
        if (rec.recibirPeticion(id)){
            
             return true;
        }
        else{
            return false;
        }
        
    }
    
}
