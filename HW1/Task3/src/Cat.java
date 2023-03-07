import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat extends Pet {
    private String nickname;
    String color;
    String breed;
    HashMap<String, Boolean> status;

    String[] statusArr;


    public Cat(String nickname, String color, String breed) {
        super("Кот");
        statusArr = new String[]{"голодный","ласковый","игривый","спокойный"};
        status = new HashMap<>();
        this.nickname = nickname;
        this.color = color;
        this.breed = breed;
        this.randomStatus();
    }
    public String getNickname() {
        return nickname;
    }
    public void showStatus() {
        System.out.print("Сейчас " + this.nickname + ": ");
        for (Map.Entry<String, Boolean> st : status.entrySet()) {
            if (st.getValue())
                System.out.printf(" /%s ",st.getKey());
            else
                System.out.printf(" /не %s  ",st.getKey());
        }
        System.out.println();
    }

    public void randomStatus(){
            Random rand = new Random();
            Boolean bol = true;
        for (String st: statusArr) {
            int rint = rand.nextInt(2);
            if (status.getOrDefault("голодный",rint ==1)){
                status.put(st, false);
            }
            else {
                status.put(st, rint == 1);
            }

        }

    }

    public void listenAndReact(String var){

        String findString = new String("\\.*" + this.nickname + "\\.*");
        Pattern patt = Pattern.compile(findString);
        Matcher match = patt.matcher(var);
        if (match.find()) {
            System.out.println(this.nickname + " отзывается 'Ммммаау' ");
//
        }
        else if (status.get("голодный") || !match.find()) {

            System.out.println(this.nickname + " не услышал имени, не реагирует....");
//
        }
    }
    public void gotPetted(Human man){
        if (status.get("ласковый")) {
            System.out.println(this.nickname +  " запрыгивает на колени к " + man.name + ", топчется, урчит ");
            status.put("ласковый", false);
            status.put("спокойный", true);

        }
        else {
            System.out.println(this.nickname + " огрызается, пытается укусить, заигрывает ");
            status.put("игривый", true);
        }
    }
    public void gotFed(){
        if (status.get("голодный")) {
            System.out.println(this.nickname + " наелся, теперь он спокоен ");

            status.put("голодный", false);
            status.put("спокойный", true);
        }
        else{
            System.out.println(this.nickname + " подошел к еде, понюхал и ушел");
        }
    }
    public void tearUpSofa(Human man){
        System.out.println(this.nickname + " вскочил на диван и начал драть его когтями ");
        man.shoutAtCat(this);
        System.out.println(this.nickname + " резко спрыгивает и убегает виляя хвостом");
        status.put("игривый", false);
        status.put("голодный", true);
        status.put("спокойный", false);
    }
    public void requestAtt(Human man){
        status.put("ласковый", true);
        System.out.println(this.nickname + " ходит кругами, требует внимания и ласки ");
        man.pettingCat(this);

    }
    public void isHungry (Human man){
        status.put("голодный", true);
        System.out.println(this.nickname + " громко мяукает!! Искренне смотрит в глаза, просит есть");
        man.feedingCat(this);
    }

    public void playMood(){
        System.out.println(this.nickname + " бегает, прячется за углом, наскакивает из засады и сразу убегает");
        status.put("игривый", false);
    }

    @Override
    public String toString() {
        return getNickname();
    }
}
