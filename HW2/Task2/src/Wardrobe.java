import java.util.ArrayList;

public class Wardrobe {

    public String position;
    public String status;
    public int amount;
    public ArrayList<String> wardrContents = new ArrayList<>();
    public boolean closed;

    public Wardrobe(String position) {
        this.position = position;
        this.closed = true;
        this.status = "Закрыт";
    }
    public boolean getStatus() {
        return this.closed;
    }
  
    @Override
    public String toString() {
        return String.format("%s ", this.status);
    }
}
