public class SelectionSort{
    
    public int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            // find minimum value
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            System.out.println(" ");
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;

    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] unsorted = {1, 5, 2, 9, 10, 0};
        for( int i =0; i < unsorted.length; i++){
            System.out.print(unsorted[i] + ", ");
        }
        System.out.println(" ");
        int [] sorted = ss.selectionSort(unsorted);
        for( int i =0; i < sorted.length; i++){
            System.out.print(sorted[i] + ", ");
        }
        System.out.println(" ");
    }
}

