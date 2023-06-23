package mjearlb.game.containers;

import java.util.LinkedList;
import mjearlb.game.items.Item;
import mjearlb.game.containers.Container;

/**
 * Container is a LinkedList that holds Item objects. 
 */
public abstract class Container<T extends Item> extends LinkedList<T> {

    protected int maxSize;

    /**
     * Constructs the Inventory object, a LinkedList bound by (@code maxSize}.
     * 
     * @param size the size of the Inventory.
     */ 
    public Container(int size) {
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

    @Override
    public String toString() {
	return super.toString();
    } // toString

} // Container
