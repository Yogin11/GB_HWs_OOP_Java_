
public class ConsolPrint {
//    String data;
    GeoTree tree;
    Research research;

    public ConsolPrint(GeoTree tree) {
        this.tree = tree;
        research = new Research(tree);
    }
    public void resultsPrint (String request, Person stunt){
        switch (request) {
            case "племянники":
                System.out.printf("Поиск племянников для %s :", stunt);
                System.out.println(research.searchSiblingsRelatives(stunt, request));
                break;
            case "сестры":
            case "братья":
                System.out.printf("Поиск сестер/братьев для %s :", stunt);
                System.out.println(research.searchSiblingsRelatives(stunt, request));
                break;
            case "дяди":
            case "тети":
                System.out.printf("Поиск дядей/тётей для %s :", stunt);
                System.out.println(research.searchSiblingsRelatives(stunt, request));
                break;
            case "потомки":
                System.out.println("Прямые потомки для " + stunt + ":");
                System.out.println(research.searchUpDown(stunt,Relat.parent,0));
                break;
            case "предшественники":
                System.out.println("Прямые предшественники для " + stunt + ":");
                System.out.println(research.searchUpDown(stunt,Relat.child,0));
                break;
        }
    }
    public void resultsPrint(String some, int year){
        if (some.equals("умершие")) {
            System.out.println("Умершие родственники: " + research.deadRelatives());
            System.out.println();
        }
        if (some.equals("родились до")) {
            System.out.printf("Родившиеся ранее %d года: %s",year,research.bornYear(year, '<'));
            System.out.println();
        }
        if (some.equals("родились после")) {
            System.out.printf("Родившиеся ранее %d года: %s",year,research.bornYear(year, '>'));
            System.out.println();
        }
    }
    public void viewAll (){
        for (Node str: tree.getTree()) {
            System.out.println(str);
        }
    }
}
