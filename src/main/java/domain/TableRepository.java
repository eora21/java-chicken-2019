package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public Table selectTable(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isEqualTableNumber(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 테이블이 없습니다."));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
