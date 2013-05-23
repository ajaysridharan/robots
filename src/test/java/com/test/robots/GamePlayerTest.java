package com.test.robots;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class GamePlayerTest {
    private GamePlayer gamePlayer;

    @Before
    public void setUp() {
        gamePlayer = new GamePlayer();
    }

    @Test
    public void shouldReturnProperPositionForGroundRobot() {
        String expected = "position is: 0, 2, 0 and direction is E";
        String actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("ground FFR", " "));
        assertEquals(expected, actual);
        expected = "position is: 8, 4, 0 and direction is N";
        actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("ground RFFFFLLFFFFRFFFF", " "));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnProperPositionForAirRobot() {
        String expected = "position is: 0, 2, 10 and direction is E";
        String actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("air FFRU", " "));
        assertEquals(expected, actual);
        expected = "position is: 3, 0, 10 and direction is S";
        actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("air URFFFLLLUUUDDD", " "));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMessageForImproperInput() {
        String expected = "Unsupported input. Sample usage: java -jar ground FFR";
        String actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("air ground FFRU", " "));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMessageForInvalidRobot() {
        String expected = "The supported robots are 'air' and 'ground'. Sample usage: ground FFR";
        String actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("sea FFRU", " "));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnProperPositionForGroundRobotEvenWhenInvalidOperationIsEncountered() {
        String expected = "Unsupported move encountered: P\n" +
                "position is: 0, 2, 0 and direction is E";
        String actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("ground FFPR", " "));
        assertEquals(expected, actual);
        expected = "Unsupported move encountered: O\n" +
                "position is: 8, 4, 0 and direction is N";
        actual = gamePlayer.playAndGetRobotPosition(StringUtils.split("ground RFFFFLLFOFFFRFFFF", " "));
        assertEquals(expected, actual);
    }

}
