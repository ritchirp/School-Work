package edu.miamioh.ritchirp;

import javax.swing.JButton;

public class RestaurantButton extends JButton {
	
	private double price;
	private String name;
	
	/**
	 * @param text the name of the item
	 * @param price the price of the item
	 */
	public RestaurantButton(String text, double price) {
		super(text);
		this.price = price;
		this.name = text;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	
	
	
}
