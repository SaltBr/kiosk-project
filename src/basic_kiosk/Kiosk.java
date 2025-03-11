package basic_kiosk;

public class Kiosk {
    InputManager inputManager = new InputManager();
    public void Start() {
        //카테고리 및 메뉴 선택
        inputManager.selectCategory();
        }
}
