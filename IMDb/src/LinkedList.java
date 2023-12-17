public class LinkedList {
    private Node head;
    private int count;

    LinkedList() {
        head = null;
        count = 0;
    }

    void add(Object node){
       Node n = new Node(node);
       n.setNextPtr(head);
       head = n;
       count++;
    }

    Node get(int index) {
        Node current = head;
        if (index <= size())
            for (int x = 0; x < index && current.getNextPtr() != null; x++)
                current = current.getNextPtr();
        else
            return null;
        return current;
    }

    int size(){
        return count;
    }
}