package bridge.validator;

public class LengthValidator {

    public static void validate(String input) {
        validateEmpty(input);
        validateIsNumeric(input);
        validateRange(input);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해 주세요.");
        }
    }

    private static void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자로 입력해 주세요.");
        }
    }
}
