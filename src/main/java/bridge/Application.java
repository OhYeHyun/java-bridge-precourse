package bridge;

import bridge.controller.BridgeController;
import bridge.domain.Bridge;
import bridge.domain.BridgeGenerator;
import bridge.service.BridgeGame;
import bridge.service.CrossService;
import bridge.service.GameSettings;
import bridge.service.TryService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGenerator generator = new BridgeGenerator();
        Bridge bridge = Bridge.getInstance();
        GameSettings settings = new GameSettings(generator, bridge);

        CrossService crossService = new CrossService(bridge);
        TryService tryService = new TryService();
        BridgeGame game = new BridgeGame(crossService, tryService);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BridgeController controller = new BridgeController(settings, game, inputView, outputView);
        controller.run();
    }
}
