package homework06;

public class Apple extends Fruit{

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
