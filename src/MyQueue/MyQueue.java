package MyQueue;
import MyLinkedList.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T value){
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

    public int size(){
        return size;
    }

    public void clear(){
        head=null;
        size=0;
    }
    public T peek(){
        return head.getValue();
    }
    public void poll(){
        System.out.println(head.getValue());
        head = head.getNextNode();
                if (head != null) {
                    head.setPrevNode(null);
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
        MyQueue<String> myQueue = new MyQueue<String>();

        myQueue.add("name1");
        myQueue.add("name2");
        myQueue.add("name3");
        myQueue.add("name4");
        myQueue.add("name5");
        myQueue.display();
        System.out.println(myQueue.peek());
        myQueue.poll();
        myQueue.display();


    }

}
