import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

    StringBuilder strMenu;

    public Menu() {
        strMenu = new StringBuilder();
        strMenu.append("Выберите пункт \n");
        strMenu.append("1.Состояние питомца  \n");
        strMenu.append("2.Человек зовет питомца к себе по имени \n");
        strMenu.append("3.Человек зовет питомца к себе \n");
        strMenu.append("4.Человек гладит питомца \n");
        strMenu.append("5.Человек кормит питомца \n");
        strMenu.append("6.Питомец дерет кожаный диван \n");
        strMenu.append("7.Питомец требует внимания \n");
        strMenu.append("8.Питомец требует еды \n");
        strMenu.append("9.Питомец играется  \n");


        strMenu.append("10.Выйти \n");
        System.out.println(strMenu);
    }

    public void choiceMenu(Cat cat, Human man){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        Boolean isExit = false;
        while (!isExit) {
            try {
                String s = sc.nextLine();
                isExit = s.equals("10");
                if (isExit) {
                    sc.close();
                    break;
                }
                a = Integer.parseInt(s);

                if (a >10 && a <1) {
                    System.out.println("Неправильный ввод, попробуйте еще раз");
                    continue;
                }
                System.out.println();
                selectMethod(a, cat,man);

           } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод, попробуйте еще раз");
                System.out.println();
            }
        }
        sc.close();

    }
    public void selectMethod(int choice, Cat cat, Human man ){
        switch (choice){
            case 1:
                cat.showStatus();

                break;
            case 2:
                cat.listenAndReact(man.callPet(cat));
                break;
            case 3:
                cat.listenAndReact(man.call());
                break;
            case 4:
                man.pettingCat(cat);
                break;
            case 5:
                man.feedingCat(cat);
                break;
            case 6:
                cat.status.put("игривый", true);
                cat.tearUpSofa(man);
                break;
            case 7:
                cat.requestAtt(man);
                break;
            case 8:
                cat.isHungry(man);
                break;
            case 9:
                cat.status.put("игривый", true);
                cat.playMood();
                break;
            case 10:
                cat.showStatus();
                break;
        }
        return;
    }

}
