package view;

import domain.Feature;
import domain.PaymentTool;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PAYMENT_TOOL = Arrays.stream(PaymentTool.values())
            .map(paymentTool -> String.format("%s %d번", paymentTool.getDescription(), paymentTool.getNumber()))
            .collect(Collectors.joining(", "));

    public static int inputFeature() {
        System.out.println("## 메인화면");

        for (Feature feature : Feature.values()) {
            System.out.println(feature);
        }

        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputOrderCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputTablePayment() {
        System.out.printf("## %s", PAYMENT_TOOL);
        return scanner.nextInt();
    }
}
