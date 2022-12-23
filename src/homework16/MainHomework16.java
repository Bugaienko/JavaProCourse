package homework16;

public class MainHomework16 {
    public static void main(String[] args) {
        Operationable addition = (x, y) -> x + y;
        Operationable subtractions = (x, y) -> x - y;
        Operationable multiplication = (x, y) -> x * y;
        Operationable division = (x, y) -> x / y;

        Operationable2 mod = (x -> {
            return (x < 0) ? x * (-1) : x;
        });
        Operationable2 square = (x -> x * x);

        int a = addition.calculate(5, 5);
        System.out.println(a);

        int b = subtractions.calculate(10, 5);
        System.out.println(b);

        int c = multiplication.calculate(4, 5);
        System.out.println(c);

        int d = division.calculate(5, 2);
        System.out.println(d);

        int e = mod.calculate(-5);
        System.out.println(e);

        int f = square.calculate(4);
        System.out.println(f);

        //TODO Добавить умножение и деление
        // 2. В Lesson12 добавить лямбды для компораторов
        // 3. Прочитать про обобщенный интрерфейс


    }
}
