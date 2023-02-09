package homework25;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sergii Bugaienko
 */

public class Race {
    private ArrayList<Stage> stages;
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
    public ArrayList<Stage> getStages() { return stages; }

    @Override
    public String toString() {
        return "Race{" +
                "stages=" + stages +
                '}';
    }
}

