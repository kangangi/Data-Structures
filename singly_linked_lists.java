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

    //Find a middle node in a singly linked list
    public ListNode middleNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Find the nth node from the end of a linked list in Java
    public ListNode nthFromEnd(ListNode head, int n){
        if (head == null){
            return null;
        }

        ListNode main = head;
        ListNode ref  = head;

        int count = 0;
        while(count < n){
            ref = ref.next;
            count++;
        }

        while(ref != null){
            if(ref == null){
                return null; // number is bigger than the length of the list
            }
            ref = ref.next;
            main = main.next;
        }

        return main;
    }

    // Remove Duplicates in sorted linked lists
    public void removeDuplicates(ListNode head){
        if (head == null){
            return ;
        }
       ListNode current = head;
       while (current != null && current.next != null){
           if (current.data == current.next.data){
               current.next = current.next.next;
           } else {
               current = current.next;
           }
       }
    }

    // How to insert a node in a sorted singly linked list

    public void insertNodeSorted(int value){
        ListNode newNode = new ListNode(value);

        if(head == null){
            head = newNode;
        } else if ( value <= head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode current = head;
            ListNode temp = null;
            while (current != null && current.data < newNode.data){
                temp = current;
                current = current.next;
            }

            newNode.next = current;
            temp.next = newNode;
        }
    }

    //How to remove a given key from a linked list
    public void removeKey(int value){
        if(head == null){
            return;
        } else if (head.data == value) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        } else {
            ListNode current = head;
            ListNode temp = null;
            while (current != null && current.data != value){
                temp = current;
                current = current.next;
            }
            if (current == null){
                return;
            } else {
                temp.next = current.next;
                current.next = null;
            }

        }
    }

    // How to detect a loop in a singly linked list
    // I used two pointers: fast and slow
    public boolean hasLoop(){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    // How to find start of a loop in a singly linked list
    private ListNode getStartingNode(ListNode slow){
        ListNode temp = head;
        while (slow != temp){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
    public ListNode startNodeInALoop(){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return getStartingNode(slow);
            }
        }
        return null;
    }

    // How to remove a loop from singly linked list

    private void removeLoop(ListNode slow){
        ListNode temp = head;
        while (slow.next != temp.next){
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = null;
    }
    public void endALoop(){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                removeLoop(slow);
            }
        }
    }

    // Merge two sorted singly linked lists
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(a != null &&  b != null){
            if(a.data <= b.data){
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a == null){
            temp.next = b;
        } else {
            tail.next= a;
        }
        return dummy.next
    }




    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        //sll.insertEnd(17);
        //sll.insertEnd(17);
        // sll.insertPosition(18, 1);
        //sll.display(sll.head);
        // ListNode temp = sll.deleteNode(2);
        // ListNode reversed = sll.reverseList(sll.head);
        // int middlenode = sll.middleNode(sll.head).data;
        // System.out.println(middlenode);
        //int nthnode = sll.nthFromEnd(sll.head, 3).data;
        //System.out.println(nthnode);
        //sll.removeDuplicates(sll.head);
        //sll.insertNodeSorted(8);
        //sll.removeKey(17);
        //System.out.println(sll.hasLoop());
        sll.endALoop();
        sll.display(sll.head);
        // sll.display(reversed);
    }
}