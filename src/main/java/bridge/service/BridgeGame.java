package bridge.service;

import java.util.List;
import java.util.Objects;

public class BridgeGame {
    private final CrossService crossService;
    private final TryService tryService;

    private boolean success = false;

    public BridgeGame(CrossService crossService, TryService tryService) {
        this.crossService = crossService;
        this.tryService = tryService;
    }

    public boolean move(String selectedBridge) {
        boolean passable = false;
        if (Objects.equals(selectedBridge, "U")) {
            passable = crossService.checkFirstBridge();
        }
        if (Objects.equals(selectedBridge, "D")) {
            passable = crossService.checkSecondBridge();
        }

        return passable;
    }

    public boolean isFinish() {
        if (crossService.successful()) {
            success = true;
        }
        return success;
    }

    private void restart() {
        crossService.initialize();
        tryService.initialize();
    }

    public List<Object> displayTurnResult() {
        return crossService.getTurnResult();
    }

    public List<Object> displayTotalResult() {
        return List.of(success, tryService.getTryCount());
    }
}
