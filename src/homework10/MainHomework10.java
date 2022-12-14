package homework10;

/**
 * Java Pro. Homework #10. CRUD
 *
 * @author Sergey Bugaenko
 * @version 01.12.22
 *
 * Реализованы CRUD операции. Реализован поиск в "базе данных":
 *  # Мин, макс, входящий в промежуток возраст;
 *  # по должности - вхождение искомой строки в должность;
 *  # мин, макс, интервал по зп
 *  # по имени - вхождение искомой/искомых строк в имя
 *  # Поиск по двум условиям - например, минимальный возраст 25 и в должности есть слово "prog" (или слова prog + back;
 *
 *
 */
public class MainHomework10 {
    public static void main(String[] args) {
        new CommandLine().exec();
    }
}
