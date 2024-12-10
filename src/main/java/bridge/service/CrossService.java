package bridge.service;

import bridge.domain.Board;
import bridge.domain.Bridge;

import java.util.List;

public class CrossService {
    private final Bridge bridge;
    private int position;

    public CrossService(Bridge bridge) {
        this.bridge = bridge;
        initialize();
    }

    public void initialize() {
        bridge.initialize();
        position = 0;
    }

    public boolean checkFirstBridge() {
        Board board = bridge.first().get(position);

        board.selected();
        position++;
        return board.getPassable();
    }

    public boolean checkSecondBridge() {
        Board board = bridge.second().get(position);

        board.selected();
        position++;
        return board.getPassable();
    }

    public boolean successful() {
        return position == bridge.getSize();
    }

    public List<List<Board>> getTurnResult() {
        List<Board> firstBridge = bridge.first().subList(0, position);
        List<Board> secondBridge = bridge.second().subList(0, position);

        return List.of(firstBridge, secondBridge);
    }

    public boolean remainingBoard() {
        return position < bridge.getSize();
    }
}
