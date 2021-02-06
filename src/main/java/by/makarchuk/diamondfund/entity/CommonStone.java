package by.makarchuk.diamondfund.entity;

import java.time.LocalDateTime;

public class CommonStone extends Stone {
    public CommonStone(LocalDateTime dateDiscovery, String name, Double weightGrm, String origin, Color color) {
        super(dateDiscovery, name, weightGrm, origin, color);
    }
}
