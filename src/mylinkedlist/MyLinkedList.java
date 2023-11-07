package mylinkedlist;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public void add(T val) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Node<T>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> newLastNode = new Node<T>(lastNode, null, val);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    public int size(){
    return size;
    }

    public void clear(){
        firstNode=null;
        size=0;
    }
    public void display() {
        Node<T> current = firstNode;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNextNode();
        }
        System.out.println("\n");
    }

    public void remove(int index){
        if (index == 0) {
            firstNode = firstNode.getNextNode();
            if (firstNode != null) {
                firstNode.setPrevNode(null);
            }
        } else {
            Node<T> currentNode = firstNode;
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

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();

        myLinkedList.add("name1"); // index 0
        myLinkedList.add("name2"); // index 1
        myLinkedList.add("name3"); // index 2
        myLinkedList.add("name4"); // index 3
        myLinkedList.add("name5"); // index 4

        //System.out.println("ll.get(2) = " + myLinkedList.get(2));

        //System.out.println(myLinkedList.size());
        //System.out.println("display size: ");
        //System.out.println(myLinkedList.size());
        //myLinkedList.display();
        //myLinkedList.clear();
        //System.out.println("display after clear");
        myLinkedList.display();
        System.out.println("display size: ");
        System.out.println(myLinkedList.size());

        myLinkedList.remove(1);

        System.out.println("display list after remove 1 element ");
        myLinkedList.display();
        System.out.println("display size: ");
        System.out.println(myLinkedList.size());


    }
}
