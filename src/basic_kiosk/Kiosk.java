package basic_kiosk;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    public void Start() {
        String userInput;
        int choiceInput;
        List<List<MenuItem>> menuCategories = Menu.getFullMenu();
        Cart currentCart = new Cart();

        while (true) {
            //카테고리 출력
            Menu.printCategoryMenu(currentCart.getCart().isEmpty());
            System.out.print("번호를 입력하세요: ");
            //사용자 입력
            userInput = scanner.nextLine();
            //0: 프로그램 종료
            if (userInput.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                //TODO: 카트 안에 물건이 있을 떄만 장바구니 버튼이 생성되기
                //TODO: 추가로 3 누르면 예외처리되어야함
            } else if (!currentCart.getCart().isEmpty() && userInput.equals(Integer.toString(menuCategories.size()+1))) {
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
                                System.out.println("\n"+currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuName() + "   | W " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuPrice() + " | " + currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuDesc());
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인    2. 취소");
                                choiceInput = Integer.parseInt(scanner.nextLine());
                                if (choiceInput ==1 ) {
                                    //생성자로 카트 아이템 생성, 카트에 메뉴 추가
                                    CartItem cartItem = new CartItem(currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuName(), currentMenu.get(Integer.parseInt(menuInput) - 1).getMenuPrice(), 1);
                                    currentCart.addCartItem(cartItem);
                                    System.out.println("추가되었습니다.\n");
                                    break;
                                } else if (choiceInput ==2) {
                                    System.out.println("메뉴판으로 돌아갑니다.\n");
                                    break;
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

    //카트 출력 및 결제 유도
    public void inCartManager(Cart myCart) {
        int paymentInput;
        int totalPrice = 0;
        if(myCart.getCart().isEmpty()){
            System.out.println("장바구니가 비어있습니다.\n");
        } else {
            for (CartItem item : myCart.getCart()) {
                System.out.println(item.getCartMenuName() + "  |  " + priceChanger(item.getCartMenuPrice()) + "원 x " + item.getCartMenuCount() + "개  :: 총 " + priceChanger(item.getCartMenuCount()*item.getCartMenuPrice()) + "원");
                totalPrice += priceChanger(item.getCartMenuCount()*item.getCartMenuPrice());
            }
            while(true){
                System.out.println("[ 총 금액 ]\n" + totalPrice + "원\n\n결제하시겠습니까?\n1. 주문   2. 메뉴판 ");
                paymentInput = Integer.parseInt(scanner.nextLine());
                //Y: 결제
                //N: 카테고리로 돌아가기
                if (paymentInput == 1) {
                    //결제 완료 후 장바구니 초기화
                    System.out.println(totalPrice+ "원 결제 완료!\n");
                    myCart.getCart().removeAll(myCart.getCart());
                    break;
                } else if (paymentInput == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.\n");
                    break;
                } else {
                    System.out.println("잘못된 명령어입니다.\n");
                }
            }
        }
    }
    //가격 숫자 변경
    public int priceChanger(float price) {
        return Math.round(price*1000);
    }
}
