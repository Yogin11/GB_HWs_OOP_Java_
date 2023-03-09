import java.util.ArrayList;
import java.util.HashMap;


public class GeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();
    public HashMap<String,String> relDict= new HashMap<>();
    public HashMap<Integer,String> levelRel= new HashMap<>();
    public ArrayList<Node> getTree() {
        return tree;
    }

    public GeoTree() {
        relDictFill(relDict);
        levelsRelFill(levelRel);
    }

    public void appendRelations(Person firstPer, Relationship relTo, Person secondPer) {


        if (relTo.equals(Relationship.parent)) {
            tree.add(new Node(firstPer, Relationship.parent, secondPer));
            tree.add(new Node(secondPer, Relationship.child, firstPer));
        }
        if (relTo.equals(Relationship.child)) {
            tree.add(new Node(firstPer, Relationship.child, secondPer));
            tree.add(new Node(secondPer, Relationship.parent, firstPer));
        }
        if (relTo.equals(Relationship.sibling)) {
            tree.add(new Node(firstPer, Relationship.sibling, secondPer));
            tree.add(new Node(secondPer, Relationship.sibling, firstPer));
        }
    }
    public void relDictFill(HashMap <String,String> relDict) {
        relDict.put("siblingmale","брат");
        relDict.put("siblingfemale","сестра");
        relDict.put("parentfemale","мать");
        relDict.put("parentmale","отец");
        relDict.put("childmale","сын");
        relDict.put("childfemale","дочь");
        relDict.put("grandchildfemale","внучка");
        relDict.put("grandchildmale","внук");
        relDict.put("grandparentfemale","бабушка");
        relDict.put("grandparentmale","дедушка");
        relDict.put("greatgrandparentfemale","прабабушка");
        relDict.put("greatgrandparentmale","прадедушка");
        relDict.put("greatgrandchildfemale","правнучка");
        relDict.put("greatgrandchildmale","правнук");

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
