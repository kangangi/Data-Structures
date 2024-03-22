import java.util.NoSuchElementException;

public class DoublylyLinkedList{

    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode{
        private int data; //Can be any type
        private ListNode next;
        private ListNode previous;

        // Constructor
        public ListNode(int data){
            this.data = data;
        }

    }

    public DoublylyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0; // head == null;
    }

    public int length(){
        return length;
    }

    // print out the element of the doubly linked list
    // can traverse forward and backwards
    public void displayForward(){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void displayReverse(){
        ListNode temp = tail;
        while (temp!=null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // Insert a node at the beginning of the doubley linked list
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty()){
            tail = newNode;
        } else{
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertEnd(int value){
        ListNode newNode = new ListNode(value);

        if (isEmpty()){
            head = newNode;
        } else{
            tail.next = newNode;
            newNode.previous = tail; // There has to be a double relationship
        }

        tail = newNode;
        length++;
    }
     // Delete firstNode in a doubly linked list
    public ListNode deleteFirst(){
        if( isEmpty()){
            System.out.println("This is empty");
            throw new NoSuchElementException();
        } else {
            ListNode temp = head;
            if (head == tail){
                tail = null;
            } else {
                head.next.previous = null;
            }

            head = head.next;
            temp.next = null;
            length--;
            return temp;
        }

    }
    public ListNode deleteEnd(){
        if (isEmpty()){
            System.out.println("This is empty");
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }


    public static void main(String[] args) {
        DoublylyLinkedList dll = new DoublylyLinkedList();
        dll.insertFirst(1);
        dll.insertFirst(10);
        dll.insertEnd(6);
        dll.insertEnd(8);

        dll.displayForward();
        dll.deleteEnd();
        dll.displayForward();
        dll.deleteEnd();
        dll.displayForward();
        dll.deleteEnd();
        dll.displayForward();
        dll.deleteEnd();
        dll.displayForward();
        dll.deleteEnd();
        //dll.displayReverse();
    }


}