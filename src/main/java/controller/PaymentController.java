package controller;

import domain.Menu;
import domain.PaymentTool;
import domain.Table;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class PaymentController {

    private final TableController tableController;
    private final OrderController orderController;

    public PaymentController(TableController tableController, OrderController orderController) {
        this.tableController = tableController;
        this.orderController = orderController;
    }

    public void pay() {
        Table table = tableController.getTable();
        Map<Menu, Integer> orderState = orderController.getOrderState(table);
        OutputView.printOrderState(orderState);
        OutputView.printTableNumber(table);
        PaymentTool paymentTool = PaymentTool.findPaymentToolByNumber(InputView.inputTablePayment());
        paymentTool.getTotalPay(orderState.values().stream().reduce(0, Integer::sum));
    }
}
