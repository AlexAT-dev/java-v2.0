import java.io.File;
import java.util.Scanner;

public class Lab15 {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Введіть ім'я каталогу для видалення файлів.");
      return;
    }

    String directoryPath = args[0];
    File directory = new File(directoryPath);

    if (!directory.isDirectory()) {
      System.out.println(
        "Каталог " + directoryPath + " не існує або не є каталогом."
      );
      return;
    }

    File[] files = directory.listFiles();

    if (files == null || files.length == 0) {
      System.out.println("Каталог " + directoryPath + " порожній.");
      return;
    }

    System.out.println("Файли для видалення у каталозі " + directoryPath + ":");
    for (File file : files) {
      System.out.println(file.getName());
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Ви дійсно бажаєте видалити файли? (Y/N): ");
    String confirmation = scanner.nextLine().toUpperCase();

    if (confirmation.equals("Y")) {
      for (File file : files) {
        if (file.delete()) {
          System.out.println("Файл " + file.getName() + " видалено.");
        } else {
          System.out.println("Не вдалося видалити файл " + file.getName());
        }
      }
    } else {
      System.out.println("Операція видалення скасована користувачем.");
    }
  }
}
