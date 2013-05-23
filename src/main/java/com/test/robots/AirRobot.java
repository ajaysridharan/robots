package com.test.robots;


import com.test.robots.Util.RobotOperations;
import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;

/**
 * This class is the implementation of an air robot.
 *
 * @author Ajay Sridharan
 */
public class AirRobot implements Robot {
    private Position position;
    private Direction direction;
    private final RobotOperations operations;

    public AirRobot(Position position, Direction direction, RobotOperations operations) {
        this.position = position;
        this.direction = direction;
        this.operations = operations;
    }

    @Override
    public void turnRight() {
        direction = operations.getTurnDirection(direction, true);
    }

    @Override
    public void turnLeft() {
        direction = operations.getTurnDirection(direction, false);
    }

    @Override
    public void moveForward() {
        if (direction.equals(Direction.N) || direction.equals(Direction.S)) {
            position.setY(operations.moveInGround(position.getY(), true));
        }
        if (direction.equals(Direction.W) || direction.equals(Direction.E)) {
            position.setX(operations.moveInGround(position.getX(), true));
        }
    }

    @Override
    public void moveBackward() {
        if (direction.equals(Direction.N) || direction.equals(Direction.S)) {
            position.setY(operations.moveInGround(position.getY(), false));
        }
        if (direction.equals(Direction.W) || direction.equals(Direction.E)) {
            position.setX(operations.moveInGround(position.getX(), false));
        }
    }

    @Override
    public void moveHigher() {
        position.setZ(operations.moveInAir(position.getZ(), true));
    }

    @Override
    public void moveLower() {
        position.setZ(operations.moveInAir(position.getZ(), false));
    }

    @Override
    public String getPosition() {
        return "position is: " + position.toString() + " and direction is " + direction;
    }
}
