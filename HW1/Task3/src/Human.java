public class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }
    public String callPet(Cat cat){
        System.out.println(this.name + " зовет: Иди сюда, " + cat);
        return " Иди сюда" + cat;
    }
    public String call() {
        System.out.println(this.name + " зовет: Иди сюда, Киса");
        return " Иди сюда Киса";
    }

    }
