package com.test.robots;

/**
 *
 */
public interface Robot {
    /**
     * This method moves a robot to the right on the ground in a (x, y, z) grid.
     */
    public void turnRight();
    /**
     * This method moves a robot to the left on the ground in a (x, y, z) grid.
     */
    public void turnLeft();
    /**
     * This method moves a robot forward on the ground in a (x, y, z) grid.
     */
    public void moveForward();
    /**
     * This method moves a robot backward on the ground in a (x, y, z) grid.
     */
    public void moveBackward();
    /**
     * This method moves a robot higher in the air in a (x, y, z) grid.
     */
    public void moveHigher();
    /**
     * This method moves a robot lower in the air in a (x, y, z) grid.
     */
    public void moveLower();
    /**
     * This method returns the position of the robot in a (x, y, z) grid.
     */
    public String getPosition();
}
