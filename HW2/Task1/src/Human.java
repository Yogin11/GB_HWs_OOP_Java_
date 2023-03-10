public abstract class Human {
    private final String Name;
    private String patronymic;
    private int birthyear;
    private int deathyear;
    private sex pol;
    enum sex {
        male,
        female
    }
    public Human (String Name, String patronymic, sex pol, int birthyear, int deathyear) {
        this.Name = Name;
        this.patronymic = patronymic;
        this.pol = pol;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
    }

    public String getName() {
        return Name;
    }
    public String getFullName() {
        return this.Name + " " + this.patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getDeathyear() {
        return deathyear;
    }

    public sex getPol() {
        return pol;
    }

    public void setPol(sex pol) {
        this.pol = pol;
    }
}
