package ResultadoText;

import java.io.File;
import java.util.Vector;

/**
 * Clase que crea el nodo perteneciente a la lista enlazada de los resultados
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
    
    public String getText(int index){//Obtiene el fragmento de texto
        return this.Resultado.elementAt(index);
    }
    
    /**
     * Metodo para añadir un fragmento de texto
     * @param texto Recibe el fragmento de texto a insertar
     */
    public void AddText(String texto){//Añade un fragmento de texto
        this.Resultado.add(texto);
    }
    
     /**
     * Metodo para añadir varios fragmentos de texto
     * @param texto Recibe un vector con los fragmetos de texto a insertar
     */
    public void AddTextos(Vector<String> texto){//Añade un vector con fragmentos de texto
        int i = 0;
        while(i < texto.size()){
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
