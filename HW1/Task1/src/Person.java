public class Person {
    private final String Name;
    private String patronymic;
    private int birthyear;
    private int deathyear;

    sex pol;

    public Person(String Name, String patronymic, sex pol,  int birthyear, int deathyear) {
        this.Name = Name;
        this.patronymic = patronymic;
        this.pol = pol;
        this.birthyear = birthyear;
        this.deathyear =deathyear;

    }

    public int getDeathyear() {
        return deathyear;
    }

    public Person (String Name, String patronymic, sex pol, int birthyear){
        this.Name = Name;
        this.patronymic = patronymic;
        this.pol = pol;
        this.birthyear = birthyear;
    }

    public String getName() {
        return Name;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public enum sex {
        male,
        female
    }

    public String getFullName() {
        return Name + " " + patronymic;
    }

    @Override
    public String toString() {
        if (this.deathyear ==0){
            return this.getFullName() + " " +  this.birthyear + " г.р." ;
        }
        else {
            return this.getFullName() + " " + this.birthyear + " - " + this.deathyear;
        }
    }
}
