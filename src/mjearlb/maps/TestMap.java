package mjearlb.maps;

import mjearlb.game.Map;
import mjearlb.game.character.NonPlayableCharacter;

/**
 * This is an example map implementation.
 */
public class TestMap extends Map {

    // TODO: populate with NPC's, build map layout, etc
    // map NPC's to ints (with hashmap?) and then build the map
    // where each int on map refers to the NPC. Will need to make the
    // hashmap public access global variable.

    NonPlayableCharacter[] npcs;

    /**
     * This constructs the TestMap object and makes it.
     */
    public TestMap() {
        super(5,5); // should set it to an empty map of size (rows, cols)
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
        int id = 5000;
        npcs = new NonPlayableCharacter[5];
        for (int i = 0; i < 5; i++) {
            npcs[i] = new NonPlayableCharacter();
            npcs[i].setName(names[i]);
            npcs[i].setId(id);
            id++;
        } // for

    } // initNPCs

    /**
     * This populates the map.
     */
    private void buildMap() {
        //this.map[0][0] = 1;
    } // buildMap

    /**
     * Creates a hashmap that maps the NPC's to numbers since those numbers
     * will be displayed on the map.
     */
    private void hashNPCs() {
        System.out.println("Cannot map NPC's to char's");
    } // hashNPCs

    /**
     * Displays the map.
     */
    public void dispMap() {
        String red = "\u001B[31m";
        String white = "\u001B[0m";
        for (int i = 0; i < currCoords[0]; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.map[i][j]); 
            } // for
            System.out.println();
        } // for

        for (int i = 0; i < currCoords[1]; i++) {
            System.out.print(this.map[currCoords[0]][i]);
        } // for
        System.out.print(red + this.map[currCoords[0]][currCoords[1]] + white);
        for (int i = currCoords[1] + 1; i < this.cols; i++) {
            System.out.print(this.map[currCoords[0]][i]);
        } // for
        System.out.println();

        for (int i = currCoords[0] + 1; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.map[i][j]);
            } // for
            System.out.println();
        } // for

    } // dispMap

} // TestMap
