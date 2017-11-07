import java.util.Scanner;

public class DonutTest{
   public static void main(String[] args){
    int count = 0;
String word = "Mississippi";

for (int index = 0; index < word.length(); index++) {
   if (word.substring(index, index + 1).equals("i"))
      count++;
}

System.out.println(count);
   }
}