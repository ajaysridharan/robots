package com.test.robots;

import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;

/**
 *
 */
public class GroundRobot implements Robot {
    private Position position;
    private Direction direction;
    private static final int MOVE_GROUND_DISTANCE = 1;
    private static final int MOVE_AIR_DISTANCE = 10;

    public GroundRobot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void turnRight() {
        setTurnDirection(true);
    }

    @Override
    public void turnLeft() {
        setTurnDirection(false);
    }

    @Override
    public void moveForward() {
        moveInDirection(true);
    }

    @Override
    public void moveBackward() {
        moveInDirection(false);
    }

    @Override
    public void moveHigher() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void moveLower() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPosition() {
        return "position is: " + position.toString() + " and direction is " + direction;
    }

    private void setTurnDirection(boolean isRight) {
        switch (direction) {
            case N:
                if (isRight) {
                    direction = Direction.E;
                } else {
                    direction = Direction.W;
                }
                break;
            case E:
                if (isRight) {
                    direction = Direction.S;
                } else {
                    direction = Direction.N;
                }
                break;
            case S:
                if (isRight) {
                    direction = Direction.W;
                } else {
                    direction = Direction.E;
                }
                break;
            case W:
                if (isRight) {
                    direction = Direction.N;
                } else {
                    direction = Direction.S;
                }
                break;

            default:
                break;
        }
    }

    private void moveInDirection(boolean isForward) {
        if (direction.equals(Direction.N) || direction.equals(Direction.S)) {
            int tempY = position.getY();
            if (isForward) {
                position.setY(tempY + MOVE_GROUND_DISTANCE);
            } else {
                position.setY(tempY - MOVE_GROUND_DISTANCE);
            }
        }
        if (direction.equals(Direction.W) || direction.equals(Direction.E)) {
            int tempX = position.getX();
            if (isForward) {
                position.setX(tempX + MOVE_GROUND_DISTANCE);
            } else {
                position.setX(tempX - MOVE_GROUND_DISTANCE);
            }
        }
    }
}
