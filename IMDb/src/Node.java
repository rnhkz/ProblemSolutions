public class Node {
    private Object data;
    private Node node;

    Node(){
        data = null;
        node = null;
    }

    Node(Object data){
        this.data = data;
        node = null;
    }

    void set(Object name){
        this.data = data;
    }

    Object get(){
        return data;
    }

    void setNextPtr(Node next){
        this.node = next;
    }

    Node getNextPtr(){
        return node;
    }

    public String toString(){
        return data.toString();
    }
}
