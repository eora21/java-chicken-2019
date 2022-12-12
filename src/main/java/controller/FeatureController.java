package controller;

import domain.Feature;
import view.InputView;

public class FeatureController {

    public void selectFeature() {
        int featureNumber = InputView.inputFeature();
        Feature feature = Feature.findFeatureByNumber(featureNumber);
        activeFeature(feature);
    }

    private void activeFeature(Feature feature) {
        if (feature == Feature.ORDER) {
            // 주문 컨트롤러 동작
            return;
        }

        if (feature == Feature.PAYMENT) {
            // 결제 컨트롤러 동작
            return;
        }

        //프로그램 종료
        return;
    }
}
