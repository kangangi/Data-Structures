import java.util.EmptyStackException;

public class ArrayStack {
    private int top;
    private int[] arr;


    public ArrayStack(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public int peak() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return arr[top];
        }
    }


    public boolean isFull() {
        return arr.length == size();
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            throw new RuntimeException("Stack is full");
        } else {
            top++;
            arr[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            int temp = arr[top];
            top--;
            return temp;
        }

    }

    // Given an array of integers. For each element in the array, find its next greater element in
    // that array. The next greater element is the first element towards  right, which is greater
    // than the current element eg input {4, 7, 3, 4, 8, 1} output {7, 8, 4, 8, -1, -1}
    public static int[] nextGreaterElement(int [] arr){
        ArrayStack stack = new ArrayStack(arr.length);
        int[] result = new int[arr.length];

        for( int i = arr.length - 1; i >= 0; i--){

            if (!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peak() <= arr[i]){
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = stack.peak();
            }

            stack.push(arr[i]);
        }

        return result;

    }


    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(3);
//        stack.push(5);
//        stack.push(10);
//        stack.push(20);
//        System.out.println(stack.pop());
//        stack.push(40);
//        System.out.println(stack.pop());
        int[] arr = {4, 7, 3, 4, 8, 1};
        int [] result = nextGreaterElement(arr);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + "-->");
        }
    }
}
