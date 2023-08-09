package mjearlb.game.items;

import mjearlb.game.items.Item;
import mjearlb.game.items.Equipment;

public abstract class Weapon extends Equipment {

    int damage; 

    /**
     * Creates a Weapon object. 
     *
     * @param name the name of the {@code Weapon}
     * @param damage the amount of damage the {@code Weapon} does. 
     */
    public Weapon(String name, int damage) {
	super(name, 0, 4);
	this.damage = damage; 
    } // Weapon

    @Override
    public String toString() {
	return this.name + " - Damage: " + this.damage; 
    } // toString

} // Weapon
