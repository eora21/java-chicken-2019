package controller;

import domain.Menu;
import domain.Order;
import domain.Table;
import java.util.Map;
import repository.MenuRepository;
import view.InputView;
import view.OutputView;

public class OrderController {

    private final TableController tableController;
    private final Order order = new Order();

    public OrderController(TableController tableController) {
        this.tableController = tableController;
    }

    public void addOrder() {
        Table table = tableController.getTable();
        Menu menu = selectMenu();
        int orderCount = InputView.inputOrderCount();
        order.add(table, menu, orderCount);
    }


    private Menu selectMenu() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        return MenuRepository.selectMenu(menuNumber);
    }

    public void showOrderState(Table table) {
        Map<Menu, Integer> orderStatus = order.getOrderStatus(table);
        OutputView.printOrderState(orderStatus);
    }
}
