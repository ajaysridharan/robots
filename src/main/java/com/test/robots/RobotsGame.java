package com.test.robots;

import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;

/**
 *
 */
public class RobotsGame {
    public static void main (String args[]) {
        if (args.length == 2) {
            if (args[0].equals("ground")) {
                Robot robot = new GroundRobot(new Position(0,0,0), Direction.N);
                for (char c : args[1].toCharArray()) {
                    switch (c) {
                        case 'R' :
                            robot.turnRight();
                            break;
                        case 'L' :
                            robot.turnRight();
                            break;
                        case 'F' :
                            robot.moveForward();
                            break;
                        case 'B' :
                            robot.moveBackward();
                            break;
                        default:
                            System.out.println("Unsupported move encountered: " + c);
                            break;
                    }
                }
                System.out.println(robot.getPosition());
            }
        }
    }
}
