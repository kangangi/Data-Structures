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

    // Find the minimum value of an array
    public static int findMinimum(int[] arr){
        // edge case
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];
        for (int i=1; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    // Given an array of integers, return the second maximum value. The second maximu value exists

    public static int findSecondMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i=0; i < arr.length; i++){
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Given an array of integers, write a function to move all 0's to end of it while maintaining tghe relative order of the non-zero elememts
    // We use the two pointers

    public static int[] moveZeros(int[] arr){
        int j = 0;
        for (int i= 0; i < arr.length; i++ ){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        return arr;
    }




    public static void main(String[] args){
        Arrayutil arrUtil = new Arrayutil();
        // Create array output
        // arrUtil.arrayDemo();
        // arrUtil.printArray( arrUtil.arrayDemo());


        //int[] arr = {13, 12, 4, 17, 17, 8, 5};
        // Remove even values demo
        // arrUtil.printArray(arrUtil.removeEven(arr));

        // Reverse array demo
        // arrUtil.printArray(arrUtil.reverseArray(arr, 1, 5));

        // Minimum value demo
        // System.out.println(arrUtil.findMinimum((arr)));

        // Second Maximum value demo
        // System.out.println(arrUtil.findSecondMaximum(arr));

        // Move zeros to end demo
        int[] arr = {8, 2, 0, 7, 6, 0, 9, 5};
        arrUtil.printArray( arrUtil.moveZeros(arr));
    }
}