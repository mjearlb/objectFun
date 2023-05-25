package mjearlb.game;

import java.util.LinkedList;
import mjearlb.game.items.Item;

/**
 * Inventory will be something that each character has
 * to store their items.
 */
public class Inventory {

    private LinkedList<Item> items;

    /**
     * Thrown when the charater's inventory is full.
     */
    public class InventoryFullException extends Exception {

        /**
         * Creates the InventoryFullException object.
         *
         * @param message the message displayed when the exception is thrown.
         */
        public InventoryFullException(String message) {
            super(message);
        } // InventoryFullException
    } // InventoryFullException

    /**
     * Constructs the Inventory object.
     */
    public Inventory() {
        this.items = new LinkedList<Item>();
    } // Inventory

    /**
     * Adds one item to the inventory, capping it at
     * 10 items.
     *
     * @param item the item we are adding.
     */
    public void addItem(Item item) {
        if (items.size() >= 10) {
            System.out.println("Error: Cannot add more than 10 items to the inventory");
        } else {
            this.items.add(item);
        } // if/else
    } // addItem

    /**
     * Removes an item from the inventory.
     *
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    } // removeNode

    /**
     * Returns the requested item.
     *
     * @param index the index of the item being requested.
     * @return the item at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Item getItem(int index) throws IndexOutOfBoundsException {
        return this.items.get(index);
    } // getItem

    /**
     * Allows for easy display of all objects in inventory.
     *
     * @return the Inventory contents in a String.
     */
    public String toString() {
        return "Inventory: " + this.items.toString();
    } // toString

} // Inventory
