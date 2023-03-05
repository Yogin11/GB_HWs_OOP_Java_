public class Main {
public static void main(String[] args) {


    Person chel = new Person("Матвей");
    Wardrobe shkap = new Wardrobe("коридор");
    Person vasya = new Person("Вася");
//    shkap.openWard();  /* откроем шкаф заранее. Или - шкаф ранее забыли закрыть.*/

    /* Положить вещи в шкаф: проверить, открыть, положить, проверить, закрыть*/

//    chel.checkIfClosed(shkap);
    chel.checkWardContents(shkap);
    chel.openIfClosed(shkap);
    chel.putClothIn("Футболка HB", shkap);
    vasya.putClothIn("Ветровка CK",shkap);
    chel.putClothIn("Полотенце LM", shkap);
    chel.checkWardContents(shkap);
    chel.takeClothOut("Футболка HB", shkap);
    vasya.takeClothOut("носки", shkap);  //Такой вещи в шкафу нет
    chel.checkWardContents(shkap);
    chel.close(shkap);
    chel.checkWardContents(shkap);      // Чтобы проверить что в шкафу, сначала нужно открыть шкаф


    }
}