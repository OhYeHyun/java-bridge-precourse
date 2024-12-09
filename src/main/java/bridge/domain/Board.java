package bridge.domain;

public class Board {
    private final boolean passable;
    private boolean selected;

    public Board(boolean passable) {
        this.passable = passable;
        this.selected = false;
    }

    public void selected() {
        selected = true;
    }

    public void initialize() {
        selected = false;
    }

    public boolean getPassable() {
        return passable;
    }

    public boolean getSelected() {
        return selected;
    }
}
