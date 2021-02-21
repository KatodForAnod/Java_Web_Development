package by.makarchuk.shape.repository;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Tetrahedron;
import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.repository.comparator.FirstXCoordinatesSort;
import by.makarchuk.shape.repository.specifacation.MinMaxAreaSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestRepository {
    @Test
    public void test_1() throws WrongInputParam {
        Repository repository = new Repository();
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(3, 0, 4);
        Point d = new Point(2, 6, 1);

        Tetrahedron tetrahedron1 = new Tetrahedron(a, b, c, d);

        Point a2 = new Point(0, 0, 0);
        Point b2 = new Point(6, 0, 0);
        Point c2 = new Point(3, 0, 4);
        Point d2 = new Point(2, 6, 1);

        Tetrahedron tetrahedron2 = new Tetrahedron(a2, b2, c2, d2);

        repository.addShape(tetrahedron1);
        repository.addShape(tetrahedron2);

        MinMaxAreaSpecification minMaxAreaSpecification = new MinMaxAreaSpecification(50.0, 70.0);
        List<Tetrahedron> list = repository.query(minMaxAreaSpecification);

        Assert.assertEquals(list.size(), 1, "Wrong MinMaxSpecification");
    }

    @Test
    public void test_2() throws WrongInputParam {
        Repository repository = new Repository();
        Point a = new Point(1, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(3, 0, 4);
        Point d = new Point(2, 6, 1);

        Tetrahedron tetrahedron1 = new Tetrahedron(a, b, c, d);

        Point a2 = new Point(0, 0, 0);
        Point b2 = new Point(6, 0, 0);
        Point c2 = new Point(3, 0, 4);
        Point d2 = new Point(2, 6, 1);

        Tetrahedron tetrahedron2 = new Tetrahedron(a2, b2, c2, d2);

        repository.addShape(tetrahedron1);
        repository.addShape(tetrahedron2);

        FirstXCoordinatesSort firstXCoordinatesSort = new FirstXCoordinatesSort();
        List<Tetrahedron> list = repository.query(firstXCoordinatesSort);

        Assert.assertEquals(list.get(0).getPointA().getX(), 0, "wrong FirstXCoordinatesSort");
    }
}
