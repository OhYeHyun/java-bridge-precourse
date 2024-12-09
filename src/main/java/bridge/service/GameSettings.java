package bridge.service;

import bridge.domain.Board;
import bridge.domain.Bridge;
import bridge.domain.BridgeGenerator;

import java.util.Objects;

public class GameSettings {
    private final BridgeGenerator generator;
    private final Bridge bridge;

    public GameSettings(BridgeGenerator generator, Bridge bridge) {
        this.generator = generator;
        this.bridge = bridge;
    }

    public void setGame(int length) {
        makeBridge(generator.generate(length));
    }

    private void makeBridge(String boardNumber) {
        Board passableBoard = new Board(true);
        Board impassableBoard = new Board(false);

        for (char number : boardNumber.toCharArray()) {
            if (Objects.equals(number, '1')) {
                bridge.addFirstBridge(passableBoard);
                bridge.addSecondBridge(impassableBoard);
            }
            if (Objects.equals(number, '0')) {
                bridge.addFirstBridge(impassableBoard);
                bridge.addSecondBridge(passableBoard);
            }
        }
    }
}
