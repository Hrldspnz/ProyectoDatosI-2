/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronDiseño;

/**
 *
 * @author arman
 */
public class IteradorConcreto implements Iterador{
    
     private AgregadoConcreto agregado;
     private int posicion_actual = 0;
    // -------------------------
     /**
      * 
      * @param agregado Vector que usara los metodos del iterador
      */
    public IteradorConcreto( AgregadoConcreto agregado )
    {
         this.agregado = agregado;
    }
    // -------------------------
    @Override
     public Object primero()
             //Obtiene el elemento primero
    {
        Object obj = null;
        if( this.agregado.aDatos.isEmpty() == false )
        {
            this.posicion_actual = 0;
            obj = this.agregado.aDatos.firstElement();
        }
        return obj;
    }
    // -------------------------
    @Override
     public Object siguiente()
             //Regresa el dato siguiente del vector
    {
        Object obj = null;
        if( (this.posicion_actual ) < this.agregado.aDatos.size() )
        {
            obj = this.agregado.aDatos.elementAt(this.posicion_actual);
            this.posicion_actual = this.posicion_actual + 1;
        }
        return obj;
    }
    // -------------------------
    @Override
     public boolean recorrer()
             // Recorre todo el vector hasta el final
    {
        boolean ok = false;
        if( this.posicion_actual < (this.agregado.aDatos.size() ) )
        {
            ok = true;
        }
        return ok;
    }
    // -------------------------
    @Override
     public Object actual()
             //Regresa el dato actual
    {
        Object obj = null;
        if( this.posicion_actual < this.agregado.aDatos.size() )
        {
            obj = this.agregado.aDatos.elementAt( this.posicion_actual );
        }
        return obj;
    }
}
