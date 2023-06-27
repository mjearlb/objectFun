package mjearlb.game.character;

import mjearlb.game.character.Stats;
import mjearlb.game.items.Item;
import mjearlb.game.containers.Inventory; 

/**
 * Basic character outline.
 */
public abstract class Character {

    protected boolean isPlayer;
    private String name;
    public String charClass;
    public Stats stats;
    public int money;
    public int defense; 
    public Inventory<Item> inventory; 

    /**
     * Creates the character object.
     *
     * @param size the size of the Character's inventory. 
     */
    public Character(int size) {
	this.money = 0;
	this.inventory = new Inventory<Item>(10);
	this.defense = 0; // defense is decided by the clothing that the character is wearing
    } // Character
    
    @Override
    public String toString() {
        return "Name: " + name + "\nMoney: " + money + "\nClass: " + charClass
            + "\n" + stats + "\nInventory: " + inventory;
    } // toString

    /**
     * Allows game to see whether character is a player or not.
     *
     * @return whether the character is a player or not.
     */
    public boolean getIsPlayer() {
        return this.isPlayer;
    } // getPlayer

    /**
     * Sets the value of isPlayer.
     *
     * @param isPlayer whether or not the character is a player.
     */
    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    } // setPlayer

    /**
     * Allows game to access character name.
     *
     * @return the {@code name} of the character.
     */
    public String getName() {
        return this.name;
    } // getName

    /**
     * Allows the user to set the name of the character.
     *
     * @param name the {@code name} of the character.
     */
    public void setName(String name) {
        this.name = name;
    } // setName

    /**
     * Sets the stats for the player's chosen class.
     *
     * @param charClass the class which the player wants to select.
     */
    public void setClass(String charClass) {
	this.charClass = charClass; 
        this.stats = new Stats(charClass);
    } // setClass

    /**
     * Adds money to the character's balance.
     *
     * @param amount the amount of money the character has. 
     */
    public void addMoney(int amount) {
	this.money += amount; 
    } // addMoney

} // Character
