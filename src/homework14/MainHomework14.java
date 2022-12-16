package homework14;


import javax.swing.*;

/**
 * Java Pro. Lesson #14.
 *
 * @author Sergey Bugaenko
 * @version 15.12.22
 */

public class MainHomework14 extends JFrame {

    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Kiev", "Ukraine"); //15
        hashTable.put("Berlin", "Germany"); //2
        hashTable.put("Paris", "France"); //11
        hashTable.put("Madrid", "Spain"); //13
        hashTable.put("Oslo", "Sweden"); //7
        hashTable.put("Baku", "Azer"); //9
        hashTable.put("Seul", "Canada"); //9
        hashTable.put("Praga", "CZ Republic"); //9
        hashTable.put("Warsawa", "Poland"); //0
        hashTable.put("Amsterdam", "Holland"); //6
        hashTable.put("Vien", "Austria"); //12
        hashTable.put("Riga", "Latvia"); //1

        // После добавления этого элемента произойдет пересчет карты

//        hashTable.put("Sofia", "Bulgaria"); //2
//        hashTable.put("New York", "USA"); //15
//
//
//        System.out.println("remove - " + hashTable.remove("Seul"));
//        hashTable.put("Seul", "Canada"); //9
//        hashTable.put("London", "United Kingdom"); //9
//        hashTable.put("Athens", "Greece"); //9
//        hashTable.put("Rome", "Italy"); //9


//        System.out.println(hashTable.get("Kiev"));
//        System.out.println(hashTable.get("Berlin"));
//        System.out.println(hashTable.get("Paris"));
//        System.out.println(hashTable.get("Madrid"));
//        System.out.println(hashTable.get("Oslo"));
//        System.out.println(hashTable.get("Baku"));
//        System.out.println(hashTable.get("Seul"));
//        System.out.println(hashTable.get("New York"));

//        new HashTable<>();



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
