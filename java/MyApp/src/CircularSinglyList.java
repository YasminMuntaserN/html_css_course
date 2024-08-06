public class CircularSinglyList {
    private Node last;
    private int length;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public CircularSinglyList() {
        this.last = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularList() {
        Node first = new Node(1);
        Node seconde = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        first.next = seconde;
        seconde.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }

    public void print() {
        if (last == null)
            return;
        Node first = last.next;// بهيك احنا بنكون جبنا النود الاول
        while (first != last) {
            System.out.print(first.value + "  ");
            first = first.next;
        }
        System.out.println(first.value);
    }

    public void InsertAtBegining(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void InsertAtEnd(int value) {
        Node newNode = new Node(value);
        if (last == null) {
            last = newNode;
            newNode.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void DeleteFirstNode() {
        if (last == null) {
            System.out.println("this list is empty");
            return;
        }
        Node first = last.next;
        if (last == first) {
            last = null;
        } else {
            last.next = first.next;
        }
        first.next = null;
        length--;
    }

    public static void main(String[] args) {
        CircularSinglyList list = new CircularSinglyList();
        list.InsertAtBegining(20);
        list.InsertAtBegining(70);
        list.InsertAtBegining(90);
        list.InsertAtEnd(500);
        list.InsertAtEnd(500);
        list.InsertAtEnd(500);
        // list.createCircularList();

        list.print();

        list.DeleteFirstNode();
        list.print();

    }

}
