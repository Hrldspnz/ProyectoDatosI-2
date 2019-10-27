/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;

import javax.swing.JFrame;



/**
 * Metodo main del proyecto
 * @author Harold
 * @author Armando
 */
public class Text_Finder {
    
   
    public static void main(String[] args) {
        
        //Se crea la ventana principal de la aplicación
        Ventana ventana1= new Ventana();
        ventana1.setSize(797,462);
        ventana1.setVisible(true);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    
    }
    
}
