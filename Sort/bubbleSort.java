class BubbleSort{

    public int[] bubbleSort(int[] arr){
        boolean isSwapped;
        for (int i = 0; i < arr.length - 1; i++){
            isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false ) break;
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
        BubbleSort bs = new BubbleSort();
        int[] unsorted = {1, 5, 2, 9, 10, 0};
        bs.printArray(unsorted);
        int [] sorted = bs.bubbleSort(unsorted);
        bs.printArray(sorted);

    }
}