package mjearlb.driver;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import mjearlb.maps.TestMap;
import mjearlb.maps.Map;
import mjearlb.game.character.Player;
import mjearlb.game.character.Stats;
import mjearlb.game.character.NonPlayableCharacter;
import mjearlb.writer.ReadFromFile;
import static mjearlb.writer.ReadFromFile.readFromFile;
import mjearlb.writer.WriteToFile;
import static mjearlb.writer.WriteToFile.writeToFile; 

/**
 * Main driver program for the game.
 */
public class GameDriver {

    private static Scanner keyboard = new Scanner(System.in);
    private static boolean playing;
    private static String choice;
    public static TestMap map;
    private static Player player;
    private static String userName; 

    public static void main(String[] args) {
        playing = true;
        getPlayer();
        initObjects();
	printHelp(); 
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
	case "int":
	    interact();
	    break;
	case "me":
	    System.out.println("Inventory:\n" + player.inventory + "\nEquipment: \n" + player.equipment);
	    break;
	case "equip":
	    equipItem(); 
	    break;
	case "save":
	    saveCharacter();
	    break; 
        default:
            System.out.println("Error: not a valid option");
        } // switch
    } // checkChoice

    /**
     * Sets the player's player object. 
     */
    private static void getPlayer() {
        boolean choosePlayer = true;
        String playerChoice = "";
        while (choosePlayer) {
            System.out.println("Load character or use default?\nTo choose, type " +
                "\"load\" or \"default\":");
            playerChoice = keyboard.nextLine();
            if (playerChoice.equalsIgnoreCase("load")) {
		loadPlayer();
		choosePlayer = false; 
            } else if (playerChoice.equalsIgnoreCase("default")) {
		userName = "gr8Icc"; 
                player = new Player();
                player.setName("Icculus");
		player.setClass("wizard"); 
                choosePlayer = false;
            } else {
                System.out.println("Error: invalid choice!");
            } // if/else
        } // while
        System.out.println(player);
    } // getPlayer

    /**
     * Loads the player's player data from a file. 
     */
    private static void loadPlayer() {
	try {
	    System.out.println("What is the unique username of your character?");
	    userName = keyboard.nextLine();
	    player = readFromFile(userName, Player.class);
	} catch (FileNotFoundException e) {
	    System.out.println("Error: file not found.\nPlease enter username again: ");
	    loadPlayer();
	} // catch
    } // loadPlayer

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
	    "inv: investigate the current tile\n" + 
	    "int: interact with the current tile\n" +
	    "me: displays player's inventory and equipment\n" +
	    "equip: equip a piece of equipment from current inventory\n" +
	    "save: save your current character");
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
	map.investMap(player.stats); 
    } // investigate

    /**
     * Allows players to interact with their current tile on the map. 
     */
    private static void interact() {
	map.tileInteract(player); 
    } // interact

    /**
     * Allows player to 'equip' an item from their inventory.
     * Must be a {@code Wearable} {@code Item}. Adds {@code Item}
     * to their {@code equipment} 
     */
    private static void equipItem() {
	System.out.println("What item would you like to equip?");
	System.out.println("Inventory:\n" + player.inventory + "\nEquipment: \n" + player.equipment);
	String item = keyboard.nextLine();
	player.equipWearable(map.rustyHelm); 
    } // equipItem

    /**
     * 
     */
    private static void saveCharacter() {
	try {
	    writeToFile(player, userName, true);
	} catch (FileAlreadyExistsException e) {
	    System.err.println(e);
	} // try/catch
    } // saveCharacter

} // GameDriver
