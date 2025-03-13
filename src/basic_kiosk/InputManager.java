package basic_kiosk;
import java.util.Scanner;

public class InputManager {
    Scanner scanner = new Scanner(System.in);

    //입력
    public String getInput() {
        return scanner.nextLine();
    }

}
