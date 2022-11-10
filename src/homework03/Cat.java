package homework03;

public class Cat extends Animal {
    public Cat(int runLimit) {
        super(runLimit);
        kind = "The Cat";
    }

    @Override
    public String swim(int distance) {
        return "I can not swim. This obstacle I cannot overcome.";
    }

    @Override
    public String toString() {
        return kind + " {" +
                "runLimit=" + runLimit +
                "}";

    }

}
