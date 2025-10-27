package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RandomGenerator;
import racingcar.util.parser.CarNamesParser;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.RoundCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNamesParser parser;
    private final CarNameValidator validator;
    private final RoundCountValidator roundCountValidator;
    private static final int MAX_NAME_LENGTH = 5;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.parser = new CarNamesParser();
        this.validator = new CarNameValidator();
        this.roundCountValidator = new RoundCountValidator();
    }

    public void run() {
        List<Car> cars = createCars();
        int roundCount = readRoundCount();

        Racing race = new Racing(cars);
        playRacing(race, roundCount);

        printWinners(race.getWinners());
    }

    private List<Car> createCars() {
        String carNamesString = inputView.readCarNames();
        List<String> carNames = parser.parse(carNamesString);
        validator.validateAll(carNames);

        return carNames.stream()
                .map(name -> new Car(name, new RandomGenerator(), 0))
                .collect(Collectors.toList());
    }

    private void playRacing(Racing racing, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            racing.playRound();
            printResults(racing.getJoinCars());
        }
    }

    private int readRoundCount() {
        String input = inputView.readRoundCount();
        int roundCount = parseRoundCount(input);
        roundCountValidator.validate(roundCount);
        return roundCount;
    }

    private int parseRoundCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 횟수는 숫자여야 합니다.");
        }
    }

    public void printResults(List<Car> cars) {
        outputView.printRoundResult(cars);
    }

    public void printWinners(List<Car> winners) {
        outputView.printWinners(winners);
    }
}
