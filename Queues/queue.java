import java.util.NoSuchElementException;

public class Queue{

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current = front;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data){
        ListNode newNode = new ListNode(data);
        if (isEmpty()){
            front = newNode;
        }else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        int result = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        length--;
        return result;
    }

    public int first(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return front.data;
    }

    public int last(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return rear.data;
    }

    // Generate Binary Numbers from 1 to n using Queue


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.print();
        queue.enqueue(15);
        queue.enqueue(20);
        queue.print();
        queue.dequeue();
        System.out.println(queue.first());
        queue.print();


    }
}