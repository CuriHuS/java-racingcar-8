package racingcar.domain;

public class Car {
    private String name;
    private RandomMaker engine;

    public Car(String name, RandomMaker maker) {
        this.name = name;
        this.engine = maker;
    }

    public String getName() {
        return this.name;
    }

    public boolean isMoving() {
        if (engine.makeRandomNumber(0, 9) >= 4) {
            return true;
        }
        return false;
    }
}
