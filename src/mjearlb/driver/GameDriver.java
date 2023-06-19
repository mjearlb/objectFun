package mjearlb.driver;

import java.util.Scanner;
import java.io.FileNotFoundException;

import mjearlb.maps.TestMap;
import mjearlb.game.Map;
import mjearlb.game.character.Player;
import mjearlb.game.character.Stats;
import mjearlb.game.character.NonPlayableCharacter;
import mjearlb.writer.ReadFromFile;
import static mjearlb.writer.ReadFromFile.readFromFile;

/**
 * Main driver program for the game.
 */
public class GameDriver {

    private static Scanner keyboard = new Scanner(System.in);
    private static boolean playing;
    private static String choice;
    public static TestMap map;
    private static Player player;

    public static void main(String[] args) {
        playing = true;
        getPlayer();
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
        map = new TestMap();
    } // initObjects

    /**
     * Checks the choice that the player makes.
     */
    private static void checkChoice() {
        switch (choice) {
        case "help":
            printHelp();
            break;
        case "map":
            map.dispMap();
            break;
        case "w":
            playerWalk();
            break;
        case "s":
            playerWalk();
            break;
        case "a":
            playerWalk();
            break;
        case "d":
            playerWalk();
            break;
	case "inv":
	    investigate();
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
        boolean choosePlayer = true;
        String playerChoice = "";
        while (choosePlayer) {
            System.out.println("Load character or use default?\nTo choose, type " +
                "\"load\" or \"default\":");
            playerChoice = keyboard.nextLine();
            if (playerChoice.equalsIgnoreCase("load")) {
                boolean validName = false;
                while (!validName) {
                    System.out.println("What is the name of your character?");
                    String playerName = keyboard.nextLine();
                    try {
                        player = readFromFile(playerName, Player.class);
                        validName = true;
                        choosePlayer = false;
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: file not found");
                    } // catch
                } // while
            } else if (playerChoice.equalsIgnoreCase("default")) {
                player = new Player();
                player.setName("Dave");
		player.setClass("human"); 
                choosePlayer = false;
            } else {
                System.out.println("Error: invalid choice!");
            } // if/else
        } // while
        System.out.println(player);
    } // getPlayer

    /**
     * Prints the options available to the character.
     */
    private static void printHelp() {
        System.out.println("Help menu:\nhelp: displays valid options\n" +
            "w: moves up one square\n" +
            "s: moves down one square\n" +
            "a: moves left one square\n" +
            "d: moves right one square\n" +
            "map: displays the map\n" +
	    "inv: investigate the current tile");
    } // printHelp

    /**
     * Determines if the player can move. If so, then then runs the
     * correct move method.
     */
    private static void playerWalk() {
        switch (choice) {
        case "w":
            try {
                map.walkUp(map.map[map.currCoords[0] - 1][map.currCoords[1]]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: cannot walk out of bounds");
            } // try/catch
            break;
        case "s":
            try {
                map.walkDown(map.map[map.currCoords[0] + 1][map.currCoords[1]]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: cannot walk out of bounds");
            } // try/catch
            break;
        case "a":
            try {
                map.walkLeft(map.map[map.currCoords[0]][map.currCoords[1] - 1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: cannot walk out of bounds");
            } // try/catch
            break;
        case "d":
            try {
                map.walkRight(map.map[map.currCoords[0]][map.currCoords[1] + 1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: cannot walk out of bounds");
            } // try/catch
            break;
        default:
            System.out.println("Error: cannot walk here!");
        } // switch
        map.dispMap();
    } // playerWalk

    /**
     * Allows players to investigate their current location on the map. 
     */
    private static void investigate() {
	map.investMap(player.stats.perception); 
    } // investigate

} // GameDriver
