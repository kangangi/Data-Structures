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
    public void printArray(int[] arr){
        for( int i =0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] unsorted = {1, 5, 2, 9, 10, 0};
        is.printArray(unsorted);
        int [] sorted = is.insertionSort(unsorted);
        is.printArray(sorted);
    }
}