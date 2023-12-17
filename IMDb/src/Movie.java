public class Movie {
    private int date;
    private String title;
    private LinkedList actors;
    private LinkedList directors;

    Movie(){
        date = 0;
        title = null;
        actors = null;
        directors = null;
    }

    Movie(int date, String title, LinkedList actors, LinkedList directors){
        this.date = date;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }

    int getDate(){
        return date;
    }

    void setDate(int date){
        this.date = date;
    }

    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    LinkedList getActors(){
        return actors;
    }

    void setActors(LinkedList actors){
        this.actors = actors;
    }

    LinkedList getDirectors(){
        return directors;
    }

    void setDirectors(int actors){
        this.directors = directors;
    }

    public String toString(){
        String a = "";
        String d = "";
        for(int x = 0; x < actors.size()-1; x++){
            a+=actors.get(x).toString() + ",";
        }
        a+=actors.get(actors.size()).toString();
        for(int x = 0; x < directors.size()-1; x++){
            d+=directors.get(x).toString() + ",";
        }
        d+=actors.get(directors.size()).toString();
        return "Date: " + date +
            "\nTitle: " + title +
            "\nActors: " + a +
            "\nDirectors: " + d +
            "\n------------------";
    }
}
