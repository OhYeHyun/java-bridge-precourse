package bridge.validator;

import java.util.Objects;

public class ContinueValidator {

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
        if (!Objects.equals(input, "R") || !Objects.equals(input, "Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q로 입력해 주세요.");
        }
    }
}
