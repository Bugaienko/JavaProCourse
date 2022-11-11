package homework04;

public class Wall implements IBarrier {
    private int size;
    private String type;

    public Wall(int size) {
        this.size = size;
        type = "wall";
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " {" +
                "size=" + size +
                "}";
    }
}
