import java.util.Scanner;

public class SymbolTest {
  private int pri_Amount;

  public static void main(String[] args) {
    SymbolTest symbolTest = new SymbolTest();

    symbolTest.inputCounter();
    symbolTest.outputChars();
  }

  public void inputCounter() {
    Scanner scanner = new Scanner(System.in);
    boolean isRetry = false;
    int number = 1;

    do {
      try {
        System.out.print("Input amount iteration (greater 0) => ");

        number = Integer.parseInt(scanner.nextLine());
        isRetry = number < 1;
      } catch (Exception e) {
        isRetry = true;
      }

      if (isRetry) {
        System.out.println("Incorrect number, try again :)\n");
      } else {
        pri_Amount = number;
      }

    } while (isRetry);

    scanner.close();
  }

  public void outputChars() {
    for (int i = 0; i < pri_Amount; i++) {
      char c = (char) (Math.random() * 26 + 'a');
      System.out.print(c + ": ");

      switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          System.out.println(c + " => голосна");
          break;
        case 'y':
        case 'w':
          System.out.println(c + " => іноді голосна");
          break;
        default:
          System.out.println(c + " => приголосна");
      }
    }
  }
}
