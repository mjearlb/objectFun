package mjearlb.driver;

import mjearlb.game.Map;
import mjearlb.game.Character;

/**
 * Main driver program for the game.
 */
public class GameDriver {

    public static void main(String[] args) {
        initObjects();
    } // main

    /**
     * Initializes the objects that will be used
     * by the game during runtime.
     */
    public static void initObjects() {
        Map map = new Map();
    } // initObjects

} // GameDriver
