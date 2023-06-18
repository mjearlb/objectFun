package mjearlb.game;

/**
 * Creates a Map that will be read by the driver class.
 */
public class Map {

    protected char[][] map;
    public int rows;
    public int cols;
    private int size;
    public int[] currCoords;

    /**
     * Constructs a map object.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     */
    public Map(int rows, int cols) {
        setMap(rows, cols);
        this.rows = rows;
        this.cols = cols;
    } // Map

    /**
     * Initializes the map to 0's, the default value for an empty space.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     */
    private void setMap(int rows, int cols) {
        this.map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.map[i][j] = '0';
            } // for
        } // for
    } // setMap

    @Override
    public String toString() {
        String mapString = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                mapString += this.map[i][j];
            } // for
            mapString += "\n";
        } // for
        return mapString;
    } // dispMap

    /**
     * Used to test if the player can walk on certain spaces.
     * NOTE: may change to accept the coord's as parameter.
     *
     * @param tile the contents of the tile being checked
     * @return {@code true} if the tile is accesible by the player,
     * {@code false} if not.
     */
    public boolean canWalk(int tile) {
        return tile >= 0;
        // for now, walkable spaces will be positive, negative will be walls, buildings, etc.
    } // canWalk

} // Map
