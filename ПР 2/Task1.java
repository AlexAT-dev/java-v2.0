public class Task1 {

  private double pri_X;
  private double pri_Y;

  public void setParams(double x, double y) {
    this.pri_X = x;
    this.pri_Y = y;
  }

  public void printConsoleTask() {
    System.out.println(
      "cos " +
      Double.toString(this.pri_X) +
      "° = " +
      Double.toString(Math.cos(Math.toRadians(this.pri_X)))
    );
    System.out.println(
      "sin " +
      Double.toString(this.pri_Y) +
      "° = " +
      Double.toString(Math.sin(Math.toRadians(this.pri_Y)))
    );
  }

  public static void main(String[] args) {
    Task1 task = new Task1();

    task.setParams(30, 30);
    task.printConsoleTask();
  }
}
