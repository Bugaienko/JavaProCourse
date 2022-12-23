package homework16;

public class MainHomework16 {
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

        Operationable multiplication = (x, y) -> x * y;

        Operationable division = (x, y) -> x / y;

        int a = addition.calculate(5, 5);
        System.out.println(a);

        int b = subtractions.calculate(10, 5);
        System.out.println(b);

        int c = multiplication.calculate(4, 5);
        System.out.println(c);

        int d = division.calculate(5, 2);
        System.out.println(d);

        //TODO Добавить умножение и деление
        // 2. В Lesson12 добавить лямбды для компораторов
        // 3. Прочитать про обобщенный интрерфейс


    }
}
