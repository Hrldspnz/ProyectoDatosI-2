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
                if(padre.getTexto().compareToIgnoreCase(Word) == 0){
                    auxiliar = auxiliar.getIzquierda();
                    if (auxiliar == null){
                        padre.setIzquierda(nuevo);
                        return;
                    }
                    
                    
                }else if (padre.getTexto().compareToIgnoreCase(Word) > 0){
                    auxiliar = auxiliar.getDerecha();
                    if(auxiliar == null){
                        padre.setDerecha(nuevo);
                        return;
                    }
                }else{
                    auxiliar = auxiliar.getIzquierda();
                    if (auxiliar == null){
                        padre.setIzquierda(nuevo);
                        return;
                    }
                }
            }
        }
        
    }
    
    public void Busqueda(Nodo comparar, String word){
        if (comparar.getString().compareToIgnoreCase(word) == 0){
            System.out.println(comparar.getArchivo());  
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word);
            }  
            
        }else if (comparar.getString().compareToIgnoreCase(word) > 0){  
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word);
            }
            
            
        }else if (comparar.getString().compareToIgnoreCase(word) < 0){
            if (comparar.getIzquierda() != null){
                Busqueda(comparar.getIzquierda(), word);
            }
        }
    }
    public void recorrer(Nodo r){
        if(r != null){
            recorrer(r.getIzquierda());
            recorrer(r.getDerecha());
        }
    }
}
