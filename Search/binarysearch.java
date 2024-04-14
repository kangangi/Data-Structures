class BinarySearch{

    public int binarySearch(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        while( left <= right){
            int mid = (left + right) /2;
            System.out.println("mid is " + mid + " right is " + right + " left is " + left);
            if (arr[mid] == x){
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return -1;
    }


    // Given a sorted array of distinct integers and target value, return the index if the target is found. If not,
    // return the index where it would be if it were inserted in order. The algorithm should run in O(logn) time

    public int searchInsert(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2; // this is to avoid error when the array is very big
            System.out.println("mid is " + mid + " right is " + right + " left is " + left);
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, 65));
        System.out.println(bs.searchInsert(arr, 66));
    }
}