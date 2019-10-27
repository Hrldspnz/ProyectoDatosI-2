/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;



import ResultadoText.ListEResultado;
import ResultadoText.RNodo;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static text_finder.Panel2.Texto;
import static Sort.Quicksort.Ordenar;
import static Sort.RadixSort.radixsort;
import static Sort.BubbleSort.bubble_srt;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;




/**
 *
 * @author arman
 */
public class Panel1 extends JPanel{
    JButton Buscar;
    JButton Borrar;
    static JTextField Barra;
    MouseListener mo;
    JButton Cargar;
    JButton Abrir;
    JButton Orden;
    
    static String letra2;
    static JScrollPane scroll;
    
    static FileOutputStream salida;
    static JList lista_Documentos;
    public static Object[] recorrer;
    public static Object[] Directorios;
    public static Object[] recorrer_borrar;
    public static ListaEnlazada Arbol;
    
    static DefaultListModel modeloLista;//provisional
    JLabel Texto_doc;
    
    static String[] parts;
    
    static Vector<String> datos;
    
    static ListEResultado resultado;
    
    static int pos;
    
    public Panel1 (){
        
        // Se le a�ade un color de fondo y bordes al panel
        
        this.setBackground(new java.awt.Color(102, 203, 175));
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        
        //Arbol donde se almacenan las palabras
        
        
        Font fuente = new Font ("TimesRoman", Font.BOLD, 20);
        
        // Almacena el texto a buscar que escriba el usuario
        Barra = new JTextField();
        Barra.setBounds(10, 20, 300, 30);
        this.add(Barra);
        
        //Boton que inicializa los metodos de busqueda
        Buscar = new JButton();
        Buscar.setBounds(330, 20, 80, 30);
        Buscar.setText("Buscar");
        this.add(Buscar);
        
        //Boton para borrar documentos
        Borrar = new JButton();
        Borrar.setBounds(170, 150, 80, 30);
        Borrar.setText("Borrar");
        this.add(Borrar);
        
        //Boton para abrir un documento y leerlo
        Abrir = new JButton();
        Abrir.setBounds(170, 200, 80, 30);
        Abrir.setText("Abrir");
        this.add(Abrir);
        
        //Boton de ordenamiento de los documentos
        Orden = new JButton();
        Orden.setBounds(250, 150, 95, 30);
        Orden.setText("Ordenar");
        this.add(Orden);
        
        //Boton para cargar archivos
        Cargar = new JButton();
        Cargar.setBounds(60, 660, 300, 40);
        Cargar.setText("Cargar Archivo");
        this.add(Cargar);
        
        Texto_doc = new JLabel();
        Texto_doc.setText("Documentos:");
        Texto_doc.setBounds(8, 70, 150, 100);
        Texto_doc.setFont(fuente);
        this.add(Texto_doc);
        
        // Al iniciar el programa se recorre todos los documentos almacenados
        File dir = new File("Docs");
        recorrer = dir.list();
        Directorios = dir.listFiles();
        
        modeloLista = new DefaultListModel();
        
        //Ingresa los nombres de los archivos en la lista de documentos
        if (recorrer == null){
            System.out.println("No hay ficheros en el directorio especificado");
        }else { 
            for (int x=0;x<recorrer.length;x++){
               
                modeloLista.addElement(recorrer[x]);
                
                }
            
            
}
        // LIsta de documentos del programa
        
        lista_Documentos = new JList(modeloLista);
        lista_Documentos.setBounds(8, 150, 150, 160);
        this.add(lista_Documentos);
        
        //Eventos del mouse
    
        mo = new MouseListener(){

            @Override
           
            public void mouseClicked(MouseEvent e) {
                //Evento que capta si se presiono el boton de cargar
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
                    //Metodos para cargar los documentos
                    JFileChooser File = new JFileChooser();
                    File.showOpenDialog(Cargar);
                    File Archivo = File.getSelectedFile();
                    Path origen = Paths.get(Archivo.getPath());
                    String nombre = Archivo.getName();
                    Path destino = FileSystems.getDefault().getPath(dir.getAbsolutePath() +"\\"+ nombre);                    
                    try {
                        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                        modeloLista.addElement(Archivo.getName());
                        File dir = new File("Docs");
                        recorrer = dir.list();
                        Directorios = dir.listFiles();
                       
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Evento que capta si se presiono el boton de buscar

                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == Buscar){
                    try {
                        parsear();
                        if(resultado.size == 0){
                            JOptionPane.showMessageDialog(null,"No se encontraron resultados");
                        }else{
                            new VentanaBusqueda().setVisible(true);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   
                }
               //Evento que capta si se presiono un documento en la lista

                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == lista_Documentos){
                    try {
                        texto(lista_Documentos);
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
                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == Orden){
                    
                    String[] options = {"Nombre", "Fecha", "Tama�o"};
                    int x = JOptionPane.showOptionDialog(null, "Seleccione como desea ordenar los archivos","Ordenar por",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    
                    int largo = modeloLista.getSize();
                    String [] documentos = new String[largo];

                    for(int i=0 ; i<largo ; i++){
                        documentos[i] = (String) modeloLista.get(i);
                    }
                    switch(x){
                        case 0 : Ordenar(documentos);break;
                        case 1 : bubble_srt(documentos);break;
                        case 2 : radixsort(documentos,largo);break;
                        default : Ordenar(documentos); break;
                            
                    }modeloLista.clear();
                    for (int i = 0; i < largo; i++) {
                       modeloLista.addElement(documentos[i]); 
                    }
                    lista_Documentos.removeAll();
                    lista_Documentos.setModel(modeloLista);
                    for (int i = 0; i < largo; i++) {
                       Directorios[i] = (Object)dir +"\\"+documentos[i];
                       System.out.println(documentos[i]);
                    }
                    
                    
                }
                if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() == Abrir){
                    Texto.setText(null);
                    
                    String text = letra2;
                    
                    Texto.setText(text);
                    
                    
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
        Orden.addMouseListener(mo);
        lista_Documentos.addMouseListener(mo);
        Abrir.addMouseListener(mo);
}
    
    /**
     * Metodo para eliminar documentos/ 
     */
    public void EliminarDocumentos() throws IOException{
       
        int pos = lista_Documentos.getSelectedIndex();
        if (pos != -1){
            int respuesta = JOptionPane.showConfirmDialog(null, "?Quiere borrar el Documento?");
            if (respuesta == 0){ 
                String fichero = (String) modeloLista.get(pos);
                File file = new File("Docs");
                String path = (file.getAbsolutePath()+"\\"+fichero);
                System.out.println(file.getAbsolutePath());
                File filePath = new File(path);
                System.out.println(filePath);
                filePath.delete();
                modeloLista.remove(pos);    
            }
        }
    }
    
    /**
     * Metodo que se encarga de leer los documentos
     * @author Harold EM, Armando
     */
    
    public static void texto(JList lista_Documentos) throws IOException{
        
        FileReader entrada;
        pos = lista_Documentos.getSelectedIndex();
        letra2 = null;
        
        try {
            File dir = (File) Directorios[pos];
            File file = new File(dir.getAbsolutePath());
            
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();


            paragraphs.stream().forEach((para) -> {
                if (letra2 == null){
                    letra2 = para.getText()+"\n";
                }else{
                    letra2 += para.getText()+"\n";
                }
            });
            fis.close();
        } catch (Exception e){
                
              try{
                File dir = (File) Directorios[pos];
                PDDocument document = PDDocument.load(new File(dir.getAbsolutePath()));
                AccessPermission ap = document.getCurrentAccessPermission();
                if (!ap.canExtractContent())
                {
                    throw new IOException("You do not have permission to extract text");
                }

                PDFTextStripper stripper = new PDFTextStripper();

                stripper.setSortByPosition(true);

                for (int p = 1; p <= document.getNumberOfPages(); ++p)
                {

                    stripper.setStartPage(p);
                    stripper.setEndPage(p);

                    String text = stripper.getText(document);

                    String pageStr = String.format("page %d:", p);
                    System.out.println(pageStr);
                    for (int i = 0; i < pageStr.length(); ++i)
                    {
                        System.out.print("-");
                    }
                    String letra3 = text.trim();

                    if(letra2 == null){
                        letra2 = letra3;
                    }else{
                        letra2 += letra3;
                    }


                }
                document.close();
                }catch(Exception exc){
                    try{                    
                        entrada = new FileReader((File) Directorios[pos]);

                        int c = 0;
                        
                        while(c != -1){

                            c = entrada.read();
                            
                            if (c != -1){
                                char letra = (char)c;
                            
                                String letra3 = Character.toString(letra);
                            
                            

                                if(letra2 == null){
                                    letra2 = letra3;
                                }else{
                                    letra2 += letra3;
                            }
                            }
                        }


                    } catch(Exception ex){
                        ex.printStackTrace();
                    }
                }                
            }
        
    }
    
        /**
         * 
         * @param Leer  Archivo que se va a parsear
         * @throws IOException 
         */
        public void Parseo(File Leer) throws IOException{
            
              
        
        FileReader entrada;
    
        letra2 = null;
        
        try {
          
            File file = new File(Leer.getAbsolutePath());
            
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();


            paragraphs.stream().forEach((para) -> {
                
                letra2 = para.getText();
            });
            fis.close();
        } catch (Exception e){
                
              try{
                
                PDDocument document = PDDocument.load(new File(Leer.getAbsolutePath()));
                AccessPermission ap = document.getCurrentAccessPermission();
                if (!ap.canExtractContent())
                {
                    throw new IOException("You do not have permission to extract text");
                }

                PDFTextStripper stripper = new PDFTextStripper();

                stripper.setSortByPosition(true);

                for (int p = 1; p <= document.getNumberOfPages(); ++p)
                {

                    stripper.setStartPage(p);
                    stripper.setEndPage(p);

                    String text = stripper.getText(document);

                    String pageStr = String.format("page %d:", p);
                    System.out.println(pageStr);
                    for (int i = 0; i < pageStr.length(); ++i)
                    {
                        System.out.print("-");
                    }
                    String letra3 = text.trim();

                    if(letra2 == null){
                        letra2 = letra3;
                    }else{
                        letra2 += letra3;
                    }


                }
                document.close();
                }catch(Exception exc){
                    try{                    
                        entrada = new FileReader(Leer);

                        int c = 0;
                        
                        while(c != -1){

                            c = entrada.read();
                            
                            if (c != -1){
                                char letra = (char)c;
                            
                                String letra3 = Character.toString(letra);
                            
                            

                                if(letra2 == null){
                                    letra2 = letra3;
                                }else{
                                    letra2 += letra3;
                            }
                            }
                        }


                    } catch(Exception ex){
                        ex.printStackTrace();
                    }
                }                
            }
            
           

        }
        
        //Metodo para parsear documentos
                        
    public void parsear() throws IOException{
        
        resultado = new ListEResultado();
        datos = new Vector<>();
        String Busca = Barra.getText();
        for (int x=0;x<Directorios.length;x++){
            Arbol = new ListaEnlazada();
            Parseo((File) Directorios[x]);
            separar((File) Directorios[x]);
            letra2 = null;
            Arbol.Busqueda(Arbol.raiz, Busca,(File) Directorios[x]);//busca la palabra y el doc al que pertenece
            
            if(datos.isEmpty()==false){//A�ade los datos del vector donde se guardan los fragmentos
                resultado.addDocument((File) Directorios[x]);
                resultado.Last().AddTextos(datos);
            
            }datos.clear();//REinicia el vector de fragmentos
        }
        
    }
    //Metodo para agregar el texto de un archivo en una variable
    public void separar(File archivo){
        String separadores = "[\\ \\.\\,\\?\\!\\=\\-]";
        
        parts = letra2.split(separadores);
        
        for (int x=0;x<parts.length;x++){
            if(parts.length == 1){
                           Arbol.agregar(parts[x], archivo, parts[x], Arbol.raiz);
                           
            }
            
            else if (x == parts.length - 1){
                           Arbol.agregar(parts[x], archivo, parts[x] + " " + parts[x - 1] + " " + parts[x - 2] + " " + parts[x - 3] + " " + parts[x - 4], Arbol.raiz);
            }
            else if (x == parts.length-2){
                           Arbol.agregar(parts[x], archivo, parts[x - 2] + " " + parts[x - 1] + " " + parts[x] + " " + parts[x + 1], Arbol.raiz);
            }
            else if (x == parts.length-3){
                           Arbol.agregar(parts[x], archivo, parts[x - 1] + " " + parts[x] + " " + parts[x + 1] + " " + parts[x + 2], Arbol.raiz);
            }
            else if (x == parts.length-4){
                           Arbol.agregar(parts[x], archivo, parts[x] + " " + parts[x + 1] + " " + parts[x + 2] + " " + parts[x + 3], Arbol.raiz);
            }
            else{
                            
                            Arbol.agregar(parts[x], archivo, parts[x] + " " + parts[x + 1] + " " + parts[x + 2] + " " + parts[x + 3] + " " + parts[x + 4], Arbol.raiz);
            }
            
        }
        
    }


    
}
    
   
    

