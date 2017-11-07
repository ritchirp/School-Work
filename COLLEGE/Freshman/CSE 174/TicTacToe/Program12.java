import java.util.Scanner;

public class Program12{
   static Scanner in = new Scanner(System.in);
   
   public static void main(String[] args){
      
      TicTacToe board = new TicTacToe();
      Boolean continueGame = true;
      
      do{
         playGame(board);
         
         if(board.getStatus() == TicTacToe.X_WINS)
            System.out.println("You win!");
         else if(board.getStatus() == TicTacToe.O_WINS)
            System.out.println("OComputer wins!");
         else
            System.out.println("Draw.");
         
         System.out.print(board);
         
         System.out.print("Play again? (y/n)");
         String answer = in.next();
         
         while(!(answer.equals("y") || answer.equals("n"))){
            System.out.print("Input y or n");
            answer = in.next();
         }
         
         if(answer.equals("n"))
            continueGame = false;
         
         board.reset();
         
      }while(continueGame);
   }
   
   // runs process for user move
   public static void userMove(TicTacToe board){
      
      System.out.print("Enter your move: ");
      int row = in.nextInt();
      int col = in.nextInt();
      
      
      while(outOfBounds(row,col) || !board.isEmpty(row, col)){
         if(outOfBounds(row,col))
            System.out.println("This is an illegal move!");
         else
            System.out.println("This cell is occupied!");
         
         System.out.print("Enter your move: ");
         row = in.nextInt();
         col = in.nextInt();
      }
      
      board.makeMove(Cell.X, row, col);
   }
   
   // runs process for computer move
   public static void computerMove(TicTacToe board){
      int num1, num2;
      
      System.out.print(board);
      
      do{
         num1 = (int)(3*Math.random());
         num2 = (int)(3*Math.random());
      } while (!board.isEmpty(num1,num2));
      
      System.out.printf("Computer plays %d %d %n",num1,num2); 
      board.makeMove(Cell.O, num1, num2);
   }
   
   public static void playGame(TicTacToe board){
      do{
         System.out.print(board);
         userMove(board);
         if(board.getStatus() == TicTacToe.IN_PROGRESS)
            computerMove(board);
      } while(board.getStatus() == TicTacToe.IN_PROGRESS);
   }
   
   public static boolean outOfBounds(int row, int col){
      return ((row<0 || row>2) || (col<0 || col>2));
   }
   
}