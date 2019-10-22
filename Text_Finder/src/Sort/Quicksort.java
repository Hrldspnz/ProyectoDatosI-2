
package Sort;

    /**
     * Clase de Ordenado por nombre con el metodo QuickSort
     * @author Harold EM
     */
    public class Quicksort  {
        private static String[] names;
        private static int number;
        
        /**
         * Metodo principal que ordena el array
         * @param nombres array con los nombres a ordenar
         * @return Retorna el array ordenado por nombres
         * @author Harold EM
         */
        
        public static String[] Ordenar(String[] nombres){
           
            sort(nombres);
            return nombres;
        }
        
        
        /**
         * Metodo que se encarga de hacer la division del array
         * @param values recibe los valores a ordenar
         */
        public static void sort(String[] values) {
            if (values ==null || values.length==0){
                return;
            }
            names = values;
            number = values.length;
            quicksort(0, number - 1);
        }
        
        /**
         * Metodo que compara las posicoines del array
         * @param low recibe un entero con la primer posicion
         * @param high recibe un  entero con la ultima posicion
         * 
         */
        private static void quicksort(int low, int high) {
            int i = low, j = high;
            String pivot = names[low + (high-low)/2];
            while (i <= j) {
                while (names[i].compareToIgnoreCase(pivot) < 0) {
                    i++;
                }
                while (names[j].compareToIgnoreCase(pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    exchange(i, j);
                    i++;
                    j--;
                }
            }
            if (low < j)
                quicksort(low, j);
            if (i < high)
                quicksort(i, high);
        }
        
        /**
         * Metodo que intercambia los valores del array
         * @param i primera pos a intercambiar del array 
         * @param j segunda poscion a intercambiar del array
         * 
         */
        private static void exchange(int i, int j) {
            String temp = names[i];
            names[i] = names[j];
            names[j] = temp;
            
        }

}