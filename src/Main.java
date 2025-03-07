import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String[] Args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<String> menuList = new ArrayList<>();
        menuList.add("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuList.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuList.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuList.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        while(true) {
            printMenu(menuList);
            System.out.print("0. 종료\n\n번호를 입력하세요: ");
            userInput = scanner.nextLine();
            if (userInput.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                try{
                    System.out.println(menuList.get(Integer.parseInt(userInput) - 1) + "\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("잘못된 번호입니다!\n");
                } catch (NumberFormatException e) {
                    System.out.println("번호를 입력해주세요!\n");
                }
            }
        }

    }

    public static void printMenu(List<String> menuList) {
        for(int i = 1; i<=menuList.size(); i++) {
            System.out.println(i+". "+menuList.get(i-1));
        }
    }
}
