// Robert Ritchie
// Computes the amount of change due to a customer and the
// most effecient use of coins to give back

import java.util.Scanner;

public class ChangeCalculator{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int change;
      int amountDue;
      int amountGiven;
      int dollarsDue;
      int quartersDue;
      int dimesDue;
      int nickelsDue;
      int penniesDue;
      
      System.out.println("Enter your numbers in cents...");
      System.out.print("How much did the customer give you? ");
      amountGiven = keyboard.nextInt();
      System.out.print("What does the customer owe? ");
      amountDue = keyboard.nextInt();
      
      change = amountGiven - amountDue;
      dollarsDue = change/100;
      change = change%100;
      quartersDue = change/25;
      change = change%25;
      dimesDue = change/10;
      change = change%10;
      nickelsDue = change/5;
      change = change%5;
      penniesDue = change;
      
      System.out.println("Give the customer...");
      System.out.println(dollarsDue + " dollars");
      System.out.println(quartersDue + " quarters");
      System.out.println(dimesDue + " dimes");
      System.out.println(nickelsDue + " nickels");
      System.out.println(penniesDue + " pennies");
      
   }
}