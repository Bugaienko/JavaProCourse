package homework06;



public class SimpleBox<T> {
    //public class SimpleBox<T extends Number> { // ограничить тип
    private T object;

    public SimpleBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
