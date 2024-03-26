import java.util.NoSuchElementException;

public class CircularSinglyLinkedList{

    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;

        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(15);
        ListNode fourth = new ListNode(20);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    // print the elements of a circular singly linked list
    public void display(){
        if (last == null){
            return ;
        }
        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.println(first.data + "");
    }

    // insert a node at the begining of a circular singly list

    public void insertStart(int value){
        ListNode temp = new ListNode(value);
        if (last == null){
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;

    }

    public void insertEnd(int value){
        ListNode temp = new ListNode(value);
        if (last == null){
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    // remove first node from circular singly linked list
    public ListNode removeFirst(){
        if (last == null){
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (temp == last){
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularLinkedList();
        csll.insertStart(0);
        csll.insertEnd(25);
        csll.display();
        csll.removeFirst();
        csll.display();

    }
}