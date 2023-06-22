package mjearlb.game;

import java.util.LinkedList;
import mjearlb.game.items.Item;

/**
 * Inventory will be something that each character has
 * to store their items.
 */
public class Inventory<T extends Item> extends LinkedList<T> {

    private int maxSize; 

    /**
     * Constructs the Inventory object, a LinkedList bound by {@code maxSize}.
     *
     * @param size the size of the Inventory. 
     */
    public Inventory(int size) {
	super();
	this.maxSize = size; 
    } // Inventory

    /**
     * Adds an {@code item} to the chest, but only after making sure
     * that it will fit.
     * 
     * @param item the item to be added.
     */
    @Override
    public boolean add(T item) {
        if (this.size() > this.maxSize) {
            return false;
        } else {
            return super.add(item);
        } // if/else
    } // add
	
    /**
     * Allows for easy display of all objects in inventory.
     *
     * @return the Inventory contents in a String.
     */
    public String toString() {
        return "Inventory: " + super.toString();
    } // toString

    /**
     * Changes the character's inventory size.
     *
     * @param size the new size of the inventory.
     */
    public void changeInvSize(int size) {
        this.maxSize = size;
    } // changeInvSize  

} // Inventory
