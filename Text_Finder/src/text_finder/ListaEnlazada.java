
package text_finder;

import java.io.File;
import static text_finder.Panel1.datos;

/**
 *
 * @author Armando
 */
public class ListaEnlazada {
    
    Nodo raiz;
    
    public ListaEnlazada(){
        raiz = null;
    }
    
    /**
     * 
     * @param Word  Palabra del texto
     * @param Archivo   Archivo al cual pertenece
     * @param Asociado  Texto asociado a la palabra
     * @param comparar  Nodo a comparar al agregarlo al arbol
     */
    public void agregar(String Word, File Archivo, String Asociado, Nodo comparar){
        // Crea un nuevo nodo
        Nodo nuevo = new Nodo(Word, Archivo, Asociado); // Si el nodo raiz es null lo asigna como raiz
        if (raiz == null){
            raiz = nuevo;
            
        } else{ 
            Nodo auxiliar = comparar;
            Nodo padre;
            
            // Si el nodo raiz no es null compara con los nodos hasta llegar a null
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
    /**
     * 
     * @param comparar  Nodo a comparar con el nodo que se busca
     * @param word  Palabra que se busca
     * @param dir Archivo en el que se busca
     */
    public void Busqueda(Nodo comparar, String word, File dir){
        //System.out.println(comparar.getString()+"---"+ word + "---"+comparar.Archivo.getName()+"---"+dir.getName());
        String[] busqueda = word.split(" ");
        String[] frase = comparar.Texto.split(" ");
        System.out.println(comparar.getArchivo() + " " + word + " " + dir.getName());
        if (comparar.getString().compareToIgnoreCase(busqueda[0]) == 0 && comparar.Archivo.getName().compareTo(dir.getName())==0){//Si encuentra la palabra y pertence al doc especificado a�ade el fragmento de texto
            if(busqueda.length == 0){
                datos.addElement(comparar.Texto);//A�adir Fragmento de texto
            }else{
                boolean result = true;
                for (int i = 0; i < busqueda.length; i++){
                    if(frase[i]!= null &&busqueda[i].compareToIgnoreCase(frase[i])!=0){
                        result = false;
                    }
                }if(result==true){
                    datos.addElement(comparar.Texto);
                }
                System.out.println(result);
            }
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word, dir);
            }  
            // Si al comparar la palabra es mayor a 0 se va hacia la derecha
        }else if (comparar.getString().compareToIgnoreCase(word) > 0){  
            if (comparar.getDerecha() != null){
                Busqueda(comparar.getDerecha(), word, dir);
            }
            
             // Si al comparar la palabra es mayor a 0 se va hacia la izquierda

        }else if (comparar.getString().compareToIgnoreCase(word) < 0){
            if (comparar.getIzquierda() != null){
                Busqueda(comparar.getIzquierda(), word, dir);
            }
        }
                    

    }
    

    
}

