public class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }

    public String callPet(Pet pet) {
        System.out.println(this.name + " зовет: Иди сюда, " + pet);
        return "  -  Иди сюда" + pet;
    }

    public String call() {
        System.out.println(this.name + " зовет: Иди сюда, озорник");
        return " -  Иди сюда озорник";
    }

    public void feedingPet(Pet pet) {
        System.out.println(this.name + " положил еды " + pet);
        pet.gotFed();
    }
    public void shoutAtPet (Pet pet){
        System.out.println(this.name + ": Ты чего опять творишь!!! Пошел вон!! ");
    }

    public void pettingPet(Pet pet) {
        System.out.println(this.name + " пытается погладить " + pet);
        if (Pettable.class.isAssignableFrom(pet.getClass())) {
            ((Pettable) pet).gotPetted(this);
        }
    }
}
