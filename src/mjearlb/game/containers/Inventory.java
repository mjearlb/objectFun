package mjearlb.game.containers;

import java.util.LinkedList;
import mjearlb.game.items.Item;
import mjearlb.game.containers.Container; 

/**
 * Inventory will be something that each character has
 * to store their items.
 */
public class Inventory<T extends Item> extends Container<T> {

    /**
     * Constructs the Inventory object, a LinkedList bound by {@code maxSize}.
     *
     * @param size the size of the Inventory. 
     */
    public Inventory(int size) {
	super(size);
    } // Inventory
	
    /**
     * Changes the character's inventory size.
     *
     * @param size the new size of the inventory.
     */
    public void changeInvSize(int size) {
        this.maxSize = size;
    } // changeInvSize

    @Override
    public String toString() {
        return "Inventory:\n" + super.toString();
    } // toString 

} // Inventory
