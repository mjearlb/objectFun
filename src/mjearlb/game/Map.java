package mjearlb.game;

/**
 * Creates a Map that will be read by the driver class.
 */
public class Map {

    private int[][] map;

    /**
     * Constructs a map object.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     */
    public Map(int rows, int cols) {
        setMap(rows, cols);
    } // Map

    /**
     * Initializes the map to 0's, the default value for an empty space.
     * setMap is meant to be ovveridden by any custom Map classes. 
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     */
    private void setMap(int rows, int cols) {
        this.map = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.map[i][j] = 0;
            } // for
        } // for
    } // setMap

} // Map
