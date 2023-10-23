package addons;

import java.util.Scanner;

public class Vector {

  private double[] pri_Values;

  public Vector() {
    setValues(null);
  }

  public Vector(double[] vector) {
    setValues(vector);
  }

  public boolean isEmpty() {
    return pri_Values.length < 1;
  }


  public void setValues(double[] vector) {
    if (vector == null) {
      pri_Values = null;
    } else {
      pri_Values = new double[vector.length];

      for (int index = 0; index < vector.length; index++) {
        pri_Values[index] = vector[index];
      }
    }
  }

  public double[] getVector() {
    return pri_Values;
  }

  public void inputConsole() {
    Scanner scanner = new Scanner(System.in);
    boolean isRetry = true;
    int number = 1;

    do {
      try {
        System.out.print("Input size vector (greater 0) => ");

        number = Integer.parseInt(scanner.nextLine());
        isRetry = number < 1;

        if (!isRetry) {
          pri_Values = new double[number];

          for (int index = 0; index < number; index++) {
            try {
              System.out.print(
                (index == 0 ? "\n" : "") +
                "Input number [" +
                (index + 1) +
                "] => "
              );

              pri_Values[index] = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
              index--;
              System.out.println("Incorrect input, try again :)\n");
            }
          }
        }
      } catch (Exception e) {
        isRetry = true;
      }

      if (isRetry) {
        System.out.println("Incorrect input, try again :)\n");
      }
    } while (isRetry);
  }

  public void outputConsole() {
    if (isEmpty()) {
      System.out.println("Vector is empty!\n\n");
    } else {
      System.out.print("\nVector values => [");

      for (int index = 0; index < pri_Values.length; index++) {
        System.out.print(
          pri_Values[index] + (index < pri_Values.length - 1 ? ", " : "]")
        );
      }
    }
  }

  public void isCollinearity(Vector other) {
    if (isEmpty() || other.isEmpty()) {
      System.out.println("\nOne of vectors is empty!");
    } else if (pri_Values.length != other.pri_Values.length) {
      System.out.println("\nOne of vectors length not equels second [ " + pri_Values.length + " ≠ " + other.pri_Values.length + " ]");
    } else {
      double[] difference = new double[2];
      boolean isEquels = false;

      for (int index = 0; index < pri_Values.length; index++) {
        difference[index == 0 ? 0 : 1] = pri_Values[index] / other.pri_Values[index];
        
        if (index > 0) {
          isEquels = difference[0] == difference[1];

          if (!isEquels) {
            System.out.println("\nVectors are not collinear.");
  
            break;
          }

          difference[0] = difference[1];
        }
      }

      if (isEquels) {
        System.out.println("\nm " + (difference[0] >= 0 ? "> 0" : "< 0") + " => The vectors are collinear and " + (difference[0] > 0 ? "co-directional" : "oppositely directed"));
      }
    }
  }

    public static void isCollinearity(Vector firstVector, Vector secondVector) {
      firstVector.isCollinearity(secondVector);
    }
}
