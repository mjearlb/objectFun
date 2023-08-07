package mjearlb.maps;

/**
 * Keeps track of coordinates for the Map class. 
 */
public class Coordinates {

    public int row;
    public int col; 

    /**
     * Creates a Coordinates object.
     *
     * @param row the row.
     * @param col the column. 
     */
    public Coordinates(int row, int col) {
	this.row = row;
	this.col = col; 
    } // Coordinates

    /**
     * Changes both coordinates at once.
     *
     * @param row the new row value.
     * @param col the new column value. 
     */
    public void changeCoords(int row, int col) {
	this.row = row;
        this.col = col;
    } // changeCoords

} // Coordinates
