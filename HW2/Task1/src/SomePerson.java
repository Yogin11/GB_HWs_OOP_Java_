public class SomePerson extends Human{
    public SomePerson(String Name, sex pol, int birthyear) {
        super(Name, pol, birthyear);
    }

    @Override
    public String getFullName() {
        return getName();
    }


    @Override
    public String toString() {
        
            return this.getFullName();
        
    }

}
