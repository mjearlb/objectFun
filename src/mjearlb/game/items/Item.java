package mjearlb.game.items;

/**
 * Is an object that can be placed in a
 * character's inventory.
 */
public abstract class Item extends Object {

    private int id;
    public String name; 

    /**
     * Creates an Item Object with no id. .
     */
    public Item(String name) {
        super();
	this.name = name; 
    } // Item

    /**
     * Allows for setting of the name of the {@code Item}. 
     *
     * @param name the name of the {@code Item}.
     */
    public void setName(String name) {
	this.name = name; 
    } // setName

} // Item
