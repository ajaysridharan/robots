package com.test.robots.Util;

import com.test.robots.bean.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class RobotOperationsTest {
    private RobotOperations operations;

    @Before
    public void setUp() {
        operations = new RobotOperations();
    }

    @Test
    public void shouldReturnTurnDirectionForProperInputs() {
        Direction actual1 = operations.getTurnDirection(Direction.N, true);
        Direction actual2 = operations.getTurnDirection(Direction.E, false);
        assertEquals(Direction.E, actual1);
        assertEquals(Direction.N, actual2);
    }

    @Test
    public void shouldReturnDefaultTurnDirectionForNullInput() {
        Direction actual = operations.getTurnDirection(null, true);
        assertEquals(Direction.N, actual);
    }

    @Test
    public void shouldReturnGroundPositionForProperInputs() {
        int actual1 = operations.moveInGround(10, true);
        int actual2 = operations.moveInGround(70, false);
        assert 11 == actual1;
        assert 69 == actual2;
    }

    @Test
    public void shouldReturnGroundPositionForBigInput() {
        int actual1 = operations.moveInGround(700000000, true);
        assert 700000001 == actual1;
    }

    @Test
     public void shouldReturnAirPositionForProperInputs() {
        int actual1 = operations.moveInAir(10, true);
        int actual2 = operations.moveInAir(70, false);
        assert 20 == actual1;
        assert 60 == actual2;
    }

    @Test
    public void shouldReturnAirPositionForBigInput() {
        int actual1 = operations.moveInAir(700000000, true);
        assert 700000010 == actual1;
    }

}
