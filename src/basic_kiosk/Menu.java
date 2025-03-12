package basic_kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> category = new ArrayList<>();
    private String categoryName;

    //생성자로 카테고리 이름과 메뉴아이템 추가
    public Menu(List<MenuItem> menuItems, String categoryName){
        category = menuItems;
        this.categoryName = categoryName;
    }
    //카테고리 이름 게터
    public String getCategoryName() {
        return categoryName;
    }
    //카테고리 내부 게터
    public List<MenuItem> getCategoryMenu() {
        return category;
    }
}
