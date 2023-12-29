import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Lab14 {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("ПР14\\input.txt"));

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("Введений рядок: " + line);

        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
          String token = tokenizer.nextToken();

          try {
            double number = Double.parseDouble(token);
            System.out.println(token + " - це число = " + number);
          } catch (NumberFormatException e) {}
        }
      }

      br.close();
    } catch (FileNotFoundException e) {
      System.out.println("Файл не знайдений");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
