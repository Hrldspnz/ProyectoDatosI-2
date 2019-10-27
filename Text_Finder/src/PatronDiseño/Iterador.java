
package PatronDiseño;

/**
 *
 * @author Armando
 */
public interface Iterador {
  
    public Object primero();    //Obtiene el primer elemento del vector
    public Object siguiente();  //Obtiene el dato siguiente del vector
    public boolean recorrer();  //Recorrer todo el vector
    public Object actual();     //Obtiene el elemento actual
}

