package ResultadoText;

import java.io.File;

/**
 * Clase para la lista enlazada que almacena los resultados de la busqueda
 * @author Harold
 */
public class ListEResultado {
    public RNodo head;
    public int size;
    
    public ListEResultado(){
        this.head = null;
    }
    
    /**
     * Metodo para insertar un nuevo doc a la lista de resultados
     * @param Doc Recibe el documento a insertar en la lista
     */
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
    
    /**
     * Metodo que busca un elemento dentro de la lista enlazada
     * @param ind Recibe el indice de la posicion donde se encuentra el elemento buscado
     * @return Devuelve el nodo buscado
     */
    public RNodo Search(int ind){
        int SIndex = 0; 
        RNodo currNode = this.head; 
        while(SIndex < ind){ 
            currNode = currNode.getNext(); 
            SIndex++; 
         
        } 
        return currNode;         
        
    }
    
    /**
     * Metodo para obtener el elemento final de la lista
     * @return Devuelve el nodo al final de la lista
     */
    public RNodo Last(){
        RNodo act = this.head;
        while(act.next != null){
            act = act.next;
        }
        
        return act;
    }
    
    /**
     * Metodo que imprime la lista de los documentos y sus fragmentos de texto
     * 
     */
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

