import java.util.Scanner;


public class Menu {

    StringBuilder strMenu;

    public Menu() {
        strMenu = new StringBuilder();
        strMenu.append("Выберите пункт \n");
        strMenu.append("1.Состояние питомца  \n");
        strMenu.append("2.Введите новое состояние питомца \n");
        strMenu.append("3.Человек зовет питомца к себе по имени \n");
        strMenu.append("4.Человек гладит питомца \n");
        strMenu.append("5.Человек кормит питомца \n");
        strMenu.append("6.Питомец шалит \n");
        strMenu.append("7.Питомец требует внимания \n");
        strMenu.append("8.Питомец требует еды \n");
        strMenu.append("9.Питомец играется  \n");


        strMenu.append("10.Выйти \n");
        System.out.println(strMenu);
    }

    public void choiceMenu(Pet pet, Human man){
        Scanner sc = new Scanner(System.in, "UTF-8");
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
                selectMethod(a, pet,man, sc);

           } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод, попробуйте еще раз");
                System.out.println();
            }
        }
        sc.close();

    }

    public void selectMethod(int choice, Pet pet, Human man, Scanner sc) {
        switch (choice) {
            case 1:
                pet.showStatus();
                break;
            
            case 2:
                System.out.println("Введите новое состояние питомца ");
                String state = sc.nextLine();
                pet.addStatus(state, false);
                break;

            case 3:
                pet.listenAndReact(man.callPet(pet));
                break;
            case 4:
                man.pettingPet(pet);
                break;
            case 5:
                man.feedingPet(pet);
                break;
            case 6:
                pet.status.put("игривый", true);
                pet.beNaughty(man);
                break;
            case 7:
                pet.requestAtt(man); 
                break;
            case 8:
                pet.isHungry();
                break;
            case 9:
                pet.status.put("игривый", true);
                pet.playMood();
                break;
            case 10:
                pet.showStatus();
                break;
        }
        return;
    }
}
