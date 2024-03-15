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
    public void display(ListNode head){
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

    // Implement method to insert a node at a given position.
    public void insertPosition(int value, int position){
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

    // Delete first node of a ListNode
    public ListNode deleteFirst(){
        if (head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // Delete node from the end of the list
    public ListNode deleteLast(){
        if (head == null){
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }


    // Deleteb node from a given position of list
    public ListNode deleteNode(int position){
        if (position == 1){
            ListNode temp = head;
            head = head.next;
            return temp;
        } else if (position == 0 || position > this.length() ){
                System.out.println("Error, invalid position");
                return null;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode temp = previous.next;
            previous.next = temp.next;
            temp.next = null;
            return temp;
        }
    }

    // How to search element in the singly linked list
    public boolean searchData(int searchKey){
        ListNode current = head;
        while(current!=null){
            if (current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reverse the singly linked list

    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null){
            next = current.next; // to keep a record of which node to go to next
            current.next = previous; // reverses the direction of the list
            previous = current; // to go to the next node
            current = next;
        }

        return  previous;
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
        sll.insertPosition(1,1);
        sll.display(sll.head);
        //ListNode temp = sll.deleteNode(2);
        ListNode reversed = sll.reverseList(sll.head);
        //System.out.println(sll.searchData(13));
        sll.display(reversed);
    }
}