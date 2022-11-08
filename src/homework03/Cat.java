package homework03;

public class Cat extends Animal {
    public Cat() {
        super();
        kind = "The Cat";
        runLimit = 200;
    }

    @Override
    public String swim(int distance) {
        return "I can not swim. This obstacle I cannot overcome.";
    }

}
