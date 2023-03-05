public class Main {

    public static void main(String[] args) {

        Human ironman = new Human("Tony Stark");

        Cat bobik = new Cat("Джарвис","серый","безпородный");
        System.out.println(bobik.type + " " + bobik.getNickname() + " " + bobik.breed + " " + bobik.color);

        String call = ironman.callPet(bobik);
        bobik.listenAndReact(call);
        call = ironman.call();
        bobik.listenAndReact(call);
    }
}