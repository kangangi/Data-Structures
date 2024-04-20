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

    public void printArray(int[] arr){
        for( int i =0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] unsorted = {1, 5, 2, 9, 10, 0};
        ss.printArray((unsorted));
        int [] sorted = ss.selectionSort(unsorted);
        ss.printArray((sorted));
    }
}

