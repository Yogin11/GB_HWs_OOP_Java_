public class Main {

    public static void main(String[] args) {

    
        Human babanna= new SomePerson("Анна", Human.sex.female,1928);
        Human sasha = new SomePerson("Александр", Human.sex.male, 1944);

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

        GeoTree tree = new Tree1();

        tree.appendRelationsPlusRole(vasya,ivan, Relat.parent,Relat.child, "отец","сын");
        tree.appendRelations(klava,ivan, Relat.parent,Relat.child );
        tree.appendRelationsPlusRole(klava,sasha, Relat.parent,Relat.child, "мать","сын");
        tree.appendRelationsPlusRole(babanna,sasha, Relat.motherinlaw,Relat.soninlaw, "теща","зять");
        tree.appendRelations(ivan,alex, Relat.parent,Relat.child );

        tree.appendRelationsPlusRole(ivan,lena, Relat.parent,Relat.child, "отец", "дочь");
        tree.appendRelationsPlusRole(klava,alex, Relat.grandparent,Relat.grandchild, "бабушка","внук");
        tree.appendRelations(valya,alex, Relat.parent,Relat.child);
        tree.appendRelations(valya,lena, Relat.parent,Relat.child );
        tree.appendRelations(lena,ilya, Relat.parent,Relat.child);
        tree.appendRelations(lena,denis, Relat.parent,Relat.child );
        tree.appendRelations(ivan,pavel, Relat.parent,Relat.child );
        tree.appendRelations(valya,pavel, Relat.parent,Relat.child );
        tree.appendRelationsPlusRole(igor,valya, Relat.soninlaw,Relat.motherinlaw, "зять","теща" );


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
