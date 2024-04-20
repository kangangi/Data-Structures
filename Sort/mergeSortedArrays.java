public class MergeSortedArray{

    public int[] mergeSortedArray(int[] arr1, int[] arr2){
        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length){
            if( arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length){
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
    public void printArray(int[] arr){
        for( int i =0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] arr1 = {2, 3, 5, 10};
        int[] arr2 = {2, 2, 4, 6, 11, 15};
        int [] result = msa.mergeSortedArray(arr1, arr2);
        msa.printArray(result);
    }
}

