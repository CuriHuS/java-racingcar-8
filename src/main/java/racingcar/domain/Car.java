package racingcar.domain;

public class Car {
    private String name;
    private RandomMaker engine;
    private int position;

    public Car(String name, RandomMaker maker, int position) {
        this.name = name;
        this.engine = maker;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (engine.makeRandomNumber(0, 9) >= 4) {
            this.position++;
        }
    }
}
