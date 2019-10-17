/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_finder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import static text_finder.Panel1.Directorios;
/**
 *
 * @author Harold
 */
public class PBdocx {
    static String letra2;
    
    public static void main(String[] args) {
        readDocxFile();
    }
    
    public static void readDocxFile() {
            try {
                File file = new File("C:\\Users\\pc\\Documents\\JAVA\\Pruebasbrgas\\PruebasPrrnas\\Docs\\texto2.txt");
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());

                XWPFDocument document = new XWPFDocument(fis);

                List<XWPFParagraph> paragraphs = document.getParagraphs();


                paragraphs.stream().forEach((para) -> {
                    System.out.println(para.getText());
                });
                fis.close();
            } catch (Exception e){
                //e.printStackTrace();
            }try{
                FileReader entrada;
                entrada = new FileReader("C:\\Users\\pc\\Documents\\JAVA\\Pruebasbrgas\\PruebasPrrnas\\Docs\\texto2.txt");
        
                int c = 0;
                //System.out.println(c);
                while(c != -1){

                    c = entrada.read();
                    //System.out.println(c);
                    char letra = (char)c;
                    String letra3 = Character.toString(letra);
                    //System.out.println(letra3);
                    
                    if(letra2 == null){
                        letra2 = letra3;
                    }else{
                        letra2 += letra3;
                    }
            
        }
        
        System.out.println(letra2);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
}
