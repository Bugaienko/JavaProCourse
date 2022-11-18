package homework06;

public class Apple extends Fruit {

    public Apple() {
        this.weight = 1;
    }

    public Apple(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple {" +
                "w=" + weight +
                '}';
    }
}
