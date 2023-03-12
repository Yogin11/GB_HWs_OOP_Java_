public class Main {

    public static void main(String[] args) {

        Human babanna= new Person2("Анна", "Александровна", Human.sex.female,1928, 2022);
        Human sasha= new Person2("Александр", "Васильевич", Human.sex.male,1944,2014);

        Human klava= new Person("Клавдия", "Федоровна", Human.sex.female,1915, 2005);
        Human vasya= new Person("Василий", "Яковлевич", Human.sex.male,1910,1971);
        Human ivan = new Person("Иван", "Васильевич", Human.sex.male,1934,2008);
        Human valya = new Person("Валентина","Владимировна", Human.sex.female,1937,0 );
        Human alex = new Person("Александр","Иванович", Human.sex.male,1965,0 );
        Human igor = new Person("Игорь","Сергеевич", Human.sex.male,1970, 0);
        Human lena = new Person("Елена","Ивановна", Human.sex.female,1972,0  );
        Human ilya = new Person("Илья","Игоревич", Human.sex.male,1987,0  );
        Human denis = new Person("Денис","Игоревич", Human.sex.male,1991,0 );
        Human pavel = new Person("Павел","Иванович", Human.sex.male,1962,1978 );

        Tree1 tree = new Tree1();

        tree.appendRelationsPlusType(vasya,ivan, Relat.parent,Relat.child, "отец","сын");
        tree.appendRelations(klava,ivan, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(klava,sasha, Relat.parent,Relat.child, "мать","сын");
        tree.appendRelationsPlusType(babanna,sasha, Relat.parent,Relat.child, "теща","зять");

        tree.appendRelationsPlusType(ivan,lena, Relat.parent,Relat.child, "отец", "дочь");
        tree.appendRelationsPlusType(klava,alex, Relat.grandparent,Relat.grandchild, "бабушка","внук");
        tree.appendRelations(ivan,alex, Relat.parent,Relat.child );
        tree.appendRelationsPlusType(valya,alex, Relat.parent,Relat.child, "мать","сын" );
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
