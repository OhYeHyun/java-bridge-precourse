package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    private static final Bridge instance = new Bridge();

    private static final List<Board> firstBridge = new ArrayList<>();
    private static final List<Board> secondBridge = new ArrayList<>();

    private Bridge() {}

    public static Bridge getInstance() {
        return instance;
    }

    public void addFirstBridge(Board board) {
        firstBridge.add(board);
    }

    public void addSecondBridge(Board board) {
        secondBridge.add(board);
    }

    public List<Board> first() {
        return Collections.unmodifiableList(firstBridge);
    }

    public List<Board> second() {
        return Collections.unmodifiableList(secondBridge);
    }

    public void initialize() {
        for (Board board : firstBridge) {
            board.initialize();
        }
        for (Board board : secondBridge) {
            board.initialize();
        }
    }

    public int getSize() {
        return firstBridge.size();
    }
}
