package Sort;

import java.io.File;
import java.util.*;
    
    /**Clase de Ordenado por tamaño con el metodo RadixSort
     * @author Harold EM
     */
    public class RadixSort {
        static File dir = new File("Docs");
        static String direccion = dir.getAbsolutePath();
        
        /**
         * Obtiene el valor mas grande del array
         * @param arr recibe el array a ordenar
         * @param n logitud del array a ordenar
         * @return devuelve el mayor elemento
         */
        public static int getMax(String arr[], int n)
        {
            File may = new File(direccion +"\\"+ arr[0]);
            int mx =  (int)may.length();
            for ( int i = 1; i < n; i++){
                File comp = new File(direccion+"\\"+arr[i]);
                if (comp.length() > mx)
                    mx = (int) comp.length();
            }
            return mx;
        }
        
        /**
         * Metdo encargado de ordenar el array
         * @param arr recibe el array a ordenar 
         * @param n largo del array
         * @param exp eponente a dividir 
         * 
         */
        public static void countSort(String arr[], int n, int exp)
        {
            String output[] = new String[n]; 
            int i;
            int count[] = new int[10];
            Arrays.fill(count,0);

            for (i = 0; i < n; i++){
                File comp = new File(direccion+"\\"+arr[i]);
                count[ ((int)comp.length()/exp)%10 ]++;
            }
            
            for (i = 1; i < 10; i++){
                count[i] += count[i - 1];
            }
           
            for (i = n - 1; i >= 0; i--)
            {
                File comp = new File(direccion+"\\"+arr[i]);
                output[count[ ((int)comp.length() /exp)%10 ] - 1] = arr[i];
                count[ ((int)comp.length()/exp)%10 ]--;
            }

            for (i = 0; i < n; i++)
                arr[i] = output[i];
        }
        /**
         * Metodo principal del radixsort
         * @param arr recibe el array a ordenar
         * @param n largo del array
         * @return Devuelve el array ordenado
         */
        public static String[] radixsort(String arr[], int n)
        {
            int m = (int) getMax(arr, n);

            for (int exp = 1; m/exp > 0; exp *= 10)
                countSort(arr, n, exp);
            return arr;
        }

    }
