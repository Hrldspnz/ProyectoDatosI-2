/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author arman
 */
public class Panel1 extends JPanel{
    JButton Buscar;
    JTextField Barra;
    
    public Panel1 (){
        this.setBackground(new java.awt.Color(102, 203, 175));
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        
        Barra = new JTextField();
        Barra.setBounds(10, 20, 300, 30);
        this.add(Barra);
        
        Buscar = new JButton();
        Buscar.setBounds(330, 20, 80, 30);
        Buscar.setText("Buscar");
        //Buscar.setBackground(Color.red);
        this.add(Buscar);
}
    
}
