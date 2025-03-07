package basic_kiosk;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] Args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

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