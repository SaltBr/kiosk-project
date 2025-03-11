package basic_kiosk;

public enum DiscountType {
    VETERAN(10),
    MILITARY(5),
    STUDENT(3),
    DEFAULT(0);

    final int discount;

    DiscountType (int discount) {
        this.discount = discount;
    }
}
