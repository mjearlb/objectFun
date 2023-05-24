package mjearlb.game;

/**
 * Creates a Map that will be read by the driver class.
 */
public class Map {

    /* CURRENT MAP:

       10000
       00000
       00000
       00000
       00000

     */

    private int[][] map;

    /**
     * Constructs a map object.
     */
    public Map() {
        setMap();
    } // Map

    /**
     * Initializes the map to 0's, except a 1 where the player is.
     */
    private void setMap() {
        this.map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.map[i][j] = 0;
            } // for
        } // for
        map[0][0] = 1;
    } // setMap

} // Map
