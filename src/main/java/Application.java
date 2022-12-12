import controller.FeatureController;

public class Application {

    public static void main(String[] args) {
        FeatureController featureController = new FeatureController();

        while (true) {
            if (featureController.run()) {
                return;
            }
        }

    }
}
