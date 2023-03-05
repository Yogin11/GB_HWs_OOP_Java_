import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat extends Pet {
    private String nickname;
    String color;
    String breed;

    public Cat(String nickname, String color, String breed) {
        super("Кот");
        this.nickname = nickname;
        this.color = color;
        this.breed = breed;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Cat(String nickname){
        super("Cat");
        this.nickname = nickname;
    }
    public void listenAndReact(String var){

        String findString = new String("\\.*" + this.nickname + "\\.*");
        Pattern patt = Pattern.compile(findString);
        Matcher match = patt.matcher(var);
        if (match.find()){
            System.out.println("Ммааауу");
        }
        else {
            System.out.println(this.nickname + " не услышала имени и убегает....");
        }
    }

    @Override
    public String toString() {
        return getNickname();
    }
}
