import algebra.DoubleVector;
import algebra.DoubleVectorExtension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogVector {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {}
    JFrame frm = new JFrame("Перше візуальне застосування");
    frm.setSize(200, 200);
    Container c = frm.getContentPane();
    c.setLayout(new FlowLayout());

    DoubleVector v1 = new DoubleVector(new double[] { 8, 2, 4, 7 });
    DoubleVector v2 = new DoubleVector(new double[] { 1, 0, -2, 2 });

    DoubleVectorExtension.TestVector(v1);
    DoubleVectorExtension.TestVector(v2);

    c.add(new JLabel("v1+v2=" + DoubleVector.add(v1, v2).toString()));
    c.add(new JLabel("v1-v2=" + DoubleVector.sub(v1, v2).toString()));
    c.add(new JLabel("v1*10=" + DoubleVector.mult(v1, 10).toString()));

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    frm.addWindowListener(wndCloser);
    frm.setVisible(true);
  }
}
