import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Pet implements Eatable, Playable {

  private String nickname;
  String color;
  String type;
  String breed;
  HashMap<String, Boolean> status;
  ArrayList<String> statusArr;

  public Pet(String nickname, String color, String breed) {

    status = new HashMap<>();
    statusArr = new ArrayList<>();
    statusArr.add("голодный");
    statusArr.add("спокойный");
    this.nickname = nickname;
    this.color = color;
    this.breed = breed;
    this.randomStatus();
  }

  public void randomStatus() {
    Random rand = new Random();
    for (String st : statusArr) {
      int rint = rand.nextInt(2);
      if (status.getOrDefault("голодный", rint == 1)) {
        status.put(st, false);
      } else {
        status.put(st, rint == 1);
      }
    }
  }
  
  public void showStatus() {
    System.out.print("Сейчас " + getNickname() + ": ");
    for (Map.Entry<String, Boolean> st : status.entrySet()) {
      if (st.getValue())
        System.out.printf(" /%s ", st.getKey());
      else
        System.out.printf(" /не %s  ", st.getKey());
    }
    System.out.println();
  }
  
  public void addStatus(String state, Boolean confirm) {
    statusArr.add(state);
    // status.put(state, confirm);
    randomStatus();

  }

  public void isHungry() {
    status.put("голодный", true);
    System.out.println(getNickname() + " просит есть");
  }

  public void listenAndReact(String var) {
    System.out.println(getNickname() + " услышал ");
  }

  public void beingFedBy(Human man) {         /// TODO Auto-generated constructor StringBuilder 
          man.feedingPet(this);
  }

  public void gotFed() {
    if (status.get("голодный")) {
      System.out.println(getNickname() + " наелся, теперь он спокоен ");
      status.put("голодный", false);
      status.put("спокойный", true);
    } else {
      System.out.println(getNickname() + "не стал есть, т.к. не голоден");
    }
  }

  public void playMood() {
    System.out.println(getNickname() + " играет");
    status.put("игривый", false);
  }

  public abstract void beNaughty(Human man); 

  public void requestAtt(Human man) {
    System.out.println(getNickname() + " пытается привлечь внимание ");
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }
 
}
