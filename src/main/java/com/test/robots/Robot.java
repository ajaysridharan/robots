package com.test.robots;

/**
 *
 */
public interface Robot {

    public void turnRight();
    public void turnLeft();
    public void moveForward();
    public void moveBackward();
    public void moveHigher();
    public void moveLower();
    public String getPosition();
}
