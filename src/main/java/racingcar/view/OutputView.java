package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String WINNER_DELIMITER = ", ";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    public OutputView() {

    }

    public void printRoundStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + NAME_POSITION_SEPARATOR + createPositionString(car.getPosition()));
    }

    private String createPositionString(int position) {
        return POSITION_SYMBOL.repeat(position);
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(WINNER_DELIMITER, winners));
    }
}
