import java.io.*;
import java.util.Scanner;
public class IMDb {
    private LinkedList movies = new LinkedList();
    private LinkedList actors = new LinkedList();
    private Scanner f;
    boolean isLast = false;

    public static void main(String args[]){
        IMDb list = new IMDb();
        list.begin2();
    }

    private void begin2() {
        setActors();
        setMovies();
        Node a = actors.get(0);
        while(a.get() != null && !isLast){
            Actor curActor = (Actor) a.get();
            System.out.println(curActor.getName());
            Node m = movies.get(0);
            while(m.get() != null && !isLast) {
                Movie curMovie = (Movie) m.get();
                LinkedList aList = curMovie.getActors();
                Node aFromList = aList.get(0);
                while(aFromList.get() != null && !isLast) {
                    Actor y = (Actor) aFromList.get();
                    if (curActor.getName().equals(y.getName())) {
                        System.out.println(curMovie.getDate() + " " + curMovie.getTitle());
                    }
                    if(aFromList.getNextPtr() != null)
                        aFromList = aFromList.getNextPtr();
                    else
                        isLast = true;
                }
                isLast = false;
                if(m.getNextPtr() != null)
                    m = m.getNextPtr();
                else
                    isLast = true;
            }
            isLast = false;
            if(a.getNextPtr() != null)
                a = a.getNextPtr();
            else
                isLast = true;
            System.out.println("----------");
        }
    }

    private void setF(String s){
        try {
            f = new Scanner(new File(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setActors(){
        setF("actors.txt");
        while(f.hasNextLine()) {
            String name = f.nextLine();
            int x = name.length();
            while (name.substring(x - 1, x).equals(" ")) {
                name = name.substring(0, x-1);
                x--;
            }
            actors.add(new Actor(name));
        }
    }

    private void setMovies(){
        setF("movies.txt");
        int count = 0;
        while(f.hasNextLine()) {
            int x = 0;
            String temp = "";
            LinkedList a = new LinkedList();
            LinkedList d = new LinkedList();
            String express = f.nextLine();
            int date = Integer.parseInt(express.substring(0, express.indexOf(" ")));
            String title = express.substring(5, express.indexOf("  "));
            express = express.substring(37);
            while(!express.substring(x,x+2).equals("  ") &&
                    !express.substring(x,x+4).equals("Dir:")) {
                x++;
                temp = "";
                while(!express.substring(x,x+2).equals(", ") &&
                        !express.substring(x,x+2).equals("  ") &&
                        !express.substring(x,x+4).equals("Dir:")) {
                    temp += express.substring(x, x + 1);
                    x++;
                }
                if(temp.substring(0,1).equals(" "))
                    temp = temp.substring(1);
                a.add(new Actor(temp));
            }
            temp = "";
            x = 0;
            express = express.substring(express.indexOf(":")+2);
            while(x+2 < express.length()) {
                while(!express.substring(x,x+2).equals(", ") && x+2 < express.length()) {
                    temp += express.substring(x, x + 1);
                    x++;
                }
                d.add(new Actor(temp));
                x++;
                temp = "";
            }
            movies.add(new Movie(date, title, a, d));
            //System.out.println(movies.get(count).toString());
            count++;
        }
    }
}