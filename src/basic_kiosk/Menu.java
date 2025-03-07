package basic_kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    static List<List<MenuItem>> menuCategories = new ArrayList<>();
    static List<String> categoryNames = new ArrayList<>();

    //생성자로 카테고리 이름과 메뉴아이템 추가
    public Menu(List<MenuItem> menuItems, String categoryName){
        menuCategories.add(menuItems);
        categoryNames.add(categoryName);
    }


    //내부 메뉴 포함 카테고리 리스트 게터
    public static List<List<MenuItem>> getFullMenu() {
        return menuCategories;
    }

    //카테고리 이름 리스트 게터
    public static List<String> getCategoryName() {
        return categoryNames;
    }
}
