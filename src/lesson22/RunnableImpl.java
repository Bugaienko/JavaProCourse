package lesson22;

/**
 * @author Sergii Bugaienko
 */

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(String.format("Thread #%d: %d ", Thread.currentThread().getId(), i ));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
