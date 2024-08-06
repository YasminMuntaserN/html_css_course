public class LinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find LinkedList Length
    public int FindLength() {
        ListNode temp = head;
        int count = 0;
        if (temp == null)
            return 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Insert in the Begining
    public void InsertAtBegining(int value) {
        ListNode New_Node = new ListNode(value);
        New_Node.next = head;
        head = New_Node;
    }

    // Insert in the End
    public void InsertAtTheEnd(int value) {
        ListNode New_Node = new ListNode(value);
        New_Node.next = null;
        if (head == null) {
            head = New_Node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = New_Node;
        return;
    }

    // Isnsert in given position
    public void InsertAtPosition(int position, int value) {
        ListNode New_Node = new ListNode(value);
        if (position == 0) {
            InsertAtBegining(value);
            return;
        } else if (position == FindLength()) {
            InsertAtTheEnd(value);
            return;
        } else {
            ListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            New_Node.next = temp.next;
            temp.next = New_Node;
        }
    }

    // Delete from the beginning
    public void DeleteBeginning() {
        if (head == null) {
            System.out.println("can not Detete from the beginning");
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }

    // Delete from the End
    public void DeleteAtTheEnd() {
        if (head == null) {
            System.out.println("can not Detete from the beginning");
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            ListNode curr = head, prev = head;
            while (curr.next != null && curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
    }

    // Delete in given position
    public void DeleteAtPosition(int position) {
        if (position == 0) {
            DeleteBeginning();
            return;
        } else if (position == FindLength()) {
            DeleteAtTheEnd();
            return;
        } else {
            ListNode curr = head, prev = head;
            for (int i = 1; i < position; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
    }

    // search an element
    public boolean search(int value) {
        ListNode temp = head;
        while (head != null) {
            if (head.data == value) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // reverse the linked list
    public void reverse() {
        ListNode curr = head, prev = null, next = curr;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find element by index
    public ListNode FindByPosition(int position) {
        ListNode temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // find the Middle element of the linked list
    public int FindMeddle() {
        if (head == null) {
            return 0;
        }
        return FindByPosition((FindLength() / 2)).data;
    }

    // find the Middle element of the linked list Another soluation
    public ListNode FindMeddle2() {
        ListNode fast = head, slow = head;
        if (head == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // find nth node from the end of a Singly Linked List
    public ListNode FindNthFromEnd(int n) {
        ListNode fast = head, slow = head;
        if (head == null) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // remove duplicate from linked list
    public void removeDuplicate() {
        int pos = 0;
        ListNode curr = head;
        if (head == null)
            return;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {

                curr = curr.next;
            }
        }
    }

    // insert a node in a sorted Singly Linked List
    public void InsertSorted(int value) { // My Soluotion
        ListNode New_Node = new ListNode(value);
        ListNode curr = head;
        if (head == null) {
            head = New_Node;
            return;
        }
        while (curr != null && curr.next != null) {
            if (curr.data < value && curr.next.data > value) {
                New_Node.next = curr.next;
                curr.next = New_Node;
            }
            curr = curr.next;
        }
        if (curr.next == null && curr.data < value) {
            New_Node.next = null;
            curr.next = New_Node;
        }
    }

    public ListNode InsertSorted2(int value) { // Another soluotion
        ListNode New_Node = new ListNode(value);
        if (head == null) {
            return New_Node;
        }
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null && curr.data < New_Node.data) {
            temp = curr;
            curr = curr.next;
        }
        New_Node.next = curr;
        temp.next = New_Node;
        return head;
    }

    // remove a given key from the linked list
    public void remove(int value) {
        if (head == null)
            return;
        ListNode curr = head, prev = head;
        while (curr != null) {
            if (curr.data == value) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void remove2(int value) {// Another soluotion
        ListNode curr = head, temp = null;
        while (curr != null && curr.data != value) {
            temp = curr;
            curr = curr.next;
        }
        if (head == null)
            return;
        temp.next = curr.next;
    }

    /* هاد المثال ارجعيلووو !!!!!!!! */
    // Cheak loop in a Singly Linked List
    public boolean CheckLoop() {
        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    // Creat a Loop in Linked List
    public void CreatLoop() {
        ListNode firNode = new ListNode(1);
        ListNode secNode = new ListNode(2);
        ListNode thNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fifNode = new ListNode(5);
        ListNode sixNode = new ListNode(6);
        head = firNode;
        firNode.next = secNode;
        secNode.next = thNode;
        thNode.next = fourNode;
        fourNode.next = fifNode;
        fifNode.next = sixNode;
        sixNode.next = thNode;
    }

    // find start of a loop in a Linked List
    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public ListNode FindLoopStart() {
        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    // Merge Two Sorted Lists
    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    // print linked List elements
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        sll.InsertAtTheEnd(1);
        sll.InsertAtTheEnd(4);
        sll.InsertAtTheEnd(8);
        sll.print();
        System.out.println(sll.FindByPosition(1).data);
        sll.InsertAtPosition(1, 500);
        sll.print();
        System.out.println(sll.FindByPosition(1).data);

        // LinkedList sll2 = new LinkedList();
        // sll2.InsertAtTheEnd(3);
        // sll2.InsertAtTheEnd(5);
        // sll2.InsertAtTheEnd(8);
        // sll2.InsertAtTheEnd(9);
        // sll2.InsertAtTheEnd(14);
        // sll2.InsertAtTheEnd(18);
        // sll2.print();
        // LinkedList newLinkedList= new LinkedList();
        // newLinkedList.head=merge(sll.head, sll2.head);
        // newLinkedList.print();

    }
}
