package edu.miamioh.ritchirp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RestaurantFrame extends JFrame {
	
	// Constants
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 550;
	
	private static final int AREA_ROWS = 20;
	private static final int AREA_COLUMNS = 30;
	
	private static final double TAX_RATE = 0.03;
	private static final double TIP = 5;
	
	// Instance variables
	
	private double total;
	
	private RestaurantButton steakButton;
	private RestaurantButton eggsButton;
	private RestaurantButton drinkButton;
	private RestaurantButton friesButton;
	private RestaurantButton burgerButton;
	private RestaurantButton soupButton;
	private RestaurantButton saladButton;
	private RestaurantButton chickenButton;
	private RestaurantButton pizzaButton;
	private RestaurantButton wingsButton;
	
	private JLabel oddItemNameLabel;
	private JTextField oddItemNameField;
	private JLabel oddItemPriceLabel;
	private JTextField oddItemPriceField;
	private JButton addOddItemButton;
	
	private JTextArea billArea;
	private JButton calculateButton;
	private JPanel panel;
	
	/**
	 * Constructs a restaurant frame
	 */
	public RestaurantFrame(){
		total = 0;
		billArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		billArea.setEditable(false);
		
		createButtons();
		createOddItemEntry();
		createBill();
		createPanel();
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Adds all of the components to the panel and adds
	 * the panel to the frame
	 */
	private void createPanel(){
		panel = new JPanel();
		panel.add(steakButton);
		panel.add(eggsButton);
		panel.add(drinkButton);
		panel.add(friesButton);
		panel.add(burgerButton);
		panel.add(soupButton);
		panel.add(saladButton);
		panel.add(chickenButton);
		panel.add(pizzaButton);
		panel.add(wingsButton);
		panel.add(oddItemNameLabel);
		panel.add(oddItemNameField);
		panel.add(oddItemPriceLabel);
		panel.add(oddItemPriceField);
		panel.add(addOddItemButton);
		panel.add(billArea);
		panel.add(calculateButton);
		this.add(panel);
	}
	
	/*
	 * Creates all of the restaurant buttons and adds the listener
	 */
	private void createButtons(){
		AddItemListener l = new AddItemListener();
		steakButton = new RestaurantButton("Steak", 10.50);
		steakButton.addActionListener(l);
		eggsButton = new RestaurantButton("Eggs", 5.50);
		eggsButton.addActionListener(l);
		drinkButton = new RestaurantButton("Drink", 2.00);
		drinkButton.addActionListener(l);
		friesButton = new RestaurantButton("Fries", 3.00);
		friesButton.addActionListener(l);
		burgerButton = new RestaurantButton("Burger", 6.30);
		burgerButton.addActionListener(l);
		soupButton = new RestaurantButton("Soup", 4.50);
		soupButton.addActionListener(l);
		saladButton = new RestaurantButton("Salad", 4.00);
		saladButton.addActionListener(l);
		chickenButton = new RestaurantButton("Chicken", 6.30);
		chickenButton.addActionListener(l);
		pizzaButton = new RestaurantButton("Pizza", 4.50);
		pizzaButton.addActionListener(l);
		wingsButton = new RestaurantButton("Wings", 5.50);
		wingsButton.addActionListener(l);
	}
	
	/*
	 * creates the components used for entering items not on the menu
	 */
	private void createOddItemEntry(){
		oddItemNameLabel = new JLabel("Name");
		oddItemNameField = new JTextField();
		oddItemNameField.setColumns(5);
		oddItemPriceLabel = new JLabel("Price");
		oddItemPriceField = new JTextField();
		oddItemPriceField.setColumns(5);
		
		addOddItemButton = new JButton("Add Item");
		ActionListener listener = new AddItemListener();
		addOddItemButton.addActionListener(listener); 
	}
	
	/*
	 * creates the components for the bill area of the frame
	 */
	private void createBill(){
		calculateButton = new JButton("Calculate");
		ActionListener l = new CalculateListener();
		calculateButton.addActionListener(l);
	}
	
	/*
	 * Will add an item through the information in the source if restaurant button
	 * if not it will add what is in the OddItem fields
	 */
	class AddItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			RestaurantButton rb; 
			if(e.getSource() instanceof RestaurantButton){
				rb = (RestaurantButton) e.getSource();
				String name = rb.getName();
				double price = rb.getPrice();
				billArea.append(name + "  " + price + "\n");
				total+=price;
			}
			else{
				String name = oddItemNameField.getText();
				double price = Double.parseDouble(oddItemPriceField.getText());
				billArea.append(name + "  " + price + "\n");
				total+=price;
			}
				
		}
		
	}
	/*
	 * Finalizes the bill and prints the tip, tax, and total
	 */
	class CalculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			double tax = total * TAX_RATE;
			tax = Math.round((float)(tax * 100))/100.0;
			total += tax;
			total += TIP;
			billArea.append("------------\n");
			billArea.append("Tip: " + TIP + "\n");
			billArea.append("Tax: " + tax + "\n");
			billArea.append("Total: " + total);
		}
		
	}
}
