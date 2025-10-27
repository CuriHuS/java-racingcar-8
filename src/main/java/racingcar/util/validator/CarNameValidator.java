package racingcar.util.validator;

import java.util.List;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public void validate(String name) {
        validateNotEmpty(name);
        validateLength(name);
    }

    public void validateAll(List<String> names) {
        for (String name : names) {
            validate(name);
        }
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %d자를 초과할 수 없습니다.", MAX_NAME_LENGTH)
            );
        }
    }
}