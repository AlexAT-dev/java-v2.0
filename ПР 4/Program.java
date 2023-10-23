import addons.Vector;

import java.util.Scanner;

public class Program {
  public static void main(String[] args){ 
    Task();
  } 

  private static void Task() {
    Scanner scanner = new Scanner(System.in);
    boolean isRetry = true;

    do {
      try {
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
    
        vector1.inputConsole();
        vector2.inputConsole();
    
        vector1.isCollinearity(vector2);
        Vector.isCollinearity(vector1, vector2);
    
        vector1.outputConsole();
        vector2.outputConsole();

        System.out.print("\n\nRepeat again? ('+' if Yes) => ");

        isRetry = scanner.nextLine().charAt(0) == '+';
      } catch (Exception e) {
        isRetry = true;
      }
    } while (isRetry);

    scanner.close();
  }
}