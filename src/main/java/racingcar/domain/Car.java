package racingcar.domain;

public class Car {
    private String name;
    private RandomGenerator engine;
    private int position;

    public Car(String name, RandomGenerator generator, int position) {
        this.name = name;
        this.engine = generator;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (engine.generateRandomNumber(0, 9) >= 4) {
            this.position++;
        }
    }
}
