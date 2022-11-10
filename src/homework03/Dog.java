package homework03;

public class Dog extends Animal {

    public Dog(int runLimit, int swimLimit) {
        super(runLimit);
        kind = "The Dog";
        this.swimLimit = swimLimit;
    }

}
