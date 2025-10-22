package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private static final int MAX_NAME_LENGTH = 5;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String carNamesString = inputView.readCarNames();
        List<String> carNames = parseCarNames(carNamesString);
        int roundCount = Integer.parseInt(inputView.readRoundCount());

        List<Car> cars = formatCarList(carNames);

        Racing race = new Racing(cars);
        playRacing(race, roundCount);

        printWinners(race.getWinners());
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }


    private List<Car> formatCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateNameLength(carName);
            Car car = new Car(carName, new RandomGenerator(), 0);
            cars.add(car);
        }
        return cars;
    }

    private List<String> parseCarNames(String carNames) {
        List<String> carNamesList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carNamesList.add(carName);
        }
        return carNamesList;
    }

    private void playRacing(Racing racing, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            racing.playRound();
            printResults(racing.getJoinCars());
        }
    }

    public void printResults(List<Car> cars) {
        outputView.printRoundResult(cars);
    }

    public void printWinners(List<Car> winners) {
        outputView.printWinners(winners);
    }

}
