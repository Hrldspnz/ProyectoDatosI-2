/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultadoText;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author Harold
 */
public class RNodo {
    public RNodo next;
    public File Doc;
    public Vector<String> Resultado;
    
    
    public RNodo(File Archivo){
    this.next = null;
    this.Doc = Archivo;
    this.Resultado = new Vector<>();
    }
    
    public File getDoc(){//obtiene nombre del doc
        return this.Doc;
    }
    public void setDoc(File docName){//pone el nombre del doc
        this.Doc = docName;
    }
    
    public Object getText(int index){//Obtiene el fragmento de texto
        return this.Resultado.get(index);
    }
    public void AddText(String texto){//Añade un fragmento de texto
        this.Resultado.add(texto);
    }
    public void AddTextos(Vector<String> texto){//Añade un vector con fragmentos de texto
        int i = 0;
        while(i <= texto.size()){
            this.Resultado.addElement(texto.elementAt(i));
            i++;
        }
        
    }
    
    public void setNext(RNodo next){//Añade el nodo siguiente
        this.next = next;
    }
    public RNodo getNext() { //devuelve el nodo siguiente
        return this.next; 
    }
}
