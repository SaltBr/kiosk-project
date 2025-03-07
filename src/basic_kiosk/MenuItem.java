package basic_kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    String menuName;
    float menuPrice;
    String menuDesc;

    public MenuItem(String menuName, float menuPrice, String menuDesc){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDesc = menuDesc;
    }
}
