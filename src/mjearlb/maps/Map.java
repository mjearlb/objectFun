package mjearlb.maps;

/**
 * Creates a Map that will be read by the driver class.
 */
public class Map {

    public char[][] map;
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
                this.map[i][j] = '-';
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
    private boolean canWalk(char tile) {
	if (tile == 'W') {
	    return false; 
	} // if
        return true;
    } // canWalk

    /**
     * Allows the player to move upwards.
     *
     * @param tile the tile we want to walk to.
     * @throws IndexOutOfBoundsException if the player tries to move off of the map.
     */
    public void walkUp(char tile) throws IndexOutOfBoundsException {
        if (canWalk(tile)) {
            this.currCoords[0] -= 1;
        } else {
            System.out.println("Error: cannot walk upwards here");
        } // if/else
    } // walkUp

    /**
     * Allows the player to move downwards.
     *
     * @param tile the tile we want to walk to.
     * @throws IndexOutOfBoundsException if the player tries to move off of the map.
     */
    public void walkDown(char tile) throws IndexOutOfBoundsException {
        if (canWalk(tile)) {
            this.currCoords[0] += 1;
        } else {
            System.out.println("Error: cannot walk downwards here");
        } // if/else
    } // walkDown

    /**
     * Allows the player to move left.
     *
     * @param tile the tile we want to walk to.
     * @throws IndexOutOfBoundsException if the player tries to move off of the map.
     */
    public void walkLeft(char tile) throws IndexOutOfBoundsException {
        if (canWalk(tile)) {
            this.currCoords[1] -= 1;
        } else {
            System.out.println("Error: cannot walk left here");
        } // if/else
    } // walkLeft

    /**
     * Allows the player to move right.
     *
     * @param tile the tile we want to walk to.
     * @throws IndexOutOfBoundsException if the player tries to move off of the map.
     */
    public void walkRight(char tile) throws IndexOutOfBoundsException {
        if (canWalk(tile)) {
            this.currCoords[1] += 1;
        } else {
            System.out.println("Error: cannot walk right here");
        } // if/else
    } // walkRight

    /**
     * Displays the map.
     */
    public void dispMap() {
        String red = "\u001B[31m";
        String white = "\u001B[0m";
	String blue = "\u001B[34m";
	String green = "\u001B[32m"; 
	
	// prints above Player
        for (int i = 0; i < currCoords[0]; i++) {
            for (int j = 0; j < this.cols; j++) {
		if (this.map[i][j] == 'D' ) {
		    System.out.print(blue + 'D' + white);
		} else if (this.map[i][j] == 'C' ) {
                    System.out.print(green + 'C' + white);
                } else {
		    System.out.print(this.map[i][j]);
		} // if/else
            } // for                                                                                        
            System.out.println();
        } // for
	
	// prints up to Player in player row
        for (int i = 0; i < currCoords[1]; i++) {
	    if (this.map[currCoords[0]][i] == 'D' ) {
		System.out.print(blue + 'D' + white); 
	    } else if (this.map[currCoords[0]][i] == 'C' ) {
                System.out.print(green + 'C' + white);
            } else {
		System.out.print(this.map[currCoords[0]][i]);
	    } // if/else
        } // for

	// prints Player
        System.out.print(red + 'P' + white);
	
	// prints rest of player row
	for (int i = currCoords[1] + 1; i < this.cols; i++) {
            if (this.map[currCoords[0]][i] == 'D' ) {
                System.out.print(blue + 'D' + white);
            } else if (this.map[currCoords[0]][i] == 'C' ) {
                System.out.print(green + 'C' + white);
            } else {
                System.out.print(this.map[currCoords[0]][i]);
            } // if/else  
        } // for                                                                                            
        System.out.println();

	// prints after Player
        for (int i = currCoords[0] + 1; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.map[i][j] == 'D' ) {
		    System.out.print(blue + 'D' + white);
		} else if (this.map[i][j] == 'C' ) {
                    System.out.print(green + 'C' + white);
                } else {
		    System.out.print(this.map[i][j]);
		} // if/else  
            } // for                                                                                        
            System.out.println();
        } // for                                                                                            
    } // dispMap 

} // Map
