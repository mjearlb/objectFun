package mjearlb.game.character;

import mjearlb.game.character.Character;

/**
 * Creates NonPlayableCharacter object.
 */
public class NonPlayableCharacter extends Character {

    /**
     * Creates an NPC. 
     *
     * @param invSize the size of the NPC's Inventory
     */
    public NonPlayableCharacter(int invSize) {
	super(invSize);
	this.isPlayer = false;
    } // NonPlayableCharacter

} // NonPlayableCharacter
