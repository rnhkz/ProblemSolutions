import java.io.*;
import java.util.*;
public class RedMeat {
    private Scanner f;
    private List<int[]> s = new LinkedList<>();
    private int day;
    public static void main(String[] args){
        RedMeat r = new RedMeat();
        r.begin();
    }
    private void begin(){
        try{
            f = new Scanner(new File("goat.txt"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        f.nextLine(); //Test Case #
        int goats = f.nextInt();
        f.nextLine();
        for(int x = 0; x < goats /*# of goats*/ ;x++){
            Scanner dat = new Scanner(f.nextLine());
            int[] data = new int[dat.nextInt()];
            for(int y = 0; y < data.length; y++) //Builds data
                data[y] = dat.nextInt();
            s.add(data);
        }
        for(int x = 0; x < 90; x++) {
            s.sort(new sortByProduce());
            if(s.get(0)[day%s.get(0).length] < s.get(1)[day%s.get(1).length]){
                s.remove(0);
                x =-1;
            }
            day++;
        }
        System.out.println(s.size() + " " + (day - 90));
    }
    public class sortByProduce implements Comparator<int[]>{
        public int compare(int[] g1, int[] g2) {
            return g1[day%g1.length] - g2[day%g2.length];
        }
    }
}