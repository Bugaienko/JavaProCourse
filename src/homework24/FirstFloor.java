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
//        System.out.println("group " + movingGroup);
        arrived.addAll(movingGroup);

    }

    public void syncColl() {
        queue = Collections.synchronizedList(queue);
        arrived = Collections.synchronizedList(arrived);
    }
}
