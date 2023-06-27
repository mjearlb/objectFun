package mjearlb.game.character;

import mjearlb.game.character.Character;

/**
 * Creates NonPlayableCharacter object.
 */
public class NonPlayableCharacter extends Character {

    public boolean sells; 

    /**
     * Creates an NPC. 
     *
     * @param invSize the size of the NPC's Inventory.
     * @param sells whether or not the NPC has things to sell. 
     */
    public NonPlayableCharacter(int invSize, boolean sells) {
	super(invSize);
	this.isPlayer = false;
	this.sells = sells; 
    } // NonPlayableCharacter

    /**
     * Creates an NPC. Defaults {@code sells} to {@code false}. 
     *
     * @param invSize the size of the NPC's Inventory.
     */
    public NonPlayableCharacter(int invSize) {
        super(invSize);
        this.isPlayer = false;
        this.sells = sells;
    } // NonPlayableCharacter      

    /**
     *
     */
    public void interactWithNPC() {

    } // interactWithNPC

    /**
     * Allows {@code sells} to be changed.
     *
     * @param sells what {@code sells} will be set to. 
     */
    public void setSells(boolean sells) {
	this.sells = sells; 
    } // setSells

} // NonPlayableCharacter
