// Robert Ritchie
// Computes the number of boxes needed to hold donuts
// Test Cases:
// These worked: 0, 11, 12, 13, 18, 25, 29, 36, 37, 59, 60
// No positive integers work incorrectly

import java.util.Scanner;

public class DonutBoxes{
   public static void main(String[] args){
      final int donutsPerBox = 12;
      int donuts, boxes;
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("How many donuts? ");
      donuts = keyboard.nextInt();
      
      boxes = donuts/12 + (donuts%12+11)/12;
      
      System.out.println("You will need " + boxes + " boxes for the donuts.");
   }
}
   