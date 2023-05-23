package mjearlb.driver;

/**
 * Basic character outline.
 */
public class Character {

    private int id;
    private boolean player;
    private String name;

    /**
     * Creates the character object.
     *
     * @param player is {@code true} if the character being created is
     * a player, false if it is an NPC.
     * @param name the name of the character.
     * @param id the id of the character.
     */
    public Character(int id, boolean player, String name) {
        this.id = id;
        this.player = player;
        this.name = name;
    } // Character

    /**
     * Allows access to the id of the character.
     *
     * @return the id of the character.
     */
    public int getId() {
        return this.id;
    } // getId

    /**
     * Allows game to see whether character is a player or not.
     *
     * @return whether the character is a player or not.
     */
    public boolean getPlayer() {
        return this.player;
    } // getPlayer

    /**
     * Allows game to access character name.
     *
     * @return the {@code name} of the character.
     */
    public String getName() {
        return this.name;
    } // getName

} // Character
