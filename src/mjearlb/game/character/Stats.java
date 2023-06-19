package mjearlb.game.character;

/**
 * Contains stats related to each character (ex: strength,
 * intelligence, magic, etc).
 */
public class Stats {

    public int strength;
    public int wisdom;
    public int agility;
    public int deception;
    public int magic;
    public int perception; 

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
	    this.strength = 8; 
	    this.wisdom = 12; 
	    this.agility = 6; 
	    this.deception = 10; 
	    this.magic = 16;
	    this.perception = 10; 
	} else if (charClass.equals("human")) {
	    this.strength = 8; 
            this.wisdom	= 8; 
            this.agility = 10; 
            this.deception = 8; 
            this.magic = 4;
	    this.perception = 7; 
	} else if (charClass.equals("elf")) {
	    this.strength = 6; 
            this.wisdom	= 11; 
            this.agility = 13; 
            this.deception = 9; 
	    this.magic = 14;
	    this.perception = 10; 
	} else if (charClass.equals("wook")) {
	    this.strength = 12;
	    this.wisdom = 4;
	    this.agility = 12;
	    this.deception = 10;
	    this.magic = 6;
	    this.perception = 4; 
	} // if/else
    } // setStats

    @Override
    public String toString() {
	return "Stats:\n\tStrength: " + this.strength +
	    "\n\tWisdom: " + this.wisdom +
	    "\n\tAgility: " + this.agility +
	    "\n\tDeception: " + this.deception +
	    "\n\tMagic: " + this.magic +
	    "\n\tPerception: " + this.perception;
	
    } // toString

} // Stats
