package homework04;

import java.util.ArrayList;
import java.util.List;

abstract class Competitor implements ICompetitor {
    protected int runLimit;
    protected int jumpLimit;
    protected String type;
    private static List<ICompetitor> list = new ArrayList<>();

    public Competitor(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        list.add(this);
    }


    private int run(int size) {
        if (size <= runLimit) {
            System.out.println("Successfully ran");
            return size;
        } else {
            System.out.println("Couldn't ran");
            return -1;
        }
    }

    private int jump(int size) {
        if (size <= jumpLimit) {
            System.out.println("Successfully jump");
            return size;
        } else {
            System.out.println("Couldn't jump");
            return -1;
        }
    }

    public int move(IBarrier barrier) {
        if (barrier.getType().equals("wall")) {
            System.out.printf("%s vs %s -> ", this, barrier);
            return jump(barrier.getSize());
        }
        if (barrier.getType().equals("track")) {
            System.out.printf("%s vs %s -> ", this, barrier);
            return run(barrier.getSize());
        }
        return -1;
    }

    @Override
    public String toString() {
        return type + " {" +
                "rLimit= " + runLimit +
                ", jumpLimit= " + jumpLimit +
                "}";
    }

    public static List<ICompetitor> getList() {
        return list;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public String getType() {
        return type;
    }
}
