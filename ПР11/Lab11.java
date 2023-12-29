import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lab11 extends JFrame {

  private JTextArea resultTextArea;
  private JTextField stepField;
  private JTextField parameterAField;
  private JTextField pointCountField;

  public Lab11() {
    setTitle("Lab11");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    resultTextArea = new JTextArea(10, 30);
    resultTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(resultTextArea);

    JLabel parameterALabel = new JLabel("Parameter A:");
    parameterAField = new JTextField(10);

    JLabel stepLabel = new JLabel("Step:");
    stepField = new JTextField(10);

    JLabel pointCountLabel = new JLabel("Point Count:");
    pointCountField = new JTextField(10);

    JButton calculateButton = new JButton("Calculate");
    calculateButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          calculateAndDisplay();
        }
      }
    );

    panel.add(stepLabel);
    panel.add(stepField);
    panel.add(parameterALabel);
    panel.add(parameterAField);
    panel.add(pointCountLabel);
    panel.add(pointCountField);
    panel.add(calculateButton);
    panel.add(scrollPane);

    add(panel);
  }

  private void calculateAndDisplay() {
    double step = Double.parseDouble(stepField.getText());
    double parameterA = Double.parseDouble(parameterAField.getText());
    int pointCount = Integer.parseInt(pointCountField.getText());

    resultTextArea.setText("");

    for (int i = 0; i < pointCount; i++) {
      double x = i * step;
      double y = parameterA * Math.sqrt(x) * Math.sin(parameterA * x);
      resultTextArea.append(String.format("X=%.2f \t\t Y=%.2f%n", x, y));
    }
  }

  public static void main(String[] args) {
    new Lab11().setVisible(true);
  }
}
