import java.util.Scanner;
public class Program11{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      System.out.print("How long is the shortest string you want to test?");
      int low = in.nextInt();
      System.out.print("How long is the longest string you want to test?");
      int high = in.nextInt();
      System.out.print("How many experiments for each string?");
      int n = in.nextInt();
      
      System.out.println("Performing " + n + " experiments for each string,");
      System.out.println("and computing the average number of swaps:");
      System.out.println();
      
      final String alpha = "abcdefghijklmnopqrstuvwxyz";
      
      for(int i = low; i<=high; i++){
         String test = alpha.substring(0,i);
         double average = averageSwap(test, n);
         System.out.printf("%s: %.1f swaps%n", test, average);
      }
      
   }
   
   // Swaps the position of two characters in a string given their positions
   public static String swap(String str, int a, int b){
      int length = str.length();
      String swap = "";
      for(int i = 0; i<length; i++){
         if(i==a)
            swap+=str.charAt(b);
         else if(i==b)
            swap+=str.charAt(a);
         else
            swap+=str.charAt(i);
      }
      return swap;
   }
   
   // Randomly swaps the position of two characters in a string
   public static String randomSwap(String str){
      int a = (int)(str.length()*Math.random());
      int b = (int)(str.length()*Math.random());
      
      return swap(str,a,b);
   }
   
   public static int experiment(String str){
      int count = 0;
      String original = str;
      
      do{
         str = randomSwap(str);
         count++;
      }while(!str.equals(original));
      
      return count;
   }
   public static double averageSwap(String str, int n){
      int totalSwaps = 0;
      for(int i=1; i<=n; i++){
         totalSwaps+=experiment(str);
      }
      return totalSwaps*1.0/n;
   }
}