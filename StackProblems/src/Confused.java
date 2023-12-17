import java.io.*;
import java.util.Scanner;
public class Confused {
    private ArrayStack<String> T = new ArrayStack<>();
    private Scanner f;
    private String express; //Expression
    private String temp; //String popped
    //private int x; //counts parenthesis
    //private int y; //counts brackets
    private String previousType; //Tracks the previously used String (parenthesis or bracket, z = reset)

    public static void main(String[] args) {
        Confused con = new Confused();
        con.begin();
    }

    private void begin() {
        try {
            f = new Scanner(new File("Additional Sample Data-1.in"));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        f.nextLine();
        boolean fail;
        while (f.hasNextLine()) {
            express = f.nextLine();
            fail = false;
            for (int x = express.length(); x > 0; x--)
                T.push(express.substring(x-1, x));
            if (isBalanced(0, 0))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private boolean isBalanced(int x, int y) {
        while (!T.isEmpty()) {
            temp = T.pop();
            switch (temp) {
                case "(":
                    x++;
                    previousType = "x";
                    break;
                case ")":
                    if (previousType.equals("x") || previousType.equals("z")) {
                        x--;
                        previousType = "z";
                    }
                    else
                        return false;
                    break;
                case "[":
                    y++;
                    previousType = "y";
                    break;
                case "]":
                    if (previousType.equals("y") || previousType.equals("z")) {
                        y--;
                        previousType = "z";
                    }
                    else
                        return false;
                    break;
            }
            if(x < 0 || y < 0)
                return false;
        }
        return true;
    }
}