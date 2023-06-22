package mjearlb.game.items.wearables;

import mjearlb.game.items.Item;

public abstract class Wearable extends Item {

    int defense; 

    /**
     * Creates a wearable item. 
     *
     * @param name the name of the item.
     * @param defense the amount of defense that the item provided. 
     */
    public Wearable(String name, int defense) {
	super(name);
	this.defense = defense; 
    } // Wearable

} // Wearable
