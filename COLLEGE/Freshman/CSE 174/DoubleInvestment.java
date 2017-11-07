import java.util.Scanner;
public class DoubleInvestment{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int sum = 35;
      int num; 
      
      do
      {System.out.print("Enter a number: ");
         num = in.nextInt();
         sum = sum + num;
      } while(num < 100);
      
      System.out.println(sum);
   }
}