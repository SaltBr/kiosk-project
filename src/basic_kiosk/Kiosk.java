package basic_kiosk;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void Start() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<List<MenuItem>> menuCategories = Menu.getFullMenu();

        while (true) {
            //카테고리 출력
            Menu.printCategoryMenu();

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
                    while(true) {
                        //메뉴 출력
                        Menu.printInnerMenu(userInput);
                        List<MenuItem> currentMenu = menuCategories.get(Integer.parseInt(userInput)-1);

                        System.out.print("메뉴를 선택하세요: ");
                        String menuInput = scanner.nextLine();
                        if (menuInput.equals("0")) {
                            System.out.println("카테고리로 이동합니다.");
                            break;
                        } else {
                            try {
                                System.out.println("선택한 메뉴: "+currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuName() + "   | W " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuPrice() + " | " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuDesc() + "\n");
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
