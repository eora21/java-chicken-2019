package domain;

public enum Feature {
    ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    QUIT(3, "프로그램 종료");

    private final int number;
    private final String description;

    Feature(int number, String description) {
        this.number = number;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", number, description);
    }
}
