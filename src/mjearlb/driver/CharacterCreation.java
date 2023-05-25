package mjearlb.driver;

import java.util.Scanner;
import mjearlb.game.Character;
import mjearlb.game.Player; 

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
        System.out.println("To change your name, type \"name\" " +
            "To finish character creation, enter \"done\".");
    } // displayOptions

    /**
     * Obtains value of the {@code choice} then takes the
     * appropriate action.
     */
    private static void checkChoice() {
        if (choice.equalsIgnoreCase("done")) {
            if ((name == null)) {
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
            displayCurrent();
        } else {
            System.out.println("Error: not a valid input!");
        } // if/else
    } // checkChoice

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
        System.out.println("Cannot save yet!");
    } // saveCharacter

} // CharacterCreation
