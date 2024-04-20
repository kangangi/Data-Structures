public class DutchNationalFlag{

    // Given an arrsy containing only 0s, 1s, and 2s. Sort the array in linear time and constant space
    // We use two pointers

    public int[] sort(int[] arr){
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        int temp = 0;
        while (i <= k){
            if ( arr[i] == 0){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
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
        DutchNationalFlag dnf = new DutchNationalFlag();
        int[] arr = {0, 1, 2, 1, 0, 2, 2, 0, 0, 1};
        dnf.printArray(arr);
        int[] sorted = dnf.sort(arr);
        dnf.printArray(sorted);

    }
}