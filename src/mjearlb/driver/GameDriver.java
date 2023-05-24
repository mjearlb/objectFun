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
        Map outside = new Map(5,5);
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
        Character player = new Character();
        player.setName("player");
        player.setId(20);
        player.setIsPlayer(true);
    } // getPlayer

    /**
     * Creates all NPC's.
     */
    private static void getNPCs() {
        Character ted = new Character();
        ted.setName("Ted");
        ted.setId(5);
        ted.setIsPlayer(false);
    } // getNPCs

} // GameDriver
