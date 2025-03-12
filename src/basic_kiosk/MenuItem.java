package basic_kiosk;

public class MenuItem {
    private final String desc;
    private final String name;
    private final float price;

    public MenuItem(String name, float price, String desc){
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    //메뉴 이름 getter
    public String getName() {
        return name;
    }

    //메뉴 가격 getter
    public float getPrice() {
        return price;
    }

    //메뉴 설명 getter
    public String getDesc() {
        return desc;
    }
}
