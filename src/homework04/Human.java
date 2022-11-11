package homework04;

public class Human implements ICompetitor {
    private int runLimit;
    private int jumpLimit;

    public Human(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
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
            return jump(barrier.getSize());
        }
        if (barrier.getType().equals("track")) {
            return run(barrier.getSize());
        }
        return -1;
    }

}
