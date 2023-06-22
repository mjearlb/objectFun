package mjearlb.game.character;

import mjearlb.game.character.Character;

/**
 * Creates Player object.
 */
public class Player extends Character {

    Inventory<Wearable> equipment; 

    /**
     * Creates an instance of the Player character.
     * Defaults to 10 inventory slots. 
     */
    public Player() {
	super(10); 
	this.isPlayer = true;
	equipment = new Inventory<Wearable>(4); 
    } // Player

    /**
     * Allows {@code Player} to equip a {@code Wearable} {@code Item}.
     *
     * @param item the {@code item} to be equipped. 
     */
    public void equipWearable(Wearable item) {
	this.inventory.remove(item);
	this.equipment.add(item); 
    } // wearItem

    /**
     * Allows {@code Player} to unequip a {@code Wearable} {@code Item}.
     *
     * @param item the {@code item} to be unequipped. 
     */
    public void unequipWearable(Wearable item) {
	this.equipment.remove(item);
	this.inventory.add(item);
    } // unwearItem

} // Player
