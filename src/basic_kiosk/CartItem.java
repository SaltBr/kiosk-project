package basic_kiosk;

public class CartItem {
    private final String menuName;
    private final float menuPrice;
    private int menuCount;

    public CartItem(String menuName, float menuPrice, int menuCount){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCount = menuCount;
    }

    //카트 내 메뉴 이름 getter
    public String getCartMenuName() {
        return menuName;
    }

    //카트 내 메뉴 가격 getter
    public float getCartMenuPrice() {
        return menuPrice;
        //TODO:개수 곱해서 리턴할 것
    }

    //카트 내 메뉴 개수 getter
    public int getCartMenuCount() {
        return menuCount;
    }

    //카트 내 메뉴 개수 추가
    public int addMenuCount() {
        //TODO:메뉴 이름이 있을 경우 count 만 1 추가. 메뉴 넣을 떄 이거 불러오면 됨
        return menuCount += 1;
    }
}
