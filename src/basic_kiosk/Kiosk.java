package basic_kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public void Start() {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            //메뉴 출력
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).menuName + "   | W " + menuItems.get(i).menuPrice + " | " + menuItems.get(i).menuDesc);
            }
            System.out.print("0. 종료\n\n번호를 입력하세요: ");

            //사용자 입력
            userInput = scanner.nextLine();
            //0: 프로그램 종료
            if (userInput.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                //메뉴 숫자: 메뉴 출력
                try {
                    System.out.println(menuItems.get(Integer.parseInt(userInput) - 1).menuName + "   | W " + menuItems.get(Integer.parseInt(userInput) - 1).menuPrice + " | " + menuItems.get(Integer.parseInt(userInput) - 1).menuDesc + "\n");
                } catch (IndexOutOfBoundsException e) {
                    //메뉴판에 없는 번호 입력
                    System.out.println("잘못된 번호입니다!\n");
                } catch (NumberFormatException e) {
                    //문자 입력
                    System.out.println("번호를 입력해주세요!\n");
                }
            }
        }
    }
}
