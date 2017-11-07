/**
 * 
 */
package lab03;
import java.util.ArrayList;
/**
 * @author Robbie Ritchie
 *
 */
public class Fighter {
	private String name;
	
	// Variables for the fighter's progression
	private int level;
	private int experience;
	private int battlesWon;
	
	// Variables for the fighter's statistics
	private int strength;
	private int dexterity;
	private int charisma;
	
	// Variables concerning the fighter's state
	private int speed;
	private int life;
	private int stamina;
	private int magic;
	private int gold;
	private int maxInventory;
	private ArrayList<String> inventory;
	public static final int SWOON = 0;
	public static final int FULL_LIFE = 100;
	public static final int TIRED = 0;
	public static final int FULL_STAMINA = 200;
	public static final int NO_MAGIC = 0;
	public static final int FULL_MAGIC = 200;
	public static final int STOPPED = 0;
	public static final int WALKING = 5;
	public static final int RUNNING = 8;
	
	// creates a new character with random stats (5-8) and some default states
	public Fighter(String name){
		this.name = name;
		this.level = 1;
		this.experience = 0;
		this.battlesWon = 0;
		this.strength = (int)(5 + Math.random()*4);
		this.dexterity = (int)(5 + Math.random()*4);
		this.charisma = (int)(5 + Math.random()*4);
		this.speed = 0;
		this.life = FULL_LIFE;
		this.maxInventory = 20;
		this.inventory = new ArrayList<String>();
	}
	
	// Create a fighter given all of its configurable stats and states
	public Fighter(String name, int level, int experience, int battlesWon,
			int strength, int dexterity, int charisma, int speed, int life,
			int gold, int maxInventory, ArrayList<String> inventory) {
		super();
		this.name = name;
		this.level = level;
		this.experience = experience;
		this.battlesWon = battlesWon;
		this.strength = strength;
		this.dexterity = dexterity;
		this.charisma = charisma;
		this.speed = speed;
		this.life = life;
		this.gold = gold;
		this.maxInventory = maxInventory;
		this.inventory = inventory;
	}
	
	// Sets the fighters speed to the run speed
	public void run(){
		this.speed = RUNNING;
	}
	// Sets the fighters speed to the walk speed
	public void walk(){
		this.speed = WALKING;
	}
	// Sets the fighters speed so he is stopped
	public void stop(){
		this.speed = STOPPED;
	}
	// Prints out a message based on the fighter's charisma
	public void talk(){
		if(this.charisma>=1 && this.charisma<5) System.out.println("*grunts*");
		if(this.charisma>=5 && this.charisma<10) System.out.println("I hate small talk.");
		if(this.charisma>=10 && this.charisma<15) System.out.println("Let's get going!");
		if(this.charisma>=15 && this.charisma<=20) System.out.println("Oh, can I help you? :-)");
	}
	
	// Simulates a battle between fighters given the enemy's stats
	// Returns true if the fighter wins, and false otherwise
	public boolean fight(int enemyStrength, int enemyDexterity, int enemyLevel){
		int advantage = 0; // this will ultimately be used to decide the battle
		
		// strength and dexterity are 2/3 as important as level
		advantage += (this.strength - enemyStrength)*2; 
		advantage += (this.dexterity -enemyDexterity)*2;
		advantage += (this.level - enemyLevel)*3;
		// this makes sure the stronger character doesn't always win
		int variance = (int)(-10 + 21*Math.random()); 
		advantage += variance;
		
		boolean battleWon;
		if (advantage>0) battleWon = true;
		else battleWon = false;
		
		if(battleWon)
			this.battlesWon++;
		
		return battleWon;
	}
	// deletes an item with a specified name from the inventory
	// will be unchanged if the item is not in the inventory
	public void drop(int item){
		inventory.remove(item);
	}
	
	// puts an item in the inventory
	// if not slots are empty, the inventory is unchanged
	public void pickUp(String item){
		if(inventory.size()<=maxInventory)
			inventory.add(item);
	}
	//Returns true if the inventory is full
	public boolean fullInventory(){
		return inventory.size()==maxInventory;
	}
	
	// gets the stamina
	public int getStamina() {
		return stamina;
	}
	//sets the stamina
	//only accepts values 0-200
	public void setStamina(int stamina) {
		if(stamina>=0 && stamina<=200)
			this.stamina = stamina;
	}
	// returns the current magic pool
	public int getMagic() {
		return magic;
	}
	
	// sets the magic
	// only accepts values 0-200
	public void setMagic(int magic) {
		if(magic>=0 && magic<=200)
			this.magic = magic;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param set the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @param set the level
	 * only accepts values 1-20
	 */
	public void setLevel(int level) {
		if(level>0 && level<=20) this.level = level;
	}
	// Levels up the fighter and increases its stats by 1 up to the max
	public void levelUp(){
		this.level++;
		if(this.strength<20) this.strength++;
		if(this.dexterity<20) this.dexterity++;
		if(this.charisma<20) this.charisma++;
	}
	
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	
	/**
	 * @param set the experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/**
	 * @return the battlesWon
	 */
	public int getBattlesWon() {
		return battlesWon;
	}
	
	/**
	 * @param set the battlesWon
	 */
	public void setBattlesWon(int battlesWon) {
		this.battlesWon = battlesWon;
	}
	
	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * @param set the strength
	 * only accepts values 1-20
	 */
	public void setStrength(int strength) {
		if (strength>0 && strength<=20) this.strength = strength;
	}
	
	/**
	 * @return the dexterity
	 */
	public int getDexterity() {
		return dexterity;
	}
	
	/**
	 * @param set the dexterity
	 * only accepts values 1-20
	 */
	public void setDexterity(int dexterity) {
		if(dexterity>0 && dexterity<=20) this.dexterity = dexterity;
	}
	
	/**
	 * @return the charisma
	 */
	public int getCharisma() {
		return charisma;
	}
	
	/**
	 * @param set the charisma
	 * only accepts values 1-20
	 */
	public void setCharisma(int charisma) {
		if(charisma>0 && charisma<=20) this.charisma = charisma;
	}
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * @param set the speed
	 * only accepts values 0-10
	 */
	public void setSpeed(int speed) {
		if(speed>=0 && speed <=10) this.speed = speed;
	}
	
	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * @param set the life
	 * only accepts values 0-100
	 */
	public void setLife(int life) {
		if(life>=0 && life <=100) this.life = life;
	}
	
	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * @param set the gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	/**
	 * @return the maxInventory
	 */
	public int getMaxInventory() {
		return maxInventory;
	}
	/**
	 * Only allows for non-negative values
	 * @param size
	 */
	public void setMaxInventory(int size) {
		if(size>=0)
			this.maxInventory = size;
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<String> getInventory() {
		return inventory;
	}
	
	/**
	 * @param completely overrides the inventory with a given arraylist
	 * note may cause problems if maxInventory isn't changed accordingly
	 */
	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Name: " + this.name
				+"/n Level " + this.level
				+ "/n Strength: " + this.strength
				+ "/n Dexterity: "+ this.dexterity
				+ "/n Charisma: " + this.charisma + "/n"
				+ this.gold + " Gold /n"
				+ this.experience + "Experience /n"
				+ this.battlesWon + "Battles won";
				
	}
	
	
	
	
}
