package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesParser {
    private static final String DELIMITER = ",";

    public List<String> parse(String input) {
        validateInput(input);
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    /**
     * 입력으로 null 혹은 빈 문자열이 입력되는 지 검증합니다.
     */
    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어있습니다.");
        }
    }
}