public class InsertionSort{

    public int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] unsorted = {1, 5, 2, 9, 10, 0};
        for( int i =0; i < unsorted.length; i++){
            System.out.print(unsorted[i] + ", ");
        }
        System.out.println(" ");
        int [] sorted = is.insertionSort(unsorted);
        for( int i =0; i < sorted.length; i++){
            System.out.print(sorted[i] + ", ");
        }
        System.out.println(" ");

    }
}