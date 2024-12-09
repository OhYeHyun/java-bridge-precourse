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

        for (char number : boardNumber.toCharArray()) {
            if (Objects.equals(number, '1')) {
                bridge.addFirstBridge(new Board(true));
                bridge.addSecondBridge(new Board(false));
            }
            if (Objects.equals(number, '0')) {
                bridge.addFirstBridge(new Board(false));
                bridge.addSecondBridge(new Board(true));
            }
        }
    }
}
