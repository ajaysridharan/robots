package com.test.robots;


import com.test.robots.Util.RobotOperations;
import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;

/**
 * This class is used for playing with different robots.
 *
 * @author Ajay Sridharan
 */
public class GamePlayer {

    /**
     * This method is used to play with the different robots based on user commands.
     * @param args The commands based on which a robot needs to be moved
     * @return The current position of a robot based on the inout commands or a message for invalid/improper inputs
     */
    public String playAndGetRobotPosition(String args[]) {
        String result = "";
        if (args.length == 2) {
            Robot robot = null;
            RobotOperations operations = new RobotOperations();
            if (args[0].equals("ground")) {
                robot = new GroundRobot(new Position(0,0,0), Direction.N, operations);
            } else if (args[0].equals("air")) {
                robot = new AirRobot(new Position(0,0,0), Direction.N, operations);
            } else {
                result = "The supported robots are 'air' and 'ground'. Sample usage: ground FFR";
            }
            if (robot != null) {
                for (char c : args[1].toCharArray()) {
                    switch (c) {
                        case 'R' :
                            robot.turnRight();
                            break;
                        case 'L' :
                            robot.turnLeft();
                            break;
                        case 'F' :
                            robot.moveForward();
                            break;
                        case 'B' :
                            robot.moveBackward();
                            break;
                        case 'U' :
                            robot.moveHigher();
                            break;
                        case 'D' :
                            robot.moveLower();
                            break;
                        default:
                            result += "Unsupported move encountered: " + c + "\n";
                            break;
                    }
                }
                result += robot.getPosition();
            }
        } else {
            result = "Unsupported input. Sample usage: java -jar ground FFR";
        }
        return result;
    }
}
