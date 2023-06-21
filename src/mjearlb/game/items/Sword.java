package mjearlb.game.items;

import mjearlb.game.items.Item; 
import mjearlb.game.items.Weapon; 

public class Sword extends Weapon {

    /**
     * Creates a {@code Sword} object.
     * 
     * @param name the name of the {@code Item}.
     * @param damage the amount of damage this Sword does. 
     */
    public Sword(String name, int damage) {
	super(name, damage); 
    } // Sword

    @Override
    public String toString() {
	return this.name + " - Damage: " + this.damage; 
    } // toString

} // Sword
