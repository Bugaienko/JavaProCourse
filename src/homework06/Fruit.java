package homework06;

abstract class Fruit {
    protected double weight;

    protected double getWeight(){
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    abstract public String toString();

}
