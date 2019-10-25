/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;


import ResultadoText.RNodo;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import static text_finder.Panel1.Barra;
import static text_finder.Panel1.modeloLista;
import static text_finder.Panel1.resultado;


 /** 
 * Clase de la ventana de busqueda  
 * @author Harold EM
 */ 
public class VentanaBusqueda extends javax.swing.JFrame {

    DefaultListModel moLista;
    static int pos = 0;
    RNodo seleccionado;
    /** 
    * Crea la ventana de busqueda  
    */ 
    public VentanaBusqueda() {
        initComponents();
    }
    /** 
     * Metodo que resalta la palabra buscada de color verde 
     * @param area1 Recibe el Jtextarea donde se va a resaltar la palabra 
     * @param texto Recibe el texto a buscar 
     */ 
    public void resaltarpalabra(JTextArea area1, String texto) {
        
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = area1.getHighlighter();
            h.removeAllHighlights();
            String text = area1.getText();
            String caracteres = texto;
            Pattern p = Pattern.compile("(?i)" + caracteres);
            Matcher m = p.matcher(text);
            while (m.find()) {
                try {
                    
                    h.addHighlight(m.start(), m.end(), highlightPainter);
                } catch (BadLocationException ex) {
                    Logger.getLogger(VentanaBusqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(area1, "la palabra a buscar no puede ser vacia");
        }
    }
    
    @SuppressWarnings("unchecked")
    /** 
     * Metodo que inicia todos los componentes de la ventanas 
     *  
     */                                      
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        t1.setColumns(20);
        t1.setRows(5);
        jScrollPane1.setViewportView(t1);

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        moLista = new DefaultListModel();
        for (int x=0;x<resultado.size;x++){
            
            moLista.addElement(resultado.Search(x).Doc.getName().toString());
        }
        jList1 = new JList(moLista);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Anterior");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addGap(34, 34, 34))
        );

        pack();
    }                        
                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        resaltarpalabra(t1,Barra.getText());
        
    }      
    
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {
        pos = 0;
        t1.setText(null);
        seleccionado = resultado.Search(jList1.getSelectedIndex());
        t1.setText(seleccionado.Resultado.elementAt(pos));
        resaltarpalabra(t1,Barra.getText());
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            if(pos>0){
                pos -= 1;
                t1.setText(null);
                t1.setText(seleccionado.Resultado.elementAt(pos));
                resaltarpalabra(t1,Barra.getText());
            }else{
                pos = seleccionado.Resultado.size()-1;
                t1.setText(null);
                t1.setText(seleccionado.Resultado.elementAt(pos));
                resaltarpalabra(t1,Barra.getText());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningun nodo");
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            if(pos<seleccionado.Resultado.size()-1){
                pos += 1;
                t1.setText(null);
                t1.setText(seleccionado.Resultado.elementAt(pos));
                resaltarpalabra(t1,Barra.getText());
            }else{
                pos = 0;
                t1.setText(null);
                t1.setText(seleccionado.Resultado.elementAt(pos));
                resaltarpalabra(t1,Barra.getText());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningun nodo");
        }
    }

    //Declaracion de variables - no modificar                      
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea t1;
    // Fin de declaracion de variables                
}
