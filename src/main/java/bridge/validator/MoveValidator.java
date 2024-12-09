package bridge.validator;

import java.util.Objects;

public class MoveValidator {

    public void validate(String input) {
        validateEmpty(input);
        validateType(input);
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private void validateType(String input) {
        if (!Objects.equals(input, "U") || !Objects.equals(input, "D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D로 입력해 주세요.");
        }
    }
}
