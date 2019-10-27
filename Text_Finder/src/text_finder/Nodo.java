
package text_finder;

import java.io.File;

/**
 *
 * @author Armando Fallas
 */
public class Nodo {
    
    String String;        
    File Archivo;      
    String Texto;                    
    Nodo Izquierda;
    Nodo Derecha;
    
    /**
     * 
     * @param Word  Palabra que almacenará
     * @param ArchivoNombre Archivo donde se encuentra la palabra
     * @param Asociado  Texto que se encuentra alrrededor de la palabra
     */
    
    public Nodo(String Word, File ArchivoNombre, String Asociado){
   
    
        Izquierda = null;
        Derecha = null;
        String = Word;
        Archivo = ArchivoNombre;
        Texto = Asociado;
}

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Nodo Izquierda) {
        this.Izquierda = Izquierda;
    }

    public Nodo getDerecha() {
        return Derecha;
    }

    public void setDerecha(Nodo Derecha) {
        this.Derecha = Derecha;
    }
    

    
     
}
    

