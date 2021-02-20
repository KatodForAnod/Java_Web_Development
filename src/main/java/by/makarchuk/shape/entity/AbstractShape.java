package by.makarchuk.shape.entity;

public abstract class AbstractShape {
    private int id;

    public AbstractShape() {
        this.id = (int) Math.random();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AbstractShape{" +
                "id=" + id +
                '}';
    }
}
