package mjearlb.driver;

import java.util.Scanner;
import mjearlb.maps.TestMap;
import mjearlb.game.Map;
import mjearlb.game.character.Player;
import mjearlb.game.character.NonPlayableCharacter;

/**
 * Main driver program for the game.
 */
public class GameDriver {

    private static Scanner keyboard = new Scanner(System.in);
    private boolean playing;
    private String choice; 

    public static void main(String[] args) {
	playing = true; 
        initObjects();
	while (playing) {
	    choice = keyboard.nextLine();
	    checkChoice(); 
	} // while
    } // main

    /**
     * Initializes the objects that will be used
     * by the game during runtime.
     */
    private static void initObjects() {
        TestMap outside = new TestMap();
        getPlayer();
        getNPCs();
    } // initObjects

    /**
     * Checks the choice that the player makes. 
     */
    private static void checkChoice() {
	switch (choice) {
	case "help":
	    printHelp(); 
	    break; 
	default:
	    System.out.println("Error: not a valid option"); 
	} // switch
    } // checkChoice

    /**
     * Finds and initializes the player's character object.
     *
     * TO DO: figure out how to store and retrieve the player's
     * character object
     */
    private static void getPlayer() {
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

    private static void printHelp() {
	System.out.println("Help menu:\nhelp: displays valid options\n" +
			   "w: moves up one square\n" +
			   "s: moves down one square\n" +
			   "a: moves left one square\n" +
			   "d: moves right one square\n"); 
    } // printHelp

} // GameDriver
