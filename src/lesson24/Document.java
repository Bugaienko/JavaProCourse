package lesson24;

/**
 * @author Sergii Bugaienko
 */

public class Document {
    private final String name;
    private final int countPages;

    public Document(String name, int pageCount) {
        this.name = name;
        this.countPages = pageCount;
    }

    public String getName() {
        return name;
    }

    public int getCountPages() {
        return countPages;
    }
}
