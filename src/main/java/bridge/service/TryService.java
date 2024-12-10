package bridge.service;

public class TryService {
    private int tryCount;

    public TryService() {
        initialize();
    }

    public void initialize() {
        tryCount = 1;
    }

    public void addCount() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }
}
