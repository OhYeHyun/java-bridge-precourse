package bridge.service;

import bridge.domain.Board;

import java.util.List;
import java.util.Objects;

public class BridgeGame {
    private final CrossService crossService;
    private final TryService tryService;

    private boolean passable = true;

    public BridgeGame(CrossService crossService, TryService tryService) {
        this.crossService = crossService;
        this.tryService = tryService;
    }

    public boolean gameSuccess() {
        return passable && crossService.successful();
    }

    public void moveBridge(String selectedMove) {
        if (Objects.equals(selectedMove, "U")) {
            passable = crossService.checkFirstBridge();
        }
        if (Objects.equals(selectedMove, "D")) {
            passable = crossService.checkSecondBridge();
        }
    }

    public boolean continueGame(String selectedContinue) {
        return Objects.equals(selectedContinue, "R");
    }

    public void restart() {
        passable = true;
        crossService.initialize();
        tryService.addCount();
    }

    public boolean getPassable() {
        return passable;
    }

    public boolean remainingBoard() {
        return crossService.remainingBoard();
    }

    public List<List<Board>> getTurnResult() {
        return crossService.getTurnResult();
    }

    public boolean getSuccessful() {
        return crossService.successful();
    }

    public int getTryCount() {
        return tryService.getTryCount();
    }
}
