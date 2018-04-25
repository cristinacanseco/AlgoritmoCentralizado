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
        String lista="";
        while(true){
            
                if(!cola.isEmpty()){
                    if(recurso == -1){                      
                        try {
                            recurso = cola.get(0);
                            GUI.jTextFieldRecurso.setText(""+recurso);
                            if(!cola.isEmpty()){
                                lista="";
                                System.out.println("La cola de peticiones actualizada es: ");
                                for(int i=1; i<cola.size(); i++){
                                    System.out.println("CA "+cola.get(i));
                                    lista += "  " + cola.get(i);
                                }
                                GUI.jTextFieldLista.setText(lista);

                            }else{
                                GUI.jTextFieldRecurso.setText(""+recurso);
                                System.out.println("La cola de peticiones actualizada está vacía ");
                                lista = "Cola de peticiones vacía";
                                GUI.jTextFieldLista.setText(lista);
                            }
                            Random ran = new Random();
                            int t = ran.nextInt(5000)+3000;
                            Thread.sleep(t);
                            liberarRecurso();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Recurso2.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IndexOutOfBoundsException ex2){
                            System.out.println(ex2.getMessage());
                        }
                       
                    }else{
                        try {
                            //Agrega a la cola
                            wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Recurso2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                //wait();
            
        }
    }
    public void liberarRecurso(){
        try {
            String lista="";
            
            //System.out.println("El recurso está siendo utilizado por : " +recurso);
            //GUI.jTextFieldRecurso.setText(""+recurso);
            
            Random ran = new Random();
            int t = ran.nextInt(5000)+2000;
            Thread.sleep(t);
            recurso = -1;
            GUI.jTextFieldRecurso.setText(""+recurso);
            cola.remove(0);

            if(!cola.isEmpty()){
                System.out.println("La cola de peticiones actualizada es: ");
                for(int i=0; i<cola.size(); i++){
                    System.out.println("CA "+cola.get(i));
                    lista += "  " + cola.get(i);
                }
                GUI.jTextFieldLista.setText(lista);
                
            }else{
                GUI.jTextFieldRecurso.setText(""+recurso);
                System.out.println("La cola de peticiones actualizada está vacía ");
                lista = "Cola de peticiones vacía";
                GUI.jTextFieldLista.setText(lista);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
}
