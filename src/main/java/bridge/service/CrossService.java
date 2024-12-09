package bridge.service;

import bridge.domain.Bridge;

public class CrossService {
    private final Bridge bridge;
    private int firstIndex;
    private int secondIndex;

    public CrossService(Bridge bridge) {
        this.bridge = bridge;
        initialize();
    }

    public void initialize() {
        firstIndex = 0;
        secondIndex = 0;
    }

    public boolean checkFirstBridge() {
        boolean passable = bridge.first().get(firstIndex).getPassable();
        updateFirstIndex(passable);
        return passable;
    }

    public boolean checkSecondBridge() {
        boolean passable = bridge.second().get(secondIndex).getPassable();
        updateSecondIndex(passable);
        return passable;
    }

    private void updateFirstIndex(boolean passable) {
        if (passable) {
            firstIndex++;
        }
    }

    private void updateSecondIndex(boolean passable) {
        if (passable) {
            secondIndex++;
        }
    }
}
