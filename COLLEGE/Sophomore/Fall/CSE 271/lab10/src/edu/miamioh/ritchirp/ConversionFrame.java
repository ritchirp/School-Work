/**
 * 
 */
package edu.miamioh.ritchirp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author ritchirp
 *
 */
public class ConversionFrame extends JFrame {
	//INstance variables
	private JTextField entryField;
	private JComboBox<String> fromBox;
	private JComboBox<String> toBox;
	private JButton convertButton;
	private JLabel toLabel;
	private JLabel resultLabel;
	private JLabel warningLabel;
	private double result;
	private JPanel convertPanel;
	private JPanel warningPanel;
	private JPanel resultPanel;
	
	private static final double EUR_TO_USD = 1.42;
	private static final double GBP_TO_USD = 1.64;
	private static final double GBP_TO_EUR = 1.13;
	
	private static final String EUR = "EUR";
	private static final String USD = "USD";
	private static final String GBP = "GBP";
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 150;
	
	/**
	 * Creates a conversion frame
	 */
	public ConversionFrame(){
		createComboBoxes();
		createComponents();
		createPanels();
		
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		this.add(convertPanel, BorderLayout.NORTH);
		this.add(warningPanel, BorderLayout.CENTER);
		this.add(resultPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Creates the panels and adds the components to them
	 */
	private void createPanels(){
		convertPanel = new JPanel();
		convertPanel.add(entryField);
		convertPanel.add(fromBox);
		convertPanel.add(toLabel);
		convertPanel.add(toBox);
		convertPanel.add(convertButton);
		
		warningPanel = new JPanel();
		warningPanel.add(warningLabel);
		
		resultPanel = new JPanel();
		resultPanel.add(resultLabel);
	}
	
	/**
	 * Creates the components except the combo boxes
	 */
	private void createComponents(){
		entryField = new JTextField(10);
		toLabel = new JLabel("to");
		warningLabel = new JLabel("");
		
		convertButton = new JButton("convert");
		ActionListener l = new ConvertListener();
		convertButton.addActionListener(l);
		
		resultLabel = new JLabel("0.00");
		resultLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	}
	
	/**
	 * Creates the combo boxes
	 */
	private void createComboBoxes(){
		fromBox = new JComboBox<String>();
		toBox = new JComboBox<String>();
		
		fromBox.addItem(EUR);
		fromBox.addItem(USD);
		fromBox.addItem(GBP);
		toBox.addItem(EUR);
		toBox.addItem(USD);
		toBox.addItem(GBP);
	}
	
	/**
	 * Converts the given amount to the correct currency and stores it in 
	 * the result variable
	 * @param from USD, EUR or GBP
	 * @param to USD, EUR or GBP
	 * @param amount the amount to be converted
	 */
	private void convert(String from, String to, double amount){
		if(from.equals(USD)){
			if(to.equals(EUR))
				result = amount * (1/EUR_TO_USD);
			else
				result = amount * (1/GBP_TO_USD);
		}
		else if(from.equals(EUR)){
			if(to.equals(USD))
				result = amount * EUR_TO_USD;
			else
				result = amount * (1/GBP_TO_EUR);
		}
		else{
			if(to.equals(EUR))
				result = amount * GBP_TO_EUR;
			else
				result = amount * GBP_TO_USD;
		}
		result = result - result%0.01;
	}
	
	/**
	 * Executes the conversion, catches errors in user inputs and changes the warninglabel
	 * appropriately
	 * @author Robbie
	 *
	 */
	public class ConvertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
			if(!entryField.getText().equals("")){
				String from = (String) fromBox.getSelectedItem();
				String to = (String) toBox.getSelectedItem();
				double amount = Double.parseDouble(entryField.getText());

				if(from.equals(to)){
					warningLabel.setText("Please select different currencies");
				}
				else{
					convert(from, to, amount);
					resultLabel.setText(result + "");
					warningLabel.setText("");
				}	
			}
			}
			catch(NumberFormatException exception){
				warningLabel.setText("Please enter a number");
			}
		}
	}
	
	public static void main(String[] args){
		ConversionFrame frame = new ConversionFrame();
	}
	
	
}
