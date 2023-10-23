import java.util.Scanner;
import java.io.*;

public class Task2 {
  private double pri_X;

  public void setParams(double x) {
    this.pri_X = x;
  }

  public void input() throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input angle => ");
    String angle = scanner.nextLine();

    this.setParams(Double.parseDouble(angle));

    scanner.close();
  }

  public void printConsoleTask() {
    System.out
        .println("cos " + Double.toString(this.pri_X) + "° = " + Double.toString(Math.cos(Math.toRadians(this.pri_X))));
    System.out
        .println("sin " + Double.toString(this.pri_X) + "° = " + Double.toString(Math.sin(Math.toRadians(this.pri_X))));
  }

  public static void main(String[] args) {
    Task2 task = new Task2();

    try {
      task.input();
      task.printConsoleTask();
    } catch (Exception e) {
      System.out.println("Incorrect number, try again later!\n");
    }
  }
}