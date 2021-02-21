package by.makarchuk.shape.repository.comparator;

import by.makarchuk.shape.entity.Tetrahedron;

import java.util.Comparator;

public class FirstXCoordinatesSort implements Comparator<Tetrahedron> {

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return (int) (o1.getPointA().getX() - o2.getPointA().getX());
    }
}
