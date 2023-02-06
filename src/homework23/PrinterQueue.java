package homework23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sergii Bugaienko
 */

public class PrinterQueue {
    private BlockingQueue<List<String>> queue = new ArrayBlockingQueue<>(5);
    private List<String> output = new ArrayList<>();

    public void print(List<String> list) {
        try {
            queue.put(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void output() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!queue.isEmpty()) {
            try {
                List<String> task = queue.take();
                for (String str: task) {
                    output.add(str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getOutput() {
        return output;
    }
}
