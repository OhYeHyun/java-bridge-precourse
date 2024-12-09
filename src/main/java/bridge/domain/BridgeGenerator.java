package bridge.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeGenerator {

    public String generate(int length) {
        StringBuilder bridge = new StringBuilder();
        while (length >= 1) {
            bridge.append(generateNumber());
            length--;
        }

        return bridge.toString();
    }

    private String generateNumber() {
        return String.valueOf(Randoms.pickNumberInRange(0, 1));
    }
}
