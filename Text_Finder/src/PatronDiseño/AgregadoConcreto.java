/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronDiseño;

import java.util.Vector;
import static text_finder.Panel1.recorrer;

/**
 *
 * @author arman
 */
public class AgregadoConcreto implements Agregado{
     protected Vector aDatos = new Vector();
    // -------------------------
    public AgregadoConcreto() {
        this.llenar();
    }
    // -------------------------
    @Override
     public Iterador getIterador()
    {
        return new IteradorConcreto( this );
    }
    // -------------------------
    public void llenar()
    {
        for (int x=0;x<recorrer.length;x++){
               
                aDatos.add(recorrer[x]);
                
                }
    }
}
