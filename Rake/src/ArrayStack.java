class ArrayStack<T> implements IStack<T>{
    private int maxSize;
    private int size;
    private T[] arr;

    ArrayStack() {
        maxSize = 128;
        size = 0;
        arr = (T[])(new Object[maxSize]);
    }

    public void push(T value){
        if (isFull())
            System.out.println("FULL");
        else {
            arr[size] = value;
            size++;
        }
    }

    public T pop(){
        if (isEmpty()) {
            System.out.println("EMPTY");
            return null;
        }
        else {
            size--;
            return arr[size];
        }
    }

    public T peek() { return arr[size-1]; }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size <= 0)
            return true;
        return false;
    }

    public boolean isFull(){
        if(size >= maxSize)
            return true;
        return false;
    }

    public void clear(){
        size = 0;
    }

    public String toString(){
        String s = "";
        for(int x = 0; x < size; x++)
            s += arr[x] + " ";
        return s;
    }

    public String ArrayToString(){
        String s = "";
        for(int x = 0; x < maxSize; x++)
            s += arr[x] + " ";
        return s;
    }
}
