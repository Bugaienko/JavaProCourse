package homework24;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sergii Bugaienko
 */

public class LastFloor {
    volatile List<String> queue = new ArrayList<>();
    volatile List<String> arrived = new ArrayList<>();

    public LastFloor(int waitingPeoples) {
        for (int i = 0; i < waitingPeoples; i++) {
            queue.add("L:p." + i);
        }
    }

    public synchronized void goDown(int capacity, FirstFloor firstFloor) {
        if (!queue.isEmpty()) {
            int quantity = Math.min(this.queue.size(), capacity);
            List<String> movingGroup = this.queue.subList(this.queue.size() - quantity, this.queue.size());
//            System.out.println("goDown " + queue + " | " + queue.size() + " | " + quantity + " | " + movingGroup);
            movingGroup = new CopyOnWriteArrayList<>(movingGroup);
            this.queue.removeAll(movingGroup);
            firstFloor.getArrived().addAll(movingGroup);
        } else {
            System.out.println("Вверху людей нет");
        }

    }

    public List<String> getQueue() {
        return queue;
    }

    public List<String> getArrived() {
        return arrived;
    }

    public void syncColl() {
        this.queue = Collections.synchronizedList(queue);
        this.arrived = Collections.synchronizedList(arrived);
    }
}
