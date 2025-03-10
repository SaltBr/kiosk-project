package basic_kiosk;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void Start() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<List<MenuItem>> menuCategories = Menu.getFullMenu();
        Cart currentCart = new Cart();

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
            } else if (userInput.equals(Integer.toString(menuCategories.size()+1))) {
                //장바구니 보기
                inCartManager(currentCart);
                //TODO: 장바구니 메뉴 (주문하기, 삭제)
            } else if (userInput.equals(Integer.toString(menuCategories.size()+2))) {
                /*TODO: 이부분을 장바구니 안 메뉴로 옮겨야 할듯
                    장바구니에 담긴 모든 항목을 출력
                    합산하여 총 금액을 계산
                 */
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
                                //선택한 메뉴 출력 및 카트에 추가
                                System.out.println("선택한 메뉴: "+currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuName() + "   | W " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuPrice() + " | " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuDesc() + "\n");
                                //생성자로 카트 아이템 생성
                                CartItem cartItem = new CartItem(currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuName(), currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuPrice(), 1);
                                currentCart.addCartItem(cartItem);
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

    public void inCartManager(Cart myCart) {
        if(myCart.getCart().isEmpty()){
            System.out.println("장바구니가 비어있습니다.\n");
        } else {
            for (CartItem item : myCart.getCart()) {
                System.out.println(item.getCartMenuName());
            }
        }
    }

}
