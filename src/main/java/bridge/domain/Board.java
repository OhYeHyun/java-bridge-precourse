package bridge.domain;

public class Board {
    private final boolean passable;

    public Board(boolean passable) {
        this.passable = passable;
    }

    public boolean getPassable() {
        return passable;
    }
}
