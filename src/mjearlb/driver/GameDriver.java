package mjearlb.driver;

import mjearlb.maps.TestMap;
import mjearlb.game.Map;
import mjearlb.game.Player;
import mjearlb.game.NonPlayableCharacter;

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
        TestMap outside = new TestMap();
        getPlayer();
        getNPCs();
    } // initObjects

    /**
     * Finds and initializes the player's character object.
     *
     * TO DO: figure out how to store and retrieve the player's
     * character object
     */
    public static void getPlayer() {
        Player player = new Player();
        player.setName("player");
        player.setId(20);
        player.setIsPlayer(true);
    } // getPlayer

    /**
     * Creates all NPC's.
     */
    private static void getNPCs() {
        NonPlayableCharacter ted = new NonPlayableCharacter();
        ted.setName("Ted");
        ted.setId(5);
        ted.setIsPlayer(false);
    } // getNPCs

} // GameDriver
