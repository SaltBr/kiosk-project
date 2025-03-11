package basic_kiosk;
import java.util.Scanner;

public class InputManager {
    Scanner scanner = new Scanner(System.in);

    //유저 입력에 따라 할인 enum 적용
    public DiscountType discountInput() {
        boolean correctDis = false;
        DiscountType discount = DiscountType.DEFAULT;

        while (!correctDis) {
            System.out.println("할인 정보를 입력해주세요.\n1. 국가유공자 : 10% \n2. 군인     :  5%\n3. 학생     :  3%\n4. 일반     :  0%");
            int discountInt = Integer.parseInt(scanner.nextLine());
            //TODO: 여기 예외 처리 필요하지 않을까? int변환 실패시
            switch (discountInt) {
                case 1:
                    discount = DiscountType.VETERAN;
                    correctDis = true;
                    break;
                case 2:
                    discount = DiscountType.MILITARY;
                    correctDis = true;
                    break;
                case 3:
                    discount = DiscountType.STUDENT;
                    correctDis = true;
                    break;
                case 4:
                    correctDis = true;
                    break;
                default:
                    System.out.println("지원하지 않는 번호입니다.");
            }
        }
        return discount;
    }
}
