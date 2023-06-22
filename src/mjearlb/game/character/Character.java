package mjearlb.game.character;

import mjearlb.game.character.Stats;

/**
 * Basic character outline.
 */
public abstract class Character {

    private int id;
    protected boolean isPlayer;
    private String name;
    public String charClass;
    public Stats stats;
    public int money; 

    /**
     * Creates the character object.
     */
    public Character() {
	this.money = 0; 
    } // Character

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nisPlayer: " + isPlayer + "\nClass: " + charClass
            + "\n" + stats;
    } // toString

    /**
     * Allows access to the id of the character.
     *
     * @return the id of the character.
     */
    public int getId() {
        return this.id;
    } // getId

    /**
     * Sets the value of the character id.
     *
     * @param id the id number of the character being created.
     */
    public void setId(int id) {
        this.id = id;
    } // setId

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
