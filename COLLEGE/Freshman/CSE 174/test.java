public class test{
   public static void main(String[] args){
      String str = "1 2";
      int sum=0;
      int distance = 0;
      for(int i = 0; i<str.length(); i+=distance+1){
         distance = 0;
         if(str.charAt(i)!=' '){
            
            String num = "";
            for(int k = i; str.charAt(k)!=' '; k++){
               num+=str.charAt(k);
               distance++;
            }
            
            sum+=Integer.parseInt(num);
            System.out.print(distance);
         }
      }
      System.out.print(sum);
   }
}