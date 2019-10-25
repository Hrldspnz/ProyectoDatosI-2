/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;

import java.io.File;
import static text_finder.Panel1.datos;

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
    
    public void Busqueda(Nodo comparar, String word, File dir){
        //System.out.println(comparar.getString()+"---"+ word + "---"+comparar.Archivo.getName()+"---"+dir.getName());
        if (comparar.getString().compareToIgnoreCase(word) == 0 && comparar.Archivo.getName().compareTo(dir.getName())==0){//Si encuentra la palabra y pertence al doc especificado añade el fragmento de texto
            //System.out.println(word + "---"+dir);
            datos.addElement(comparar.Texto);//Añadir Fragmento de texto
           
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word, dir);
            }  
            
        }else if (comparar.getString().compareToIgnoreCase(word) > 0){  
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word, dir);
            }
            
            
        }else if (comparar.getString().compareToIgnoreCase(word) < 0){
            if (comparar.getIzquierda() != null){
                Busqueda(comparar.getIzquierda(), word, dir);
            }
        }
    }
    /**
    public void recorrer(Nodo r){
        if(r != null){
            recorrer(r.getIzquierda());
            System.out.println(r.getArchivo());
            recorrer(r.getDerecha());
        }
    }
    **/
}

