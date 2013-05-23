package com.test.robots;

/**
 * This class serves as a command line facade for the game play.
 *
 * @author Ajay Sridharan
 */
public class RobotsGameFacade {
    public static void main (String args[]) {
        System.out.println(new GamePlayer().playAndGetRobotPosition(args));
    }
}
