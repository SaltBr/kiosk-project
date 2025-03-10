package basic_kiosk;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    //장바구니 리스트
    List<CartItem> cart = new ArrayList<>();

    //장바구니에 아이템 추가
    public void addCartItem(CartItem item) {
        boolean isItem = false;
        for(int i = 0; i< cart.size(); i++){
            //카트에 같은 이름의 아이템이 있다면 개수만 +1
            if ((item.getCartMenuName()).equals(cart.get(i).getCartMenuName())){
                cart.get(i).addMenuCount();
                isItem = true;
                break;
            }
        }
        if(!isItem || cart.isEmpty()){
            //카트에 같은 이름의 아이템이 없다면, 혹은 카트가 비어있다면 이름, 가격, 개수 모두 추가
            cart.add(item);
        }
    }

    //장바구니 게터
    public List<CartItem> getCart() {
        return cart;
    }
}
