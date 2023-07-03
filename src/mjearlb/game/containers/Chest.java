package mjearlb.game.containers;

import java.util.LinkedList;
import mjearlb.game.items.Item;
import mjearlb.game.containers.Container; 

public class Chest<T extends Item> extends Container<T> {

    /**
     * Creates a Chest object, which is a LinkedList bound by {@code size}.
     *
     * @param size the size of the chest. 
     */
    public Chest(int size) {
	super(size);
    } // Chest

    @Override
    public String toString() {
	return "Contents:\n" + super.toString();
    } // toString

} // Chest
