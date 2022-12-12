package controller;

import domain.Menu;
import domain.Order;
import domain.Table;
import repository.MenuRepository;
import repository.TableRepository;
import view.InputView;
import view.OutputView;

public class OrderController {
    private final Order order = new Order();

    public void addOrder() {
        Table table = selectTable();
        Menu menu = selectMenu();
        int orderCount = InputView.inputOrderCount();
        order.add(table, menu, orderCount);
    }

    private Table selectTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        return TableRepository.selectTable(tableNumber);
    }

    private Menu selectMenu() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        return MenuRepository.selectMenu(menuNumber);
    }
}
