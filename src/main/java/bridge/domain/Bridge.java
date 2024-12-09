package bridge.domain;

import java.util.ArrayList;
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
}
