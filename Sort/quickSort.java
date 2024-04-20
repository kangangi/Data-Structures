public class QuickSort{

    public int[] sort(int[] arr, int low, int high){
        if (low < high){
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p + 1, high);
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low;
        int j = low;
        while(i <= high){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1; // index of the pivot
    }

    public void printArray(int[] arr){
        for( int i =0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        QuickSort qs  = new QuickSort();
        int[] arr = {8, -3, 5, 2, 6, 9, -6, 1, 3};
        qs.printArray(arr);
        int[] sorted = qs.sort(arr, 0, arr.length -1);
        qs.printArray(sorted);
    }
}