public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    private static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // head==null
    }

    public int length() {
        return length;
    }

    public void InsertAtBegining(int value) {
        Node new_Node = new Node(value);
        if (isEmpty()) {
            tail = new_Node;
        } else {
            head.prev = new_Node;
        }
        new_Node.next = head;
        // new_Node.prev = null; //هادي احنا اوردي ممررينها بالكونستركتور يعني مالها
        // لازمة احطها هان
        head = new_Node;
        length++;
    }

    public void InsertInTheEnd(int value) {
        Node new_Node = new Node(value);
        if (isEmpty()) {
            head = new_Node;
        } else {
            tail.next = new_Node;
        }
        new_Node.prev = tail;
        tail = new_Node;
        length++;
    }

    // Isnsert in given position
    public void InsertAtPosition(int index, int value) {
        Node newNode = new Node(value);
        if (index == 0) {
            removeAtBeginning();
            return;
        } else if (index == length) {
            removeFromEnd();
            return;
        } else {
            Node curr = head;
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            newNode.prev = curr;
            newNode.next = curr.next;
            curr.next = newNode;
        }
        length++;
    }

    // Delete At Beginning
    public void removeAtBeginning() {
        Node curr = head;
        if (isEmpty()) {
            return;
        }
        curr.next.prev = null;
        head = curr.next;
        length--;

    }

    // Delete from the End
    public void removeFromEnd() {
        Node curr = tail;
        if (isEmpty()) {
            return;
        }
        curr.prev.next = null;
        tail = curr.prev;
        length--;
    }

    // Delete the node by position
    public void RemoveFromIndex(int index) {
        Node curr = FindByPosition(index);
        if (index == 0) {
            removeAtBeginning();
            return;
        } else if (index == length) {
            removeFromEnd();
            return;
        } else if (curr == null) {
            return;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        length--;
    }

    // Search Find or Not found
    public boolean search(int value) {
        Node curr = head;
        if (curr == null) {
            System.out.println("the list is empty");
        }
        while (curr != null) {
            if (curr.data == value)
                return true;
            curr = curr.next;
        }
        return false;
    }

    // Find element by index
    public Node FindByPosition(int position) {
        Node temp = head, prev = head, next = null;
        if (head == null)
            return null;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // reveverse
    public void reversed() {
        Node temp = head;
        if (temp == null) {
            return;
        }
        while (temp != null) {

        }
    }

    // علشان نطبعها من الامام
    public void displayForward() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // علشان نطبعها من ورا
    public void displayBackorward() {
        if (head == null)
            return;
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ---> ");
            temp = temp.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // dll.InsertAtBegining(5);
        // dll.InsertAtBegining(4);
        // dll.InsertAtBegining(3);
        // dll.InsertAtBegining(2);
        // dremoveAtBeginning();
        dll.InsertInTheEnd(5);
        dll.InsertInTheEnd(4);
        dll.InsertInTheEnd(3);
        dll.InsertInTheEnd(2);
        dll.InsertInTheEnd(1);
        dll.displayForward();
        System.out.println(dll.FindByPosition(3).data);
        dll.InsertAtPosition(3, 500);
        dll.displayForward();

        System.out.println(dll.FindByPosition(3).data);
    }

}