package basic_kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final static List<List<MenuItem>> menuCategories = new ArrayList<>();
    private final static List<String> categoryNames = new ArrayList<>();

    //생성자로 카테고리 이름과 메뉴아이템 추가
    public Menu(List<MenuItem> menuItems, String categoryName){
        menuCategories.add(menuItems);
        categoryNames.add(categoryName);
    }

    //카테고리 메뉴 (이름만) 출력 메서드
    public static void printCategoryMenu() {
        for (String e: categoryNames) {
            System.out.println((categoryNames.indexOf(e)+1) + ". " +e);
        }
        System.out.print("0. 종료\n\n");
    }

    //내부 메뉴 출력 메서드
    public static void printInnerMenu(String userInput) {
        List<MenuItem> currentMenu = menuCategories.get(Integer.parseInt(userInput)-1);
        for (int i = 0; i < currentMenu.size(); i++) {
            System.out.println((i + 1) + ". " + currentMenu.get(i).getMenuName() + "   | W " + currentMenu.get(i).getMenuPrice() + " | " + currentMenu.get(i).getMenuDesc());
        }
        System.out.print("0. 뒤로가기\n\n");
    }

    //내부 메뉴 포함 카테고리 리스트 게터
    public static List<List<MenuItem>> getFullMenu() {
        return menuCategories;
    }
}
