package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMaker {

    public RandomMaker() {
    }

    public int makeRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
