package mjearlb.game.character;

import mjearlb.game.character.Character;
import mjearlb.game.containers.Inventory;
import mjearlb.game.items.Item;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import mjearlb.game.containers.Inventory;
import mjearlb.game.items.Equipment;
import java.lang.reflect.Type;

/**
 * Creates Player object.
 */
public class Player extends Character {

    public Inventory<Equipment> equipment;
    
    /**
     * Creates an instance of the Player character.
     * Defaults to 10 inventory slots. 
     */
    public Player() {
	super(10); 
	this.isPlayer = true;
	this.equipment = new Inventory<Equipment>(4); 
    } // Player

    /**
     * Allows {@code Player} to equip a {@code Wearable} {@code Item}.
     *
     * @param item the {@code item} to be equipped. 
     */
    public void equipWearable(Equipment item) {
	this.inventory.remove(item);
	this.equipment.add(item); 
    } // wearItem

    /**
     * Allows {@code Player} to unequip a {@code Equipment} {@code Item}.
     *
     * @param item the {@code item} to be unequipped. 
     */
    public void unequipWearable(Equipment item) {
	this.equipment.remove(item);
	this.inventory.add(item);
    } // unwearItem

    @Override
    public String toString() {
	return super.toString() + "\nEquipment: " + this.equipment; 
    } // toString

    /**
     * Sets the stats of the player.
     *
     * @param stats the stats of the player
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    } // setStats

    /**
     * Sets the amount of money the player has.
     *
     * @param money the amount of money
     */
    public void setMoney(int money) {
        this.money = money;
    } // setMoney

    /**
     * Sets the defense value of the player.
     * 
     * @param defense the defense value
     */
    public void setDefense(int defense) {
        this.defense = defense;
    } //setDefense

    public static Player fromJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Player.class, new PlayerDeserializer());
        Gson gson = gsonBuilder.create();

        Player player = gson.fromJson(json, Player.class);
        return player;
    } // fromJson

    /**
     * A helper class that allows us to deserialoze the {@code Player} object. 
     */
    private static class PlayerDeserializer implements JsonDeserializer<Player> {
	@Override
	public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
	    JsonObject jsonObject = json.getAsJsonObject();
	    Player player = new Player();

	    player.isPlayer = jsonObject.get("isPlayer").getAsBoolean();
	    player.name = jsonObject.get("name").getAsString();
	    player.charClass = jsonObject.get("charClass").getAsString();
	    player.money = jsonObject.get("money").getAsInt();
	    player.defense = jsonObject.get("defense").getAsInt();

	    // Deserialize 'equipment' field
	    JsonArray equipmentArray = jsonObject.get("equipment").getAsJsonArray();
	    player.equipment = new Inventory<>(4);
	    for (JsonElement element : equipmentArray) {
		Equipment equipment = context.deserialize(element, Equipment.class);
		player.equipment.add(equipment);
	    } // for 

	    // Deserialize 'inventory' field
	    JsonArray inventoryArray = jsonObject.get("inventory").getAsJsonArray();
	    player.inventory = new Inventory<>(10);
	    for (JsonElement element : inventoryArray) {
		Item item = context.deserialize(element, Item.class);
		player.inventory.add(item);
	    } // for 

	    // Deserialize 'stats' field
	    JsonObject statsObject = jsonObject.get("stats").getAsJsonObject();
	    player.stats = context.deserialize(statsObject, Stats.class);

	    return player;
	} // deserialize
    } // PlayerDeserializer


} // Player
