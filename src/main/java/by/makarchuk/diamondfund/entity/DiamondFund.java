package by.makarchuk.diamondfund.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiamondFund {
    private static final Logger logger = Logger.getLogger(DiamondFund.class);
    private List<Stone> stones = new ArrayList<>();

    public DiamondFund() {
    }

    public void setStones(List<Stone> stones) {
        logger.info("setStones input: " + stones);
        this.stones = stones;
    }

    public List<Stone> getStones() {
        logger.info("getStones");
        return Collections.unmodifiableList(stones);
    }

    public void addStone(Stone stone) {
        logger.info("addStone input: " + stone);
        stones.add(stone);
    }

    public void removeStone(Stone stone) {
        logger.info("removeStone input: " + stone);
        stones.remove(stone);
    }

    @Override
    public String toString() {
        StringBuilder infAbtStones = new StringBuilder();
        infAbtStones.append("DiamondFund{ stones: \n");

        for (Stone i : stones) {
            infAbtStones.append(i.toString()).append("\n");
        }
        infAbtStones.append("}");

        return infAbtStones.toString();
    }
}
