public class Main {

    public static void main(String[] args) {

        Person klava= new Person("Клавдия", "Федоровна", Person.sex.female,1915, 2005);
        Person vasya= new Person("Василий", "Яковлевич", Person.sex.male,1910,1971);

        Person ivan = new Person("Иван", "Васильевич", Person.sex.male,1934,2008);
        Person valya = new Person("Валентина","Владимировна", Person.sex.female,1937,0 );
        Person alex = new Person("Александр","Иванович", Person.sex.male,1965,0 );
        Person igor = new Person("Игорь","Сергеевич", Person.sex.male,1970, 0);
        Person lena = new Person("Елена","Ивановна", Person.sex.female,1972,0  );
        Person ilya = new Person("Илья","Игоревич", Person.sex.male,1987,0  );
        Person denis = new Person("Денис","Игоревич", Person.sex.male,1991,0 );
        Person pavel = new Person("Павел","Иванович", Person.sex.male,1962,1978 );

        Tree1 tree = new Tree1();


        tree.appendRelationsPlusType(vasya,ivan, Relat.parent,Relat.child, "отец","сын");
        tree.appendRelations(klava,ivan, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(klava,alex, Relat.grandparent,Relat.grandchild, "бабушка","внук");
        tree.appendRelations(ivan,alex, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(valya,alex, Relat.parent,Relat.child, "мать","сын" );
        tree.appendRelationsPlusType(ivan,lena, Relat.parent,Relat.child, "отец", "дочь");
        tree.appendRelations(valya,lena, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(lena,ilya, Relat.parent,Relat.child, "мать","сын" );
        tree.appendRelations(lena,denis, Relat.parent,Relat.child );
        tree.appendRelations(ivan,pavel, Relat.parent,Relat.child );
        tree.appendRelations(valya,pavel, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(igor,valya, Relat.soninlaw,Relat.motherinlaw, "зять","теща" );


        ConsolPrint printOut = new ConsolPrint(tree);
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
