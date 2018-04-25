/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristy
 */
public class Recurso2 extends Thread {
    private ArrayList<Integer> cola;
    private int recurso;
    
    public Recurso2(ArrayList<Integer> lista){
        cola = lista;
        recurso = -1;
    }
    
    public ArrayList<Integer> getCola() {
        return cola;
    }
    
    public void run(){
        //Revisar el recurso
        while(true){
            try {
                if(!cola.isEmpty()){
                    if(recurso == -1){                      
                        recurso = cola.get(0);
                        liberarRecurso();         
                    }else{
                        try {
                            //Agrega a la cola
                            wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Recurso2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Recurso2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void liberarRecurso(){
        String lista="";
        try {
            System.out.println("El recurso está siendo utilizado por : " +recurso);
            GUI.jTextFieldRecurso.setText(""+recurso);
            Random ran = new Random();
            int t = ran.nextInt(10000);
            Thread.sleep(t);
            recurso = -1;
            cola.remove(0);

            if(!cola.isEmpty()){
                System.out.println("La cola de peticiones actualizada es: ");
                for(int i=0; i<cola.size(); i++){
                    System.out.println("CA "+cola.get(i));
                    lista += "  " + cola.get(i);
                }
                GUI.jTextFieldLista.setText(lista);
                
            }else{
                System.out.println("La cola de peticiones actualizada está vacía ");
                lista = "Cola de peticiones vacía";
                GUI.jTextFieldLista.setText(lista);
            }
            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
