import java.util.ArrayList;
import java.util.HashMap;


public abstract class GeoTree implements Appendable {
    private final ArrayList<Node> tree = new ArrayList<>();
    public HashMap<String,String> relDict= new HashMap<>();
    public HashMap<Integer,String> levelRel= new HashMap<>();

    public GeoTree() {
       levelsRelFill(levelRel);
    }

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void appendRelations(Human firstPer, Human secondPer, Relat relDirect, Relat relOpposite) {
        tree.add(new Node(firstPer, relDirect, secondPer));
        tree.add(new Node(secondPer, relOpposite, firstPer));
    }

    public void appendRelationsPlusRole(Human firstPer, Human secondPer, Relat relDirect, Relat relOpposite, String role1, String role2) {
        appendRelations(firstPer,secondPer,relDirect, relOpposite);
        relDict.put(relDirect.toString() + firstPer.getPol(), role1);
        relDict.put(relOpposite.toString() + secondPer.getPol(), role2);
//        System.out.println( relDict);
    }

    public void levelsRelFill(HashMap <Integer,String> levelRel) {
        levelRel.put(-3, "greatgrandchild");
        levelRel.put(-2, "grandchild");
        levelRel.put(-1, "child");
        levelRel.put(1, "parent");
        levelRel.put(2, "grandparent");
        levelRel.put(3, "greatgrandparent");
    }


}
