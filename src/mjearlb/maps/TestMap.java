package mjearlb.maps;

import java.util.Scanner;

import mjearlb.maps.Map;
import mjearlb.game.character.NonPlayableCharacter;
import mjearlb.game.character.Stats;
import mjearlb.game.items.Item; 
import mjearlb.game.containers.Chest;
import mjearlb.game.items.Sword;
import mjearlb.game.character.Player;
import mjearlb.game.containers.Inventory;
import mjearlb.game.items.Equipment; 

/**
 * This is an example map implementation.
 */
public class TestMap extends Map {

    // TODO: populate with NPC's, build map layout, etc
    // map NPC's to ints (with hashmap?) and then build the map
    // where each int on map refers to the NPC. Will need to make the
    // hashmap public access global variable.

    private static Scanner keyboard = new Scanner(System.in);
    NonPlayableCharacter[] npcs;
    Chest<Item>[] chests;
    public Sword dullSword;
    public Equipment rustyHelm;
    public Sword claireSword; 
    
    /**
     * This constructs the TestMap object and makes it.
     */
    public TestMap() {
        super(10, 10); // should set it to an empty map of size (rows, cols)
	initItems(); 
	initChests();
	initNPCs(); 
        buildMap();
        hashNPCs();
        this.currCoords = new int[] {1,1};
    } // TestMap

    /**
     * This initializes the NPC objects and assigns them to the array
     * of NPC's.
     */
    private void initNPCs() {
        String[] names = {"Tim", "Nathan", "Claire", "Kevin", "Supa Mike"};
        npcs = new NonPlayableCharacter[5];
        for (int i = 0; i < 5; i++) {
            npcs[i] = new NonPlayableCharacter(5, false);
            npcs[i].setName(names[i]);
        } // for
	npcs[1].setSells(false); 
	npcs[2].setSells(true);
	npcs[2].inventory.add(claireSword); 
    } // initNPCs

    /**
     * This populates the map.
     */
    private void buildMap() {
        this.map[1][7] = '1';
	this.map[3][3] = '2';
	this.map[0][0] = 'C';
	this.map[7][7] = 'k';
	this.map[7][8] = 'k'; 

	// walled off area
	this.map[4][4] = 'W';
	this.map[4][5] = 'W';
	this.map[4][6] = 'W';
	this.map[5][6] = 'W';
	this.map[6][6] = 'W';
	this.map[6][6] = 'W';
	this.map[6][5] = 'W';
	this.map[6][4] = 'W';
	this.map[5][4] = 'W';
    } // buildMap

    /**
     * Creates a hashmap that maps the NPC's to numbers since those numbers
     * will be displayed on the map.
     */
    private void hashNPCs() {
        System.out.println("Cannot map NPC's to char's");
    } // hashNPCs

    /**
     * Returns a description of the surrounding area.
     *
     * @param stats the stats of the player. 
     */
    public void investMap(Stats stats) {
	switch (this.map[currCoords[0]][currCoords[1]]) {
	case '1':
	    if (stats.perception > 10) {
		System.out.println("You can see that there is a secret door in here");
		this.map[currCoords[0]][currCoords[1]] = 'D'; 
	    } else {
		System.out.println("There is nothing of note in this area");
	    } // if/else
	    break;
	case '2':
	    if (stats.perception > 10) {
		System.out.println("There is a chest here");
		this.map[currCoords[0]][currCoords[1]] = 'C';
	    } else {
                System.out.println("There is nothing of note in this area");
            } // if/else                                                                                                                                                                                   
            break;
	case 'D':
	    System.out.println("There is a door here.");
	    break;
	case 'C':
	    System.out.println("There is a chest here.");	
            break;
	case 'k':
	    System.out.println("There is a person standing here. They seem friendly enough to approach."); 
	    break; 
	default:
	    System.out.println("There is nothing of note in this area"); 
	} // switch	
    } // investMap

    /**
     * Interacts with the current tile.
     *
     * @param player the player.
     */ 
    public void tileInteract(Player player) {
	switch (this.map[currCoords[0]][currCoords[1]]) {
	case 'D':
            System.out.println("You enter the door.");
            break;
        case 'C':
	    /* NOTE: This is to be changed as it is a very bad way to distinguish between the chests.
	       TODO: decide if Hashmap would work for this?
	     */ 
	    if (currCoords[0] == 3 && currCoords[1] == 3) {
		System.out.println("You open the chest.\n" + chests[0] + "\nTake an item? (y/n)");
		if (keyboard.nextLine().equals("y")) {
		    takeFromChest(player, chests[0], dullSword); 
		} // if
	    } else if (currCoords[0] == 0 && currCoords[1] == 0) {
		System.out.println("You open the chest.\n" + chests[1] + "\nTake an item? (y/n)");
		if (keyboard.nextLine().equals("y")) {
                    takeFromChest(player, chests[1], rustyHelm);
                } // if
	    } // else/if
            break;
	case 'k':
	     if (currCoords[0] == 7 && currCoords[1] == 8) {
		 interactNPC(npcs[1]); 
	     } else if (currCoords[0] == 7 && currCoords[1] == 7) {
		interactNPC(npcs[2]);
	    } // if/else
	    break;
        default:
            System.out.println("There is nothing for you to interact with.");
        } // switch
    } // tileInteract

    /**
     * Initializes the in-game items. 
     */
    private void initItems() {
	dullSword = new Sword("Sword of Dullness", 4);
	claireSword = new Sword("Claire's Sword", 6); 
	rustyHelm = new Equipment("Helmet of Rustiness", 2, 0); 
    } // initItems

    /**
     * Initializes the chests used in the game. 
     */
    private void initChests() {
	chests = new Chest[2];
	for (int i = 0; i < chests.length; i++) {
	    chests[i] = new Chest<Item>(10);
	} // for
	chests[0].add(dullSword);
	chests[1].add(rustyHelm); 
    } // initChests

    /**
     * Allows user to move an {@code item} from a chest to                                                                                                                                                 
     * their inventory.                                                                                                                                                                                    
     *                                                                                                                                                                                                     
     * @param player the player.
     * @param chest the chest being accessed. 
     * @param item the item.
     */
    public void takeFromChest(Player player, Chest chest, Item item) {
        chest.remove(item);
	player.inventory.add(item); 
    } // takeFromChest

    /**
     * Allows the user to interact with an NPC character.
     *
     * @param npc the NPC being interacted with.
     */
    public void interactNPC(NonPlayableCharacter npc) {
	System.out.println("Hi! I am " + npc.name + "!");
	if (npc.sells == true) {
	    System.out.println("I have the following wares to sell:\n" + npc.inventory); 
	} // if
    } // interactNPC

} // TestMap
