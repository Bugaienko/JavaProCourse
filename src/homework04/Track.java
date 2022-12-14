package homework04;

public class Track implements IBarrier {
    private int size;
    private String type;

    public void go(ICompetitor competitor){

    }

    public Track(int size) {
        this.size = size;
        type = "track";
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
