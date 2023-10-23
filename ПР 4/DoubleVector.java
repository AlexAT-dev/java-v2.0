public class DoubleVector {

  private double[] vector = null;

  public DoubleVector(double[] vector) {
    this.vector = new double[vector.length];

    for (int i = 0; i < vector.length; i++) {
      this.vector[i] = vector[i];
    }
  }

  // Скалярний добуток векторів
  public double mult(DoubleVector anotherVector) {
    double s = 0;
    for (int i = 0; i < vector.length; i++) {
      s += vector[i] * anotherVector.vector[i];
    }
    return s;
  }

  public static double mult(DoubleVector a, DoubleVector b) {
    return a.mult(b);
  }

  public DoubleVector mult(double number) {
    DoubleVector newVector = new DoubleVector(vector);

    for (int i = 0; i < vector.length; i++) {
      newVector.vector[i] *= number;
    }
    return newVector;
  }

  public static DoubleVector mult(DoubleVector a, double number) {
    return a.mult(number);
  }

  public DoubleVector add(DoubleVector vector2) {
    DoubleVector newVector = new DoubleVector(vector);

    for (int i = 0; i < vector.length; i++) {
      newVector.vector[i] += vector2.vector[i];
    }
    return newVector;
  }

  public static DoubleVector add(DoubleVector a, DoubleVector b) {
    return a.add(b);
  }

  public DoubleVector sub(DoubleVector vector2) {
    DoubleVector newVector = new DoubleVector(vector);

    for (int i = 0; i < vector.length; i++) {
      newVector.vector[i] -= vector2.vector[i];
    }
    return newVector;
  }

  public static DoubleVector sub(DoubleVector a, DoubleVector b) {
    return a.sub(b);
  }

  @Override
  public String toString() {
    if (vector.length == 0) return "";

    String result = "{" + vector[0];

    for (int i = 1; i < vector.length; i++) {
      result += ", " + vector[i];
    }

    result += "}";

    return result;
  }

  public static void main(String[] args) {
    double[] a = { 1, 2, 3, 4 };
    double[] b = { 1, 1, 1, 1 };
    double[] c = { 2, 2, 2, 2 };
    DoubleVector v1 = new DoubleVector(a);
    DoubleVector v2 = new DoubleVector(b);
    DoubleVector v3 = new DoubleVector(c);
    System.out.println("v1*v2=" + v1.mult(v2));
    System.out.println("v1*v2=" + DoubleVector.mult(v1, v2));
    System.out.println("v1*v3=" + v1.mult(v3));

    System.out.println("v1*2=" + v1.mult(2));
    System.out.println("v1+v2=" + DoubleVector.add(v1, v2));
    System.out.println("v1-v2=" + DoubleVector.sub(v1, v2));
  }
}
