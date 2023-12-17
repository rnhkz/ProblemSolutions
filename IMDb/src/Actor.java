public class Actor {
    private String name;

    Actor(){
        name = null;
    }

    Actor(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }

    public String toString(){
        return getName();
    }
}
