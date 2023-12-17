import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrettyPrint {
    private Scanner f;

    public static void main(String[] args){
        PrettyPrint p = new PrettyPrint();
        p.begin();
    }

    private void begin(){
        try{
            f = new Scanner(new File("pretty.dat"));
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
            root.printPretty(root);
            System.out.println();
            System.out.print("In Order: ");
            root.printInOrder(root);
            System.out.println();
        }
    }
}