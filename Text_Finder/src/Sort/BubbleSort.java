package Sort;

import static Sort.RadixSort.direccion;
import java.io.File;
import java.util.Date;


/**
 * Clase de Ordenado por fecha con el metodo BubbleSort
 * @author HaroldEM
 */
 
public class BubbleSort {
    
    /**
     * Metodo principal para ordenar el array
     * @param array recibe el array a ordenar 
     * @return retorna el array ordenado por fecha
     * 
     */
    public static String[] bubble_srt(String array[]) {
        int n = array.length;
        int k;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                File filedate = new File(direccion+"\\"+array[i]);
                File filedate2 = new File(direccion+"\\"+array[k]);
                Date d = new Date(filedate.lastModified());
                Date d2 = new Date(filedate2.lastModified());

                if (d.before(d2)) {
                    String temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }

        }return array;

    }

}
