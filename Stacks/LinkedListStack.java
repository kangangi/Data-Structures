import java.util.EmptyStackException;

// Linked list representation of a stack
public class Stack{

    private ListNode top;
    private int length;

    private  class ListNode {
        private int data;
        private ListNode  next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public Stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if( isEmpty() ){
            throw new EmptyStackException();
        } else {
            ListNode temp = top;
            top = temp.next;
            length--;
            return temp.data;
        }
    }

    public int peak(){
        if( isEmpty() ){
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());

    }
}