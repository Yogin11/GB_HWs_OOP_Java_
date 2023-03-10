

public class Person extends Human{

      public Person(String Name, String patronymic, sex pol , int birthyear, int deathyear){
        super(Name, patronymic, pol, birthyear,deathyear );
    }


    @Override
    public String toString() {
        if (this.getDeathyear() ==0){
            return this.getFullName() + " " + this.getBirthyear() + " г.р." ;
        }
        else {
            return this.getFullName() + " " + this.getBirthyear() + " - " + this.getDeathyear();
        }
    }
}
