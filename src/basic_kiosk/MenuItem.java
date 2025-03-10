package basic_kiosk;

public class MenuItem {
    private final String menuDesc;
    private final String menuName;
    private final float menuPrice;

    public MenuItem(String menuName, float menuPrice, String menuDesc){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDesc = menuDesc;
    }

    //메뉴 이름 getter
    public String getMenuName() {
        return menuName;
    }

    //메뉴 가격 getter
    public float getMenuPrice() {
        return menuPrice;
    }

    //메뉴 설명 getter
    public String getMenuDesc() {
        return menuDesc;
    }
}
