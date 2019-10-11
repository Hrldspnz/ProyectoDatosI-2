
package Sort;


    public class Quicksort  {
        private static int[] numbers;
        private static int number;
        
        public static void main(String[] args){
            int arr[] = {3,2,10,1,5};
            sort(arr);
        }
        
        public static void sort(int[] values) {
            // check for empty or null array
            if (values ==null || values.length==0){
                return;
            }
            numbers = values;
            number = values.length;
            quicksort(0, number - 1);
        }
        private static void quicksort(int low, int high) {
            int i = low, j = high;
            int pivot = numbers[low + (high-low)/2];
            System.out.println("pivote: " + pivot);
            System.out.println("valores iniciales de i, j "+i +" "+ j);
            while (i <= j) {
                while (numbers[i] < pivot) {
                    i++;
                }
                while (numbers[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    System.out.println("valores despues del bucle "+i +" "+ j);
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
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            System.out.println("intercambiados: "+numbers[i] +" "+ numbers[j]);
            printArray(numbers, 0,0);
        }

        static void printArray(int arr[], int i1, int i2){
            int n = arr.length;
            for (int i=0; i<n; ++i)
                //if(i == i1)
                //    System.out.print(arr[i] + " " + i1 + " " + i2 + " ");
                System.out.print(arr[i] + " ");
        System.out.println();
        }
}