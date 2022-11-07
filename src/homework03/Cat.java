package homework03;

public class Cat extends Animal {
    public Cat() {
        super();
        runLimit = 200;
    }

    public String run(int distance) {
        if (distance > runLimit) {
            return "Такое препятствие я не могу преодолеть";
        }
        return "Кот пробежал " + distance + "м.";
    }

    public String swim(int distance) {
        return "Я не умею плавать. Такое препятствие я не могу преодолеть";
    }

    @Override
    public String toString() {
        return "Кот";
    }
}
