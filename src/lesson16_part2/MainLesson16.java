package lesson16_part2;

public class MainLesson16 {
    public static void main(String[] args) {
        Operationable addition = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        Operationable subtractions = (x, y) -> x - y;
//        Operationable subtractions = (x, y) -> {
//            return x - y;
//        };

        int a = addition.calculate(5, 5);
        System.out.println(a);

        int b = subtractions.calculate(10, 5);
        System.out.println(b);

        //TODO Добавить умножение и деление
        // 2. В Lesson12 добавить лямбды для компораторов
        // 3. Прочитать про обобщенный интрерфейс


    }
}
