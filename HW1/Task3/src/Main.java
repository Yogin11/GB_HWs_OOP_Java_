public class Main {

    public static void main(String[] args) {

        Human ironman = new Human("Tony Stark");
        Cat jarvis = new Cat("Барсик","серый","беcпородный");
        System.out.println(jarvis.type + " " + jarvis.getNickname() + " " + jarvis.breed + " " + jarvis.color);
        Menu menu = new Menu();
        menu.choiceMenu(jarvis, ironman);
    }
}