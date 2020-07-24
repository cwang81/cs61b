package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(1);
        assertEquals(1, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.move();
        assertEquals(0.97, c.energy(), 0.001);
        c.move();
        assertEquals(0.94, c.energy(), 0.001);
        c.stay();
        assertEquals(0.93, c.energy(), 0.001);
        c.stay();
        assertEquals(0.92, c.energy(), 0.001);
    }

    @Test
    public void testReplicate() {
        /**
         * fraction of energy to retain when replicating.
         */
        double repEnergyRetained = 0.5;
        /**
         * fraction of energy to bestow upon offspring.
         */
        double repEnergyGiven = 0.5;
        Clorus c = new Clorus(1);
        double expectedEnergy = c.energy() * repEnergyRetained * repEnergyGiven;
        Clorus cBaby = c.replicate();
        double actualEnergy = cBaby.energy();
        assertNotEquals(c, cBaby);
        assertEquals(expectedEnergy, actualEnergy, 0.001);
    }

    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(1.0);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        // Attack the Plip if there is empty space nearby.
        c = new Clorus(1.0);
        HashMap<Direction, Occupant> topPlip = new HashMap<Direction, Occupant>();
        topPlip.put(Direction.TOP, new Plip(1.0));
        topPlip.put(Direction.BOTTOM, new Impassible());
        topPlip.put(Direction.LEFT, new Empty());
        topPlip.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(topPlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(expected, actual);

        // Do not attack the Plip if there is no empty space nearby.
        c = new Clorus(1.0);
        HashMap<Direction, Occupant> topPlipNoEmptySpace = new HashMap<Direction, Occupant>();
        topPlipNoEmptySpace.put(Direction.TOP, new Plip(1.0));
        topPlipNoEmptySpace.put(Direction.BOTTOM, new Impassible());
        topPlipNoEmptySpace.put(Direction.LEFT, new Impassible());
        topPlipNoEmptySpace.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(topPlipNoEmptySpace);
        expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(1.0);
        HashMap<Direction, Occupant> allEmpty = new HashMap<Direction, Occupant>();
        allEmpty.put(Direction.TOP, new Empty());
        allEmpty.put(Direction.BOTTOM, new Empty());
        allEmpty.put(Direction.LEFT, new Empty());
        allEmpty.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(allEmpty);
        Action unexpected = new Action(Action.ActionType.STAY);

        assertNotEquals(unexpected, actual);


        // We don't have Cloruses yet, so we can't test behavior for when they are nearby right now.
    }
}
