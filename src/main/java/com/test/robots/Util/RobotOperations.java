package com.test.robots.Util;

import com.test.robots.bean.Direction;

/**
 * This class defines the logic behind some of the common operations for robots.
 *
 * @author Ajay Sridharan
 */
public class RobotOperations {
    private static final int MOVE_GROUND_DISTANCE = 1;
    private static final int MOVE_AIR_DISTANCE = 10;

    /**
     * This method returns a direction based on the current status and the input.
     * @param current The current direction of a robot.
     * @param isRightTurn Indicates if the robot needs to turn right or left.
     * @return The new direction that a robot needs to face
     */
    public Direction getTurnDirection(Direction current, boolean isRightTurn) {
        Direction result = Direction.N;
        if (current != null) {
            switch (current) {
                case N:
                    if (isRightTurn) {
                        result = Direction.E;
                    } else {
                        result = Direction.W;
                    }
                    break;
                case E:
                    if (isRightTurn) {
                        result = Direction.S;
                    } else {
                        result = Direction.N;
                    }
                    break;
                case S:
                    if (isRightTurn) {
                        result = Direction.W;
                    } else {
                        result = Direction.E;
                    }
                    break;
                case W:
                    if (isRightTurn) {
                        result = Direction.N;
                    } else {
                        result = Direction.S;
                    }
                    break;

                default:
                    break;
            }
        }
        return result;
    }

    /**
     * This method moves a robot on the ground based on the current position and the nature of the move.
     * @param currentPosition The current position of a robot in a (x,y,z) grid.
     * @param isForward Indicates if the robot needs to move forward or backward.
     * @return The new position that a robot needs to move.
     */
    public int moveInGround(int currentPosition, boolean isForward) {
        int result = 0;
        if (isForward) {
            result = currentPosition + MOVE_GROUND_DISTANCE;
        } else {
            result = currentPosition - MOVE_GROUND_DISTANCE;
        }
        return result;
    }

    /**
     * This method moves a robot on the air based on the current position and the nature of the move.
     * @param currentPosition The current position of a robot in a (x,y,z) grid.
     * @param isUp Indicates if the robot needs to move higher or lower.
     * @return The new position that a robot needs to move.
     */
    public int moveInAir(int currentPosition, boolean isUp) {
        int result = 0;
        if (isUp) {
            result = currentPosition + MOVE_AIR_DISTANCE;
        } else {
            result = currentPosition - MOVE_AIR_DISTANCE;
        }
        return result;
    }
}
