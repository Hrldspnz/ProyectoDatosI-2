/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



/**
 *
 * @author arman
 */
public class Panel1 extends JPanel{
    JButton Buscar;
    JButton Borrar;
    JTextField Barra;
    MouseListener mo;
    JButton Cargar;
    
    JTextArea Texto;
    static String letra2;
    static JScrollPane scroll;
    
    static FileOutputStream salida;
    JList lista_Documentos;
    public static Object[] recorrer;
    public static Object[] recorrer_borrar;
    
    DefaultListModel modeloLista;
    JLabel Texto_doc;
    
    public Panel1 (){
        this.setBackground(new java.awt.Color(102, 203, 175));
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        
        Font fuente = new Font ("TimesRoman", Font.BOLD, 20);
        
        Barra = new JTextField();
        Barra.setBounds(10, 20, 300, 30);
        this.add(Barra);
        
        Buscar = new JButton();
        Buscar.setBounds(330, 20, 80, 30);
        Buscar.setText("Buscar");
        this.add(Buscar);
        
        Borrar = new JButton();
        Borrar.setBounds(170, 150, 80, 30);
        Borrar.setText("Borrar");
        this.add(Borrar);
        
        Cargar = new JButton();
        Cargar.setBounds(60, 660, 300, 40);
        Cargar.setText("Cargar Archivo");
        this.add(Cargar);
        
        Texto_doc = new JLabel();
        Texto_doc.setText("Documentos:");
        Texto_doc.setBounds(8, 70, 150, 100);
        Texto_doc.setFont(fuente);
        this.add(Texto_doc);
        
        File dir = new File("C:\\Users\\arman\\OneDrive\\Documentos\\Segundo semestre\\datos1\\ProyectoDatosI-2\\Text_Finder\\src\\Documentos");
        recorrer = dir.list();
        
        modeloLista = new DefaultListModel();
        
        if (recorrer == null){
            System.out.println("No hay ficheros en el directorio especificado");
        }else { 
            for (int x=0;x<recorrer.length;x++){
                
                modeloLista.addElement(recorrer[x]);
                
                }
            
            
}
        lista_Documentos = new JList(modeloLista);
        lista_Documentos.setBounds(8, 150, 150, 160);
        this.add(lista_Documentos);
        
    
        mo = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == Cargar){
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JFileChooser File = new JFileChooser();
                    File.showOpenDialog(Cargar);
                    File Archivo = File.getSelectedFile();
                    Path origen = Paths.get(Archivo.getPath());
                    String nombre = Archivo.getName();
                    Path destino = FileSystems.getDefault().getPath("Documentos" + nombre);                    
                    try {
                        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                        modeloLista.addElement(Archivo.getName());
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == Borrar){
                    try {
                        EliminarDocumentos();
                    } catch (IOException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        };
        this.addMouseListener(mo);
        Buscar.addMouseListener(mo);
        Cargar.addMouseListener(mo);
        Borrar.addMouseListener(mo);
}
    public void EliminarDocumentos() throws IOException{
       
        int pos = lista_Documentos.getSelectedIndex();
        if (pos != -1){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere borrar el Documento?");
            if (respuesta == 0){
                modeloLista.remove(pos);
     
        }
    }
    }
    /*
    public void texto() throws IOException{
        JFrame window = new JFrame();
        Texto = new JTextArea();
        scroll = new JScrollPane(Texto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 136, 390, 250);
        window.setSize(500,462);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileReader entrada;
        Texto.setBounds(0, 0, window.getWidth(), window.getHeight());
        window.add(Texto);
        
        
        
        
        
        entrada = new FileReader("C:/Users/arman/OneDrive/Documentos/texto.txt");
        int c = entrada.read();
        while(c != -1){
            
            c = entrada.read();
            char letra = (char)c;
            String letra3 = Character.toString(letra);
            
            
            letra2 += letra3;
            
            //System.out.print(letra2);
        }
        Texto.setText(letra2);
        Texto.repaint();
    }
    
   */
    
}
