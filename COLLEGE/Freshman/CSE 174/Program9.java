// Robert Ritchie
// CSE 174
// The user plays a game of nim against an ai with random intelligence



import java.util.Scanner;

public class Program9{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int pileSize = (int)(10 + 90*Math.random());
      boolean computerIsSmart = true;
      
      // Determines the computer intelligence
      if(Math.random()>0.5)
         computerIsSmart = false;
      
      if(computerIsSmart)
         System.out.println("*** The computer is playing smart.");
      else
         System.out.println("*** The computer is playing dumb.");
      System.out.println();
      
      // Determines the first move
      boolean userGoesFirst=false;
      if(Math.random()>0.5)
         userGoesFirst=true;
      
      // Lets the user make the first move
      int move;
      if(userGoesFirst){
         int maxMove;
            System.out.println("*** There are " + pileSize + " marbles in the pile.");
            if(pileSize==1)
               maxMove=1;
            else
               maxMove=pileSize/2;
            
            System.out.print("How many do you want to take (1-" + maxMove + ")");
            move = in.nextInt();
            // Stops the user if entered move is illegal
            while(move>maxMove || move<1){
               System.out.println("*** Illegal entry!");
               System.out.print("How many do you want to take (1-" + maxMove + ")");
               move = in.nextInt();
            }
            pileSize -= move;
            System.out.println();
      }
      
      // Loop for playing the game
      boolean userWins=true;
      while(pileSize>0){
         // Computer's move
         System.out.println("*** There are " + pileSize + " marbles in the pile.");
         move = getMove(pileSize, computerIsSmart);
         pileSize -= move;
         System.out.println("Computer will take " + move + ".");
         System.out.println();
         
         // Determines victor
         if(pileSize==1)
            userWins=false;
         
         // User's move
         if(pileSize>0){
            int maxMove;
            System.out.println("*** There are " + pileSize + " marbles in the pile.");
            if(pileSize==1)
               maxMove=1;
            else
               maxMove=pileSize/2;
            
            System.out.print("How many do you want to take (1-" + maxMove + ")");
            move = in.nextInt();
            // Stops the user if entered move is illegal
            while(move>maxMove){
               System.out.println("*** Illegal entry!");
               System.out.print("How many do you want to take (1-" + maxMove + ")");
               move = in.nextInt();
            }
            pileSize -= move;
            System.out.println();
         }
         
         // Determines victor
         if(pileSize==1)
            userWins=true;
      }
      
      if(userWins)
         System.out.print("User wins!");
      else
         System.out.print("Computer wins. :(");
      
   }
   // Returns the move the computer will use if it is playing smart
   public static int getSmartMove(int marbles){
      return (marbles - (int)Math.pow(2,Math.floor(Math.log(marbles)/Math.log(2))) + 1);
   }
   
   // Returns the move the computer will use if it is playing dumb
   public static int getStupidMove(int marbles){
      return (int)(1+ marbles/2*Math.random());
   }
   
   // Returns the correct type of computer move
   public static int getMove(int marbles, boolean computerIsSmart){
      if(computerIsSmart)
         return getSmartMove(marbles);
      else
         return getStupidMove(marbles);
   }
   
}