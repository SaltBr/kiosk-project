package basic_kiosk;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    //장바구니 리스트
    List<String> myCart = new ArrayList<>();

    //장바구니 게터
    public List<String> getCart() {
        return myCart;
    }
}
