package domain;

import java.util.Arrays;

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

    public static Feature findFeatureByNumber(int number) {
        return Arrays.stream(Feature.values())
                .filter(feature -> feature.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 기능이 없습니다."));
    }

    @Override
    public String toString() {
        return String.format("%d - %s", number, description);
    }
}
