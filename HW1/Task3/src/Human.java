public class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }

    public String callPet(Cat cat) {
        System.out.println(this.name + " зовет: Иди сюда, " + cat);
        return "  -  Иди сюда" + cat;
    }

    public String call() {
        System.out.println(this.name + " зовет: Иди сюда, Киса");
        return " -  Иди сюда Киса";
    }

    public void feedingCat(Cat cat) {
        System.out.println(this.name + " положил еды " + cat);
        cat.gotFed();
    }
    public void shoutAtCat (Cat cat){
        System.out.println(this.name + ": Ты чего опять творишь!!! Пошел вон!! ");
    }

    public void pettingCat(Cat cat) {
        System.out.println(this.name + " пытается погладить " + cat);
        cat.gotPetted(this);
    }
}
