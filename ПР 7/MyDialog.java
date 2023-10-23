import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyDialog extends JFrame {

  private ArrayList<JTextField> fields = new ArrayList<JTextField>();

  public JPanel createInput(String text) {
    JLabel label = new JLabel(text);
    JTextField field = new JTextField(10);
    fields.add(field);

    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(field);

    return panel;
  }

  MyDialog() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 150);
    setResizable(false);

    Container c = getContentPane();

    JPanel panel_inputs = new JPanel();
    JPanel panel_btn = new JPanel();
    c.add(panel_inputs, BorderLayout.CENTER);
    c.add(panel_btn, BorderLayout.SOUTH);

    panel_inputs.add(createInput("Поле вводу"));
    panel_inputs.add(createInput("Поле виводу"));

    JTextField field1 = fields.get(0);
    JTextField field2 = fields.get(1);

    JButton btn_copy = new JButton("Скопіювати");
    btn_copy.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          field2.setText(field1.getText());
        }
      }
    );

    panel_btn.add(btn_copy);

    setVisible(true);
  }

  public static void main(String[] args) {
    new MyDialog();
  }
}
