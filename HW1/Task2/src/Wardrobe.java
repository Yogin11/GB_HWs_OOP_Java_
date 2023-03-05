import java.util.ArrayList;

public class Wardrobe {

    public String position;
    public String status;
    public static  int amount;
    private static  ArrayList<String> wardrContents = new ArrayList<>();

    private boolean closed;
    public Wardrobe(String position) {
        this.position = position;
        this.closed = true;
        this.status = "Закрыт";
    }
    public boolean getStatus() {
        return this.closed;
    }
    public void openWard(){
        this.status = "Открыт";
        this.closed = false;
//        return !this.closed;
    }
    public void closeWard() {
        this.status = "Закрыт";
        this.closed = true;
    }
    public void acceptContents(String thing ){
        if (!this.closed) {
            wardrContents.add(thing);
            amount++;
        }
    }
    public ArrayList<String> getWardContents() {
        return wardrContents;

    }
    public void leaveContents(String thing){
            wardrContents.remove(thing);
            amount--;
    }

    @Override
    public String toString() {
        return String.format("%s ", this.status);
    }
}
