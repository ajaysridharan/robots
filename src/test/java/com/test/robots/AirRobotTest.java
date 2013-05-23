package com.test.robots;


import com.test.robots.Util.RobotOperations;
import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AirRobotTest {
    private Robot robot;
    private Position position;
    private RobotOperations operations;

    @Before
    public void setUp() {
        position = mock(Position.class);
        operations = mock(RobotOperations.class);
        robot = new AirRobot(position, Direction.N, operations);
    }

    @Test
    public void shouldTurnRightProperly() {
        when(position.toString()).thenReturn("0, 0, 0");
        robot = new AirRobot(position, Direction.N, operations);
        when(operations.getTurnDirection(any(Direction.class), anyBoolean())).thenReturn(Direction.N);
        robot.turnRight();
        verify(operations).getTurnDirection(Direction.N, true);
        assertEquals("position is: 0, 0, 0 and direction is N", robot.getPosition());
    }

    @Test
    public void shouldTurnLeftProperly() {
        when(position.toString()).thenReturn("0, 0, 0");
        when(operations.getTurnDirection(any(Direction.class), anyBoolean())).thenReturn(Direction.W);
        robot = new AirRobot(position, Direction.N, operations);
        robot.turnLeft();
        verify(operations).getTurnDirection(Direction.N, false);
        assertEquals("position is: 0, 0, 0 and direction is W", robot.getPosition());
    }

    @Test
    public void shouldMoveForwardInYAxisProperly() {
        when(position.toString()).thenReturn("0, 5, 0");
        when(position.getY()).thenReturn(1);
        when(operations.moveInGround(anyInt(), anyBoolean())).thenReturn(5);
        robot = new AirRobot(position, Direction.N, operations);
        robot.moveForward();
        verify(operations).moveInGround(1, true);
        assertEquals("position is: 0, 5, 0 and direction is N", robot.getPosition());
    }

    @Test
    public void shouldMoveForwardInXAxisProperly() {
        when(position.toString()).thenReturn("0, 15, 0");
        when(position.getX()).thenReturn(10);
        when(operations.moveInGround(anyInt(), anyBoolean())).thenReturn(15);
        robot = new AirRobot(position, Direction.W, operations);
        robot.moveForward();
        verify(operations).moveInGround(10, true);
        assertEquals("position is: 0, 15, 0 and direction is W", robot.getPosition());
    }

    @Test
    public void shouldMoveBackwardInYAxisProperly() {
        when(position.toString()).thenReturn("5, 0, 0");
        when(position.getY()).thenReturn(1);
        when(operations.moveInGround(anyInt(), anyBoolean())).thenReturn(5);
        robot = new AirRobot(position, Direction.N, operations);
        robot.moveBackward();
        verify(operations).moveInGround(1, false);
        assertEquals("position is: 5, 0, 0 and direction is N", robot.getPosition());
    }

    @Test
    public void shouldMoveBackwardInXAxisProperly() {
        when(position.toString()).thenReturn("15, 0, 0");
        when(position.getX()).thenReturn(10);
        when(operations.moveInGround(anyInt(), anyBoolean())).thenReturn(15);
        robot = new AirRobot(position, Direction.W, operations);
        robot.moveBackward();
        verify(operations).moveInGround(10, false);
        assertEquals("position is: 15, 0, 0 and direction is W", robot.getPosition());
    }

    @Test
    public void shouldMoveHigherProperly() {
        when(position.toString()).thenReturn("0, 5, 1");
        when(position.getZ()).thenReturn(1);
        when(operations.moveInAir(anyInt(), anyBoolean())).thenReturn(5);
        robot = new AirRobot(position, Direction.N, operations);
        robot.moveHigher();
        verify(operations).moveInAir(1, true);
        assertEquals("position is: 0, 5, 1 and direction is N", robot.getPosition());
    }

    @Test
    public void shouldMoveLowerProperly() {
        when(position.toString()).thenReturn("0, 5, -10");
        when(position.getZ()).thenReturn(0);
        when(operations.moveInAir(anyInt(), anyBoolean())).thenReturn(-10);
        robot = new AirRobot(position, Direction.N, operations);
        robot.moveLower();
        verify(operations).moveInAir(0, false);
        assertEquals("position is: 0, 5, -10 and direction is N", robot.getPosition());
    }
}
