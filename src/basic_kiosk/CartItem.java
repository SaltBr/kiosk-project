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
    }

    //카트 내 메뉴 개수 getter
    public int getCartMenuCount() {
        return menuCount;
    }

    //카트 내 메뉴 개수 추가
    public void addMenuCount() {
        menuCount += 1;
    }
}
