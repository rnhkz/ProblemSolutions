import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ChildsPlay {
    private boolean[][] Graph;
    public static void main(String[] args) {
        ChildsPlay c = new ChildsPlay();
        c.begin();
    }
    public void begin() {
        try {
            Scanner f = new Scanner(new File("Test.txt"));
            int cases = f.nextInt();
            f.nextLine();
            for (int x = 0; x < cases; x++) {
                int n = f.nextInt();
                Graph = new boolean[n][n];
                int m = f.nextInt();
                int l = f.nextInt();
                f.nextLine();
                for (int y = 0; y < m; y++) {
                    Graph[f.nextInt()-1][f.nextInt()-1] = true;
                    f.nextLine();
                }
                boolean[] knocked = new boolean[n];
                for(int z = 0; z < l; z++) {
                    int domino = f.nextInt()-1;
                    knocked[domino]=true;
                    traverse(Graph[domino], knocked);
                    if(f.hasNextLine())
                        f.nextLine();
                }
                System.out.println(size(knocked));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void traverse(boolean[] domino, boolean[] knocked) {
        for (int x = 0; x < domino.length; x++)
            if (!knocked[x] && domino[x]) {
                knocked[x] = true;
                traverse(Graph[x], knocked);
            }
    }
    private int size(boolean[] knocked){
        int total = 0;
        for(boolean b : knocked)
            if(b)
                total++;
        return total;
    }
}