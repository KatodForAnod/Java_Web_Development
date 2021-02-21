package by.makarchuk.shape.repository.comparator;

import by.makarchuk.shape.entity.Tetrahedron;

import java.util.Comparator;

public class IdCompare implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return o1.getId() - o2.getId();
    }
}
