package homework06;

public class Orange extends Fruit{

    public Orange(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Orange {" +
                "w=" + weight +
                '}';
    }
}
