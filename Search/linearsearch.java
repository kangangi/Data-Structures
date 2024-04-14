public class LinearSearch{

    public int linearSearch(int[] arr, int n , int x){
        for (int i=0; i < n; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        int [] arr = { 5, 1, 9, 2, 10, 15, 20};
        System.out.println(ls.linearSearch(arr, arr.length, 4));
    }
}