package homework03;

public class Cat extends Animal {
    public Cat() {
        super();
        kind = "Кошка";
        runLimit = 200;
    }

    @Override
    public String swim(int distance) {
        return "Я не умею плавать. Такое препятствие я не могу преодолеть";
    }

}
