public class Test {
    private Node head;
    private Node tail;
    private int length;

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public Test() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void PrintForwerd() {
        Node temp = head;
        if (temp == null)
            return;
        while (temp != null) {
            System.out.print(temp.value + "----->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void Printbackwerd() {
        Node temp = tail;
        if (temp == null)
            return;
        while (temp != null) {
            System.out.print(temp.value + "----->");
            temp = temp.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    public void InsertAtBegining(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            tail = newNode; // راح تكون الليست فاضية فهنروح نخلي التل هوا الي يأشر ع النيونود بينما الهد في
                            // كل الحالات هنخليه ياشر ع النود الجديد لانو احنا بنضيف من البداية
        } else {
            head.prev = newNode; // لما ما تكون فاضية هنخلي البرفيس تبع الهد ياشر ع النود الجديدة
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void InsertAtTheEnd(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    public void DeleteFirstNode() {
        Node curr = head;
        if (isEmpty()) {
            System.out.println(" Theres No element to delete");
            return;
        }
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = curr.next;
        length--;
    }

    public void DeleteTheLastNode() {
        Node curr = tail;
        if (isEmpty()) {
            System.out.println(" Theres No element to delete");
            return;
        }
        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = curr.prev;
        length--;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.InsertAtBegining(5);
        test.InsertAtBegining(4);
        test.InsertAtBegining(3);
        test.InsertAtBegining(2);
        test.InsertAtBegining(1);
        test.InsertAtTheEnd(6);
        test.InsertAtTheEnd(7);

        test.DeleteFirstNode();
        test.PrintForwerd();
        // test.Printbackwerd();
        test.DeleteTheLastNode();
        test.PrintForwerd();
        // test.Printbackwerd();

    }

}