package controller;

import domain.Menu;
import domain.Order;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class OrderController {
    private final Order order = new Order();

    public void selectOrder() {
        Table table = selectTable();
    }

    private Table selectTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        return TableRepository.selectTable(tableNumber);
    }
}
