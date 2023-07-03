package mjearlb.game.items;

import mjearlb.game.items.Item;

public class Equipment extends Item {

    int defense;
    String type;
    static final String types[] = {"helmet", "chestplate", "pants", "boots", "weapon"}; 

    /**
     * Creates a wearable item. 
     *
     * @param name the name of the item.
     * @param defense the amount of defense that the item provided.
     * @param typeId the type of wearable.
     */
    public Equipment(String name, int defense, int typeId) {
	super(name);
	this.defense = defense;
	setType(typeId); 
    } // Wearable

    /**
     * Sets the {@code type} of the Equipment. 
     *
     * @param typeId the ID of the type of Equipment it is. 
     */
    private void setType(int typeId) {
	this.type = types[typeId]; 
    } // setType

    @Override
    public String toString() {
	return this.name + " - Defense: " + this.defense; 
    } // toString

} // Wearable
