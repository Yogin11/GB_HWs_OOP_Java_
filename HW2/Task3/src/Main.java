public class Main {

    public static void main(String[] args) {

        Human ironman = new Human("Tony Stark");
        Pet jarvis = new Cat("Барсик", "серый", "беcпородный");
        printIntro(jarvis);
        // Pet kesha = new Perrot("Кеша", "зеленый", "волнистый");
        // printIntro(kesha);
        
        Menu menu = new Menu();
        menu.choiceMenu(jarvis, ironman);
        // menu.choiceMenu(kesha, ironman);

    }
    public static void printIntro(Pet pet) {
        System.out.println(pet.type + " " + pet.getNickname() + " " + pet.breed + " " + pet.color);
    }
}