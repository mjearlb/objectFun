package mjearlb.game.items;

import mjearlb.game.items.Item;

public abstract class Weapon extends Item {

    int damage; 

    /**
     * Creates a Weapon object. 
     *
     * @param name the name of the {@code Weapon}
     * @param damage the amount of damage the {@code Weapon} does. 
     */
    public Weapon(String name, int damage) {
	super(name);
	this.damage = damage; 
    } // Weapon

    @Override
    public void toString() {
	return this.name + " - Damage: " + this.damage; 
    } // toString

} // Weapon
