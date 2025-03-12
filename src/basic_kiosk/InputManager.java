package basic_kiosk;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    //셍상자로 메뉴카테고리 채우기
    Scanner scanner = new Scanner(System.in);

    //카테고리 입력
    public String getInput() {
        return scanner.nextLine();
    }

}
