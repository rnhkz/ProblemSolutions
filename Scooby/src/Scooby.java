import java.io.*;
import java.util.Scanner;
public class Scooby {
    private boolean[][] Graph;
    private final String charKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        Scooby s = new Scooby();
        s.begin();
    }
    public void begin() {
        try {
            Scanner f = new Scanner(new File("Test.txt"));
            int cases = f.nextInt();
            f.nextLine();
            for (int x = 0; x < cases; x++) {
                Graph = new boolean[charKey.length()][charKey.length()];
                String s = f.nextLine();
                for (int y = 0; y < s.length(); y += 3) {
                    Graph[charKey.indexOf(s.charAt(y))][charKey.indexOf(s.charAt(y+1))] = true;
                    Graph[charKey.indexOf(s.charAt(y+1))][charKey.indexOf(s.charAt(y))] = true;
                }
                String command = f.nextLine();
                if(traverse(Graph[charKey.indexOf(command.charAt(0))], command.charAt(1), new boolean[26], false))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private boolean traverse(boolean[] room, char target, boolean[] entered, boolean found) {
        for (int x = 0; x < room.length; x++) {
            if (!entered[x] && room[x]) {
                entered[x] = true;
                if (x == charKey.indexOf(target))
                    found = true;
                found = traverse(Graph[x], target, entered, found);
            }
        } return found;
    }
}