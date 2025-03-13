package basic_kiosk;

import java.util.List;

public class Kiosk {
    private final List<Menu> newMenu;
    private final InputManager inputManager;
    private final Cart currentCart = new Cart();


    public Kiosk (List<Menu> newMenu){
        this.newMenu = newMenu;
        this.inputManager = new InputManager();
    }

    public void Start() {
        //카테고리 및 메뉴 선택
        selectCategory();
        }

    public void selectCategory() {
        String userInput;
        while (true) {
            //카테고리 출력
            newMenu.stream().forEach(s -> System.out.println((newMenu.indexOf(s)+1) +". " +s.getCategoryName()));
            if (!currentCart.getCart().isEmpty()) {
                System.out.println((newMenu.size()+1)+". 장바구니 보기\n---------------");
            }
            System.out.println("0. 종료\n");

            System.out.print("번호를 입력하세요: ");
            //사용자 입력
            userInput = inputManager.getInput();
            if (userInput.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else if (!currentCart.getCart().isEmpty() && userInput.equals(Integer.toString(newMenu.size() + 1))) {
                //장바구니 보기
                int totalPrice = 0;
                if (currentCart.getCart().isEmpty()) {
                    System.out.println("장바구니가 비어있습니다.\n");
                } else {
                    for (CartItem item : currentCart.getCart()) {
                        System.out.println(item.getCartMenuName() + "  |  " + priceChanger(item.getCartMenuPrice()) + "원 x " + item.getCartMenuCount() + "개  :: 총 " + priceChanger(item.getCartMenuCount() * item.getCartMenuPrice()) + "원");
                        totalPrice += priceChanger(item.getCartMenuCount() * item.getCartMenuPrice());
                    }
                    try {
                        cartInput(totalPrice, currentCart);
                    } catch (NumberFormatException e) {
                        //문자 입력
                        System.out.println("번호를 입력해주세요!\n");
                    }
                }
            } else {
                //카테고리 숫자: 카테고리 출력
                try {
                    //세부 메뉴 입력받기
                    selectFood(userInput, currentCart);
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

    //세부 메뉴 입력받기
    public void selectFood(String userInput, Cart currentCart) {
        int choiceInput;
        while (true) {
            //세부 메뉴 출력
            List<MenuItem> currentMenu = newMenu.get(Integer.parseInt(userInput)-1).getCategoryMenu();
            System.out.println("---------------");
            currentMenu.stream().forEach(s -> System.out.println((currentMenu.indexOf(s)+1) +". " +currentMenu.get(currentMenu.indexOf(s)).getName() + "   | W " + currentMenu.get(currentMenu.indexOf(s)).getPrice() + " | " + currentMenu.get(currentMenu.indexOf(s)).getDesc()));
            System.out.println("---------------\n0. 뒤로가기\n");


            System.out.print("메뉴를 선택하세요: ");
            String menuInput = inputManager.getInput();
            if (menuInput.equals("0")) {
                System.out.println("카테고리로 이동합니다.\n");
                break;
            } else {
                try {
                    //선택한 메뉴 출력 및 카트에 추가
                    System.out.println("\n" + currentMenu.get(Integer.parseInt(menuInput) - 1).getName() + "   | W " + currentMenu.get(Integer.parseInt(menuInput) - 1).getPrice() + " | " + currentMenu.get(Integer.parseInt(menuInput) - 1).getDesc());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인    2. 취소");
                    choiceInput = Integer.parseInt(inputManager.getInput());
                    if (choiceInput == 1) {
                        //생성자로 카트 아이템 생성, 카트에 메뉴 추가
                        CartItem cartItem = new CartItem(currentMenu.get(Integer.parseInt(menuInput) - 1).getName(), currentMenu.get(Integer.parseInt(menuInput) - 1).getPrice(), 1);
                        currentCart.addCartItem(cartItem);
                        System.out.println("추가되었습니다.\n");
                        break;
                    } else if (choiceInput == 2) {
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
    }

    //유저 입력에 따라 할인 enum 적용
    public DiscountType discountInput() {
        boolean correctDis = false;
        DiscountType discount = DiscountType.DEFAULT;

        while (!correctDis) {
            System.out.println("할인 정보를 입력해주세요.\n1. 국가유공자 : 10% \n2. 군인     :  5%\n3. 학생     :  3%\n4. 일반     :  0%");
            int discountInt = Integer.parseInt(inputManager.getInput());
            switch (discountInt) {
                case 1:
                    discount = DiscountType.VETERAN;
                    correctDis = true;
                    break;
                case 2:
                    discount = DiscountType.MILITARY;
                    correctDis = true;
                    break;
                case 3:
                    discount = DiscountType.STUDENT;
                    correctDis = true;
                    break;
                case 4:
                    correctDis = true;
                    break;
                default:
                    System.out.println("지원하지 않는 번호입니다.");
            }
        }
        return discount;
    }

    public void cartInput(int totalPrice, Cart myCart) {
        //Y: 결제
        //N: 카테고리로 돌아가기
        while (true) {
            System.out.println("[ 총 금액 ]\n" + totalPrice + "원\n\n1. 주문   2.주문삭제   3. 메뉴판 ");
            int paymentInput = Integer.parseInt(inputManager.getInput());
            if (paymentInput == 1) {
                //최종 금액에 할인 적용
                DiscountType discountType = discountInput();
                totalPrice *= 1 - discountType.discount / 100.0;
                //결제 완료 후 장바구니 초기화
                System.out.println(totalPrice + "원 결제 완료!\n");
                myCart.getCart().removeAll(myCart.getCart());
                break;
            } else if (paymentInput ==2) {
                //주문 삭제
                while(true) {
                    boolean menuExist = false;
                    System.out.print("삭제할 메뉴의 이름 (뒤로가기 0): ");
                    String menuName = inputManager.getInput();

                    //0을 입력하면 종료
                    if(menuName.equals("0")){
                        break;
                    }

                    //해당 메뉴가 실제로 있는지 확인
                    for(int i = 0; i<currentCart.getCart().size(); i++){
                        if(currentCart.getCart().get(i).getCartMenuName().equals(menuName)){
                            menuExist = true;
                            break;
                        }
                    }
                    //메뉴가 있는 경우에만 실행되게
                    if(menuExist){
                        List<CartItem> newCart = myCart.getCart().stream().filter(a -> !a.getCartMenuName().equals(menuName)).toList();
                        currentCart.resetCart();
                        for(CartItem c : newCart) {
                            currentCart.addCartItem(c);
                        }
                        System.out.println("삭제되었습니다.\n");
                        break;
                    } else {
                        System.out.println("잘못된 이름이거나, 메뉴가 존재하지 않습니다.");
                    }
                }
                break;
            } else if (paymentInput == 3) {
                //카테고리로 돌아가기
                System.out.println("메뉴판으로 돌아갑니다.\n");
                break;
            } else {
                System.out.println("잘못된 명령어입니다.\n");
            }
        }
    }

    //가격 숫자 변경
    public int priceChanger(float price) {
        return Math.round(price * 1000);
    }
}
