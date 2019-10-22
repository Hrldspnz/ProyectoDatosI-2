/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;

import java.io.File;

/**
 *
 * @author arman
 */
public class ListaEnlazada {
    
    Nodo raiz;
    
    public ListaEnlazada(){
        raiz = null;
    }
    
    public void agregar(String Word, File Archivo, String Asociado, Nodo comparar){
        Nodo nuevo = new Nodo(Word, Archivo, Asociado);
        if (raiz == null){
            raiz = nuevo;
        } else{
            Nodo auxiliar = comparar;
            Nodo padre;
            while (true){
                padre = auxiliar;
                if(padre.getTexto().compareToIgnoreCase(Word) == 1){
                    auxiliar = auxiliar.getIzquierda();
                    if (auxiliar == null){
                        padre.setIzquierda(nuevo);
                        return;
                    }else{
                        agregar(Word, Archivo, Asociado, auxiliar);
                    }
                    
                    
                }else{
                    auxiliar = auxiliar.getDerecha();
                    if(auxiliar == null){
                        padre.setDerecha(nuevo);
                        return;
                    }else{
                        agregar(Word, Archivo, Asociado, auxiliar);
                    }
                }
            }
        }
        
    }
}
