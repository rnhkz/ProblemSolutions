import java.io.*;
import java.util.Scanner;
public class Railroad {
    private ArrayStack<Integer> AStack = new ArrayStack<>(); //Right of Station (Represents initial cart order)
    private ArrayStack<Integer> BStack = new ArrayStack<>(); //Left of Station (Represents expected cart order)
    private ArrayStack<Integer> station = new ArrayStack<>(); //Station
    private Scanner f;
    private Scanner express; //Expression
    private int trainSize; //Size of train

    public static void main(String[] args) {
        Railroad rail = new Railroad();
        rail.begin();
    }

    private void begin() {
        try {
            f = new Scanner(new File("railroad.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (f.hasNextLine()) {
            express = new Scanner(f.nextLine());
            while (express.hasNextInt())
                AStack.push(express.nextInt());
            if (AStack.size() == 1) {
                trainSize = AStack.pop();
                if (trainSize == 0)
                    System.out.println("");
            }
            else {
                for (int x = 0; x < trainSize; x++)
                    BStack.push(x+1);
                if (canMarshal())
                    System.out.println("Yes");
                else
                    System.out.println("No");
                stacksReset();
            }
        }
    }

    private boolean canMarshal() {
        while (!BStack.isEmpty()) {
            if (station.isEmpty())
                station.push(AStack.pop());
            if (station.peek() == BStack.peek()) {
                station.pop();
                BStack.pop();
            }
            else if (AStack.size() > 0)
                station.push(AStack.pop());
            else
                return false;
        }
        return true;
    }

    private void stacksReset() {
        station.clear();
        AStack.clear();
        BStack.clear();
    }
}
