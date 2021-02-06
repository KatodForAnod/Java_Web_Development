package by.makarchuk.diamondfund.entity;

import java.time.LocalDateTime;

public class Stone {
    private LocalDateTime dateDiscovery;
    private String name;
    private Double carats;

    @Override
    public String toString() {
        return "stone";
    }
}
