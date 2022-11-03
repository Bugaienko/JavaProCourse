public class HelloCat {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "red", 4);

        cat.setName("Barsik New");
        cat.setColor("red");
        cat.setAge(4);
        
        cat.voice();
        System.out.println(cat);
    }
}
