public class Arrayutil{

    public void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo (){
        int[] myArray = new int[5]; //default values
        myArray[0] = 5;
        myArray[1] = 8;
        myArray[2] = 2;
        myArray[3] = 10;
        myArray[4] = 11;
        printArray(myArray);
        System.out.println(myArray.length - 1);
    }

    //Given an array of intergers, retuern an array with even integer removed

    public static int[] removeEven(int[] arr){
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount]; // to create a new array with fixed length
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0 ){
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    // Reversing an array in Java
    // Two pointers is used

    public static  int[] reverseArray(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }



    public static void main(String[] args){
        Arrayutil arrUtil = new Arrayutil();
        arrUtil.arrayDemo();

        int[] arr = {3, 2, 4, 7, 10, 6, 5};
        arrUtil.printArray(arrUtil.removeEven(arr));

        System.out.println(arr.length - 1);
        arrUtil.printArray(arrUtil.reverseArray(arr, 0, arr.length-1));
    }
}