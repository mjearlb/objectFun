package mjearlb.game.character;

import mjearlb.game.character.Character;

/**
 * Creates Player object.
 */
public class Player extends Character {

    /**
     * Creates an instance of the Player character.
     * Defaults to 10 inventory slots. 
     */
    public Player() {
	super(10); 
	this.isPlayer = true;
    } // Player

} // Player
