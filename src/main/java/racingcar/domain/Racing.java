package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int bestPosition;
    private final List<Car> joinCars;

    public Racing(List<Car> joinCars) {
        this.bestPosition = 0;
        this.joinCars = joinCars;
    }

    /**
     * 해당 레이싱에 참여한 차들을 한번 움직인다.
     */
    public void playRound() {
        for (Car car : joinCars) {
            car.move();
            updateBestPosition(car);
        }
    }

    /**
     * 해당 레이싱 1등의 위치를 업데이트한다.
     */
    private void updateBestPosition(Car car) {
        if (bestPosition < car.getPosition()) {
            bestPosition = car.getPosition();
        }
    }

    /**
     * 해당 레이싱의 현재 시점 우승자를 나타낸다.
     */
    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        for (Car car : joinCars) {
            if (car.getPosition() == bestPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
