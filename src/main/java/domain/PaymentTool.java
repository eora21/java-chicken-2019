package domain;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public enum PaymentTool {
    CARD(1, "신용 카드는", total -> total),
    CASH(2, "현금은", total -> (int)(total * 0.95));

    private final int number;
    private final String description;
    private final IntUnaryOperator calculate;

    PaymentTool(int number, String description, IntUnaryOperator calculate) {
        this.number = number;
        this.description = description;
        this.calculate = calculate;
    }

    public static PaymentTool findPaymentToolByNumber(int number) {
        return Arrays.stream(PaymentTool.values())
                .filter(paymentTool -> paymentTool.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력값을 다시 확인해주세요"));
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalPay(int total) {
        return this.calculate.applyAsInt(total);
    }
}
