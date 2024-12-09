package bridge.validator;

public class LengthValidator {

    public void validate(String input) {
        validateEmpty(input);
        validateIsNumeric(input);
        validateRange(input);
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해 주세요.");
        }
    }

    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자로 입력해 주세요.");
        }
    }
}
