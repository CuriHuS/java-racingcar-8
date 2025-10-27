package racingcar.util.validator;

public class RoundCountValidator {

    public void validate(int roundCount) {
        validatePositive(roundCount);
    }

    private void validatePositive(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("라운드 횟수는 양수여야 합니다.");
        }
    }
}