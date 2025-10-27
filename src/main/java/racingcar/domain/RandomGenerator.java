package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public RandomGenerator() {
    }

    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
