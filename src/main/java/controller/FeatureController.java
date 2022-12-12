package controller;

import domain.Feature;
import service.TableService;
import view.InputView;
import view.OutputView;

public class FeatureController {

    private final TableController tableController = new TableController(new TableService());
    private final OrderController orderController = new OrderController(tableController);
    private final PaymentController paymentController = new PaymentController(tableController, orderController);

    public boolean run() {
        try {
            return selectFeature();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    private boolean selectFeature() {
        int featureNumber = InputView.inputFeature();
        Feature feature = Feature.findFeatureByNumber(featureNumber);

        if (feature == Feature.QUIT) {
            return true;
        }

        activeFeature(feature);
        return false;
    }

    private void activeFeature(Feature feature) {
        if (feature == Feature.ORDER) {
            orderController.addOrder();
            return;
        }

        if (feature == Feature.PAYMENT) {
            paymentController.pay();
            return;
        }
    }
}
