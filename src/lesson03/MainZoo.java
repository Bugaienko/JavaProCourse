package lesson03;

/*
 * Java Pro. Lesson #03
 *
 * @author Sergey Bugaenko
 * @version 07.11.22 -
 */


public class MainZoo {
    public static void main(String[] args) {

        Cat cat = new Cat("Murzik", "red", 3);
        Dog dog = new Dog("Scharik", "black", 5);

        Animal[] animals = {cat, dog};
//      Иллюстрация полиморфизма в ООП
        for (Animal animal: animals) {
            animal.voice();
        }

        Object[] animals2 = {cat, dog};
        for (Object obj: animals2){
//            obj.voice(); Проблема. У объекта нет метода voice
        }

        IAnimal[] animals3 = {cat, dog};
        for (IAnimal animal: animals3) {
            animal.voice();
        }

    }

}
