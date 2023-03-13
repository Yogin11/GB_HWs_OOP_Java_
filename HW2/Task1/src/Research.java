import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Research implements BornAndDead{
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

    public HashSet<String> findParChild(Human p, Relat re) {
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(re)) {
                result0.add(nod.p2.getFullName());
            }
        }
        return result0;
    }

    public ArrayList<String> searchUpDown(Human p, Relat re, int n) {
        boolean bol = false;
        if (re.equals(Relat.parent)) {
            n--;
        } else n++;
        ArrayList<Human> arrPerRelated = new ArrayList<>();
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(re)) {
                bol = result1.add(nod.p2.getFullName() + " " + relDict.getOrDefault(levelRel.get(n) + nod.p2.getPol(), "родственник"));
                arrPerRelated.add(nod.p2);
            }
        }
        if (bol) {
            for (Human pr : arrPerRelated) {
                searchUpDown(pr, re, n);
            }
            return result1;
        }
        // else return;
            return result1;
    }
    @Override
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
    public HashSet<String> searchSiblingsRelatives(Human p, String var) {
        boolean bol = false;
        ArrayList<Human> arrPerRelated = new ArrayList<>();
        for (Node nod : tree) {
            if (nod.p1.getFullName().equals(p.getFullName()) && nod.re.equals(Relat.child)) {
                bol = true;
                arrPerRelated.add(nod.p2);
            }
        }
        if (bol) {
            for (Human pr : arrPerRelated) {
                for (Node nod : tree) {
                    if (nod.p1.getFullName().equals(pr.getFullName()) && nod.re.equals(Relat.parent) && !nod.p2.getFullName().equals(p.getFullName())) {
                        if (var.equals("племянники")){
                            findParChild(nod.p2,Relat.parent);}
                        else if (var.equals("братья") || var.equals("сестры")){
                            result0.add(nod.p2.getFullName());
                            }
                        else if (var.equals("дяди") || var.equals("тети")){
                           return searchSiblingsRelatives(nod.p1,"братья");
                        }
                    }
                }
            }
        }
        return result0;
    }

    @Override
    public HashSet<String> deadRelatives(){
        HashSet <String> set = new HashSet<>();
        for (Node nod : tree) {
            if (nod.p1.getDeathyear() >0){
                set.add(nod.p1.getFullName());
            }
        }
        return set;
    }
}
