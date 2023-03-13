public class Perrot extends Pet implements Flyable, Voicable {

    public Perrot(String nickname, String color, String breed) {
        super(nickname, color, breed);
           type = "Попугай";
        
    }
    public void voice() {
        System.out.println(this.getNickname() + " говорит и чирикает ");
    }

    public void fly() {
        System.out.println(getNickname() + " летает");
    }
    
    @Override
    public String toString() {
        return getNickname();
    }
    @Override
    public void beNaughty(Human man) {
        System.out.println(getNickname() + " громко шумит ");
        fly();
        voice();
    }
}   
