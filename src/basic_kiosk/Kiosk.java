package basic_kiosk;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void Start() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<List<MenuItem>> menuCategories = Menu.getFullMenu();
        List<String> categoryNames = Menu.getCategoryName();

        while (true) {
            //카테고리 출력
            for (String e: categoryNames) {
                System.out.println((categoryNames.indexOf(e)+1) + ". " +e);
            }
            System.out.print("0. 종료\n\n");

            System.out.print("번호를 입력하세요: ");
            //사용자 입력
            userInput = scanner.nextLine();
            //0: 프로그램 종료
            if (userInput.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                //카테고리 숫자: 카테고리 출력
                try {
                    List<MenuItem> currentMenu = menuCategories.get(Integer.parseInt(userInput)-1);
                    for (int i = 0; i < currentMenu.size(); i++) {
                        System.out.println((i + 1) + ". " + currentMenu.get(i).menuName + "   | W " + currentMenu.get(i).menuPrice + " | " + currentMenu.get(i).menuDesc);
                    }
                    while(true) {
                        System.out.print("0. 뒤로가기\n\n메뉴를 선택하세요: ");
                        String menuInput = scanner.nextLine();
                        if (menuInput.equals("0")) {
                            System.out.println("카테고리로 이동합니다.");
                            break;
                        } else {
                            try {
                                System.out.println("선택한 메뉴: "+currentMenu.get(Integer.parseInt(menuInput) - 1).menuName + "   | W " + currentMenu.get(Integer.parseInt(menuInput) - 1).menuPrice + " | " + currentMenu.get(Integer.parseInt(menuInput) - 1).menuDesc + "\n");
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                //메뉴판에 없는 번호 입력
                                System.out.println("잘못된 번호입니다!\n");
                            } catch (NumberFormatException e) {
                                //문자 입력
                                System.out.println("번호를 입력해주세요!\n");
                            }
                        }
                    }
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
