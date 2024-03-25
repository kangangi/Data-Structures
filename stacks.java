//import java.util.EmptyStackException;
//
//
//// Linked list representation of a stack
//public class Stack{
//
//    private ListNode top;
//    private int length;
//
//    private  class ListNode {
//        private int data;
//        private ListNode  next;
//
//        public ListNode(int data){
//            this.data = data;
//        }
//    }
//
//    public Stack(){
//        top = null;
//        length = 0;
//    }
//
//    public int length(){
//        return length;
//    }
//
//    public boolean isEmpty(){
//        return length == 0;
//    }
//
//    public void push(int data){
//        ListNode temp = new ListNode(data);
//        temp.next = top;
//        top = temp;
//        length++;
//    }
//
//    public int pop(){
//        if( isEmpty() ){
//            throw new EmptyStackException();
//        } else {
//            ListNode temp = top;
//            top = temp.next;
//            length--;
//            return temp.data;
//        }
//    }
//
//    public int peak(){
//        if( isEmpty() ){
//            throw new EmptyStackException();
//        } else {
//            return top.data;
//        }
//    }
//
//    public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.push(5);
//        stack.push(10);
//        stack.push(20);
//        System.out.println(stack.peak());
//        System.out.println(stack.pop());
//        System.out.println(stack.peak());
//        System.out.println(stack.pop());
//        System.out.println(stack.peak());
//        System.out.println(stack.pop());
//        System.out.println(stack.peak());
//
//    }
//}

// Array implementation of a Stack

//public class ArrayStack {
//    private int top;
//    private int[] arr;
//
//
//    public ArrayStack(int capacity) {
//        top = -1;
//        arr = new int[capacity];
//    }
//
//    public int size() {
//        return top + 1;
//    }
//
//    public boolean isFull() {
//        return arr.length == size();
//    }
//
//    public boolean isEmpty() {
//        return top < 0;
//    }
//
//    public void push(int data) {
//        if (isFull()) {
//            System.out.println("Stack is full");
//            throw new RuntimeException("Stack is full");
//        } else {
//            top++;
//            arr[top] = data;
//        }
//    }
//
//    public int pop() {
//        if (isEmpty()) {
//            throw new RuntimeException("Stack is empty");
//        } else {
//            int temp = arr[top];
//            top--;
//            return temp;
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(3);
//        stack.push(5);
//        stack.push(10);
//        stack.push(20);
//        System.out.println(stack.pop());
//        stack.push(40);
//        System.out.println(stack.pop());
//    }
//}


// Reverse string using a stack

import java.util.Stack;
public class StringReverse{

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for (char c: chars){
            stack.push(c);
        }

        for (int i =0; i < str.length(); i++){
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(str);
        System.out.println(reverse(str));
    }
}


// Given an array of integers. For each element in the array, find its next greater element in
// that array. The next greater element is the first element towards  right, which is greater
// than the current element eg input {4, 7, 3, 4, 8, 1} output {7, 8, 4, 8, -1, -1}


import java.util.Stack;
public class NextGreaterElement{

    public static int[] nextGreaterElement(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for( int i = arr.length - 1; i >= 0; i--){
            if (!stack.isEmpty()){
                while(!stack.isEmpty && stack.peek() <= arr[i]){
                    stack.pop()
                }
            }
            if (stack.isEmpty()){
                result[i] = -1
            } else {
                result[i] = stack.peek()
            }

            stack.push(arr[i])
        }

        return result

    }

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(str);
        System.out.println(reverse(str));
    }
}


