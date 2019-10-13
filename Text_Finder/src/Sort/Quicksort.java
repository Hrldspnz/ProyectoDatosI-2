
package Sort;

    /**
     * @author Harold EM
     */
    public class Quicksort  {
        private static String[] names;
        private static int number;
        
        public static String[] Ordenar(String[] nombres){
           
            sort(nombres);
            return nombres;
        }
        
        public static void sort(String[] values) {
            if (values ==null || values.length==0){
                return;
            }
            names = values;
            number = values.length;
            quicksort(0, number - 1);
        }
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

        private static void exchange(int i, int j) {
            String temp = names[i];
            names[i] = names[j];
            names[j] = temp;
            
        }

        static void printArray(String arr[], int i1, int i2){
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
        System.out.println();
        }
}