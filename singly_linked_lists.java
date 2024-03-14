public class SinglyLinkedList{

    private ListNode head;

    private static class ListNode{
        private int data; //Can be any type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

    // print out the list
    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    //Get the length of the list
    public int length(){
        ListNode current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    // Insert a new node at the beginning of the linked list
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert a new node at the end of the linked list
    public void insertEnd(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    // Implement method to inster a node at a given position.
    public void instertPosition(int value, int position){
        ListNode newNode = new ListNode(value);
        if (position == 1){
            newNode.next = head;
            head = newNode;
        } else if ( position == 0 || position > this.length()) {
            System.out.println("Error, invalid position");
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }

            ListNode temp = previous.next;
            newNode.next = temp;
            previous.next = newNode;
        }

    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.insertFirst(7);
        sll.insertFirst(5);
        sll.insertEnd(770);
        sll.instertPosition(1,1);
        sll.display();
        System.out.println(sll.length());
    }
}