package basic_kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] Args) {
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coca Cola", 3f, "빨간 코카콜라"));
        drinks.add(new MenuItem("Pepsi", 3f, "파란 펩시"));
        drinks.add(new MenuItem("Sprite", 3.1f, "초록 스프라이트"));

        //Main의 메뉴아이템을 Menu로 넘겨줌
        Menu burger = new Menu(burgers, "Burgers");
        Menu drink = new Menu(drinks, "Drinks");

        //키오스크 시작
        Kiosk kiosk = new Kiosk();
        kiosk.Start();
    }
}