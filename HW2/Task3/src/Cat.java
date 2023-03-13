
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Cat extends Pet implements Pettable,Voicable {
            
    public Cat(String nickname, String color, String breed) {
        super(nickname, color, breed);
        type = "Кот";
        statusArr.add("ласковый");
        statusArr.add("игривый");
        randomStatus();
    }
   
    public void listenAndReact(String var) {
        String findString = new String("\\.*" + getNickname() + "\\.*");
        Pattern patt = Pattern.compile(findString);
        Matcher match = patt.matcher(var);
        if (match.find()) {
            System.out.println(getNickname() + " отзывается 'Ммммаау' ");
        } else if (status.get("голодный") || !match.find()) {
            System.out.println(getNickname() + " не услышал имени, не реагирует....");
        }
    }
    
    @Override
    public void gotPetted(Human man){
        if (status.get("ласковый")) {
            System.out.println(getNickname() + " запрыгивает на колени к " + man.name + ", топчется, урчит ");
            this.voice();
            status.put("ласковый", false);
            status.put("спокойный", true);
        }
        else {
            System.out.println(getNickname() + " огрызается, пытается укусить, заигрывает ");
            status.put("игривый", true);
        }
    }
 
    public void requestAtt(Human man) {
        status.put("ласковый", true);
        System.out.println(getNickname() + " требует внимания");
        man.pettingPet(this); /// TODO Auto-generated constructor StringBuilder 
    }

    public void voice() {
        System.out.println(getNickname() + " мяукает");
    }
    
    @Override
    public void beNaughty(Human man) {
        System.out.println(getNickname() + " вскочил на диван и начал драть его когтями ");
        man.shoutAtPet(this);
        System.out.println(getNickname() + " резко спрыгивает и убегает виляя хвостом");
        status.put("игривый", false);
        status.put("голодный", true);
        status.put("спокойный", false);
    }
      
    @Override
    public String toString() {
        return getNickname();
    }
}
