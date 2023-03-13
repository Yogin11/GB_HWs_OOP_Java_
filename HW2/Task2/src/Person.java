public class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
    public void checkIfClosed(Wardrobe obj){
        System.out.println(" Шкаф " + obj.status);
    }

    /**
     * Проверяем открыт ли шкаф. Если нет, то открываем.
     * @param obj
     */
    public void openIfClosed(Wardrobe obj) {
        if (obj.getStatus()) {
            System.out.println("Шкаф закрыт." + this.name+ " открывает");
            obj.status = "Открыт";
            obj.closed = false;
        }
    }

    /**
     * Помещаем в шкаф
     * @param somecloth вещь, складируемая в шкаф
     * @param obj шкаф
     */
    public void putClothIn(String somecloth, Wardrobe obj){
        if (!obj.getStatus()) {
            System.out.println(this.name + " кладет в шкаф - " + somecloth);
            obj.wardrContents.add(somecloth);
            obj.amount++;
        }
        else System.out.println("Чтобы поместить что-то в шкаф, нужно открыть шкаф");
    }

    /**
     * Проверка содержимого в шкафу
     * @param obj - шкаф
     */
    public void checkWardContents(Wardrobe obj){
        if (!obj.getStatus()) {
        System.out.println( "Всего вещей в шкафу - " +obj.amount + " шт. : " + obj.wardrContents);
        }
        else {
            System.out.println("Чтобы проверить что в шкафу, " + this.name + " сначала должен открыть шкаф ");
        }
    }

    /**
     * Забираем вещь из шкафа
     * @param somecloth вещь, которую. берут из шкафа
     * @param obj шкаф
     */
    public void takeClothOut(String somecloth, Wardrobe obj){
        if (!obj.getStatus()) {
            if (obj.wardrContents.contains(somecloth)) {
                System.out.println(this.name + " берет из шкафа " + somecloth);
                obj.wardrContents.remove(somecloth);
                obj.amount--;
            }
            else System.out.println("Вещи '" + somecloth + "' в шкафу  нет");
        }
        else System.out.println("Чтобы взять что-то из шкафа, " + this.name + " должен открыть шкаф");
    }

    public void close(Wardrobe obj) {
        obj.closed = true;
        System.out.println("Шкаф закрыт ");
    }
    @Override
    public String toString() {
        return this.name;
    }
}
