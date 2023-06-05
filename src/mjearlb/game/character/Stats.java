package mjearlb.game.character;

/**
 * Contains stats related to each character (ex: strength,
 * intelligence, magic, etc).
 */
public class Stats {

    int strength;
    int wisdom;
    int agility;
    int deception;
    int magic; 

    /**
     * Creates a character's stats. 
     *
     * @param charClass the class of the character. 
     */
    public Stats(String charClass) {
	setStats(charClass); 
    } // Stats

    /**
     * Sets a character's stats based on what class the character is. 
     *
     * @param charClass the class of the character. 
     */
    private void setStats(String charClass) {
	if (charClass.equals("wizard")) {
	    this.strength = 6; 
	    this.wisdom = 12; 
	    this.agility = 6; 
	    this.deception = 10; 
	    this.magic = 16; 
	} else if (charClass.equals("human")) {
	    this.strength = 8; 
            this.wisdom	= 8; 
            this.agility = 10; 
            this.deception = 8; 
            this.magic = 4; 
	} else if (charClass.equals("elf")) {
	    this.strength = 6; 
            this.wisdom	= 11; 
            this.agility = 13; 
            this.deception = 9; 
	    this.magic = 14; 
	} // if/else
    } // setStats

    @Override
    public String toString() {
	return "Stats:\nStrength: " + this.strength +
	    "\nWisdom: " + this.wisdom +
	    "\nAgility: " + this.agility +
	    "\nDeception: " + this.deception +
	    "\nMagic: " + this.magic; 
    } // toString

} // Stats
