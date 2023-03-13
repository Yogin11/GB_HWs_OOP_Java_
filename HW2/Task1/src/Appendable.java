public interface Appendable {

    public void appendRelations(Human p1, Human p2, Relat relDirect, Relat relOpposite);

    public void appendRelationsPlusType(Human p1, Human p2, Relat relDirect, Relat relOpposite,String role1, String role2);
}
