package mystack;

public class MyStack<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void push(T value){
        if (head == null){
            head = new Node<>(null,null,value);
        }else if (tail==null){
            tail = new Node<T>(head,null,value);
            head.setNextNode(tail);
        }else {
            Node<T> newTail = new Node<T>(tail,null,value);
            tail.setNextNode(newTail);
            tail=newTail;
        }
        size++;
    }

    public void remove(int index){
        if (index == 0) {
            head = head.getNextNode();
            if (head != null) {
                head.setPrevNode(null);
            }
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            Node<T> prevNode = currentNode.getPrevNode();
            Node<T> nextNode = currentNode.getNextNode();
            prevNode.setNextNode(nextNode);
            if (nextNode != null) {
                nextNode.setPrevNode(prevNode);
            }
        }
        size--;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head=null;
        size=0;
    }
    public T peek(){
        return tail.getValue();
    }
    public void pop(){
        System.out.println(tail.getValue());
        tail = tail.getPrevNode();
        if (tail != null) {
            tail.setNextNode(null);
        }
        size--;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNextNode();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("name1");
        myStack.push("name2");
        myStack.push("name3");
        myStack.push("name4");
        myStack.push("name5");

        myStack.display();
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.display();
    }
}
