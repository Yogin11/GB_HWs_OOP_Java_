public class Main {

    public static void main(String[] args) {

        Person klava= new Person("Клавдия", "Федоровна", Person.sex.female,1915, 2005);
        Person vasya= new Person("Василий", "Яковлевич", Person.sex.male,1910,1971);

        Person ivan = new Person("Иван", "Васильевич", Person.sex.male,1934,2008);
        Person valya = new Person("Валентина","Владимировна", Person.sex.female,1937);
        Person alex = new Person("Александр","Иванович", Person.sex.male,1965);
//        Person igor = new Person("Игорь","Сергеевич", Person.sex.male,1970);
        Person lena = new Person("Елена","Ивановна", Person.sex.female,1972 );
        Person ilya = new Person("Илья","Игоревич", Person.sex.male,1987 );
        Person denis = new Person("Денис","Игоревич", Person.sex.male,1991 );
        Person pavel = new Person("Павел","Иванович", Person.sex.male,1962,1978 );

        GeoTree gt = new GeoTree();

        gt.appendRelations(vasya,Relationship.parent,ivan);
        gt.appendRelations(klava,Relationship.parent,ivan);
        gt.appendRelations(ivan,Relationship.parent,lena);
        gt.appendRelations(ivan,Relationship.parent,alex);
        gt.appendRelations(valya,Relationship.parent,lena);
        gt.appendRelations(valya,Relationship.parent,alex);
//        gt.appendRelations(alex,Relationship.sibling,lena);
        gt.appendRelations(lena,Relationship.parent,ilya);
        gt.appendRelations(lena,Relationship.parent,denis);
        gt.appendRelations(pavel,Relationship.child,ivan);

        ConsolPrint printOut = new ConsolPrint(gt);
        System.out.println();

        printOut.resultsPrint("племянники", alex);
        printOut.resultsPrint("братья", lena);
        printOut.resultsPrint("дяди", denis);
        printOut.resultsPrint("братья", denis);
        printOut.resultsPrint("умершие",0);
        printOut.resultsPrint("родились до",1941);
        printOut.resultsPrint("родились после",1980);
        printOut.resultsPrint("потомки",klava);
        printOut.resultsPrint("предшественники",denis);
//        printOut.viewAll();               //показать все узлы дерева
    }
}
