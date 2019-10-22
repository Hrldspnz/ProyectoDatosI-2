/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static text_finder.Ventana.jPanel2;

/**
 *
 * @author arman
 */
public class Panel2 extends JPanel{
    
    static JTextArea Texto;
    static JScrollPane Scroll;
    
    public Panel2(){
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        Texto = new JTextArea();
        Texto.setBounds(0, 0, 917, 699);
        Texto.setLineWrap(true);
        this.add(Texto);
        
        Scroll = new JScrollPane();
        Scroll.setViewportView(Texto);
    }
    
}
