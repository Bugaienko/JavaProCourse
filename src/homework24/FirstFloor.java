package homework24;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sergii Bugaienko
 */

public class FirstFloor {
    volatile List<String> queue = new ArrayList<>();
    volatile List<String> arrived = new ArrayList<>();

    public FirstFloor(int waitingPeoples) {
        for (int i = 0; i < waitingPeoples; i++) {
            queue.add("F:p." + i);
        }
    }

    public List<String> getArrived() {
        return arrived;
    }

    public synchronized void liftArrived(List<String> movingGroup) {
        arrived.addAll(movingGroup);
    }

    public List<String> getQueue() {
        return queue;
    }

    public void syncColl() {
        queue = Collections.synchronizedList(queue);
        arrived = Collections.synchronizedList(arrived);
    }

    public synchronized void goUp(int capacity, LastFloor lastFloor) {
        if (!queue.isEmpty()) {
            int quantity = Math.min(capacity, queue.size());
            List<String> movingGroup = queue.subList(queue.size() - quantity, queue.size());
            movingGroup = new CopyOnWriteArrayList<>(movingGroup);
//            System.out.println(movingGroup);
            queue.removeAll(movingGroup);
            lastFloor.getArrived().addAll(movingGroup);
//            System.out.println(lastFloor.getArrived());
        } else {
            System.out.println("Внизу людей нет");
        }
    }
}
