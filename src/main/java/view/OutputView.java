package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";


    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printError(String text) {
        System.out.printf("[ERROR] %s%n", text);
    }

    public static void printOrderState(Map<Menu, Integer> orderStatus) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");

        orderStatus.forEach((menu, count) -> {
            System.out.printf("%s, %d, %d%n", menu.getName(), count, menu.getPrice() * count);
        });
    }

    public static void printTableNumber(Table table) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다.", table.getNumber());
    }
}
