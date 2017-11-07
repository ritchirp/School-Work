package edu.miamioh.ritchirp;

public class LectureHall {
	private String name;
	private int capacity;
	/**
	 * @param name The name of the hall
	 * @param capacity How many students the hall can hold
	 */
	public LectureHall(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
