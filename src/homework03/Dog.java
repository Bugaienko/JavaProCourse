package homework03;

public class Dog extends Animal {

    public Dog() {
        super();
        runLimit = 500;
        swimLimit = 10;
    }

    public String run(int distance) {
        if (distance > runLimit) {
            return "Такое препятствие я не могу преодолеть";
        }
        return "Собака пробежала " + distance + "м.";
    }

    public String swim(int distance) {
        if (distance > swimLimit) {
            return "Такое препятствие я не могу преодолеть";
        }
        return "Собака проплыла " + distance + "м.";
    }

    @Override
    public String toString() {
        return "Собака";
    }
}
