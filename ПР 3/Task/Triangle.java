import java.util.Scanner;

public class Triangle {

  private float pri_SideFirst;
  private float pri_SideSecond;
  private float pri_Hipotenuse;

  public static void main(String[] args) {
    Triangle triangle = new Triangle();

    triangle.input();
    triangle.angels();
  }

  public void input() {
    Scanner scanner = new Scanner(System.in);
    boolean isRetry = false;
    float sideFirst = 1, sideSecond = 1;

    do {
      try {
        System.out.print("Input side A => ");
        sideFirst = Float.parseFloat(scanner.nextLine());

        System.out.print("Input side B => ");
        sideSecond = Float.parseFloat(scanner.nextLine());

        isRetry = sideFirst < 1 || sideSecond < 1;
      } catch (Exception e) {
        isRetry = true;
      }

      if (isRetry) {
        System.out.println("Incorrect numbers, try again :)\n");
      } else {
        pri_SideFirst = sideFirst;
        pri_SideSecond = sideSecond;
      }
    } while (isRetry);

    scanner.close();
  }

  public void calculateHipotenuse() {
    pri_Hipotenuse =
      (float) (
        pri_SideFirst < 1 || pri_SideSecond < 1
          ? 0
          : Math.hypot(pri_SideFirst, pri_SideSecond)
      );
  }

  public void angels() {
    calculateHipotenuse();

    float angelFirst = (float) Math.toDegrees(
      Math.asin(pri_SideFirst / pri_Hipotenuse)
    );
    float angelSecond = (float) Math.toDegrees(
      Math.asin(pri_SideSecond / pri_Hipotenuse)
    );

    System.out.println(
      "\nHipotenuse = " +
      pri_Hipotenuse +
      "\nAngel a = " +
      angelFirst +
      "°\nAngel b = " +
      angelSecond +
      "°"
    );
  }
}
