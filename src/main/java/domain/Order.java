package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private static final int DEFAULT = 0;
    private static final int MAX_ORDER_COUNT = 99;

    private final Map<Table, Map<Menu, Integer>> orderStatus = new HashMap<>();

    public void add(Table table, Menu menu, int orderCount) {
        validOrderCount(orderCount);
        Map<Menu, Integer> tableStatus = getTableStatusByTable(table);
        addOrder(tableStatus, menu, orderCount);
    }

    private void validOrderCount(int orderCount) {
        if (orderCount <= 0) {
            throw new IllegalArgumentException("메뉴의 수량이 유효하지 않습니다.");
        }
    }

    private Map<Menu, Integer> getTableStatusByTable(Table table) {
        if (!orderStatus.containsKey(table)) {
            orderStatus.put(table, new HashMap<>());
        }

        return orderStatus.get(table);
    }

    private void addOrder(Map<Menu, Integer> tableStatus, Menu menu, int orderCount) {
        int beforeOrderCount = tableStatus.getOrDefault(menu, DEFAULT);

        if (beforeOrderCount + orderCount > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("주문할 수 있는 메뉴의 최대 수량은 %d까지입니다.", MAX_ORDER_COUNT));
        }

        tableStatus.put(menu, beforeOrderCount + orderCount);
    }

    public void clearTable(Table table) {
        getTableStatusByTable(table).clear();
    }

}
