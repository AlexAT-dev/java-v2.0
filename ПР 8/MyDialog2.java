import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyDialog2 extends JFrame {

  private ArrayList<JTextField> fields = new ArrayList<JTextField>();
  private ArrayList<String> list = new ArrayList<String>();

  public JPanel createInput(String text) {
    JLabel label = new JLabel(text);
    JTextField field = new JTextField(10);
    fields.add(field);

    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(field);

    return panel;
  }

  MyDialog2() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 150);
    setResizable(false);

    Container c = getContentPane();

    JPanel panel_inputs = new JPanel();
    JPanel panel_btn = new JPanel();
    c.add(panel_inputs, BorderLayout.CENTER);
    c.add(panel_btn, BorderLayout.SOUTH);

    JPanel input1 = createInput("Поле вводу");
    JPanel input2 = createInput("Поле виводу");

    panel_inputs.add(input1);
    panel_inputs.add(input2);

    JTextField field1 = fields.get(0);
    JTextField field2 = fields.get(1);

    JButton btn_copy = new JButton("Скопіювати");
    btn_copy.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String str = field1.getText();
          field2.setText(str);

          if (!str.isEmpty()) list.add(str);
        }
      }
    );

    JButton btn_print = new JButton("Надрукувати");
    btn_print.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Список:");
          for (String str : list) {
            System.out.println(str);
          }
        }
      }
    );
    panel_btn.add(btn_copy);
    panel_btn.add(btn_print);

    setVisible(true);
  }

  public static void main(String[] args) {
    new MyDialog2();
  }
}
