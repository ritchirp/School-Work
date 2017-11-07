// Robert Ritchie
//

import java.util.Scanner;

public class MathQuiz {
   public static void main(String args[]){
      
      Scanner keyboard = new Scanner(System.in);
      String difficulty;
      
      System.out.println("Welcome to my math quiz!");
      System.out.println("This quiz will give you four multiplication problems,");
      System.out.println("followed by four division problems.");
      System.out.println("An easy quiz will include numbers up to 100.");
      System.out.println("A hard quiz will include numbers up to 1000.");
      System.out.println("-----------------------------------------------------");
      System.out.println("Do you want an easy quiz or a hard quiz?");
      System.out.print("Enter the word hard or easy: ");
      difficulty = keyboard.next();
      
      int max = 0;
      if(difficulty.equalsIgnoreCase("easy"))
         max = 100;
      if(difficulty.equalsIgnoreCase("hard"))
         max = 1000;
      
      System.out.println();
      System.out.println("-MULTIPLICATION--------------------------------------");
      System.out.println("You have chosen " + difficulty.toLowerCase() + ".");
      
      int multiplicand1, multiplicand2;
      int correctAnswer, givenAnswer;
      int multiplicationScore = 0;
      int swap;
      long initialTime = System.currentTimeMillis();
      
      // generates the numbers for the multiplication problems
      multiplicand1 = (int)(1 + Math.sqrt(max)*Math.random());
      multiplicand2 = (int)(1 + (max/multiplicand1)*Math.random());
      correctAnswer = multiplicand1 * multiplicand2;
      
      System.out.print(multiplicand1 + " × " + multiplicand2 + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         multiplicationScore++;
         System.out.println("Correct! " + multiplicationScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + multiplicand1 + " × " + multiplicand2 + " = " + correctAnswer);
         System.out.println(". " + multiplicationScore + " answers correct so far.");
      }
      
      
     // Repeat problem procedure 
      multiplicand1 = (int)(1 + Math.sqrt(max)*Math.random());
      multiplicand2 = (int)(1 + (max/multiplicand1)*Math.random());
      correctAnswer = multiplicand1 * multiplicand2;
      
      System.out.print(multiplicand1 + " × " + multiplicand2 + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         multiplicationScore++;
         System.out.println("Correct! " + multiplicationScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + multiplicand1 + " × " + multiplicand2 + " = " + correctAnswer);
         System.out.println(". " + multiplicationScore + " answers correct so far.");
      }
      
      
      // Repeat problem procedure 
      multiplicand1 = (int)(1 + Math.sqrt(max)*Math.random());
      multiplicand2 = (int)(1 + (max/multiplicand1)*Math.random());
      correctAnswer = multiplicand1 * multiplicand2;
      
      System.out.print(multiplicand1 + " × " + multiplicand2 + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         multiplicationScore++;
         System.out.println("Correct! " + multiplicationScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + multiplicand1 + " × " + multiplicand2 + " = " + correctAnswer);
         System.out.println(". " + multiplicationScore + " answers correct so far.");
      }
      
      
      // Repeat problem procedure 
      multiplicand1 = (int)(1 + Math.sqrt(max)*Math.random());
      multiplicand2 = (int)(1 + (max/multiplicand1)*Math.random());
      correctAnswer = multiplicand1 * multiplicand2;
      
      System.out.print(multiplicand1 + " × " + multiplicand2 + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         multiplicationScore++;
         System.out.println("Correct! " + multiplicationScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + multiplicand1 + " × " + multiplicand2 + " = " + correctAnswer);
         System.out.println(". " + multiplicationScore + " answers correct so far.");
      }
      
      
      System.out.println();
      System.out.println("-DIVISION--------------------------------------------");
      // generates the numbers for division problems 
      int dividend, divisor;
      int divisionScore = 0;
      int totalScore = multiplicationScore;
      
      divisor = (int)(1 + Math.sqrt(max)*Math.random());
      correctAnswer = (int)(1 + (max/divisor)*Math.random());
      dividend = divisor * correctAnswer;
      
      System.out.print(dividend + " ÷ " + divisor + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         divisionScore++;
         totalScore = divisionScore + multiplicationScore;
         System.out.println("Correct! " + totalScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + dividend + " ÷ " + divisor + " = " + correctAnswer);
         System.out.println(". " + totalScore + " answers correct so far.");
      }
      
      
      // Repeat problem procedure
      divisor = (int)(1 + Math.sqrt(max)*Math.random());
      correctAnswer = (int)(1 + (max/divisor)*Math.random());
      dividend = divisor * correctAnswer;
      
      System.out.print(dividend + " ÷ " + divisor + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         divisionScore++;
         totalScore = divisionScore + multiplicationScore;
         System.out.println("Correct! " + totalScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + dividend + " ÷ " + divisor + " = " + correctAnswer);
         System.out.println(". " + totalScore + " answers correct so far.");
      }
      
      
      // Repeat problem procedure
      divisor = (int)(1 + Math.sqrt(max)*Math.random());
      correctAnswer = (int)(1 + (max/divisor)*Math.random());
      dividend = divisor * correctAnswer;
      
      System.out.print(dividend + " ÷ " + divisor + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         divisionScore++;
         totalScore = divisionScore + multiplicationScore;
         System.out.println("Correct! " + totalScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + dividend + " ÷ " + divisor + " = " + correctAnswer);
         System.out.println(". " + totalScore + " answers correct so far.");
      }
      
      
      // Repeat problem procedure
      divisor = (int)(1 + Math.sqrt(max)*Math.random());
      correctAnswer = (int)(1 + (max/divisor)*Math.random());
      dividend = divisor * correctAnswer;
      
      System.out.print(dividend + " ÷ " + divisor + " = :");
      givenAnswer = keyboard.nextInt();
      if(givenAnswer==correctAnswer){
         divisionScore++;
         totalScore = divisionScore + multiplicationScore;
         System.out.println("Correct! " + totalScore + " answers correct so far.");
      }
      else{
         System.out.print("No, " + dividend + " ÷ " + divisor + " = " + correctAnswer);
         System.out.println(". " + totalScore + " answers correct so far.");
      }
      
      long finalTime = System.currentTimeMillis();
      long elapsedTime = (finalTime - initialTime)/1000;
      
      System.out.println();
      System.out.println("-RESULTS---------------------------------------------");
      double multiplicationPercent = multiplicationScore/4.0*100;
      double divisionPercent = divisionScore/4.0*100;
      double totalPercent = (multiplicationPercent + divisionPercent)/2.0;
      
      System.out.println("You answered the questions in " + elapsedTime + " seconds.");
      System.out.printf("Multiplication score: %d out of 4 (%.2f%%)%n", multiplicationScore,
                        multiplicationPercent);
      System.out.printf("Division score: %d out of 4 (%.2f%%)%n", divisionScore, divisionPercent);
      System.out.printf("Overall score: %d out of 8 (%.2f%%)", totalScore, totalPercent);
      
   }
}
