package mjearlb.game.items;

/**
 * Is an object that can be placed in a
 * character's inventory.
 */
public class Item extends Object {

    private int id;

    /**
     * Creates an Item Object with no id. .
     */
    public Item() {
        super();
    } // Item

    /**
     * Creates an Item Object.
     *
     * @param id the id of the item.
     */
    public Item(int id) {
        super();
        this.id = id;
    } // Item

    /**
     * Allows for changing of the item id.
     *
     * @param id the id of the item.
     */
    public void setId(int id) {
        this.id = id;
    } // setId

    /**
     * Allows for retrieval of the item's id.
     *
     * @return the {@code id} of the item.
     */
    public int getId() {
        return this.id;
    } // getId

} // Item
