/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultadoText;

import java.util.Vector;

/**
 *
 * @author Harold
 */
public class RNodo {
    public RNodo next;
    public Object Doc;
    public Vector<String> Resultado;
    
    
    public RNodo(){
    this.next = null;
    this.Doc = null;
    this.Resultado = new Vector<>();
    }
    
    public Object getDoc(){
        return this.Doc;
    }
    public void setDoc(Object docName){
        this.Doc = docName;
    }
    
    public Object getText(int index){
        return this.Resultado.get(index);
    }
    public void AddText(String texto){
        this.Resultado.add(texto);
    }
    public void AddTextos(Vector<String> texto){
        int i = 0;
        while(i <= texto.size()){
            this.Resultado.addElement(texto.elementAt(i));
            i++;
        }
        
    }
    
    public void setNext(RNodo next){
        this.next = next;
    }
    public RNodo getNext() { 
        return this.next; 
    }
}
