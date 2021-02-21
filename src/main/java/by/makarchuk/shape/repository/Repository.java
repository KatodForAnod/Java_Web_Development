package by.makarchuk.shape.repository;

import by.makarchuk.shape.action.CalculateFigureArea;
import by.makarchuk.shape.entity.Tetrahedron;
import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.repository.specifacation.Specification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private static final Logger logger = Logger.getLogger(Repository.class);
    private Warehouse warehouse;
    private List<Tetrahedron> shapes;

    public Repository() {
        logger.info("created repository");
        warehouse = Warehouse.getInstance();
        shapes = new ArrayList<>();
    }

    public List<Tetrahedron> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public boolean addShape(Tetrahedron tetrahedron) {
        boolean successful = true;
        try {
            Double area = CalculateFigureArea.calculateTetrahedronArea(tetrahedron.getPointA(),
                    tetrahedron.getPointB(),
                    tetrahedron.getPointC(),
                    tetrahedron.getPointD());
            warehouse.addArea(tetrahedron.getId(), area);
            shapes.add(tetrahedron);
        } catch (WrongInputParam e) {
            logger.error("addShape: invalid figure", e);
            e.printStackTrace();
            successful = false;
        }

        return successful;
    }

    public void removeShape(int index) throws WrongInputParam {
        if (index < 0 || index >= shapes.size()) {
            logger.error("removeShape: wrong prams");
            throw new WrongInputParam("wrong params");
        }
        Tetrahedron tetrahedron = shapes.remove(index);
        warehouse.removeArea(tetrahedron.getId());
    }

    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> list = shapes.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());

        return list;
    }

    public List<Tetrahedron> query(Comparator<Tetrahedron> comparator) {
        List<Tetrahedron> list = shapes.stream().sorted(comparator).collect(Collectors.toList());

        return list;
    }
}
