package lesson14;


import java.util.*;

/**
 * Java Pro. Lesson #14.
 *
 * @author Sergey Bugaenko
 * @version 15.12.22
 */

public class MainLesson14 {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Kiev", "Ukraine");
        hashTable.put("Berlin", "Germany");
        hashTable.put("Paris", "France");
        hashTable.put("Madrid", "Spain");
        hashTable.put("Oslo", "Sweden");
        hashTable.put("Baku", "Azer");
        hashTable.put("Seul", "Canada");
        hashTable.put("New York", "USA");
        System.out.println(hashTable.get("Kiev"));
        System.out.println(hashTable.get("Berlin"));
        System.out.println(hashTable.get("Paris"));
        System.out.println(hashTable.get("Madrid"));
        System.out.println(hashTable.get("Oslo"));
        System.out.println(hashTable.get("Baku"));
        System.out.println(hashTable.get("Seul"));
        System.out.println(hashTable.get("New York"));


        System.out.println(hashTable);
//        Map<String, String> map = new HashMap<>();
//        map.put("Kiev", "Ukraine");
//        map.put("Berlin", "Germany");
//        map.put("Paris", "France");
//        System.out.println(map);
//        System.out.println(map.get("Kiev"));
//        System.out.println(map.keySet());
//        System.out.println(map.entrySet());
//        System.out.println(map.values());


//        List<Integer> arrayList = new ArrayList<>();
//        List<Integer> linkedList = new LinkedList<>();
//        Set<Integer> hashSet = new HashSet<>();
//        ex(arrayList);
//        ex(linkedList);
//        ex(hashSet);
    }

//    private static void ex(Collection<Integer> list){
//        //TODO
//    }

}
