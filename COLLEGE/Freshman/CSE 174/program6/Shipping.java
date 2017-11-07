// Robert Ritchie
// CSE 174
// Determines the package type and options for shipping a package based on its volume and calculates
// the cost of shipping.
// Test cases:
// 200 First Class, 17.50
// 200 Economy, 16.00
// 400 First Class 31.50
// 500 First Class 38.50
// 800 Large Package 30.00
// 900 Large Package 30.00

import java.util.Scanner;

public class Shipping{
   public static void main(String[] args){
      
      // Gets package volume
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter volume in cubic inches: ");
      double volume = keyboard.nextDouble();
      
      // Determines package volume class
      String size;
      if(volume>=800)
         size = "Large";
      else if(volume>=400)
         size = "Medium";
      else
         size = "Small";
      
      System.out.println(size + " package");
      
      // Asks for first class if applicable
      String rate;
      if(size.equals("Small")){
         System.out.print("Do you want to ship first class?");
         String answer = keyboard.next();
         if(answer.equals("yes"))
            rate = "First class";
         else
            rate = "Economy";
      }
      else if(size.equals("Medium")) // Determines rates for medium and large packages
         rate = "First class";
      else
         rate = "Large package";
      System.out.println(rate + " rate");
      
      // Calculates and prints shipping cost
      double cost;
      if(rate.equals("Economy"))
         cost = 0.08*volume;
      else if(rate.equals("First class"))
         cost = 3.5 + 0.07*volume;
      else
         cost = 30;
      System.out.printf("Shipping cost: $%.2f",cost);
         
   }
}