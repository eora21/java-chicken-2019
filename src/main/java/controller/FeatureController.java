package controller;

import domain.Feature;
import java.util.function.Predicate;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class FeatureController {

    private final OrderController orderController = new OrderController();

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
            // 결제 컨트롤러 동작
            return;
        }
    }
}
