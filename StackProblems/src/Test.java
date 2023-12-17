public class Test {
    public static void main(String[] args) {
        ArrayStack a = new ArrayStack();
        a.push(2.2);
        a.push(4.4);
        System.out.println(a.toString());
        a.pop();
        System.out.println(a.toString());
    }
}
