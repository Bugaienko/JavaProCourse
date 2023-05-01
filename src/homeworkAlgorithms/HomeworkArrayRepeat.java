package homeworkAlgorithms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Sergii Bugaienko
 */

public class HomeworkArrayRepeat {
    public static void main(String[] args) {
        String[] s = {"mama", "myla", "ramy"};


        Character[] res = searchRepeatingChar(s);
        System.out.println(Arrays.toString(res));

    }

    private static Character[] searchRepeatingChar(String[] s) {
        if (s.length == 0) {
            return new Character[0];
        }
        Map<Character, Integer> map = new TreeMap<>();

        for (String str : s) {
            char[] chars = str.toCharArray();
            Set<Character> repeatInOneStr = new HashSet<>();
            for (char ch : chars) {
                if (!repeatInOneStr.contains(ch)) {
                    repeatInOneStr.add(ch);
                    Integer count = map.get(ch);
                    map.put(ch, count != null ? count + 1 : 1);
                }
            }
        }

        return map.entrySet().stream().filter(e -> e.getValue() == s.length).map(Map.Entry::getKey).toArray(Character[]::new);

    }
}