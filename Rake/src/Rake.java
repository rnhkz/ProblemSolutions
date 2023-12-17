import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rake {
    private Scanner f;

    public static void main(String[] args){
        Rake r = new Rake();
        r.begin();
    }

    private void begin(){
        try{
            f = new Scanner(new File("rake.dat"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while(f.hasNextLine()){
            Scanner data = new Scanner(f.nextLine());
            TreeNode root = new TreeNode(data.nextInt());
            while(data.hasNextInt()){
                root.add(data.nextInt(), root);
            }
            root.print(root);
            System.out.println();
        }
    }
}
