package mjearlb.driver;

import java.util.Scanner;
import mjearlb.game.character.Character;
import mjearlb.game.character.Player;
import mjearlb.game.character.Stats;
import mjearlb.writer.WriteToFile;
import static mjearlb.writer.WriteToFile.writeToFile; 

/**
 * Allows the player to create a custom character.
 */
public class CharacterCreation {

    private static Scanner keyboard = new Scanner(System.in);
    private static boolean cont;
    private static int id;
    private static String name;
    private static String choice;
    private static Player player;
    private static String classChoice;

    public static void main(String[] args) {
        player = new Player();
        player.setId(1983);

        cont = true;
        System.out.println("Hello! Welcome to the character creation "
            + "menu! Please select from the options below:");

        while (cont) {
            displayOptions();
            choice = keyboard.nextLine();
            checkChoice();
        } // while

    } // main

    /**
     * Displays the options available to the user.
     */
    private static void displayOptions() {
        System.out.println("To change the class of your character, type \"class\"\n"
            + "To change your character's name, type \"name\"\n"
            + "To see what you have already selected, type \"current\"\n"
            + "To finish character creation, enter \"done\".");
    } // displayOptions

    /**
     * Obtains value of the {@code choice} then takes the
     * appropriate action.
     */
    private static void checkChoice() {
        if (choice.equalsIgnoreCase("done")) {
            if (name == null || player.stats == null) {
                System.out.println("Error: cannot create unfinished character. "
                    + "Would you like to exit without saving? (y/n)");
                choice = keyboard.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    cont = false;
                } // if
            } else {
                System.out.println("Saving...");
                saveCharacter();
                cont = false;
            } // if/else
        } else if (choice.equalsIgnoreCase("name")) {
            System.out.println("Please enter your name");
            name = keyboard.nextLine();
            player.setName(name);
        } else if (choice.equalsIgnoreCase("class")) {
            chooseClass();
        } else if (choice.equalsIgnoreCase("current")) {
            displayCurrent();
        } else {
            System.out.println("Error: not a valid input!");
        } // if/else
    } // checkChoice

    /**
     * Allows user to select the class of their character.
     */
    private static void chooseClass() {
        System.out.println("\nPlease choose your class: " +
            "human, wizard, elf");
        classChoice = keyboard.nextLine();
        switch (classChoice) {
        case "human":
            player.stats = new Stats("human");
            player.charClass = "human";
            break;
        case "wizard":
            player.stats = new Stats("wizard");
            player.charClass = "wizard";
            break;
        case "elf":
            player.stats = new Stats("elf");
            player.charClass = "elf";
            break;
        default:
            System.out.println("Error: not a class");
            chooseClass();
        } // switch
    } // chooseClass

    /**
     * Displays current user selections.
     */
    private static void displayCurrent() {
        System.out.println(player);
    } // displayCurrent

    /**
     * Saves the created character's data.
     */
    private static void saveCharacter() {
        displayCurrent();
	String username = null; 
	while (username == null) {
	    System.out.print("Please enter a unique player username: ");
	    if (isUnique(username)) {
		    username = keyboard.nextLine();
	    } // if
	} // while
	writeToFile(player, username); 
    } // saveCharacter

    /**
     * Checks the uniqueness of the player's username.
     *
     * @return false if another file is found in resources/ with the same
     * name. 
     */
    private static boolean isUnique(String username) {
	return true; 
    } // isUnique

} // CharacterCreation
