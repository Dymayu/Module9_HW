package MyStack;

public class Node<T> {

        private Node<T> prevNode;
        private Node<T> nextNode;
        private T value;

        public Node(Node<T> prevNode, Node<T> nextNode, T value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        public Node<T> getPrevNode() {
            return prevNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public T getValue() {
            return value;
        }

        public void setPrevNode(Node<T> prevNode) {
            this.prevNode = prevNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public void setValue(T value) {
            this.value = value;
        }

}
