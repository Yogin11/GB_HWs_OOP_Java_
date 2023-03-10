import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Research {

    HashSet<String> result0 = new HashSet<>();
    ArrayList<String> result1 = new ArrayList<>();
    HashMap<Integer,String> levelRel;
    HashMap<String,String> relDict;
    ArrayList<Node> tree;

    public Research(GeoTree geoTree) {
        this.tree = geoTree.getTree();
        this.levelRel = geoTree.levelRel;
        this.relDict = geoTree.relDict;
    }

    public HashSet<String> findParChild(Person p, Relationship re) {
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(re)) {
                result0.add(nod.p2.getFullName());
            }
        }
        return result0;
    }

    public ArrayList<String> searchUpDown(Person p, Relationship re, int n) {
        boolean bol = false;
        if (re.equals(Relationship.parent)) {
            n--;
        } else n++;
        ArrayList<Person> arrPerRelated = new ArrayList<>();
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(re)) {
                bol = result1.add(nod.p2.getFullName() + " " + relDict.get(levelRel.get(n) + nod.p2.pol.toString()));
                arrPerRelated.add(nod.p2);
            }
        }
        if (bol) {
            for (Person pr : arrPerRelated) {
                return searchUpDown(pr, re, n);
            }
        }
            return result1;
    }
    public HashSet<String> bornYear(int year, char symb){
        HashSet <String> bYears = new HashSet<>();
        for (Node nod : tree) {
            if (symb == '<'){
                if (nod.p1.getBirthyear() < year) {
                    bYears.add(nod.p1.getFullName()+" " + nod.p1.getBirthyear());
                }
            }
            else
            if (nod.p1.getBirthyear() > year) {
                bYears.add(nod.p1.getFullName()+" " + nod.p1.getBirthyear());
            }
        }
        return bYears;

    }
    public HashSet<String> deadRelatives(){
        HashSet <String> set = new HashSet<>();
        for (Node nod : tree) {
            if (nod.p1.getDeathyear() >0){
                set.add(nod.p1.getFullName());
            }
        }
        return set;

    }
    public HashSet<String> searchSiblingsRelatives(Person p, String var) {
        boolean bol = false;
        ArrayList<Person> arrPerRelated = new ArrayList<>();
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(Relationship.child)) {
                bol = true;
                arrPerRelated.add(nod.p2);
            }
        }
        if (bol) {
            for (Person pr : arrPerRelated) {
                for (Node nod : tree) {
                    if (nod.p1.getFullName().equals(pr.getFullName()) && nod.re.equals(Relationship.parent) && !nod.p2.getFullName().equals(p.getFullName())) {
                        if (var.equals("????????????????????")){
                            findParChild(nod.p2,Relationship.parent);}
                        else if (var.equals("????????????") || var.equals("????????????")){
                            result0.add(nod.p2.getFullName());
                            }
                        else if (var.equals("????????") || var.equals("????????")){
                           return searchSiblingsRelatives(nod.p1,"????????????");
                        }
                    }
                }
            }
        }
        return result0;
    }
}
