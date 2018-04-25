/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC;

import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Coordinador {
    private String name;
    Recurso2 rec ;
    ArrayList<Integer> lista = new ArrayList<>();
    
    public Coordinador(String name){
        this.name = name;
    }
    
    public Coordinador (int id){
        lista.add(id);
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }
    
    public void agregarDato(int i){
        lista.add(i);
        rec = new Recurso2(lista);
        rec.start();
    }
    
}
