import java.io.*;
import java.util.Scanner;
public class RPNCalculator2 {
    private ArrayStack<Double> T = new ArrayStack<>();
    private Scanner f;
    private Scanner express; //Expression
    private String temp; //Next type in Scanner Expression
    private double x; //first number (right)
    private double y; //second number (left)

    public static void main(String[] args) {
        RPNCalculator2 rpn = new RPNCalculator2();
        rpn.begin();
    }

    private void begin() {
        try {
            f = new Scanner(new File("expressions.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        f.nextLine();
        while (f.hasNextLine()) {
            express = new Scanner(f.nextLine());
            while (express.hasNext()) {
                if (express.hasNextDouble()) {
                    T.push(express.nextDouble());
                }
                else {
                    temp = express.next();
                    if (T.size() >= 2) {
                        try {
                            y = T.pop();
                            x = T.pop();
                        }
                        catch (IllegalStateException e){
                            e.printStackTrace();
                        }

                        switch (temp) {
                            case "+":
                                T.push(x + y);
                                break;
                            case "-":
                                T.push(x - y);
                                break;
                            case "*":
                                T.push(x * y);
                                break;
                            case "/":
                                T.push(x / y);
                                break;
                        }
                    }
                    else
                        T.clear();
                }
            }
            if (T.isEmpty())
                System.out.println("Invalid");
            else {
                System.out.println(T.peek());
                T.clear();
            }
        }
    }
}
