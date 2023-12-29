import java.io.*;
import java.util.*;

public class Lab13 {

  public static void main(String args[]) {
    if (args.length < 2) {
      System.out.println(
        "Потрібно два параметри виклику: ім'я файлу і рядок для пошуку"
      );
      return;
    }

    String thisLine;
    ArrayList<String> list = new ArrayList<>();
    BufferedReader fin = null;

    try {
      fin =
        new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

      while ((thisLine = fin.readLine()) != null) {
        System.out.println("Введений рядок:" + thisLine);
        list.add(thisLine);
      }

      Collections.sort(list);

      System.out.println("Відсортований список рядків:");
      Iterator<String> iter = list.iterator();

      while (iter.hasNext()) {
        String str = iter.next();
        System.out.println(str);
      }

      // Шукати рядок, заданий другим параметром
      String searchString = args[1];
      int searchResult = Collections.binarySearch(list, searchString);

      if (searchResult >= 0) {
        System.out.println(
          "Рядок '" +
          searchString +
          "' знайдений у відсортованому списку на позиції " +
          searchResult
        );
      } else {
        System.out.println(
          "Рядок '" + searchString + "' не знайдений у відсортованому списку"
        );
      }
    } catch (FileNotFoundException e) {
      System.out.println("Файл не знайдено: " + args[0]);
      System.out.println("Error: " + e);
    } catch (IOException e) {
      System.out.println("Помилка введення/виведення. Файл " + args[0]);
      System.out.println("Error: " + e);
    } finally {
      if (fin != null) {
        try {
          fin.close(); // !!! Закрыть файл
        } catch (IOException ex) {
          System.out.println("Помилка закриття файлу " + args[0]);
          System.out.println("Error: " + ex);
        }
        fin = null;
      }
    }
  }
}
