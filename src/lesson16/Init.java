package lesson16;

import java.util.ArrayList;
import java.util.List;

public class Init {
    public static List<Dict> init(){
        List<Dict> dicts = new ArrayList<>();
        dicts.add(new Dict("Kiev", "Ukraine"));
        dicts.add(new Dict("Berlin", "Germany"));
        dicts.add(new Dict("Paris", "France"));
        dicts.add(new Dict("Madrid", "Spain"));
        dicts.add(new Dict("Oslo", "Sweden"));
        dicts.add(new Dict("Baku", "Azer"));
        dicts.add(new Dict("Seul", "Canada"));
        dicts.add(new Dict("Praga", "CZ Republic"));
        dicts.add(new Dict("Warsawa", "Poland"));
        dicts.add(new Dict("Amsterdam", "Holland"));
        dicts.add(new Dict("Riga", "Latvia"));
        return dicts;
    }

}
