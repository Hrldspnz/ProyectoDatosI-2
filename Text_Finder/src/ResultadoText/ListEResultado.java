/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultadoText;

import java.io.File;

/**
 *
 * @author Harold
 */
public class ListEResultado {
    public RNodo head;
    public int size;
    
    public ListEResultado(){
        this.head = null;
    }
    public void addDocument(File Doc){
        RNodo NBnode = new RNodo(Doc);
        if (this.head == null){
            this.head = NBnode;
            

        }else{
            RNodo act = this.head;
            while (act.getNext() != null) { 
                    act = act.getNext(); 
                }
            act.setNext(NBnode); 
            act = act.getNext();
            act.setDoc(Doc);
           
        } this.size++;
    }
    public RNodo Search(int ind){
        int SIndex = 0; 
        RNodo currNode = this.head; 
        while(SIndex < ind){ 
            currNode = currNode.getNext(); 
            SIndex++; 
         
        } 
        return currNode;         
        
    }
    public RNodo Last(){
        RNodo act = this.head;
        while(act.next != null){
            act = act.next;
        }
        
        return act;
    }
       
    public void imprimirL(){
        
        RNodo r = this.head;
        while(r != null){
            System.out.println(r.Doc.getName());
            System.out.println("-------------------------------------------------");
            for(String fragtexto : r.Resultado){
                System.out.println(fragtexto);
            }
            r = r.next;
        }
        
    }
}

