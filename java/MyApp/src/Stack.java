
/*// Implement a Stack using linked list
public class Stack {
    private Node top;
    private int length;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int value) {
        Node temp = new Node(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty list");
        }
        int result = top.value;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty list");
        }
        return top.value;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
         System.out.println(s.peek());
       s.pop();
       System.out.println(s.peek());
    }
}
*/
/* // Implement a Stack using an Array 
public class Stack {
    private int top;
    private int[] arr;

    public Stack(int size) {
        top = -1;
        arr = new int[size];
    }
    // public Stack(){
    //     this(10);
    // }
    public void push(int data){
        if(isFull()){
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top]=data;
    }
    public boolean isFull(){
        return arr.length == size();
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top < 0;
    }
    public int pop(){
        if(isEmpty()){
          throw new RuntimeException("Stack is full !!!");
        }
        int result=arr[top];
        top--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty!!!");
        }
        return arr[top];
    }
    public static void main(String[]args){
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
*/
/* //reverse a String using a Stack
/* //Valid Parentheses problem (Balanced Brackets) */
import java.time.LocalTime;
import java.util.Stack;

class StringReverse {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (c == '}' && top == '{' ||
                            c == ')' && top == '(' ||
                            c == ']' && top == '[') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void  calcAgeInYear(int Year){
      LocalTime currentTime=   LocalTime. now();
      System.out.println(currentTime);

    }
    public static void main(String[] args) {
        String str = "{([]}";
       // System.out.println(isValid(str));
calcAgeInYear(2004);
    }
}
