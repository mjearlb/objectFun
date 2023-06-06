package mjearlb.maps;

import mjearlb.game.Map;
import mjearlb.game.character.NonPlayableCharacter;

public class TestMap extends Map {

    // TODO: populate with NPC's, build map layout, etc
    // map NPC's to ints (with hashmap?) and then build the map
    // where each int on map refers to the NPC. Will need to make the
    // hashmap public access global variable.

    NonPlayableCharacter[] npcs;

    public TestMap() {
	super(5,5); // should set it to an empty map of size (rows, cols)
	initNPCs();
	buildMap();
	hashNPCs();
    } // TestMap

    private void initNPCs() {
	String[] names = {"Tim", "Nathan", "Claire", "Kevin", "Supa Mike"};
	int id = 5000;
	npcs = new NonPlayableCharacter[5];
	for (int i = 0; i < 5; i++) {
	    npcs[i] = new NonPlayableCharacter();
	    npcs[i].setName(names[i]);
	    npcs[i].setId(id);
	    id++;
	} // for

    } // initNPCs

    private void buildMap() {
	this.map[0][0] = 1;
    } // buildMap

    private void hashNPCs() {
	System.out.println("Cannot map NPC's to int's");
    } // hashNPCs

    public void dispMap() {
	System.out.println(this.toString()); 
    } // dispMap

} // TestMap
