package mjearlb.maps;

import java.util.Scanner;

import mjearlb.maps.Map;
import mjearlb.game.character.NonPlayableCharacter;
import mjearlb.game.character.Stats;
import mjearlb.game.items.Item; 
import mjearlb.game.Chest;
import mjearlb.game.items.Sword;
import mjearlb.game.character.Player;
import mjearlb.game.Inventory; 

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
    Sword dullSword; 

    /**
     * This constructs the TestMap object and makes it.
     */
    public TestMap() {
        super(10, 10); // should set it to an empty map of size (rows, cols)
        initNPCs();
	initItems(); 
	initChests();
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
        int id = 5000;
        npcs = new NonPlayableCharacter[5];
        for (int i = 0; i < 5; i++) {
            npcs[i] = new NonPlayableCharacter(5);
            npcs[i].setName(names[i]);
            npcs[i].setId(id);
            id++;
        } // for

    } // initNPCs

    /**
     * This populates the map.
     */
    private void buildMap() {
        this.map[1][1] = '1';
	this.map[3][3] = '0' - 1;

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
	case '/':
	    if (stats.perception > 10) {
		System.out.println("You can see that there is a secret door in here");
		this.map[currCoords[0]][currCoords[1]] = 'D'; 
	    } else {
		System.out.println("There is nothing of note in this area");
	    } // if/else
	    break;
	case '1':
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
            System.out.println("You open the chest.\n" + chests[0] + "\nTake an item? (y/n)");
	    if (keyboard.nextLine().equals("y")) {
	        takeFromChest(player, chests[0], dullSword); 
	    } // if 
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
    } // initItems

    /**
     * Initializes the chests used in the game. 
     */
    private void initChests() {
	chests = new Chest[1];
	for (int i = 0; i < chests.length; i++) {
	    chests[i] = new Chest<Item>(10);
	    chests[i].add(dullSword); 
	} // for	
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

} // TestMap
