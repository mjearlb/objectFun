package mjearlb.game;

import java.util.LinkedList;
import mjearlb.game.items.Item;

public class Chest<T extends Item> extends LinkedList<T> {

    private int maxSize; 

    /**
     * Creates a Chest object, which is a LinkedList bound by {@code size}.
     *
     * @param size the size of the chest. 
     */
    public Chest(int size) {
	super();
	this.maxSize = size; 
    } // Chest

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

    @Override
    public String toString() {
	return "Contents:\n" + super.toString();
    } // toString

} // Chest
